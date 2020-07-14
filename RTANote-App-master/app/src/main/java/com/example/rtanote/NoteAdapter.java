package com.example.rtanote;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    List<Note> listNotes;
    Context context;

    public NoteAdapter(List<Note> listNotes, Context context) {
        this.listNotes = listNotes;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tvTitle.setText(listNotes.get(position).getTitle());
        holder.tvDesc.setText(listNotes.get(position).getDescription());
        holder.tvDate.setText(listNotes.get(position).getDate());

        holder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);

                intent.putExtra(DetailActivity.POSITION_EXTRA, position);

                context.startActivity(intent);
                ((Activity)context).finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listNotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvDate, tvDesc;
        CardView cvItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_title_item);
            tvDesc = itemView.findViewById(R.id.tv_desc_item);
            tvDate = itemView.findViewById(R.id.tv_date_item);
            cvItem = itemView.findViewById(R.id.cv_item);
        }
    }
}
