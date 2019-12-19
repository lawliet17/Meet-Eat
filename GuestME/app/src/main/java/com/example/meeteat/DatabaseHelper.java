package com.example.meeteat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "loginSQLite.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE session(id integer PRIMARY KEY, login text)");
        sqLiteDatabase.execSQL("CREATE TABLE user(id integer PRIMARY KEY AUTOINCREMENT,email text, password text)");
        sqLiteDatabase.execSQL("INSERT INTO session(id,login) VALUES(1,'kosong')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS session");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS user");
        onCreate(sqLiteDatabase);
    }

    //check session
    public Boolean checkSession(String sessionValues){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor =db.rawQuery("SELECT * FROM session WHERE login= ?",new String[]{sessionValues});
        if (cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }

    //upgrade session
    public Boolean upgradeSession(String sessionValues, int id){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("login",sessionValues);
        long update=db.update("session",contentValues,"id="+id,null);
        if(update==-1){
            return false;
        }
        else{
            return true;
        }
    }

    //insert user
    public Boolean InsertUser(String email, String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long insert=db.insert("user",null,contentValues);
        if(insert==-1){
            return false;
        }
        else{
            return true;
        }
    }

    //check login
    public boolean checkLogin(String email, String password){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM user WHERE email=? AND password=?",new String[]{email,password});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }

}
