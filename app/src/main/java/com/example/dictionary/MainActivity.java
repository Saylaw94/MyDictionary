package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView cat1, cat2, cat3, cat4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         cat1 = findViewById(R.id.cat1);
         cat2 = findViewById(R.id.cat2);
         cat3 = findViewById(R.id.cat3);
         cat4 = findViewById(R.id.cat4);

        cat1.setOnClickListener(this);
        cat2.setOnClickListener(this);
        cat3.setOnClickListener(this);
        cat4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, Items.class);
        switch (v.getId()){
            case R.id.cat1:
                intent.putExtra("key", "one");
                startActivity(intent);
            break;
            case R.id.cat2:
                intent.putExtra("key", "two");
                startActivity(intent);
            break;
            case R.id.cat3:
                intent.putExtra("key", "three");
                startActivity(intent);
                break;
            case R.id.cat4:
                intent.putExtra("key", "four");
                startActivity(intent);
            break;
        }
    }
}
