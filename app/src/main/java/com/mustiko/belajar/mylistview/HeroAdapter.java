package com.mustiko.belajar.mylistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HeroAdapter extends BaseAdapter {

    // data yang sudah didapatkan dalam bentul arraylist heroes maka akan di oleh di class ini
    // untuk di tampilkan ke listview

    // todo 5
    private Context context;

    // variabel heroes berfungsi untuk menampung data yang dikirim dari activity
    // dan digunakan sebagai sumber data ke dalam view holder
    private ArrayList<Hero> heroes = new ArrayList<>();

    //setter hasil generate
    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    // Constructor digunakan untuk mengirimkan data
    // atau melakukan suatu proses ketika suatu obyek diinisialisasi.
    //constructor hasil generate
    // Dalam kasus ini constructor digunakan untuk mengirim context ke dalam adapter,
    // karena itulah saat inisialisasi HeroAdapter terdapat parameter this yang merupakan context dari activity.
    // Di sini juga dibedakan antara mengirim context dan mengirim data supaya inisialisasi adapter hanya sekali saja, tidak berulang kali.
    public HeroAdapter(Context context) {
        this.context = context;
    }

    // untuk mengetahui berapa banyak item yang akan ditampilkan
    @Override
    public int getCount() {
        return heroes.size();
    }

    @Override
    public Object getItem(int i) {
        return heroes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    // memanggil layout
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(itemView);
        Hero hero = (Hero) getItem(i);
        viewHolder.bind(hero);
        return itemView;
    }

    // melakukan manipulasi berupa inisialisasi dan casting komponen yang akan digunakan di listview
    // untuk menjadi tempat data
    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;
        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }
        void bind(Hero hero) {
            txtName.setText(hero.getName());
            txtDescription.setText(hero.getDescription());
            imgPhoto.setImageResource(hero.getPhoto());
        }
    }
}
