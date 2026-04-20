package service;
import model.Artwork;

import java.io.*;
import java.util.ArrayList;

public class FileStorage {

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