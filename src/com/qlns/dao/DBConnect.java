/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.dao;

import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Thang
 */
public class DBConnect {
    public static Connection getConnection () {
        try {
            Connection cons  = null;
            Class.forName("com.mysql.jdbc.Driver");
            cons = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/book_store?autoReconnect=true&useSSL=false", "root", "1234");
            return cons;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}