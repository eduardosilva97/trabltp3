package com.example.weslley.bancodesangue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ExibicaoActivity extends AppCompatActivity {

    ListView lstDoadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibicao);

        lstDoadores = (ListView) findViewById(R.id.lstDoadores);


    }
}
