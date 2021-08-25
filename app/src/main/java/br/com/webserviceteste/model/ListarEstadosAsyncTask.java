package br.com.webserviceteste.model;

import android.os.AsyncTask;
import android.util.Log;

public class ListarEstadosAsyncTask extends  AsyncTask<String, String, String> {

    String api_token;
    public ListarEstadosAsyncTask(String token) {
        this.api_token =  token;
    }

    @Override
    protected void onPreExecute(){
        Log.i("APIListar" , "onPreExecute()");
    }

    @Override
    protected String doInBackground(String... strings) {

        Log.i("APIListar" , "doInBackground()");

        return "processado com sucesso";
    }

    @Override
    protected void onPostExecute(String result){
        Log.i("APIListar" , "onPostExecute() --> " + result);
    }
}
