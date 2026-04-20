package com.shh.service;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

    public class ConnectionManager {

        private static final String URL_KEY = "db.url";
        private static final String USER_KEY = "db.user";
        private static final String PASSWORD_KEY = "db.password";

        private ConnectionManager(){}

        public static Connection getConnection() {
            try {
                return DriverManager.getConnection(URL_KEY, USER_KEY, PASSWORD_KEY);
            } catch (SQLException e) {
                throw new RuntimeException("Ошибка подключения к БД", e);
            }
        }
    }

