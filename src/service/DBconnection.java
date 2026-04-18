package service;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {

    public static Connection connect() {
        try {
            return DriverManager.getConnection("jdbc:sqlite:artworks.db");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}