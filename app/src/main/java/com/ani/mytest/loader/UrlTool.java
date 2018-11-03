package com.ani.mytest.loader;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ghost on 2018/11/3.
 */

public class UrlTool {

    public static String getDataFromUrl(String strUrl) {
        String result = "";
        InputStream in = null;
        InputStreamReader inStream = null;
        BufferedReader buffer = null;
        HttpURLConnection conn = null;
        try {
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(40000);
            conn.setReadTimeout(40000);
            conn.setUseCaches(false);
            conn.setDoOutput(false);
            conn.setInstanceFollowRedirects(false);
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Content-Type","application/json");
            conn.connect();
            if (conn.getResponseCode() >= HttpURLConnection.HTTP_OK && conn.getResponseCode() < 500) {
                if (conn.getResponseCode() >= HttpURLConnection.HTTP_BAD_REQUEST) {
                    in = conn.getErrorStream();
                } else {
                    in = conn.getInputStream();
                }
                inStream = new InputStreamReader(in);
                buffer = new BufferedReader(inStream);
                String strLine = null;
                while ((strLine = buffer.readLine()) != null) {
                    result += strLine;
                }
                JSONObject json = new JSONObject(result);
                json.put("http_code",conn.getResponseCode());
                result=json.toString();
            } else {

                in = conn.getErrorStream();
                inStream = new InputStreamReader(in);
                buffer = new BufferedReader(inStream);
                String strLine = null;
                while ((strLine = buffer.readLine()) != null) {
                    result += strLine;
                }
                JSONObject json = new JSONObject();
                json.put("http_code",conn.getResponseCode());
                result=json.toString();
            }
        } catch (Exception ex) {
            Log.e("TEST","ex="+ex);
            try {
                JSONObject json = new JSONObject();
                json.put("http_code", 0);
                result = json.toString();
            }catch(Exception e){ }
        } finally {
            try{ in.close(); }catch(Exception e){ }
            try{ buffer.close(); }catch(Exception e){ }
            try{ inStream.close(); }catch(Exception e){ }
        }
        return result;
    }
}
