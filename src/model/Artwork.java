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
        String type = (this instanceof Painting )? "Painting" : "Sculpture";
        return type + "," + id + "," + title + "," + artist + "," + date + "," + location;
    }

    public static Artwork fromFile(String line) {
        String[] p = line.split(",");
        if(p.length < 6) return null;
        String type = p[0];
        int id = Integer.parseInt(p[1]);
        String title = p[2];
        String artist = p[3];
        String date = p[4];
        String location = p[5];

        if ("Painting".equalsIgnoreCase(type)) {
            return new Painting(id, title , artist , date, location );
        } else {
            return new Sculpture(id, title , artist , date, location);
        }

    }
}
//Integer.parseInt(p[0]),