package com.example.mai_pc.ibtikarhttpurlconnectionjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkhttpActivity extends AppCompatActivity {
   private TextView showjson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);

        showjson = (TextView) findViewById(R.id.jsonItem);

        String url= "https://api.themoviedb.org/3/movie/top_rated?api_key=be6e82ab66a065f245b84e4b4692aee8&language=en-US&page=1";
        OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();

        final Gson gson = new Gson();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    final MtPojo movie=gson.fromJson(response.body().string(),MtPojo.class);
//                    final String myresponse= response.body().string();
                    OkhttpActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showjson.setText( movie.getResults()[1].toString());
                        }
                    });
                }

            }
        });

    }
}