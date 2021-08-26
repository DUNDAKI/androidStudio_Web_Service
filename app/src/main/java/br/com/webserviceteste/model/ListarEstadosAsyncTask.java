package br.com.webserviceteste.model;

import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class ListarEstadosAsyncTask extends  AsyncTask<String, String, String> {
    String ip = "10.0.0.109";
    String ip2 = "192.168.1.108";
    String query, caminho = "http://"+ip2+"/curso_udemy/exer/APIListarEstados.php";
    String api_token;
    HttpURLConnection conn;
    URL url = null;
    Uri.Builder builder;
    int response_code;
    final  int READ_TIME_OUT = 10000;
    final  int CONNECTION_TIME_OUT = 30000;

    final String URL_WEB_SERVICE = caminho;

    public ListarEstadosAsyncTask(String token){

        this.api_token = token;
        this.builder = new Uri.Builder();
        builder.appendQueryParameter("api_token", api_token);

    }

    @Override
    protected void onPreExecute(){

        Log.i("APIListar","onPreExecute()");

    }

    @Override
    protected String doInBackground(String... strings) {

        Log.i("APIListar","doInBackground()");

        // Gerar o conteúdo para a URL

        try {

            url = new URL(URL_WEB_SERVICE);

        }catch (MalformedURLException e){

            Log.i("APIListar","doInBackground() --> "+e.getMessage());

        }catch (Exception e){

            Log.i("APIListar","doInBackground() --> "+e.getMessage());
        }

        // Gerar uma requisição HTTP - POST - Result será um ArrayJson

        // conn

        try {

            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(READ_TIME_OUT);
            conn.setConnectTimeout(CONNECTION_TIME_OUT);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("charset","utf-8");

            conn.setDoInput(true);
            conn.setDoOutput(true);

            conn.connect();

        }catch (Exception e){

            Log.i("APIListar","doInBackground() --> "+e.getMessage());

        }

        // Adicionar o TOKEN e/ou outros parâmetros como por exemplo
        // um objeto a ser incluido, deletado ou alterado.
        // CRUD completo

        try {

            query = builder.build().getEncodedQuery();

            OutputStream stream = conn.getOutputStream();

            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(stream,"utf-8"));

            writer.write(query);
            writer.flush();
            writer.close();
            stream.close();

            conn.connect();


        }catch (Exception e){

            Log.i("APIListar","doInBackground() --> "+e.getMessage());


        }

        // receber o response - arrayJson
        // http - código do response | 200 | 404 | 503

        try {

            response_code = conn.getResponseCode();



        }catch (Exception e){

            Log.i("APIListar","doInBackground() --> "+e.getMessage());
        }


        return "Processamento concluído...";


    }

    @Override
    protected void onPostExecute(String result){

        Log.i("APIListar","onPostExecute()--> Result: "+result);


    }


}
