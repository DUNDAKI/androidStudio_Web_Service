package br.com.webserviceteste.model;

import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.util.Log;

import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

public class ListarEstadosAsyncTask extends  AsyncTask<String, String, String> {
    String ip = "10.0.0.108";
    String ip2 = "192.168.1.108";
    String caminho = "http://ip2/curso_udemy/exer/APIListarCidades.php";
    String api_token;
    HttpURLConnection conn;
    URL url = null;
    Uri.Builder builder;
    String p ;


   private static String getIp(){
       String host,name;
       try{
           host = InetAddress.getLocalHost().getHostAddress();

       }catch (UnknownHostException e ){
           host = "Unknow";
       }
       return host;

   }



    final  int READ_TIME_OUT = 10000;
    final  int CONNECTION_TIME_OUT = 30000;

    final String URL_WEB_SERVICE = caminho;

    public ListarEstadosAsyncTask(String token) {
        this.api_token =  token;
        this.builder = new Uri.Builder();
        builder.appendQueryParameter("api_token", api_token);

        int parada  = 0;
    }

    @Override
    protected void onPreExecute(){


        Log.i("APIListar" , "onPreExecute()");

    }

    @Override
    protected String doInBackground(String... strings) {


        Log.i("APIListar", "getIp() " + getIp());
        Log.i("APIListar" , "doInBackground()");
        return "processado com sucesso";
    }

    @Override
    protected void onPostExecute(String result){
        Log.i("APIListar" , "onPostExecute() --> " + result);
    }


}
