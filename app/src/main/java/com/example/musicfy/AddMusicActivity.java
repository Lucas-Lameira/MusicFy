package com.example.musicfy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddMusicActivity extends AppCompatActivity {
    private EditText newMusicName, newArtist, newAlbum, newGenre;
    Button saveMusicBtn;
    Connection db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_music);

        db = new Connection(AddMusicActivity.this);

        newArtist = findViewById(R.id.newArtist);
        newMusicName = findViewById(R.id.newMusicName);
        newAlbum = findViewById(R.id.newAlbum);
        newGenre = findViewById(R.id.newGenre);

        saveMusicBtn = findViewById(R.id.saveMusicBtn);
        saveMusicBtn.setOnClickListener(v -> {
            Music music = new Music();

            music.setArtist(newArtist.getText().toString());
            music.setMusicName(newMusicName.getText().toString());
            music.setAlbum(newAlbum.getText().toString());
            music.setGenre(newGenre.getText().toString());

            long rowId = db.addMusic(music);

            if(rowId == -1) {
                Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "works", Toast.LENGTH_LONG).show();
            }
        });
    }
}