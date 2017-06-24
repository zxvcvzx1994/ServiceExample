package com.example.kh.myapplication.Module;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by kh on 6/23/2017.
 */

public class Myclass1 implements Parcelable{
    private String a;
    private Date b;

    public Myclass1(String a, Date b){
        this.a =a;
        this.b= b;
    }

    public Myclass1(Parcel input){
        a = input.readString();
        b = new java.sql.Date(input.readLong());
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public Date getB() {
        return b;
    }

    public void setB(Date b) {
        this.b = b;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    private static Parcelable.Creator<Myclass1> CREATOR = new Creator<Myclass1>() {
        @Override
        public Myclass1 createFromParcel(Parcel source) {
            return new Myclass1(source);
        }

        @Override
        public Myclass1[] newArray(int size) {
            return new Myclass1[size];
        }
    };
}
