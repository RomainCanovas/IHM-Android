package com.example.canor.android.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.canor.android.model.Article;

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

public class DatabaseArticles extends SQLiteOpenHelper {

    private static String DB_NAME = "f.sqlite";

    private SQLiteDatabase myDataBase;
    private final Context myContext;

    public DatabaseArticles(Context context) {
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

    public List<Article> getAllArticles() {
        List<Article> articles = new ArrayList<>();
        Cursor cursor = myDataBase.rawQuery("SELECT * FROM articles", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            articles.add(new Article(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9),
                    cursor.getString(10),
                    cursor.getString(11)));
            cursor.moveToNext();
        }
        myDataBase.close();
        cursor.close();
        return articles;
    }

    public List<Article> getAllPromosArticles() {
        List<Article> articles = new ArrayList<>();
        Cursor cursor = myDataBase.rawQuery("SELECT * FROM articles WHERE promo==1", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            articles.add(new Article(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9),
                    cursor.getString(10),
                    cursor.getString(11)));
            cursor.moveToNext();
        }
        myDataBase.close();
        cursor.close();
        return articles;
    }

    public List<Article> getAllNewsArticles() {
        List<Article> articles = new ArrayList<>();
        Cursor cursor = myDataBase.rawQuery("SELECT * FROM articles WHERE new==1", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            articles.add(new Article(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9),
                    cursor.getString(10),
                    cursor.getString(11)));
            cursor.moveToNext();
        }
        myDataBase.close();
        cursor.close();
        return articles;
    }


    public List<Article> getAllEventArticles() {
        List<Article> articles = new ArrayList<>();
        Cursor cursor = myDataBase.rawQuery("SELECT * FROM articles WHERE category==\"event\"", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            articles.add(new Article(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9),
                    cursor.getString(10),
                    cursor.getString(11)));
            cursor.moveToNext();
        }
        myDataBase.close();
        cursor.close();
        return articles;
    }


    public List<Article> getAllDvpArticles() {
        List<Article> articles = new ArrayList<>();
        Cursor cursor = myDataBase.rawQuery("SELECT * FROM articles WHERE category==\"dvp\"", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            articles.add(new Article(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9),
                    cursor.getString(10),
                    cursor.getString(11)));
            cursor.moveToNext();
        }
        myDataBase.close();
        cursor.close();
        return articles;
    }

    public Article getArticle(String id) {
        List<Article> articles = new ArrayList<>();
        Cursor cursor = myDataBase.rawQuery("SELECT * FROM articles WHERE id==\""+id+"\"", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            articles.add(new Article(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9),
                    cursor.getString(10),
                    cursor.getString(11)));
            cursor.moveToNext();
        }
        myDataBase.close();
        cursor.close();
        return articles.get(0);
    }

    public List<Article> getNewMusicArticle() {
        List<Article> articles = new ArrayList<>();
        Cursor cursor = myDataBase.rawQuery("SELECT * FROM articles WHERE category==\"musique\" AND WHERE new==1", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            articles.add(new Article(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9),
                    cursor.getString(10),
                    cursor.getString(11)));
            cursor.moveToNext();
        }
        myDataBase.close();
        cursor.close();
        return articles;
    }

    public List<Article> getNewBooksArticle() {
        List<Article> articles = new ArrayList<>();
        Cursor cursor = myDataBase.rawQuery("SELECT * FROM articles WHERE category==\"livres\" AND WHERE new==1", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            articles.add(new Article(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9),
                    cursor.getString(10),
                    cursor.getString(11)));
            cursor.moveToNext();
        }
        myDataBase.close();
        cursor.close();
        return articles;
    }

    public List<Article> getNewDvpArticle() {
        List<Article> articles = new ArrayList<>();
        Cursor cursor = myDataBase.rawQuery("SELECT * FROM articles WHERE category==\"dvp\" AND WHERE new==1", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            articles.add(new Article(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9),
                    cursor.getString(10),
                    cursor.getString(11)));
            cursor.moveToNext();
        }
        myDataBase.close();
        cursor.close();
        return articles;
    }
    public List<Article> getNewEventArticle() {
        List<Article> articles = new ArrayList<>();
        Cursor cursor = myDataBase.rawQuery("SELECT * FROM articles WHERE category==\"event\" AND WHERE new==1", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            articles.add(new Article(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9),
                    cursor.getString(10),
                    cursor.getString(11)));
            cursor.moveToNext();
        }
        myDataBase.close();
        cursor.close();
        return articles;
    }

    public List<Article> getNewChildArticle() {
        List<Article> articles = new ArrayList<>();
        Cursor cursor = myDataBase.rawQuery("SELECT * FROM articles WHERE category==\"enfants\" AND WHERE new==1", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            articles.add(new Article(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9),
                    cursor.getString(10),
                    cursor.getString(11)));
            cursor.moveToNext();
        }
        myDataBase.close();
        cursor.close();
        return articles;
    }

    public List<Article> getPromoMusicArticle() {
        List<Article> articles = new ArrayList<>();
        Cursor cursor = myDataBase.rawQuery("SELECT * FROM articles WHERE category==\"musique\" AND WHERE promo==1", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            articles.add(new Article(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9),
                    cursor.getString(10),
                    cursor.getString(11)));
            cursor.moveToNext();
        }
        myDataBase.close();
        cursor.close();
        return articles;
    }

    public List<Article> getPromoBooksArticle() {
        List<Article> articles = new ArrayList<>();
        Cursor cursor = myDataBase.rawQuery("SELECT * FROM articles WHERE category==\"livres\" AND WHERE promo==1", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            articles.add(new Article(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9),
                    cursor.getString(10),
                    cursor.getString(11)));
            cursor.moveToNext();
        }
        myDataBase.close();
        cursor.close();
        return articles;
    }

    public List<Article> getPromoDvpArticle() {
        List<Article> articles = new ArrayList<>();
        Cursor cursor = myDataBase.rawQuery("SELECT * FROM articles WHERE category==\"dvp\" AND WHERE promo==1", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            articles.add(new Article(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9),
                    cursor.getString(10),
                    cursor.getString(11)));
            cursor.moveToNext();
        }
        myDataBase.close();
        cursor.close();
        return articles;
    }
    public List<Article> getPromoEventArticle() {
        List<Article> articles = new ArrayList<>();
        Cursor cursor = myDataBase.rawQuery("SELECT * FROM articles WHERE category==\"event\" AND WHERE promo==1", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            articles.add(new Article(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9),
                    cursor.getString(10),
                    cursor.getString(11)));
            cursor.moveToNext();
        }
        myDataBase.close();
        cursor.close();
        return articles;
    }

    public List<Article> getPromoChildArticle() {
        List<Article> articles = new ArrayList<>();
        Cursor cursor = myDataBase.rawQuery("SELECT * FROM articles WHERE category==\"enfants\" AND WHERE promo==1", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            articles.add(new Article(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9),
                    cursor.getString(10),
                    cursor.getString(11)));
            cursor.moveToNext();
        }
        myDataBase.close();
        cursor.close();
        return articles;
    }

}