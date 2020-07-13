package Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import Model.Contact;
import Utils.Util;
import androidx.annotation.Nullable;

class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(@Nullable Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        SQL - structured query language
        String CREATE_CONTACT_TABLE = "CREATE TABLE " + Util.TABLE_NAME + "("
                + Util.KEY_ID + " INTEGER PRIMARY KEY, " + Util.KEY_NAME + " TEXT,"
                + Util.KEY_PHONE_NUMBER + " TEXT" + ")";

        db.execSQL(CREATE_CONTACT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//         Dropping is deleting the table!
        db.execSQL("DROP TABLE IF EXISTS " + Util.TABLE_NAME);

//        Create table again
        onCreate(db);
    }

    /**
     * CRUD Operations - Create, Read, Update, Delete
     */

//    Add Contact
    public void addContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Util.KEY_NAME, contact.getName());
        contentValues.put(Util.KEY_PHONE_NUMBER, contact.getPhoneNumber());

        db.insert(Util.TABLE_NAME, null, contentValues);
        db.close();
    }
//    Get a contact
    public Contact getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Util.TABLE_NAME, new String[] {
                Util.KEY_ID, Util.KEY_NAME, Util.KEY_PHONE_NUMBER
        }, Util.KEY_ID + "=?", new String[] {
                String.valueOf(id)
        }, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));

        return contact;

    }
}
