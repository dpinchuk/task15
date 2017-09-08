package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Repository {

    private final String URL = "jdbc:mysql://127.0.0.1:3306";
    private final String DB = "auction_db?serverTimezone=Europe/Kiev";
    private final String USER = "dpinchuk";
    private final String PASS = "dmss111278";

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL + "/" + DB, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Database connection error...");
        }
        return null;
    }

}