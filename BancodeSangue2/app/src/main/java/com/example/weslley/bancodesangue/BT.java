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
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Weslley on 04/05/2017.
 */

public class BT extends AsyncTask <String, Void, List<String>>{

    Context ctx;

    BT(Context ctx) {

        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected List<String> doInBackground(String... params) {

        String cidadeURL = "http://192.168.25.7/banco_sangue/cidade.php";

        String metodo = params[0];

        List<String> lista = new ArrayList<>();

        if (metodo.equals("cidade")) {

            String cidade = params[1];

            try {

                URL url = new URL(cidadeURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");

                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

                String data = URLEncoder.encode("cidade", "UTF-8") + "=" + URLEncoder.encode(cidade, "UTF-8");

                bw.write(data);
                bw.flush();
                bw.close();
                os.close();

                InputStream is = httpURLConnection.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is, "iso-8859-1"));

                String row;

                while ((row = br.readLine()) != null) {

                    lista.add(row);
                }

                br.close();
                is.close();

                httpURLConnection.disconnect();

                return lista;
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    protected void onPostExecute (List<String> lista) {

        for (String str : lista) {
            Toast.makeText(ctx, str, Toast.LENGTH_LONG).show();
        }

    }

}
