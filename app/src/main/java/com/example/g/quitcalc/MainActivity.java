package com.example.g.quitcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    final String DATETIME_FORMAT = "yyyy/MM/dd HH:mm:ss";
    final String BEGINNING_DATE  = "2012/05/29 11:00:00";

    private void update_result() {
        Calendar cal = Calendar.getInstance();
        long now = cal.getTimeInMillis();

        SimpleDateFormat format = new SimpleDateFormat(DATETIME_FORMAT);
        try {
            cal.setTime(format.parse(BEGINNING_DATE));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long beg = cal.getTimeInMillis();
        int diff = (int)((now - beg) / (1000 * 60 * 60 * 24));
        Log.i("test", String.valueOf(now));

        TextView start_date = (TextView)findViewById(R.id.textView);
        start_date.setText("開始日：" + BEGINNING_DATE);

        TextView result = (TextView)findViewById(R.id.textView2);
        result.setText(String.valueOf(diff));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onResume() {
        super.onResume();
        update_result();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
