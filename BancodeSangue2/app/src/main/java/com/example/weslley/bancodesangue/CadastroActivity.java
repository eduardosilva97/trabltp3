package com.example.weslley.bancodesangue;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CadastroActivity extends AppCompatActivity {

    Button btnCancelar, btnCadastrar;
    EditText txtNome, txtCPF, txtRG, txtEndereço, txtBairro, txtCidade, txtEstado,
             txtTelPes, txtTelCom, txtTelRes, txtSenhaCad1, txtSenhaCad2, txtEmail;
    Spinner spnGrupoSanguineo, spnDia, spnMes, spnAno;
    String nome, email, CPF, RG, endereco, bairro, cidade, estado, telPes, telRes, telCom, senhaCad1, senhaCad2, grupoSanguineo, dia, mes, ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btnCancelar  = (Button) findViewById(R.id.btnCancelar);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        txtNome      = (EditText) findViewById(R.id.txtNome);
        txtCPF       = (EditText) findViewById(R.id.txtCPF);
        txtRG        = (EditText) findViewById(R.id.txtRG);
        txtEndereço  = (EditText) findViewById(R.id.txtEndereco);
        txtBairro    = (EditText) findViewById(R.id.txtBairro);
        txtCidade    = (EditText) findViewById(R.id.txtCidade);
        txtEstado    = (EditText) findViewById(R.id.txtEstado);
        txtTelPes    = (EditText) findViewById(R.id.txtTelPes);
        txtTelCom    = (EditText) findViewById(R.id.txtTelCom);
        txtTelRes    = (EditText) findViewById(R.id.txtTelRes);
        txtSenhaCad1 = (EditText) findViewById(R.id.txtSenhaCad1);
        txtSenhaCad2 = (EditText) findViewById(R.id.txtSenhaCad2);
        txtEmail     = (EditText) findViewById(R.id.txtEmailCad);

        carregarSpinnerGrupoSanguineo();

        carregarSpinnerDias();
        carregarSpinnerMeses();
        carregarSpinnerAnos();

        btnCadastrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                nome           = txtNome.getText().toString();
                email          = txtEmail.getText().toString();
                CPF            = txtCPF.getText().toString();
                RG             = txtRG.getText().toString();
                endereco       = txtEndereço.getText().toString();
                bairro         = txtBairro.getText().toString();
                cidade         = txtCidade.getText().toString();
                estado         = txtEstado.getText().toString();
                telPes         = txtTelPes.getText().toString();
                telRes         = txtTelRes.getText().toString();
                telCom         = txtTelCom.getText().toString();
                senhaCad1      = txtSenhaCad1.getText().toString();
                senhaCad2      = txtSenhaCad2.getText().toString();
                grupoSanguineo = spnGrupoSanguineo.getSelectedItem().toString();
                dia            = spnDia.getSelectedItem().toString();
                mes            = spnMes.getSelectedItem().toString();
                ano            = spnAno.getSelectedItem().toString();

                if (senhaCad1.equals(senhaCad2)) {
                    String metodo = "registro";

                    BackgroundTask backgroundTask = new BackgroundTask(CadastroActivity.this);

                    backgroundTask.execute(metodo, nome, RG, CPF, endereco, bairro, cidade, estado, telPes, telRes, telCom, senhaCad1, grupoSanguineo, ano + "-" + mes + "-" + dia, email);

                    finish();
                }
                else
                    Toast.makeText(CadastroActivity.this, "Senhas não coincidem.", Toast.LENGTH_LONG).show();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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

    private void carregarSpinnerDias ()
    {
        List<Integer> dias = new ArrayList<>();

        for (int i = 1; i < 32; i++)
            dias.add(i);

        ArrayAdapter adapterDias = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, dias);

        spnDia = (Spinner) findViewById(R.id.spnDia);
        spnDia.setAdapter(adapterDias);
    }

    private void carregarSpinnerMeses ()
    {
        List<Integer> meses = new ArrayList<>();

        for (int i = 1; i < 13; i++)
            meses.add(i);

        ArrayAdapter adapterDias = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, meses);

        spnMes = (Spinner) findViewById(R.id.spnMes);
        spnMes.setAdapter(adapterDias);
    }

    private void carregarSpinnerAnos ()
    {
        List<Integer> anos = new ArrayList<>();

        for (int i = 1999; i > 1959; i--)
            anos.add(i);

        ArrayAdapter adapterDias = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, anos);

        spnAno = (Spinner) findViewById(R.id.spnAno);
        spnAno.setAdapter(adapterDias);
    }
}
