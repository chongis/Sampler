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

import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    String[] tosend = new String[3];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void test() {
        LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = vi.inflate(R.layout.activity_main, null);


// insert into main view
        //ViewGroup insertPoint = (ViewGroup) findViewById(R.id.m);
        //insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));

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
        if (previ != 0) {
            previ -= 1;
        }
        double costnow = (double) previ * ppuf;
        String thenew = Integer.toString(previ);
        quantity.setText(thenew);
        //cost.setText("$" + Double.toString(costnow));
        Formatter fmt = new Formatter();
        fmt.format("%.2f", costnow);

        cost.setText("$" + fmt);

        displayTotal(view);
        //if (IdAsString == "com.example.root.sampler:id/legsdec") {
        //    if (legs > 0){
        //        legs -= 1;
        //    }
        //    TextView quantityTextView = (TextView) findViewById(R.id.legsnum);
        //    quantityTextView.setText("" + legs);
        //}




    }
    public void increase(View view) {
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
        //cost.setText("$" + Double.toString(costnow));
        Formatter fmt = new Formatter();
        fmt.format("%.2f", costnow);

        cost.setText("$" + fmt);
        displayTotal(view);

    }
    public void displayTotal(View view) {
        //String IdAsString = view.getResources().getResourceName(view.getId());
        //TextView quantityTextView = IdAsString;
        //TextView quantityTextView = (TextView) findViewById(R.id.IdAsString);
        //view.getId().setText("" + 2);
        String[] items = {"legs","burger","ling"};

        double finaltotal = 0;

        LinearLayout ll = (LinearLayout)findViewById(R.id.totalprice);
        ll.removeAllViews();
        ll.setOrientation(LinearLayout.VERTICAL);
        // add text view

        for (int c = 0;c < 3 ; c++) {
            TextView tv = new TextView(this);
            String IdAsString = "com.example.root.sampler:id/";
            String temp = IdAsString + items[c];

            String numberItems = temp + "num";
            String totalCost = temp +"cost";
            String ppuString = temp +"ppu";

            int name = getResources().getIdentifier(temp, "id", getPackageName());
            int ppu = getResources().getIdentifier(ppuString, "id", getPackageName());
            int nItems = getResources().getIdentifier(numberItems, "id", getPackageName());
            int tCost = getResources().getIdentifier(totalCost, "id", getPackageName());

            TextView ppuview = (TextView) findViewById(ppu);
            TextView cost = (TextView) findViewById(tCost);
            TextView quantity = (TextView) findViewById(nItems);
            TextView nameview = (TextView) findViewById(name);

            String nameof = nameview.getText().toString();

            String ppuS = ppuview.getText().toString();
            String[] fi = ppuS.split(" ");
            int lent = fi.length;
            double ppuf = Double.parseDouble(fi[(lent-1)].substring(1, fi[(lent-1)].length()));

            String prev = quantity.getText().toString();
            prev = prev.replace("\n","");
            prev = prev.replace(" ","");
            int previ = Integer.valueOf(prev);
            double costnow = (double) previ * ppuf;
            String thenew = Integer.toString(previ);
            //quantity.setText(thenew);
            //cost.setText("$" + Double.toString(costnow));
            Formatter fmt = new Formatter();
            fmt.format("%.2f", costnow);

            Formatter fmt2 = new Formatter();
            fmt2.format("%.2f", ppuf);

            String temp2 = nameof +": " + thenew + " x $"+ fmt2 + " = $" + fmt;
            tosend[c] = temp2;

            tv.setText(temp2);
            tv.setTextSize(20);
            tv.setPadding(20,20,20,20);
            tv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            ll.addView(tv);

            finaltotal += costnow;
        }
        TextView line = new TextView(this);
        line.setText("-----------------------------------------------------");
        line.setTextSize(26);
        line.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT));
        ll.addView(line);


        TextView ftotal = new TextView(this);
        finaltotal = finaltotal * 1.08;
        Formatter fmt3 = new Formatter();
        fmt3.format("%.2f", finaltotal);
        ftotal.setText("Final Total (with tax): $" + fmt3);
        ftotal.setTextSize(26);
        ftotal.setPadding(25,25,25,25);
        ftotal.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        ll.addView(ftotal);



    }
}





























