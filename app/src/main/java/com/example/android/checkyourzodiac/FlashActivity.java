package com.example.android.checkyourzodiac;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

public class FlashActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        tv=(TextView)findViewById(R.id.textView2);
        tv.setText(Html.fromHtml("<html>&copy;copyright 2016-2017</html>"));
        new Mythread().start();
    }
    public class Mythread extends Thread
    {
        int i=0;
        @Override
        public void run() {
            try {
                Thread.sleep(10*1000);
            }catch(Exception e)
            {}
            Intent intn=new Intent(FlashActivity.this,
                    MainActivity.class);
            startActivity(intn);
        }
    }

}
