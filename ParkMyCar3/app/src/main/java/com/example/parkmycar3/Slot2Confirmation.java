package com.example.parkmycar3;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Slot2Confirmation extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener
{

    EditText vehicleNumber,mobileNumber,custName;
    Button savebtn;
    Button cancelbtn;
    Button dateTimePick;
    TextView showDateTime;
    FirebaseDatabase db=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;
    int day,month,year,hour,minute;
    int dayFinal,monthFinal,yearFinal,hourFinal,minuteFinal;
    //int counter=0;



    String dataFieldVehicleNumber;
    String dataFieldMobileNumber;
    String dataFieldCustName;
    String dataFieldYear;
    String dataFieldMonth;
    String dataFieldDay;
    String dataFieldHour;
    String dataFieldMinute;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot2_confirmation);

        vehicleNumber=findViewById(R.id.vehicleNo);
        mobileNumber=findViewById(R.id.mobile);
        custName=findViewById(R.id.name);

        savebtn=findViewById(R.id.save);
        cancelbtn=findViewById(R.id.cancel);
        dateTimePick=findViewById(R.id.datetimepick);
        showDateTime=findViewById(R.id.result);

        databaseReference=db.getReference("Slot2Db");

        dateTimePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c=Calendar.getInstance();
                year=c.get(Calendar.YEAR);
                month=c.get(Calendar.MONTH);
                day=c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog=new DatePickerDialog(Slot2Confirmation.this,Slot2Confirmation.this,year,month,day);
                datePickerDialog.show();
            }
            //https://www.youtube.com/watch?v=a_Ap6T4RlYU
        });
        cancelbtn.setEnabled(false);
        //-----------------------------------------------------------------------------------------------------------
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                dataFieldVehicleNumber = vehicleNumber.getText().toString();
                dataFieldMobileNumber = mobileNumber.getText().toString();
                dataFieldCustName = custName.getText().toString();
                dataFieldYear= String.valueOf(yearFinal);
                dataFieldMonth= String.valueOf(monthFinal);
                dataFieldDay = String.valueOf(dayFinal);
                dataFieldHour =String.valueOf(hourFinal);
                dataFieldMinute=String.valueOf(minuteFinal);

                //id = databaseReference.push().getKey();
                id = "PARSLOT2";


                if(dataFieldVehicleNumber.isEmpty()||dataFieldCustName.isEmpty()||dataFieldMobileNumber.isEmpty()||dataFieldDay.equals("0"))
                {
                    showDateTime.setText("Please enter all the booking details first.");
                }
                if (!TextUtils.isEmpty(dataFieldVehicleNumber)&&!TextUtils.isEmpty(dataFieldCustName)&&!TextUtils.isEmpty(dataFieldMobileNumber)&&!dataFieldDay.equals("0"))
                {
                    Slot1Db data=new Slot1Db(dataFieldVehicleNumber,dataFieldMobileNumber,dataFieldCustName,dataFieldYear,dataFieldMonth,dataFieldDay,dataFieldHour,dataFieldMinute,id);
                    databaseReference.child(id).setValue(data);
                    Toast.makeText(Slot2Confirmation.this,"data saved",Toast.LENGTH_SHORT).show();
                    savebtn.setEnabled(false);

                    showDateTime.setText ("Your Booking ID: "+id+"\n"+
                            "Your Vehicle Number: "+dataFieldVehicleNumber+"\n"+
                            "Customer Name: "+dataFieldCustName+"\n"+
                            "Booking Date: "+dayFinal+"/"+monthFinal+"/"+yearFinal+"\n"+
                            "Booking Time: "+hourFinal+" : "+minuteFinal+"\n");
                    cancelbtn.setEnabled(true);
                }


            }
        });



        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelBooking("PARSLOT2");
                showDateTime.setText("BOOKING CANCELLED !!");
            }
        });
        //----------------------------------------------------------------------------------------------------------
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2)
    {
        yearFinal=i;
        monthFinal=i1+1;
        dayFinal=i2;

        Calendar c=Calendar.getInstance();
        hour=c.get(Calendar.HOUR_OF_DAY);
        minute=c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog=new TimePickerDialog(Slot2Confirmation.this,Slot2Confirmation.this,hour,minute, DateFormat.is24HourFormat(this));
        timePickerDialog.show();

    }
    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1)
    {
        hourFinal=i;
        minuteFinal=i1;

    }



    public boolean cancelBooking(String id)
    {
        DatabaseReference dR=FirebaseDatabase.getInstance().getReference("Slot2Db").child(id);
        dR.removeValue();
        Toast.makeText(this, "booking cancelled(data deleted)", Toast.LENGTH_SHORT).show();
        savebtn.setEnabled(true);
        return true;

    }

}
