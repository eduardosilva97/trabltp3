package com.example.weslley.bancodesangue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class PesquisaActivity extends AppCompatActivity {

    Button btnVoltar, btnCidade, btnEstado, btnGrupoSanguineo;
    Spinner spnGrupoSanguineo;
    EditText txtCidade, txtEstado;

    String cidade, estado, grupoSanguineo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);

        txtCidade         = (EditText) findViewById(R.id.txtCidade);
        txtEstado         = (EditText) findViewById(R.id.txtEstado);
        btnVoltar         = (Button) findViewById(R.id.btnVoltar);
        btnCidade         = (Button) findViewById(R.id.btnCidade);
        btnEstado         = (Button) findViewById(R.id.btnEstado);
        btnGrupoSanguineo = (Button) findViewById(R.id.btnGrupoSanguineo);
        spnGrupoSanguineo = (Spinner) findViewById(R.id.spnGrupoSanguineo);

        carregarSpinnerGrupoSanguineo();

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnCidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PesquisaActivity.this, ExibicaoActivity.class);

                startActivity(intent);

                cidade = txtCidade.getText().toString();

                String metodo = "cidade";

                BT bt = new BT(PesquisaActivity.this);

                bt.execute (metodo, cidade);
            }
        });

        btnEstado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PesquisaActivity.this, ExibicaoActivity.class);

                startActivity(intent);
            }
        });

        btnGrupoSanguineo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PesquisaActivity.this, ExibicaoActivity.class);

                startActivity(intent);


            }
        });

    }





    private void carregarSpinnerGrupoSanguineo ()
    {
        List<String> opcoes = new ArrayList<>();

        opcoes.add("O-");
        opcoes.add("O+");
        opcoes.add("A-");
        opcoes.add("A+");
        opcoes.add("B-");
        opcoes.add("B-");
        opcoes.add("AB-");
        opcoes.add("AB+");

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, opcoes);

        spnGrupoSanguineo = (Spinner) findViewById(R.id.spnGrupoSanguineo);
        spnGrupoSanguineo.setAdapter(adapter);
    }
}
