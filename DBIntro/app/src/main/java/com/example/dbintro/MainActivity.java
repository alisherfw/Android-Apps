package com.example.dbintro;

import Data.DatabaseHandler;
import Model.Contact;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler db = new DatabaseHandler(this);

//                Insert contacts
        Log.d("Insert: ", "Insertin...");
        db.addContact(new Contact("Paul", "412424512"));
        db.addContact(new Contact("John", "125293123"));
        db.addContact(new Contact("Rose", "241232422"));
        db.addContact(new Contact("Bella", "298589232"));

//        Read them back
        Log.d("Reading", "Reading all contacts");
        List<Contact> contactList = db.getAllContacts();
        for (Contact c : contactList) {
            String log = "ID: " + c.getId()+ " , Name: " + c.getName() + ", Phone: " + c.getPhoneNumber();
            Log.d("Name: ", log);

        }

    }
}