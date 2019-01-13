/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.actions;

import com.cc.dal.GenericDaoJpaImpl;
import com.cc.dal.IGenericDao;
import com.cc.entities.Shop;
import com.cc.entities.User;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author medEl
 */
@Results({
    @Result(name = "success", location = "/shops.jsp")
    ,
    @Result(name = "login", location = "/index.jsp")
    ,
    @Result(name = "pref", location = "/preferred.jsp")
})
public class Actions extends ActionSupport implements ServletRequestAware, SessionAware {

    private String email;
    private String pass;
    private String repeatPass;
    private String fullName;

    private List<Shop> shops;

    private final IGenericDao dao;

    private SessionMap<String, Object> sessionMap;
    private HttpServletRequest request;

    public Actions() {
        dao = new GenericDaoJpaImpl();
    }

    @Action(value = "redirect")
    public String redirect() {
        if (sessionMap.get("user") == null) {
            return "login";
        } else {
            shops = dao.getAll(Shop.class);
            return "success";
        }
    }

    @Action(value = "signin")
    public String signIn() {

        User u = null;

        try {
            u = (User) dao.findBy2Params(User.class, "email", email, "password", pass).get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return "login";
        }

        if (u != null) {
            sessionMap.put("user", u);
            shops = dao.getAll(Shop.class);
            return "success";
        } else {
            return "login";
        }
    }

    @Action(value = "signup")
    public String signUp() {
        if (pass.equals(repeatPass)) {
            User u = new User(fullName, email, pass);
            dao.add(u);
            sessionMap.put("user", u);
            shops = dao.getAll(Shop.class);
            return "success";
        } else {
            return "login";
        }
    }

    @Action(value = "logout")
    public String logout() {
        sessionMap.clear();
        return "login";
    }

    @Action(value = "like")
    public String addToLiked() {
        User u = (User) sessionMap.get("user");
        u = (User) dao.findById(User.class, u.getUserId());
        u.getPreferredShops().add((Shop) dao.findById(Shop.class, new Integer(request.getParameter("id"))));
        dao.update(u);
        return "success";
    }

    @Action(value = "preferred")
    public String preferred() {
        if (sessionMap.get("user") == null) {
            return "login";
        } else {
            User u = (User) sessionMap.get("user");
            u = (User) dao.findById(User.class, u.getUserId());
            shops = u.getPreferredShops();
            return "pref";
        }
    }

    @Action(value = "remove")
    public String removeFromPrefered() {
        User u = (User) sessionMap.get("user");
        u = (User) dao.findById(User.class, u.getUserId());
        u.getPreferredShops().remove((Shop) dao.findById(Shop.class, new Integer(request.getParameter("id"))));
        dao.update(u);
        sessionMap.put("user", u);
        return "pref";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRepeatPass() {
        return repeatPass;
    }

    public void setRepeatPass(String repeatPass) {
        this.repeatPass = repeatPass;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.sessionMap = (SessionMap<String, Object>) map;
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }
  
}
