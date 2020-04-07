package com.latihan.apimy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.latihan.apimy.model.EventsItem;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.VH> {
    private List<EventsItem> items;

    public EventAdapter(List<EventsItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public EventAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventAdapter.VH holder, int position) {
        EventsItem eventsItem = items.get(position);

        holder.tva.setText(eventsItem.getStrHomeTeam());
        holder.tvb.setText(eventsItem.getStrAwayTeam());
        holder.tvjadwal.setText(eventsItem.getDateEvent());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        TextView tva, tvb, tvjadwal;
        ImageView iva, ivb;

        public VH(@NonNull View itemView) {
            super(itemView);

            tva = itemView.findViewById(R.id.tv_a);
            tvb = itemView.findViewById(R.id.tv_b);
            tvjadwal = itemView.findViewById(R.id.tv_jadwal);

            iva =itemView.findViewById(R.id.iv_a);
            ivb = itemView.findViewById(R.id.iv_b);
        }
    }
}
