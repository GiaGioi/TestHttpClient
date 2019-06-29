package com.gioidev.testhttphttpclient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends AppCompatActivity {
    private TextView tvisConnected;
    private EditText edConnected;
    private Button btRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
//        btRequest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String urlRequest = edConnected.getText().toString();
//                if (!TextUtils.isEmpty(urlRequest)) {
//                    if(URLUtil.isHttpUrl(urlRequest)){
//
//                    }
//                }
//            }
//        });

        HttpURLConnection urlConnection = null;

        try {
            URL url = new URL("http://www.mysite.se/index.asp?data=99");

            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream stream = urlConnection.getInputStream();
            InputStreamReader streamReader = new InputStreamReader(stream);

            int data = streamReader.read();
            while (data != 1){
                char curent = (char) data;
                data = streamReader.read();
                Log.d("Request" , "ABC"+curent);
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

    }

    private void init() {
        tvisConnected = findViewById(R.id.tvConnected);
        edConnected = findViewById(R.id.edRequest);
        btRequest = findViewById(R.id.btRequest);
    }
}
