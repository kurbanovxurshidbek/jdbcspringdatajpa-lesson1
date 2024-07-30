package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertSQLTest {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/taskdb";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "root123";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps;

        try {
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            if (conn != null) {
                System.out.println("Connected to DBMS successfully");
                System.out.println(conn.getClass().getName()); // Java Reflection

                // insert into task(content) values ('DBMS');
                ps = conn.prepareStatement("insert into task(content) values (?)");

                //Fill in the question mark with a value. It is called Binding.
                ps.setString(1, "DBMS");

                // Run SQL
                int updateCount = ps.executeUpdate();
                System.out.println("updateCount: " + updateCount);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}
