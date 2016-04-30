package com.example.glmgracy.currencies;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 桂新 on 2016/4/29.
 */
public class JSONParser {
    static InputStream sInputStream = null;
    static JSONObject sReturnJsonObject = null;
    static String sRawJsonString = "";
    String aaa = "";

    public JSONParser() {
    }

    public JSONObject getJSONFromUrl(String url) {
        //attempt to get response from server
        try {
            URL url2 = new URL(url);
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) url2.openConnection();
                InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                aaa = readStream(inputStream);

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        }
        try {
            sReturnJsonObject = new JSONObject(aaa);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sReturnJsonObject;
    }

    private String readStream(InputStream in) {
        Log.v("Util", "readStream");
        BufferedReader reader = null;
        String json = "";
        try {
            String line = "";
            reader = new BufferedReader(new InputStreamReader(in));
            while ((line = reader.readLine()) != null) {
                json += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return json;
    }
}
