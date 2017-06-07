package com.example.canor.android.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.canor.android.model.Category;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Romain on 04/06/2017.
 */

public class DatabaseCategories extends SQLiteOpenHelper {

    private static String DB_NAME = "d.sqlite";

    private SQLiteDatabase myDataBase;
    private final Context myContext;

    public DatabaseCategories(Context context) {
        super(context, DB_NAME, null, 1);
        this.myContext = context;
    }

    public void openDataBase() throws SQLException, IOException {
        //Open the database
        String myPath = myContext.getDatabasePath(DB_NAME).getAbsolutePath();
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    }

    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();
        if (!dbExist) {
            //By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            this.getReadableDatabase();
            try {
                // Copy the database in assets to the application database.
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database", e);
            }
        }
    }

    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            String myPath = myContext.getDatabasePath(DB_NAME).getAbsolutePath();
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
            //database doesn't exist yet.
        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null;
    }

    private void copyDataBase() throws IOException {
        InputStream myInput = myContext.getAssets().open(DB_NAME);
        String outFileName = myContext.getDatabasePath(DB_NAME).getAbsolutePath();
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    @Override
    public synchronized void close() {
        if (myDataBase != null)
            myDataBase.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        Cursor cursor = myDataBase.rawQuery("SELECT * FROM category", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            categories.add(new Category(
                    cursor.getString(1),
                    cursor.getString(2)));
            cursor.moveToNext();
        }
        myDataBase.close();
        cursor.close();
        return categories;
    }

    public List<Category> getAllMusicCategories() {
        List<Category> categories = new ArrayList<>();
        Cursor cursor = myDataBase.rawQuery("SELECT * FROM musique", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            categories.add(new Category(
                    cursor.getString(1),
                    cursor.getString(2)));
            cursor.moveToNext();
        }
        myDataBase.close();
        cursor.close();
        return categories;
    }

    public List<Category> getAllBooksCategories() {
        List<Category> categories = new ArrayList<>();
        Cursor cursor = myDataBase.rawQuery("SELECT * FROM livres", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            categories.add(new Category(
                    cursor.getString(1),
                    cursor.getString(2)));
            cursor.moveToNext();
        }
        myDataBase.close();
        cursor.close();
        return categories;
    }

    public List<Category> getAllChildCategories() {
        List<Category> categories = new ArrayList<>();
        Cursor cursor = myDataBase.rawQuery("SELECT * FROM enfants", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            categories.add(new Category(
                    cursor.getString(1),
                    cursor.getString(2)));
            cursor.moveToNext();
        }
        myDataBase.close();
        cursor.close();
        return categories;
    }

    public List<Category> getPromosCategories() {
        List<Category> categories = new ArrayList<>();
        Cursor cursor = myDataBase.rawQuery("SELECT DISTINCT category,picCat FROM articles WHERE promo==1", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            categories.add(new Category(
                    cursor.getString(0),
                    cursor.getString(1)));
            cursor.moveToNext();
        }
        myDataBase.close();
        cursor.close();
        return categories;
    }

    public List<Category> getNewsCategories() {
        List<Category> categories = new ArrayList<>();
        Cursor cursor = myDataBase.rawQuery("SELECT DISTINCT category,picCat FROM articles WHERE new==1", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            categories.add(new Category(
                    cursor.getString(0),
                    cursor.getString(1)));
            cursor.moveToNext();
        }
        myDataBase.close();
        cursor.close();
        return categories;
    }
}