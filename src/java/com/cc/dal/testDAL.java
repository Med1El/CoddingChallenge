/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cc.dal;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.EntityManagerFactory;
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
        //createDB("db2");
        //this generates the tables in the db
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CCPU"); 
        emf.close();
        
         
        
    }

}
