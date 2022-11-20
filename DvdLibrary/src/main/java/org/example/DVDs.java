package org.example;

import java.util.ArrayList;

public class DVDs {

    private int id;
    private String title;
    private String releaseDate;
    private int mpaaRating;
    private String directorName;
    private String studioName;
    private String userRating;

    public static ArrayList<DVDs> AllDvds = new ArrayList<>();

    public DVDs(int id, String title, String releaseDate, int mppaRating, String directorName, String studioName, String userRating) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.mpaaRating = mppaRating;
        this.directorName = directorName;
        this.studioName = studioName;
        this.userRating = userRating;
    }


    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public int getMpaaRating() {
        return mpaaRating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public String getStudioName() {
        return studioName;
    }

    public String getUserRating() {
        return userRating;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setMpaaRating(int mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static ArrayList<DVDs> getAllDvds() {
        return AllDvds;
    }
    public static void setAllDvds(ArrayList<DVDs> allDvds) {
        AllDvds = allDvds;
    }

    @Override
    public String toString() {
        return "id = " + id +
                ", " + title +
                ", date - " + releaseDate +
                ", PEGI - " + mpaaRating +
                ", directed - " + directorName +
                ", studio - " + studioName +
                ", rating/note - " + userRating +
                "\n";
    }

    public String toWrite() {
        return title + "," + releaseDate + "," + mpaaRating + "," + directorName + "," + studioName + "," + userRating + "\n";
    }
}
