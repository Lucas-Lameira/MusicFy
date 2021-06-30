package com.example.musicfy;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Connection extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "music";

    private static final String MUSIC_TABLE = "musicInfo";
    private static final String COL_ID = "id";
    private static final String COL_ARTIST = "artist";
    private static final String COL_MUSIC_NAME = "musicName";
    private static final String COL_ALBUM = "album";
    private static final String COL_GENRE = "genre";

    public Connection(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + MUSIC_TABLE + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_ARTIST + " VARCHAR(50), " +
                COL_MUSIC_NAME + " VARCHAR(50), " +
                COL_ALBUM + " VARCHAR(20), " +
                COL_GENRE + " VARCHAR(20) );";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + MUSIC_TABLE);
        onCreate(db);
    }


    public long addMusic (Music music) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        //values.put();
        values.put(COL_ARTIST, music.getArtist());
        values.put(COL_MUSIC_NAME, music.getMusicName());
        values.put(COL_ALBUM, music.getAlbum());
        values.put(COL_GENRE, music.getGenre());

        long rowId = db.insert(MUSIC_TABLE, null, values);

        db.close();

        return rowId;
    }

    public List<Music> listAllSongs () {

        List<Music> musicList = new ArrayList<>();

        String query = "SELECT * FROM " + MUSIC_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()){
            do {
                Music music = new Music();

                music.setId(Integer.parseInt(cursor.getString(0)));
                music.setAlbum(cursor.getString(1));
                music.setMusicName(cursor.getString(2));
                music.setAlbum(cursor.getString(3));
                music.setGenre(cursor.getString(4));

                musicList.add(music);
            } while (cursor.moveToNext());
        }
        return musicList;
    }

    Cursor readAllData () {
        String query = "SELECT * FROM " + MUSIC_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;

        if(db != null){
            cursor = db.rawQuery(query, null);
        }

        return cursor;
    }

}
