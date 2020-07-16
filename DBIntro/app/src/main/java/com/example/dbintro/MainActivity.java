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

        Log.d("DB count: ", String.valueOf(db.getContactsCount()));

//                Insert contacts
        Log.d("Insert: ", "Insertin...");
//        db.addContact(new Contact("Paul", "412424512"));
//        db.addContact(new Contact("John", "125293123"));
//        db.addContact(new Contact("Rose", "241232422"));
//        db.addContact(new Contact("Bella", "298589232"));

//        Read them back
        Log.d("Reading",    "Reading all contacts");
        List<Contact> contactList = db.getAllContacts();

//        Get 1 contact
//        Contact oneContact = db.getContact(4);
//        oneContact.setName("Polooooooo");
//        oneContact.setPhoneNumber("00000000");
//        Update contact

//        int newContact = db.updateContact(oneContact);
//
//        Log.d("One Contact: ", "Update row " + String.valueOf(newContact) + " Name: " + oneContact.getName() + " Phone: " + oneContact.getPhoneNumber());

//        db.deleteContact(oneContact);

        for (Contact c : contactList) {
            String log = "ID: " + c.getId()+ " , Name: " + c.getName() + ", Phone: " + c.getPhoneNumber();
            Log.d("Name: ", log);

        }

    }
}