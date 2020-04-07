package com.latihan.itcproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//TODO 8. BUAT ADAPTERNYA, TERUS ALT ENTER SEMUA YANG MERAH

public class MinumanAdapter extends RecyclerView.Adapter<MinumanAdapter.VH> {

    //HABIS DITARUH DI RAK / NAMPAN, SEKARANG MMAU DIPINDAH KE NAMPAN ADAPTER

    private ArrayList<Minuman> listMinuman; //buat nampannya adapter

    //TODO 9. BUAT CONSTRUCTORNYA PAKEK ALT+INSERT >>> CONSTRUCTOR

    public MinumanAdapter(ArrayList<Minuman> listMinuman) {
        this.listMinuman = listMinuman;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cetakan_gelas, parent, false);
        return new VH(view);
    }

    //TODO 11. SISANYA LIAT AJA DI SINI :3

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Minuman minuman = listMinuman.get(position);

        holder.tvNama.setText(minuman.getNama());
        holder.tvHarga.setText(""+minuman.getHarga());
        holder.tvDesc.setText(minuman.getDesc());
    }

    @Override
    public int getItemCount() {
        return listMinuman.size();
    }


    //TODO 10. DEKLARASIIN DATA DATA YANG MAU DIPAKEK

    public class VH extends RecyclerView.ViewHolder {
        TextView tvNama, tvHarga, tvDesc;
        public VH(@NonNull View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.tv_nama);
            tvDesc = itemView.findViewById(R.id.tv_desc);
            tvHarga = itemView.findViewById(R.id.tv_harga);
        }
    }
}
