package com.example.mein_erp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

import static android.content.Context.MODE_APPEND;
import static android.content.Context.MODE_ENABLE_WRITE_AHEAD_LOGGING;

import static android.content.Context.MODE_PRIVATE;
import static android.content.Context.UI_MODE_SERVICE;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class Client {

    String name, familyname, phone, birthday;
    boolean wantsremidner;




    private void kundespeichern(View view) {


        try {

            SQLiteDatabase clientDatabase = SQLiteDatabase.openOrCreateDatabase("clients", null, null);

            clientDatabase.execSQL("CREATE TABLE IF NOT EXISTS clients (name VARCHAR, familyname VARCHAR, phone VARCHAR, birthday VARCHAR, wantsreminder BOOLEAN)");
            clientDatabase.execSQL("INSERT INTO clients(name, familyname, phone, birthday, wantsreminder) VALUES ('Magda', 'Nowak', '733489551','01.01.1975',TRUE)");

            Cursor c= clientDatabase.rawQuery("SELECT * FROM clients", null);

        }
        catch  (Exception e){

            e.printStackTrace();
        }
    }

    private void kundenladen (View view){

        try{
            //  SQLiteDatabase clientDatabase = SQLiteDatabase.openDatabase("clients",null, null);
            // clientDatabase.execSQL("READ TABLE clients (name VARCHAR, familyname VARCHAR, phone VARCHAR, birthday VARCHAR, wantsreminder BOOLEAN)");


        }catch (Exception e){

        }
    }
}
