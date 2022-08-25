package com.shopperapp.ShopperApp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connect {
    private String jdbcConnectionURL;
    private String username;
    private String password;

    public DB_Connect(String username, String password) {
        jdbcConnectionURL = "jdbc:mysql://localhost:3306/autoshopper_db";
        this.username = username;
        this.password = password;
    }

    public DB_Connect(String jdbcConnectionURL, String username, String password) {
        this.jdbcConnectionURL = jdbcConnectionURL;
        this.username = username;
        this.password = password;
    }

    public String getJdbcConnectionURL(){
        return jdbcConnectionURL;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void readAll() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(jdbcConnectionURL, username, password);
        } catch (SQLException e) {
            System.out.println("ERROR:" + e);
        } finally {
            try {
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

}
