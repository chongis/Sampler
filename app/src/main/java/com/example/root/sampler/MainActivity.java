package com.example.root.sampler;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.Button;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {
    int legs = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout ll = (LinearLayout)findViewById(R.id.m);
        ll.setOrientation(LinearLayout.VERTICAL);
        // add text view
        TextView tv = new TextView(this);
        tv.setText("Dynamic Text!");
        tv.setTextSize(36);
        tv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        ll.addView(tv);


    }

    public void test() {
        LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = vi.inflate(R.layout.activity_main, null);


// insert into main view
        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.m);
        insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));

    }
    private void decrease(View view) {
        String IdAsString = view.getResources().getResourceName(view.getId());
        if (IdAsString == "legsdec") {
            if (legs > 0){
                legs -= 1;
            }
            TextView quantityTextView = (TextView) findViewById(R.id.legsnum);
            quantityTextView.setText("" + legs);

        }



    }
    private void increase(View view) {
        legs += 1;

    }
    private void displayQuantity(View view) {
        String IdAsString = view.getResources().getResourceName(view.getId());
        //TextView quantityTextView = IdAsString;
        //TextView quantityTextView = (TextView) findViewById(R.id.IdAsString);
        //view.getId().setText("" + 2);

    }
}