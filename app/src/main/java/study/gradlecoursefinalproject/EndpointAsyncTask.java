package study.gradlecoursefinalproject;


import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.study.backend.joker.jokesApi.JokesApi;

import java.io.IOException;

import timber.log.Timber;

public class EndpointAsyncTask extends AsyncTask<Void,Void,String> {

    private static JokesApi myApiService = null;
    private static String URL = "http://192.168.1.102:8080/_ah/api/";

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null){
            JokesApi.Builder builder = new JokesApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(),null)
                    .setRootUrl(URL)
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }

        try{
            return myApiService.getJoke().execute().getData();
        }catch (IOException e){
            Timber.e(e.getMessage());
            return "error";
        }
    }

}
