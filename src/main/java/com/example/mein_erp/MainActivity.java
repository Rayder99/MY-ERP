package com.example.mein_erp;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.Normalizer2;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SQLiteDatabase clientDatabase = this.openOrCreateDatabase("clients", MODE_PRIVATE, null);

    }

    public void mainscreen(View view){
        setContentView(R.layout.activity_main);

    }

    public void createClient(View view) {

        //setContentView(R.layout.create_client);
        createNewClient();
    }
    public void masterdata(View view){
        setContentView(R.layout.work_masterdata);

    }


    private void createNewClient() {

        EditText name = findViewById(R.id.vorname);
        EditText familyname = findViewById(R.id.nachname);
        EditText phone = findViewById(R.id.phone);
        EditText birthday = findViewById(R.id.birthday);
        //boolean smsreminder = findViewById(R.id.switchsmsreminder);


        try {

            SQLiteDatabase clientDatabase = SQLiteDatabase.openOrCreateDatabase("clients", null, null);

            clientDatabase.execSQL("CREATE TABLE IF NOT EXISTS clients (name VARCHAR, familyname VARCHAR, phone VARCHAR, birthday VARCHAR, wantsreminder BOOLEAN)");
            clientDatabase.execSQL("INSERT INTO clients(name, familyname, phone, birthday, wantsreminder) VALUES (name, familyname, phone, birthday, TRUE)");


            // auslesen


        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    public void readClientData(View view){


        try {

            SQLiteDatabase clientDatabase = SQLiteDatabase.openOrCreateDatabase("clients", null, null);

            clientDatabase.execSQL("CREATE TABLE IF NOT EXISTS clients (name VARCHAR, familyname VARCHAR, phone VARCHAR, birthday VARCHAR, wantsreminder BOOLEAN)");

            Cursor c = clientDatabase.rawQuery("SELECT * FROM clients", null);


            int nameIndex = c.getColumnIndex("name");
            int vornameIndex = c.getColumnIndex("familyname");
            int phoneIndex = c.getColumnIndex("phone");
            int birthdayIndex = c.getColumnIndex("birthday");
            int reminderIndex = c.getColumnIndex("wantsreminder");


            if(c.moveToFirst()){
                do {

                    Log.i("Name", c.getString(nameIndex));
                    Log.i("Vorname", c.getString(vornameIndex));
                    Log.i("phone", c.getString(phoneIndex));
                    Log.i("birthday", c.getString(birthdayIndex));
                    Log.i("wantsreminder", c.getString(reminderIndex));
                }
                while (c.moveToNext());
            }
        }catch (Exception e){

            e.printStackTrace();
        }
        ;


    }

    public void schicken(View view){

        EditText meintext= findViewById(R.id.messageText);
        String Nachricht= meintext.getText().toString();

        EditText mynumber= findViewById(R.id.messageText);
        String number= mynumber.getText().toString();


        Log.i("info", "Erfolg");
        Log.i("String:",Nachricht + number);
        Toast.makeText(this, "Erfolg", Toast.LENGTH_LONG).show();
        SmsManager manager = null;

        manager = SmsManager.getDefault();
        manager.sendTextMessage(number,null, Nachricht, null,null);


    }
}
