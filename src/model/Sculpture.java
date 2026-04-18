package model;

public class Sculpture extends model.Artwork {
    public Sculpture(int id, String t, String a, String d, String l) {
        super(id, t, a, d, l);
    }

    @Override
    public void display() {
        System.out.println("Sculpture: " + getTitle());
    }
}