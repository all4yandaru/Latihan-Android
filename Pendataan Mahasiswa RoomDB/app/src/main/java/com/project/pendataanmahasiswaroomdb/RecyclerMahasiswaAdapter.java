package com.project.pendataanmahasiswaroomdb;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

// TODO 15: buat kerangka recyclerview, alt enter aja yg merah merah
public class RecyclerMahasiswaAdapter extends RecyclerView.Adapter<RecyclerMahasiswaAdapter.ViewHolder> {

    // TODO 16: tambahin variabel ini & constructornya
    private List<Mahasiswa> daftarMahasiswa;
    private AppDatabase appDatabase;
    private Context context;

    public RecyclerMahasiswaAdapter(List<Mahasiswa> daftarMahasiswa, Context context) {
        this.daftarMahasiswa = daftarMahasiswa;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // TODO 18: Inisialisasi Layout Item untuk RecyclerView
        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewframe, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        // TODO 19: Deklarasi Variable untuk mendapatkan data dari Database melalui Array
        String getNIM = daftarMahasiswa.get(position).getNim();
        String getNama = daftarMahasiswa.get(position).getNama();

        //Menampilkan data berdasarkan posisi Item dari RecyclerView
        holder.Nim.setText(getNIM);
        holder.Nama.setText(getNama);

        // TODO 24: buat on long click biar ada pilihan update / delete kalo di klik nanti
        holder.item.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CharSequence[] menuPilihan = {"Edit", "Delete"};
                AlertDialog.Builder dialog = new AlertDialog.Builder(v.getContext())
                        .setTitle("Pilih Aksi")
                        .setItems(menuPilihan, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which){
                                    case 0:
                                    /*
                                     Menjalankan Perintah Edit Data
                                     Menggunakan Bundle untuk mengambil data yang akan Diedit
                                     */
                                        onEditData(position, context);
                                        break;

                                    case 1:
                                    /*
                                     Menjalankan Perintah Delete Data
                                     Akan dibahas pada Tutorial selanjutnya
                                     */
                                    // TODO 28: buat method utk delete
                                        onDeleteData(position, context);
                                        break;
                                }
                            }
                        });
                dialog.create();
                dialog.show();
                return true;
            }
        });
    }

    //Menghapus Data dari Room Database yang dipilih oleh user
    private void onDeleteData(int position, Context context) {
        appDatabase = Room.databaseBuilder(context,
                AppDatabase.class, "dbMahasiswa").allowMainThreadQueries().build();

        Mahasiswa mhs = new Mahasiswa();
        mhs.setNim(daftarMahasiswa.get(position).getNim());
        appDatabase.mahasiswaDAO().deleteMahasiswa(mhs);
        Toast.makeText(context, "Data Berhasil Dihapus", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(context, ReadDataActivity.class);
        context.startActivity(intent);
        ((Activity)context).finish();
    }

    // TODO 25: Mengirim Data yang akan diedit dari ArrayList berdasarkan posisi item pada RecyclerView
    private void onEditData(int position, Context context){
        context.startActivity(new Intent(context, EditActivity.class).putExtra("data", daftarMahasiswa.get(position)));
        ((Activity)context).finish();
    }

    @Override
    public int getItemCount() {
        // TODO 20: Menghitung data / ukuran dari Array
        return daftarMahasiswa.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // TODO 17: deklarasi variabel yg ada di dalam desain recycler view
        private TextView Nim, Nama;
        private CardView item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Nim = itemView.findViewById(R.id.nim);
            Nama = itemView.findViewById(R.id.nama);
            item = itemView.findViewById(R.id.cvMain);
        }
    }
}
