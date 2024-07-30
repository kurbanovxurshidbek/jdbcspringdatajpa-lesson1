package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectSQLTest {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/taskdb";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "root123";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            if (connection != null) {
                System.out.println("Connected to DBMS successfully");
                System.out.println(connection.getClass().getName()); // Java Reflection
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}
