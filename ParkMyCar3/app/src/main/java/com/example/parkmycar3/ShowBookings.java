package com.example.parkmycar3;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ShowBookings extends AppCompatActivity {

    Button BooKNow;
    Button Retrivedata;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    ListView listView;
    ArrayList<Slot1Db> list;
    ArrayAdapter<Slot1Db> adapter;
    //Slot1Db slot1db;
   //TextView Bookings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bookings);

        BooKNow =(Button)findViewById(R.id.booknow);
        BooKNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ShowBookings.this,Places.class);
                startActivity(intent);
            }
        });
        //databaseReference= FirebaseDatabase.getInstance().getReference("Data");
        //Bookings=findViewById(R.id.bookingview);
       // Retrivedata=findViewById(R.id.retrivebtn);

       // slot1db=new Slot1Db();
      //  listView=findViewById(R.id.listView);
        database=FirebaseDatabase.getInstance();
        databaseReference=database.getReference("Slot1Db");
        list=new ArrayList<>();
        adapter=new ArrayAdapter<Slot1Db>(this,R.layout.activity_show_bookings,list);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren())
                {
                   // slot1db=ds.getValue(Slot1Db.class);
                   // list.add(slot1db);
                }
                //listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


}
