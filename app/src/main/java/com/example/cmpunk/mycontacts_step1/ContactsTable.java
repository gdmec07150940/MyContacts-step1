package com.example.cmpunk.mycontacts_step1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.cmpunk.mycontacts_step1.MyDB;
import com.example.cmpunk.mycontacts_step1.User;

/**
 * Created by CM Punk on 2016/11/3.
 */
public class ContactsTable {
    private final static String TABLENAME = "contactsTable";
    private MyDB db;

    public ContactsTable(Context context) {
        db = new MyDB(context);
        if (!db.isTableExits(TABLENAME)) {
            String createTableSql = "CREATE TABLE IF NOT EXISTS" + TABLENAME + "(id_DB integer" +
                    "primary key AUTOINCREMENT," +
                    User.NAME + "VARCHAR," +
                    User.MOBILE + "VARCHAR," +
                    User.QQ + "VARCHAR," +
                    User.DANWEI + "VARCHAR," +
                    User.ADDRESS + "VARCHAR)";
            db.createTable(createTableSql);
        }
    }

    public boolean addData(User user) {
        ContentValues values = new ContentValues();
        values.put(User.NAME, user.getName());
        values.put(User.MOBILE, user.getMobile());
        values.put(User.DANWEI, user.getDanwei());
        values.put(User.QQ, user.getQq());
        values.put(User.ADDRESS, user.getAddress());
        return db.save(TABLENAME, values);
    }
}