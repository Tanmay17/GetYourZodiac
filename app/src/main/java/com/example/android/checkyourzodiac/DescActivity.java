package com.example.android.checkyourzodiac;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DescActivity extends AppCompatActivity {

    ImageView iv;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc);
        Intent intn=getIntent();
        Bundle b=intn.getExtras();
        String sign=b.getString("sign");
        String horoscope=b.getString("horoscope");
        tv=(TextView)findViewById(R.id.textView);
        iv=(ImageView)findViewById(R.id.imageView13);
        tv.setText(horoscope);
        updateImage(sign);
    }
    void updateImage(String sign){
        switch (sign){
            case "Aries":
                iv.setImageResource(R.drawable.xaries_horoscope);
                break;
            case "Aquarius":
                iv.setImageResource(R.drawable.xaquarius_horoscope);
                break;
            case "Cancer":
                iv.setImageResource(R.drawable.xcancer_horoscope);
                break;
            case "Capricorn":
                iv.setImageResource(R.drawable.xcapricorn_horoscope);
                break;
            case "Gemini":
                iv.setImageResource(R.drawable.xgemini_horoscope);
                break;
            case "Leo":
                iv.setImageResource(R.drawable.xleo_horoscope);
                break;
            case "Libra":
                iv.setImageResource(R.drawable.xlibra_horoscope);
                break;
            case "Pisces":
                iv.setImageResource(R.drawable.xpisces_horoscope);
                break;
            case "Sagittarius":
                iv.setImageResource(R.drawable.xsagittarius_horoscope);
                break;
            case "Scorpio":
                iv.setImageResource(R.drawable.xscorpio_horoscope);
                break;
            case "Taurus":
                iv.setImageResource(R.drawable.xtaurus_horoscope);
                break;
            case "Virgo":
                iv.setImageResource(R.drawable.xvirgo_horoscope);
                break;
        }
    }
}
