package com.qsoft.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    private static final String CLASS_NAME = "com.mysql.jdbc.Driver";

    // URL, user name, password for connection
    private static final String URL = "jdbc:mysql://localhost:3306/h2t";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "";

    // SQL strings to create table and insert sample data

    public static Connection getConnection() throws Exception{
        Class.forName(CLASS_NAME);
        try{
            return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
