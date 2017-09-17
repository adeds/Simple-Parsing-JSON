package com.noes.adeds.belajarjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private String ParsingData = "{\n" +
            "  \"status\":\"ok\",\n" +
            "  \"code\":\"200\",\n" +
            "  \"biodata\":{\n" +
            "    \"nama\":\"Bujang Lapuk ade\",\n" +
            "    \"alamat\":\"makasar\",\n" +
            "    \"etc\":{\n" +
            "      \"hobi\":\"mancing\",\n" +
            "      \"kelamin\":\"ganda\"\n" +
            "    }\n" +
            "  },\n" +
            "  \n" +
            "  \"other\":{\n" +
            "    \"tanggal\":\"30\",\n" +
            "    \"bulan\":\"jan\"\n" +
            "  }\n" +
            "}";

    private String ParsingArray = "{\n" +
            "  \"message\":\"Hello broww\",\n" +
            "  \"code\":\"200\",\n" +
            "  \n" +
            "  \"mahasiswa\":[\n" +
            "    \n" +
            "    {\n" +
            "     \"nama\":\"budi\",\n" +
            "     \"jurusan\":\"ta\"\n" +
            "    },\n" +
            "    \n" +
            "    {\n" +
            "      \"nama\":\"anduk\",\n" +
            "      \"jurusan\":\"tk\"\n" +
            "    }\n" +
            "    \n" +
            "  ],\n" +
            "  \"dosen\":\n" +
            "    {\n" +
            "         \"nama\":\"jati\"\n" +
            "    }\n" +
            "  \n" +
            "}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parsing();
        parsingArray();
    }

    private void parsingArray() {
        try{
            JSONObject induk = new JSONObject(ParsingArray);
            String pesan = induk.getString("message");
            int code = induk.getInt("code");
            JSONArray mhs = induk.getJSONArray("mahasiswa");

            for(int i =0 ; i<mhs.length();i++){
                JSONObject absen = mhs.getJSONObject(i);    //
                String nama = absen.getString("nama");
                String jurusan = absen.getString("jurusan");

            }

            JSONObject dosen = induk.getJSONObject("dosen");
            String nama = dosen.getString("nama");


        }
        catch (Exception e){
            Log.e("error",e.getMessage());
        }
    }

    private void parsing() {
        try {


            JSONObject object1 = new JSONObject(ParsingData);

            String status = object1.getString("status");
            String code = object1.getString("code");

            JSONObject object2 = object1.getJSONObject("biodata");
            String nama =object2.getString("nama");
            String alamat =object2.getString("alamat");

            JSONObject object3 = object2.getJSONObject("etc");
            String hobi = object3.getString("hobi");
            String kelamin = object3.getString("kelamin");

            JSONObject object4 = object1.getJSONObject("other");
            int tgl = object4.getInt("tanggal");
            String bulan = object4.getString("bulan");



            Log.e("data",status+" "+code);
        }catch (Exception e){
            Log.e("info",e.getMessage());
        }
    }
}
