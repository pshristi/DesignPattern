package com.example.learninglld.objectPoolPattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBResource {
    Connection dbconnection;
    public DBResource() {
        try {
            dbconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
