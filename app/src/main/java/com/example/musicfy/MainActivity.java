package com.example.musicfy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerSong;
    FloatingActionButton addMusicBtn;
    CustomAdapter customAdapter;
    Connection db;

    private List<Music> musicList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new Connection(MainActivity.this);
        addMusicBtn = findViewById(R.id.goToAdd);
        recyclerSong = findViewById(R.id.songs);
        customAdapter = new CustomAdapter(musicList);
        recyclerSong.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerSong.setAdapter(customAdapter);

        addMusicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddMusicActivity.class);
                startActivity(intent);
            }
        });

        storeData();
    }

    void storeData () {
        Cursor cursor = db.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "No data", Toast.LENGTH_LONG).show();
        }else{
            while (cursor.moveToNext()){
                Music m = new Music();
                m.setId(Integer.parseInt(cursor.getString(0)));
                m.setArtist(cursor.getString(1));
                m.setMusicName(cursor.getString(2));
                m.setAlbum(cursor.getString(3));
                m.setGenre(cursor.getString(4));
                musicList.add(m);
            }
        }
    }
}