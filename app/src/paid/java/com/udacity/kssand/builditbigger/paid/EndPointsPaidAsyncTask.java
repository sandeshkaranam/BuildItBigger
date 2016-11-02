package com.udacity.kssand.builditbigger;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.kssand.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.kssand.joketellerlibrary.JokeDisplayActivity;

import java.io.IOException;

/**
 * Created by kssand on 11-Jul-16.
 */
public class EndPointsPaidAsyncTask extends AsyncTask<Context,Integer,String>{

    private static MyApi myApiService = null;
    private Context context;
    ProgressDialog progressDialog = null;

    public EndPointsPaidAsyncTask(Context context){
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();
    }

    @Override
    protected String doInBackground(Context... params) {
        if(myApiService == null) {  // Only do this once
           /* MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://192.168.1.136:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });*/
            // end options for devappserver

            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://my-cloud-endpoint.appspot.com/_ah/api/");


            myApiService = builder.build();
        }

        context = params[0];

        try {
            return myApiService.retrieveJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if(result == null || result == ""){
            result = "Sorry...We could not retrieve your joke";
        }
        progressDialog.dismiss();
        Intent clickIntent = new Intent(context, JokeDisplayActivity.class);
        clickIntent.putExtra("JOKE", result);
        context.startActivity(clickIntent);
    }
}
