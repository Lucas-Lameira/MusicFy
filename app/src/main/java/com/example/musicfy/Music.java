package com.example.musicfy;

public class Music {

    int id;
    String artist;
    String musicName;
    String album;
    String genre;

    public Music () {}

    public Music (String artist, String musicName, String album, String genre) {
        this.id = id;
        this.artist = artist;
        this.musicName = musicName;
        this.album = album;
        this.genre = genre;
    }

    public Music (int id, String artist, String musicName, String album, String genre) {
        this.id = id;
        this.artist = artist;
        this.musicName = musicName;
        this.album = album;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
