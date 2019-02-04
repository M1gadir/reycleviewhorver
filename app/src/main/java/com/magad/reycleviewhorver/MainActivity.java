package com.magad.reycleviewhorver;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Listhorbuah adapter;
    ListVerBuah adapterr;
    public RecyclerView rvhor,rvver;

    String[] jenisbuh   ={"buah-buahan","kacang-kacangan","sayuran","makanan","Buah Berair"};
    String[] buah       ={"apel","jagung","pisang","Semangka","Wortel"};

    int[] imgbuah       = {R.drawable.apple,R.drawable.corn,R.drawable.bananas,R.drawable.watermelon,R.drawable.carrot};
    int[] jenisimg      = {R.drawable.fruit,R.drawable.peanuts,R.drawable.vegetables,R.drawable.groceries,R.drawable.watermelon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        adapter = new Listhorbuah();
        rvhor = findViewById(R.id.rvho);
        rvhor.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rvhor.setAdapter(adapter);
        adapterr = new ListVerBuah();
        rvver = findViewById(R.id.rvve);
        rvver.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rvver.setAdapter(adapterr);


    }

    private class Listhorbuah extends RecyclerView.Adapter<Listhorbuah.BuahHor> {
        @NonNull
        @Override
        public BuahHor onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listhorbuah,viewGroup,false);
            return new BuahHor(v);
        }

        @Override
        public void onBindViewHolder(@NonNull BuahHor buahHor, final int i) {
        buahHor.imv.setImageResource(jenisimg[i]);
        buahHor.tvm.setText(jenisbuh[i]);
        buahHor.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (i) {
                        case 0:
                            Toast.makeText(MainActivity.this, "ini jenis buah buahan ", Toast.LENGTH_SHORT).show();
                            break;
                        case 1:
                            Toast.makeText(MainActivity.this, "ini jenis kacang kacangan", Toast.LENGTH_SHORT).show();
                            break;
                        case 2:
                            Toast.makeText(MainActivity.this, "ini adalah buah pisang", Toast.LENGTH_SHORT).show();
                            break;
                        case 3:
                            Toast.makeText(MainActivity.this, "ini buah yang memiliki kandungan air yang banyak", Toast.LENGTH_SHORT).show();
                            break;
                        case 4:
                            Toast.makeText(MainActivity.this, "ini jenis makanan kesukaan kelinci", Toast.LENGTH_SHORT).show();
                            break;
                    }

                }
            });
        }

        @Override
        public int getItemCount() {
            return jenisbuh.length ;
        }

        public class BuahHor extends RecyclerView.ViewHolder {
            ImageView imv;
            TextView tvm;
            public BuahHor(@NonNull View itemView) {
                super(itemView);
                imv = itemView.findViewById(R.id.jenbuh);
                tvm = itemView.findViewById(R.id.tv_jenbuh);

            }

        }
    }

    private class ListVerBuah extends RecyclerView.Adapter<ListVerBuah.Buahver> {
        @NonNull
        @Override
        public Buahver onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listverbuah,viewGroup,false);
           return new Buahver(v);
        }

        @Override
        public void onBindViewHolder(@NonNull Buahver buahver,final int i) {
            buahver.tvmm.setText(buah[i]);
            buahver.imv.setImageResource(imgbuah[i]);
            buahver.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (i) {
                        case 0:
                            Toast.makeText(MainActivity.this, "ini buah merk macbook ", Toast.LENGTH_SHORT).show();
                            break;
                        case 1:
                            Toast.makeText(MainActivity.this, "ini buah ada di pop corn", Toast.LENGTH_SHORT).show();
                            break;
                        case 2:
                            Toast.makeText(MainActivity.this, "ini jenis sayuran", Toast.LENGTH_SHORT).show();
                            break;
                        case 3:
                            Toast.makeText(MainActivity.this, "ini jenis makanan", Toast.LENGTH_SHORT).show();
                            break;
                        case 4:
                            Toast.makeText(MainActivity.this, "ini jenis buah berair", Toast.LENGTH_SHORT).show();
                            break;
                    }

                }
            });
        }

        @Override
        public int getItemCount() {
            return buah.length ;
        }

        public class Buahver extends RecyclerView.ViewHolder {

            ImageView imv;
            TextView tvmm;
            public Buahver(@NonNull View itemView) {
                super(itemView);
                imv = itemView.findViewById(R.id.imviewbuah);
                tvmm = itemView.findViewById(R.id.tvver);


            }
        }
    }
}
