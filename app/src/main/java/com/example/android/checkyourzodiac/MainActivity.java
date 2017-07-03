package com.example.android.checkyourzodiac;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    String sign;
    public void callServer(View arg){
        int id=arg.getId();
        if(id==R.id.img1){
            sign="Aries";
        }else if(id==R.id.img2){
            sign="Aquarius";
        }else if(id==R.id.img3){
            sign="Cancer";
        }else if(id==R.id.img4){
            sign="Capricorn";
        }else if(id==R.id.img5){
            sign="Gemini";
        }else if(id==R.id.img6){
            sign="Leo";
        }else if(id==R.id.img7){
            sign="Libra";
        }else if(id==R.id.img8){
            sign="Pisces";
        }else if(id==R.id.img9){
            sign="Sagittarius";
        }else if(id==R.id.img10){
            sign="Scorpio";
        }else if(id==R.id.img11){
            sign="Taurus";
        }else if(id==R.id.img12){
            sign="Virgo";
        }
        Mytask task=new Mytask();
        task.execute(sign);
    }
    public class Mytask extends AsyncTask<String,Integer,String>
    {
        ProgressDialog pd;
        @Override
        protected void onPreExecute() {
            pd=new ProgressDialog(MainActivity.this);
            pd.setMessage("Please wait...");
            pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pd.setCancelable(false);
            pd.show();
        }
        String h;
        @Override
        protected String doInBackground(String... params) {
            try {
                URL url = new URL(
                        "http://www.prokerala.com/astrology/horoscope/?sign=" + params[0]);
                InputStream in = url.openStream();
                DataInputStream din = new DataInputStream(in);
                String res = "", s;
                while ((s = din.readLine()) != null) {
                    res += s;
                }
                String srch = "<h2>" + params[0] + " Love & Relationship Horoscope</h2>";
                int index1 = res.indexOf(srch) + srch.length();
                int index2 = res.indexOf("</p>", index1);
                h = res.substring(index1+3, index2);
            }catch(Exception e){}
            return h;
        }

        @Override
        protected void onPostExecute(String s) {
            pd.dismiss();
            Intent intn=new Intent(MainActivity.this,DescActivity.class);
            intn.putExtra("sign",sign);
            intn.putExtra("horoscope",s);
            startActivity(intn);
        }
    }
}
