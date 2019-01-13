/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author medEl
 */
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int userId;
    @Column(name = "full_name")
    private String fullName;
    private String email;
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_shops", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "shop_id"))
    private List<Shop> preferredShops;

    public User() {
    }

    public User(String fullName, String email, String password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Shop> getPreferredShops() {
        return preferredShops;
    }

    public void setPreferredShops(List<Shop> preferredShops) {
        this.preferredShops = preferredShops;
    }



    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", fullName=" + fullName + ", email=" + email + ", password=" + password + '}';
    }

}
