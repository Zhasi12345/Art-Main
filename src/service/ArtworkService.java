package service;
import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ArtworkService {


    public void add(Artwork a) {

        String sql = "INSERT OR IGNORE INTO artworks (id, title, artist, date, location, type) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection c = DBconnection.connect();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, a.getId());
            ps.setString(2, a.getTitle());
            ps.setString(3, a.getArtist());
            ps.setString(4, a.getDate());
            ps.setString(5, a.getLocation());

            if (a instanceof Painting) {
                ps.setString(6, "Painting");
            } else {
                ps.setString(6, "Sculpture");
            }

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Artwork> getAll() {

        ArrayList<Artwork> list = new ArrayList<>();

        String sql = "SELECT * FROM artworks";

        try (Connection c = DBconnection.connect();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                int id = rs.getInt("id");
                String title = rs.getString("title");
                String artist = rs.getString("artist");
                String date = rs.getString("date");
                String location = rs.getString("location");
                String type = rs.getString("type");

                Artwork a;

                if ("Painting".equals(type)) {
                    a = new Painting(id, title, artist, date, location);
                } else {
                    a = new Sculpture(id, title, artist, date, location);
                }

                list.add(a);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    public void delete(int id) {

        String sql = "DELETE FROM artworks WHERE id=?";

        try (Connection c = DBconnection.connect();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(int id, String title, String artist, String date, String location) {

        String sql = "UPDATE artworks SET title=?, artist=?, date=?, location=? WHERE id=?";

        try (Connection c = DBconnection.connect();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, title);
            ps.setString(2, artist);
            ps.setString(3, date);
            ps.setString(4, location);
            ps.setInt(5, id);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exportData() {

        ArrayList<Artwork> list = getAll();
        FileStorage.exportCSV(list);
    }

    public void importData() {
        ArrayList<Artwork> importedList = FileStorage.importCSV();

        for (Artwork a : importedList) {
            if (a != null) {
                add(a);
            }
        }
    }
}