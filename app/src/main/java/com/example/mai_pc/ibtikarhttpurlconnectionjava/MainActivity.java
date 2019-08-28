package com.example.mai_pc.ibtikarhttpurlconnectionjava;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnHit = (Button) findViewById(R.id.btnHit);
        tvData = (TextView) findViewById(R.id.tvJsonItem);
        Button trans=(Button)findViewById(R.id.button2);

        trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,OkhttpActivity.class);
                startActivity(i);
            }
        });

        btnHit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new JsonTask().execute("https://api.themoviedb.org/3/movie/top_rated?api_key=be6e82ab66a065f245b84e4b4692aee8&language=en-US&page=1");
            }

        });


    }


    public class JsonTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }

                //first method//

//                String finaljson=buffer.toString();
//                JSONObject parentobj= new JSONObject(finaljson);
//                JSONArray parentarr= parentobj.getJSONArray("results");
//                JSONObject finalobj= parentarr.getJSONObject(0);
//                String moviename= finalobj.getString("title");
//                int vote= finalobj.getInt("vote_count");
//                return moviename + "-" + vote;


                    //second  method//
//                String finaljson=buffer.toString();
//                JSONObject parentobj= new JSONObject(finaljson);
//                JSONArray parentarr= parentobj.getJSONArray("results");
//                StringBuffer finalBufferData= new StringBuffer();

//                for(int i=0; i<parentarr.length();i++){
//                    JSONObject finalobj= parentarr.getJSONObject(i);
//                    String moviename= finalobj.getString("title");
//                    int vote= finalobj.getInt("vote_count");
//                    finalBufferData.append(moviename+"-"+ vote);
//                }
//                return finalBufferData.toString();

                String finaljson=buffer.toString();
                JSONObject parentobj= new JSONObject(finaljson);
                JSONArray parentarr= parentobj.getJSONArray("results");

                List<MovieModel> movieModelList= new ArrayList<>();
//                String result = null;
                for(int i=0; i<parentarr.length(); i++){
                    JSONObject finalobj= parentarr.getJSONObject(i);
                    MovieModel moviemodel= new MovieModel();
//                    moviemodel.setTitle(finalobj.getString("title"));
//                    moviemodel.setOriginal_language(finalobj.getString("Original_language"));
//                    moviemodel.setVote_count(finalobj.getInt("Vote_count"));
//                    moviemodel.setPopularity((float) finalobj.getDouble("Popularity"));

//result.concat(String.valueOf(moviemodel));
                    movieModelList.add(moviemodel);
                }
//                return movieModelList;



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }

                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            tvData.setText(result);
        }

    }




    }



















