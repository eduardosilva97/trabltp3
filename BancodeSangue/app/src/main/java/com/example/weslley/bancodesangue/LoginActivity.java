package com.example.weslley.bancodesangue;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText txtEmailLog, txtSenhaLog;
    Button btnLogin;
    TextView lblCadastro;
    String email, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin    = (Button)   findViewById(R.id.btnLogin);
        txtEmailLog = (EditText) findViewById(R.id.txtEmailLog);
        txtSenhaLog = (EditText) findViewById(R.id.txtSenhaLog);
        lblCadastro = (TextView) findViewById(R.id.lblCadastro);

        lblCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent telaCadastro = new Intent(LoginActivity.this, CadastroActivity.class);

                startActivity(telaCadastro);

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = txtEmailLog.getText().toString();
                senha = txtSenhaLog.getText().toString();

                if (email.equals("") || senha.equals("")) {
                    Toast.makeText(LoginActivity.this, "Preencha o(s) campo(s) vazio(s)", Toast.LENGTH_LONG).show();
                }
                else {

                    String metodo = "login";

                    BackgroundTask backgroundTask = new BackgroundTask(LoginActivity.this);

                    backgroundTask.execute(metodo, email, senha);
                }
            }
        });
    }
}
