package main.java.connections;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConnections {

    public static Connection getConnection(){
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/qspider", "root", "Jack@123");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Getting Error While Creating the connection");
            return null;
        }
    }

}
