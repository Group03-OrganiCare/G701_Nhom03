package com.n03.g701;


import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final int DB_VERSION=1;
    public static final String DB_NAME= "product.sqlite";
    public static final String TBL_NAME= "ProductTB";
    public static final String COL_W_ID= "P_Id";
    public static final String COL_W_NSX= "P_NSX";
    public static final String COL_W_PHOTO= "P_Photo";
    public static final String COL_W_NAME= "P_Name";
    public static final String COL_W_PRICE= "P_Price";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE IF NOT EXISTS "+TBL_NAME+"("+COL_W_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COL_W_NAME +" VARCHAR(100), "+COL_W_NSX+ " VARCHAR(200), "+COL_W_PHOTO+ "BOLB, "+ COL_W_NSX+ " VARCHAR(200), " + COL_W_PRICE + " DECIMAL(9,0))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TBL_NAME);
        onCreate(db);
    }
    public void queryExec(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }
    public Cursor getData(String sql){
        SQLiteDatabase db =getReadableDatabase();
        return db.rawQuery(sql,null);
    }
    public boolean insertData( String Idcode,String name, String nsx, double price, byte[] photo){
        try{
            SQLiteDatabase db= getWritableDatabase();
            String sql ="INSERT INTO "+TBL_NAME+" VALUES(null, ?, ?, ?, ?, ?)";
            SQLiteStatement statement=db.compileStatement(sql);
            statement.bindString(1,Idcode);
            statement.bindString(2,name);
            statement.bindString(3,nsx);
            statement.bindDouble(4,price);
            statement.bindBlob(5,photo);

            statement.executeInsert();
            return true;
        }catch (Exception ex){
            Log.e("ERROR: ",ex.getMessage());
            return false;
        }

    }
}
