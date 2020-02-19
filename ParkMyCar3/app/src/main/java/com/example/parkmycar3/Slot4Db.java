package com.example.parkmycar3;

public class Slot4Db {

    String VehicleNumber;
    String MobileNumber;
    String CustomerName;
    String Year;
    String Month;
    String Day,Hour,Minute;
    String id;

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public  String getYear() { return Year;}

    public String getMonth(){ return Month;}

    public String getDay() { return Day;}

    public String getHour(){ return Hour;}

    public String getMinute() { return Minute;}

    public String getId() {
        return id;
    }

    public Slot4Db(String vehicleNumber, String mobileNumber, String customerName, String year, String month,String day, String hour, String minute,String id) {
        VehicleNumber = vehicleNumber;
        MobileNumber = mobileNumber;
        CustomerName = customerName;
        Year=year;
        Month=month;
        Day=day;
        Hour=hour;
        Minute=minute;
        this.id = id;
    }


    public void Slot4Db()
    {

    }
}
