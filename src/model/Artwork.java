package model;

public class Artwork {
    private int id;
    private String title, artist, date, location;

    public Artwork(int id, String t, String a, String d, String l) {
        this.id = id;
        this.title = t;
        this.artist = a;
        this.date = d;
        this.location = l;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public String getDate() { return date; }
    public String getLocation() { return location; }

    public void setTitle(String t) { title = t; }
    public void setArtist(String a) { artist = a; }
    public void setDate(String d) { date = d; }
    public void setLocation(String l) { location = l; }

    public String toFile() {
        return id + "," + title + "," + artist + "," + date + "," + location;
    }

    public static Artwork fromFile(String line) {
        String[] p = line.split(",");
        return new Artwork(
                Integer.parseInt(p[0]),
                p[1], p[2], p[3], p[4]
        );
    }
}