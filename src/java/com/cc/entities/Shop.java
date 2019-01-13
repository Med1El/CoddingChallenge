/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author medEl
 */
@Entity
public class Shop implements Serializable {

    @Id
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private int shopId;
    private String name;
    @Column(name = "pic_url")
    private String picUrl;

    public Shop() {
    }

    public Shop(String name, String picUrl) {
        this.name = name;
        this.picUrl = picUrl;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @Override
    public String toString() {
        return "Shop{" + "shopId=" + shopId + ", name=" + name + ", picUrl=" + picUrl + '}';
    }
    
    

}
