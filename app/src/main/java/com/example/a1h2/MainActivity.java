package com.example.a1h2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText tv1 , tv2 , tv3;
    private Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.ed_person);
        tv2 = findViewById(R.id.ed_theme);
        tv3 = findViewById(R.id.ed_massenge);
        button1 = findViewById(R.id.bt_send);
        button2 = findViewById(R.id.bt_camera);
        initBut2();
        initBut();
    }

    private void initBut2() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tv1.getText().toString().isEmpty() && tv2.getText().toString().isEmpty() && tv3.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Заполните все поля ", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("plain/text");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{tv1.getText().toString()});
                    intent.putExtra(Intent.EXTRA_SUBJECT, tv2.getText().toString());
                    intent.putExtra(Intent.EXTRA_TEXT, tv3.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }


    private void initBut() {
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(in);
            }
        });
    }


}