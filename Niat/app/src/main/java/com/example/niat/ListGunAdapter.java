package com.example.niat;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListGunAdapter extends RecyclerView.Adapter<ListGunAdapter.ListViewHolder> {
    private ArrayList<Gun> listGun;
    private Context context;

    public ArrayList<Gun> getListGun() {
        return listGun;
    }

    public void setListGun(ArrayList<Gun> listGun) {
        this.listGun = listGun;
    }

    public ListGunAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_gun, viewGroup, false);
        return new ListViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final ListGunAdapter.ListViewHolder listViewHolder, final int i) {
        Glide.with(context).load(getListGun().get(i).getPicture()).into(listViewHolder.imgPhoto);
        listViewHolder.tvName.setText(getListGun().get(i).getGun());
        listViewHolder.tvFrom.setText(getListGun().get(i).getStyle());

        listViewHolder.itemRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("extra_name", listGun.get(i).getGun());
                intent.putExtra("extra_image", listGun.get(i).getPicture());
                intent.putExtra("extra_dari", listGun.get(i).getDari());
                intent.putExtra("extra_SniperText",listGun.get(i).getSniper_name());
                intent.putExtra("extra_RusherText",listGun.get(i).getRusher_name());
                intent.putExtra("extra_ObserverText",listGun.get(i).getObserver_name());
                intent.putExtra("extra_SupportText",listGun.get(i).getSupport_name());
                intent.putExtra("extra_Sniper",listGun.get(i).getSniper());


                context.startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return listGun.size();
    }


    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvFrom;
        CardView itemRow;

        ListViewHolder(View itemView) {
            super(itemView);
            itemRow = itemView.findViewById(R.id.item_row);
            imgPhoto = itemView.findViewById(R.id.img_item_gun);
            tvName = itemView.findViewById(R.id.tv_name);
            tvFrom = itemView.findViewById(R.id.tv_type);
        }
    }

}