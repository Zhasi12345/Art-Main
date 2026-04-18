package service;

import java.sql.Connection;
import java.sql.Statement;

public class InitDB {
    public static void main(String[] args) {

        try (Connection c = DBconnection.connect();
             Statement s = c.createStatement()) {

            s.execute("CREATE TABLE IF NOT EXISTS artworks (" +
                    "id INTEGER PRIMARY KEY, " +
                    "title TEXT, " +
                    "artist TEXT, " +
                    "date TEXT, " +
                    "location TEXT, " +
                    "type TEXT)");

            System.out.println("Table created");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}