package com.mustiko.belajar.mylistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // todo 2 listview dengan array adapter sebagai adapter dari data bertipe array
//    private String[] dataName = {"Cut Nyak Dien","Ki Hajar Dewantara",
//            "Moh Yamin","Patimura","R A Kartini","Sukarno"};

    // todo 7
    private HeroAdapter adapter;
    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private ArrayList<Hero> heroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ini di pakai untuk array adapter
//        ListView listView = findViewById(R.id.lv_list);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, android.R.id.text1, dataName);
//
//        listView.setAdapter(adapter);

        ListView listView = findViewById(R.id.lv_list);
        adapter = new HeroAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, heroes.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // mengambil / insiasi setiap data array dari resource string
    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    // memasukkan data-data ke arraylist supanya bisa diproses oleh adapter
    private void addItem() {
        heroes = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Hero hero = new Hero();
            hero.setPhoto(dataPhoto.getResourceId(i, -1));
            hero.setName(dataName[i]);
            hero.setDescription(dataDescription[i]);

            // arraylist heroes di masukkan data yang ada di class hero yang sebelumnya sudah di set
            heroes.add(hero);
        }

        // memasukkan data yang ada di arraylist heroes ke dalam adapter
        adapter.setHeroes(heroes);
    }


}
