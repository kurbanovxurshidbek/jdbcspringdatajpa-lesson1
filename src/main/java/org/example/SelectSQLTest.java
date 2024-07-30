package org.example;

import java.sql.*;

public class SelectSQLTest {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/taskdb";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "root123";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            if (conn != null) {
                System.out.println("Connected to DBMS successfully");
                System.out.println(conn.getClass().getName()); // Java Reflection

                // insert into task(content) values ('DBMS');
                ps = conn.prepareStatement("select * from task");

                // Run SQL
                rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String content = rs.getString("content");
                    System.out.println(id + " : " + content);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}
