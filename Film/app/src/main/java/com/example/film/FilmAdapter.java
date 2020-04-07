package com.example.film;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.VH> {

    private ArrayList<Film>listFilm;

    private Context context;

    public FilmAdapter(Context context) { this.context = context;
    }

    public void setListFilm (ArrayList<Film>listFilm) { this.listFilm = listFilm;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.print, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, final int position) {
        Film film = listFilm.get(position);

        holder.judul.setText(film.getJudul());
        holder.tglRilis.setText(film.getTanggalRilis());
        Glide.with(context).load(film.getPhoto()).apply(new RequestOptions().override(60,60)).into(holder.imgPhoto);

        holder.itemRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, Detail.class);
                i.putExtra(Detail.extraJudul, listFilm.get(position).getJudul());
                i.putExtra(Detail.extraTanggalRilis, listFilm.get(position).getTanggalRilis());
                i.putExtra(Detail.extraSutradara, listFilm.get(position).getSutradara());
                i.putExtra(Detail.extraDesc, listFilm.get(position).getDesc());
                i.putExtra(Detail.extraImage, listFilm.get(position).getPhoto());

                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listFilm.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView judul, tglRilis;
        CardView itemRow;
        public VH(@NonNull View itemView) {
            super(itemView);

            judul = itemView.findViewById(R.id.tv_judul);
            imgPhoto = itemView.findViewById(R.id.img_cover);
            tglRilis = itemView.findViewById(R.id.tv_tgl_rilis);
            itemRow = itemView.findViewById(R.id.cardview);
        }
    }
}
