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

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {



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
    public void decrease(View view) {
        String IdAsString = view.getResources().getResourceName(view.getId());
        int len = IdAsString.length();
        String temp = IdAsString.substring(0, (len-3));

        String numberItems = temp + "num";
        String totalCost = temp +"cost";
        String ppuString = temp +"ppu";

        int ppu = getResources().getIdentifier(ppuString, "id", getPackageName());
        int nItems = getResources().getIdentifier(numberItems, "id", getPackageName());
        int tCost = getResources().getIdentifier(totalCost, "id", getPackageName());

        TextView ppuview = (TextView) findViewById(ppu);
        TextView cost = (TextView) findViewById(tCost);
        TextView quantity = (TextView) findViewById(nItems);

        String ppuS = ppuview.getText().toString();
        String[] fi = ppuS.split(" ");
        int lent = fi.length;
        double ppuf = Double.parseDouble(fi[(lent-1)].substring(1, fi[(lent-1)].length()));

        String prev = quantity.getText().toString();
        prev = prev.replace("\n","");
        prev = prev.replace(" ","");
        int previ = Integer.valueOf(prev);
        previ += 1;
        double costnow = (double) previ * ppuf;
        String thenew = Integer.toString(previ);
        quantity.setText(thenew);
        cost.setText("$" + Double.toString(costnow));

        //if (IdAsString == "com.example.root.sampler:id/legsdec") {
        //    if (legs > 0){
        //        legs -= 1;
        //    }
        //    TextView quantityTextView = (TextView) findViewById(R.id.legsnum);
        //    quantityTextView.setText("" + legs);
        //}




    }
    public void increase(View view) {
        //legs += 1;

    }
    private void displayQuantity(View view) {
        String IdAsString = view.getResources().getResourceName(view.getId());
        //TextView quantityTextView = IdAsString;
        //TextView quantityTextView = (TextView) findViewById(R.id.IdAsString);
        //view.getId().setText("" + 2);

    }
}