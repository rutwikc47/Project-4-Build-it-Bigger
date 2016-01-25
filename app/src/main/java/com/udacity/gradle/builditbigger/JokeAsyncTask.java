package com.udacity.gradle.builditbigger;


import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.rccorp.p4backend.myApi.MyApi;
import com.rccorp.p4backend.myApi.model.MyBean;

import java.io.IOException;

public class JokeAsyncTask extends AsyncTask<Void, Void, String> {

    String jokedata;

    @Override
    protected String doInBackground(Void... voids) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

        MyApi myApiService = builder.build();


        try {
            jokedata=myApiService.getJokes().execute().getData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jokedata;
    }

}
