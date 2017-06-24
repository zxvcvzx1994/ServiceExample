package com.example.kh.myapplication.Module;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by kh on 6/23/2017.
 */

public class MyClass implements Parcelable{
    private String name;
    private Date date;

    public MyClass(String name, Date date){
        this.name = name;
        this.date = date;
    }

    public MyClass(Parcel input){
        name  =input.readString();
        date  = new java.sql.Date(input.readLong());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(date.getTime());
        dest.writeString(name);
    }

    public static Parcelable.Creator<MyClass> CREATOR = new Creator<MyClass>() {
        @Override
        public MyClass createFromParcel(Parcel source) {
            return new MyClass(source);
        }

        @Override
        public MyClass[] newArray(int size) {
            return new MyClass[size];
        }
    };
}
