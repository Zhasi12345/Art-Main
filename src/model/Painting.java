package model;

public class Painting extends model.Artwork {
    public Painting(int id, String t, String a, String d, String l) {
        super(id, t, a, d, l);
    }

    @Override
    public void display() {
        System.out.println("Painting: " + getTitle());
    }
}