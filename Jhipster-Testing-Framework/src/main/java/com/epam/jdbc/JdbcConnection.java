package com.epam.jdbc;

import java.sql.*;

public class JdbcConnection {
    public static void main(String[] args) throws SQLException,ClassNotFoundException {
        Class.forName("org.h2.Driver");
        String jdbcURL = "jdbc:h2:file:~/jhipster-sample-app/target/h2db/db/sample";
        String username = "jhipsterSampleApplication";
        String password = "";

        Connection connection = DriverManager.getConnection(jdbcURL, username, password);
        System.out.println("Connected to H2 embedded database.");

        String sql = "SELECT * FROM INFORMATION_SCHEMA.USERS";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            String user = resultSet.getString("USER_NAME");
            System.out.println(user);
        }

        connection.close();
    }
}
