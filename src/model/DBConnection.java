package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.io.InputStream;
import java.util.Properties;
import java.io.IOException;

public class DBConnection {

    public static Connection Connect() {

        Connection conn = null;
        Properties properties = new Properties();

        try(InputStream input = DBConnection.class.getClassLoader().getResourceAsStream("db.properties")) {
            
            // Load the properties file
            if (input == null) {
                throw new IOException("Unable to find db.properties");
            }
            properties.load(input);
            
            // Retrieve database properties
            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");
            
            // Load a class
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            
            System.out.println("Connection Successful");
        } catch (Exception e) {
            System.out.println("Conn    ection Failed: " + e.getMessage());
            e.printStackTrace();
        }

        return conn;

    }

}
