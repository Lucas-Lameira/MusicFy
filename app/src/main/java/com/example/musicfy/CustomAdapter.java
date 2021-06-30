package com.example.musicfy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private List<Music> listOfMusics;

    public CustomAdapter (List<Music> music) {
        this.listOfMusics = music;
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.music_row_frag, parent, false);

        return new ViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        Music music = listOfMusics.get(position);

        holder.art.setText(music.getArtist());
        holder.name.setText(music.getMusicName());
        holder.alb.setText(music.getAlbum());
        holder.gen.setText(music.getGenre());
    }

    @Override
    public int getItemCount() {
        return listOfMusics.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView art, name, alb, gen;

        public ViewHolder(View view) {
            super(view);
            art = (TextView) view.findViewById(R.id.artist);
            name = (TextView) view.findViewById(R.id.musicName);
            alb = (TextView) view.findViewById(R.id.album);
            gen = (TextView) view.findViewById(R.id.genre);
        }
    }
}
