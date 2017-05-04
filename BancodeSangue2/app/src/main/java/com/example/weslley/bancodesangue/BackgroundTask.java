package com.example.weslley.bancodesangue;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Weslley on 03/05/2017.
 */

public class BackgroundTask extends AsyncTask <String, Void, String> {

    Context ctx;
    AlertDialog alertDialog;

    BackgroundTask (Context ctx) {

        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute () {
        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Informações do login");
    }

    @Override
    protected String doInBackground(String... params) {

        String loginURL = "http://192.168.25.7/banco_sangue/login.php";
        String registroURL = "http://192.168.25.7/banco_sangue/registro.php";

        String metodo = params[0];

        if (metodo.equals("registro")) {
            String nome           = params[1];
            String RG             = params[2];
            String CPF            = params[3];
            String endereco       = params[4];
            String bairro         = params[5];
            String cidade         = params[6];
            String estado         = params[7];
            String telPes         = params[8];
            String telRes         = params[9];
            String telCom         = params[10];
            String senhaCad       = params[11];
            String grupoSanguineo = params[12];
            String dataNascimento = params[13];
            String email          = params[14];

            try {
                URL url = new URL(registroURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");

                // httpURLConnection.setDoOutput(true);

                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("nome", "UTF-8") + "=" + URLEncoder.encode(nome, "UTF-8") + "&" +
                        URLEncoder.encode("CPF", "UTF-8") + "=" + URLEncoder.encode(CPF, "UTF-8") + "&" +
                        URLEncoder.encode("RG", "UTF-8") + "=" + URLEncoder.encode(RG, "UTF-8") + "&" +
                        URLEncoder.encode("endereco", "UTF-8") + "=" + URLEncoder.encode(endereco, "UTF-8") + "&" +
                        URLEncoder.encode("bairro", "UTF-8") + "=" + URLEncoder.encode(bairro, "UTF-8") + "&" +
                        URLEncoder.encode("cidade", "UTF-8") + "=" + URLEncoder.encode(cidade, "UTF-8") + "&" +
                        URLEncoder.encode("estado", "UTF-8") + "=" + URLEncoder.encode(estado, "UTF-8") + "&" +
                        URLEncoder.encode("telPes", "UTF-8") + "=" + URLEncoder.encode(telPes, "UTF-8") + "&" +
                        URLEncoder.encode("telCom", "UTF-8") + "=" + URLEncoder.encode(telCom, "UTF-8") + "&" +
                        URLEncoder.encode("telRes", "UTF-8") + "=" + URLEncoder.encode(telRes, "UTF-8") + "&" +
                        URLEncoder.encode("senhaCad", "UTF-8") + "=" + URLEncoder.encode(senhaCad, "UTF-8") + "&" +
                        URLEncoder.encode("grupoSanguineo", "UTF-8") + "=" + URLEncoder.encode(grupoSanguineo, "UTF-8") +
                        URLEncoder.encode("dataNascimento", "UTF-8") + "=" + URLEncoder.encode(dataNascimento, "UTF-8") +
                        URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8");

                bw.write(data);
                bw.flush();
                bw.close();
                os.close();
                InputStream is = httpURLConnection.getInputStream();
                is.close();
                //httpURLConnection.connect();
                httpURLConnection.disconnect();

                return "Registro bem sucedido!";
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

        }
        else {
            if (metodo.equals("login")) {

                String email = params[1];
                String senha = params[2];

                try {
                    URL url = new URL(loginURL);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream os = httpURLConnection.getOutputStream();
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                    String data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&" +
                            URLEncoder.encode("senha", "UTF-8") + "=" + URLEncoder.encode(senha, "UTF-8");

                    bw.write(data);
                    bw.flush();
                    bw.close();
                    os.close();

                    InputStream is = httpURLConnection.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is, "iso-8859-1"));

                    String response = "";
                    String line = "";

                    while ((line = br.readLine()) != null) {

                        response += line;
                    }

                    br.close();
                    is.close();
                    //httpURLConnection.connect();
                    httpURLConnection.disconnect();

                    return response;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }



    @Override
    protected void onProgressUpdate (Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        if (result.equals("Registro bem sucedido!")){
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }
        else {
            alertDialog.setMessage(result);
            alertDialog.show();
        }
    }
}
