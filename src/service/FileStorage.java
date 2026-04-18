package service;
import model.Artwork;

import java.io.*;
import java.util.ArrayList;

public class FileStorage {

    private static final String FILE = "data/artworks.txt";

    public static void save(ArrayList<Artwork> list) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE))) {
            for (Artwork a : list) {
                pw.println(a.toFile());
            }
        } catch (Exception e) {
            System.out.println("Save");
        }
    }

    public static ArrayList<Artwork> load() {
        ArrayList<Artwork> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(Artwork.fromFile(line));
            }
        } catch (Exception e) {
            System.out.println("Loading");
        }

        return list;
    }

    public static void exportCSV(ArrayList<Artwork> list) {
        try (PrintWriter pw = new PrintWriter("data/export.csv")) {
            for (Artwork a : list) {
                pw.println(a.toFile());
            }
        } catch (Exception e) {
            System.out.println("Export");
        }
    }

    public static ArrayList<Artwork> importCSV() {
        ArrayList<Artwork> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("data/export.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(Artwork.fromFile(line));
            }
        } catch (Exception e) {
            System.out.println("Import");
        }

        return list;
    }
}