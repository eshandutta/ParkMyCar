package com.example.parkmycar3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Places extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        //Getting reference of widgets from the XML Layout
        /*ListView lv=(ListView)findViewById(R.id.lv);
        final TextView tv=(TextView)findViewById(R.id.tv);
        //Initializing a new String Array
        String[] zones=new String[]{
                "ECITY | Electronic City Wipro Gate",
                "ECITY | Electronic City Infosys Gate",
                "WHTFLD | Whitefield Main Road Pheonix Market City",
                "WHTFLD | Broke Field Hope Farm(Whitefield)",
                "KRMG | Koramangala Multilevel PArking",
        };
        List<String> zones_list=new ArrayList<String>(Arrays.asList(zones));
        //create a arrayadapter from list
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, zones_list);
        // Populate ListView with items from ArrayAdapter
        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String selectedItem = (String) adapterView.getItemAtPosition(i);
                if(selectedItem.equals("ECITY | Electronic City Wipro Gate"))
                {
                    Intent intent = new Intent(getApplicationContext(),Slots.class);
                    //intent.putExtra("name",classes[i]);
                    startActivity(intent);
                }
            }
        });*/

        CardView cardView1=findViewById(R.id.card_view1);
        cardView1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(getApplicationContext(),Slots.class);
                startActivity(intent);
            }
        });
        CardView cardView2=findViewById(R.id.card_view2);
        cardView2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(getApplicationContext(),Slots.class);
                startActivity(intent);
            }
        });
        CardView cardView3=findViewById(R.id.card_view3);
        cardView3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(getApplicationContext(),Slots.class);
                startActivity(intent);
            }
        });
        CardView cardView4=findViewById(R.id.card_view4);
        cardView4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(getApplicationContext(),Slots.class);
                startActivity(intent);
            }
        });
        CardView cardView5=findViewById(R.id.card_view5);
        cardView5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(getApplicationContext(),Slots.class);
                startActivity(intent);
            }
        });

    }
}