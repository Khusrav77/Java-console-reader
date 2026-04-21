package com.shh.util;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

    public final class ConnectionManager {

        private static final String URL_KEY = "db.url";
        private static final String USER_KEY = "db.user";
        private static final String PASSWORD_KEY = "db.password";

        private ConnectionManager(){}

        public static Connection getConnection() {
            try {
                return DriverManager.getConnection(
                        PropertiesUtil.get(URL_KEY),
                        PropertiesUtil.get(USER_KEY),
                        PropertiesUtil.get(PASSWORD_KEY)
                );
            } catch (SQLException e) {
                throw new RuntimeException("Ошибка подключения к БД", e);
            }
        }
    }

