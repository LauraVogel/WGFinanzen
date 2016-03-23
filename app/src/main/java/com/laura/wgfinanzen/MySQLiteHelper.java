package com.laura.wgfinanzen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Laura on 24.09.2015.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASENAME = "wgfinanzen.db";
    private static final int DATABASEVERSION = 1;

    //Tabelle Positions
    private static final String POSITION = "positionen";
    private static final String POSITIONENID = "P_ID";
    private static final String POSITIONTITEL = "TITEL";
    private static final String POSITIONDESCRIPTION = "DESCRIPTION";
    private static final String POSITIONDATE = "DATE";
    private static final String POSITIONVALUE = "VALUE";
    private static final String POSITION_FK_PERSONID = "FK_PERSONID";

    //Tabelle Person
    private static final String PERSON = "person";
    private static final String PERSONID = "PERSON_ID";
    private static final String PERSONNAME = "Name";

    //Tabelle Dept
    private static final String DEPT = "dept";
    private static final String DEPTID = "D_ID";
    private static final String DEPTVALUE = "VALUE";
    private static final String DEPT_FK_PERSONID = "FK_PERSONID";


    public MySQLiteHelper(Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + POSITION + " (" + POSITIONENID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + POSITIONTITEL + " TEXT," + POSITIONDESCRIPTION + " TEXT " + POSITIONVALUE + "REAL)");
        db.execSQL("CREATE TABLE " + PERSON + " (" + PERSONID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PERSONNAME + " TEXT");
        db.execSQL("CREATE TABLE " + DEPT + " (" + DEPTID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + DEPTVALUE + " REAL");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<Position> getPositions(){
        String titel = "SELECT " + POSITIONTITEL + " FROM " + POSITION;
        String description = "SELECT " + POSITIONDESCRIPTION + " FROM " + POSITION;
        String value = "SELECT " + POSITIONVALUE + " FROM " + POSITION;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(titel, null);

        List<Position> p = new ArrayList<>();

        if(c.moveToFirst())
        {
            do
            {
                Position temp = new Position();
                temp.setName(c.getString(0));
                p.add(temp);
            }
            while (c.moveToNext());
        }
        return p;
    }

    public void safePosition(Position p){
        try{
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(POSITIONTITEL,p.getName());
            values.put(POSITIONDESCRIPTION, p.getDescription());
            //values.put(POSITIONVALUE, p.getValue());

            db.insert(POSITION, null, values);
            db.close();
        }
        catch (Exception e){
            Log. d("Eintrag nicht", "gespeichert");
        }
    }

    public List<Person> getPersons(){
        String name = "SELECT " + PERSONNAME + " FROM " + PERSON;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(name, null);

        List<Person> p = new ArrayList<>();

        if(c.moveToFirst())
        {
            do {
                Person temp = new Person();
                temp.setName(c.getString(0));
                p.add(temp);
            }
            while (c.moveToNext());
        }
        return p;
    }

    public void safePerson(Person p){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(PERSONNAME, p.getName());

        db.insert(PERSON, null, values);
        db.close();
    }
}
