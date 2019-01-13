/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.dal;

import com.cc.entities.Shop;
import com.cc.entities.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author medEl
 */
public class testDAL {

    public static void createDB(String db) throws SQLException {
        Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/?user=", "root", "");
        Statement stmt = (Statement) connection.createStatement();
        stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + db);
        connection.close();
    }

    public static void main(String[] args) throws Exception {
        
        //to generate the database
        createDB("db2");
        //this generates the tables in the db
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CCPU");

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        
        Shop shop1 = new Shop("Express","imgs/express.jpg");
        em.persist(shop1);
        
        Shop shop2 = new Shop("TheGem","imgs/bg2.jpg");
        em.persist(shop2);
        
        Shop shop3 = new Shop("Adidas","imgs/adidas.jpg");
        em.persist(shop3);
        
        Shop shop4 = new Shop("Chanel","imgs/chanel.jpg");
        em.persist(shop4);
        
        Shop shop5 = new Shop("Apple","imgs/apple.png");
        em.persist(shop5);
        
        Shop shop6 = new Shop("Nike","imgs/nike.png");
        em.persist(shop6);
        
        Shop shop7 = new Shop("Walmart","imgs/walmart.png");
        em.persist(shop7);
        
        Shop shop8 = new Shop("Roxy","imgs/roxy.png");
        em.persist(shop8);
        
        et.commit();
        em.close(); 
        emf.close();
        
          
         
        
    }

}
