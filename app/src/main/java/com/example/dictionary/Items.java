package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dictionary.Adapter.WordAdapter;

import java.util.ArrayList;

public class Items extends AppCompatActivity  implements WordAdapter.OnWordListener {
    TextView audio;

    ArrayList<Word> myWords = new ArrayList<Word>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        audio = findViewById(R.id.sound);

         RecyclerView list = findViewById(R.id.show_list);



        Bundle bundle = getIntent().getExtras();

        switch (bundle.getString("key")) {
            case "one":
                myWords.add(new Word("Name", "At", R.raw.name));
                myWords.add(new Word("Moon", "Ay", R.raw.moon));
                myWords.add(new Word("Bread", "Nan", R.raw.bread));
                myWords.add(new Word("School", "Mektep", R.raw.school));
                myWords.add(new Word("Milk", "Su`t", R.raw.milk));
                myWords.add(new Word("Ruler", "Sizg`ish", R.raw.ruler));
                myWords.add(new Word("Pen", "Qa`lem", R.raw.pen));
                myWords.add(new Word("Cat", "Pishiq", R.raw.cat));
                myWords.add(new Word("Dog", "Iyt", R.raw.dog));
            break;
            case "two":
                myWords.add(new Word("Month", "Ay", R.raw.month));
                myWords.add(new Word("Year", "Jil", R.raw.year));
                myWords.add(new Word("Day", "Ku'n", R.raw.day));
                myWords.add(new Word("Programming", "Da`stu`lew", R.raw.programming));
                myWords.add(new Word("Book", "Kita`p", R.raw.book));
                myWords.add(new Word("Elephant", "Pil", R.raw.elephant));
                myWords.add(new Word("Horse", "At", R.raw.horse));
            break;
            case "three":
                myWords.add(new Word("Line", "Siziq", R.raw.line));
                myWords.add(new Word("Mouse", "Tishqan", R.raw.mouse));
                myWords.add(new Word("Keyboard", "Klaviyatura", R.raw.keyboard));
                myWords.add(new Word("Phone", "Telefon", R.raw.phone));
                myWords.add(new Word("Meat", "Go`sh", R.raw.meat));
                myWords.add(new Word("Body", "Dene", R.raw.body));
                myWords.add(new Word("Word", "So'z", R.raw.word));
                myWords.add(new Word("Pencil", "Ruchka", R.raw.pencil));
            break;
            case "four":
                myWords.add(new Word("Blackboard", "Doska(Taxta)", R.raw.blackboard));
                myWords.add(new Word("Task ", "Tapsirma", R.raw.task));
                myWords.add(new Word("Home task", "U'yge tapsirma", R.raw.hometask));
                myWords.add(new Word("Teacher", "Mug`allim", R.raw.teacher));
                myWords.add(new Word("Knife", "Pishaq", R.raw.knife));
                myWords.add(new Word("Eye", "Ko'z", R.raw.eye));
                myWords.add(new Word("Foot", "Ayaq", R.raw.foot));
                myWords.add(new Word("Tooth", "Tis", R.raw.tooth));
            break;

        }

         WordAdapter adapter= new WordAdapter(myWords, this);


        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onWordClick(int position) {
        int m = myWords.get(position).getAudioResourceId();
        MediaPlayer mediaPlayer = MediaPlayer.create(this, m);
        mediaPlayer.start();
    }
}
