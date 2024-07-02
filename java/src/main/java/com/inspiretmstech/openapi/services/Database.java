package com.inspiretmstech.openapi.services;

import com.inspiretmstech.openapi.Runtime;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static String getConnectionString() {
        return "jdbc:postgresql://" + Runtime.DB_HOST + ":" + Runtime.DB_PORT + "/" + Runtime.DB_NAME + "?prepareThreshold=0";
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(Database.getConnectionString(), Runtime.DB_USER, Runtime.DB_PASS);
    }

}
