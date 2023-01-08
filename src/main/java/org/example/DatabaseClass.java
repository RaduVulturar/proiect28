package org.example;
        import java.sql.*;
        import java.util.*;

public class DatabaseClass {


    public Connection GetConnection() throws SQLException {

        // Create a connection to the database
        String url = "jdbc:mysql://localhost:3306/shapes";
        String username = "root";
        String password = "toor";
        Connection con = DriverManager.getConnection(url, username, password);

        return con;

    }

}
