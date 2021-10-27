package com.example.signupsignin


import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLdb(context: Context?) : SQLiteOpenHelper(context, "users.db", null , 1)
{
    var sqLite: SQLiteDatabase = writableDatabase
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table users  (Name text, Mobile text, Location text, password text)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}

    fun savedata(s1: String, s2: String, s3: String, s4: String): Long {
        sqLite = writableDatabase

        val cv = ContentValues()
        cv.put("Name", s1)
        cv.put("Mobile", s2)
        cv.put("Location", s3)
        cv.put("Password", s4)
        return sqLite.insert("users", null, cv)

    }


    @SuppressLint("Range")
    fun check(s2: String): String {

        var c: Cursor = sqLite.query("users", null, "Mobile=?", arrayOf(s2), null, null, null)
        if (c.count < 1) {
            return "name not exists"
        }
        c.moveToFirst()
        return c.getString(c.getColumnIndex("Password"))
    }


    @SuppressLint("Range")
    fun retrieve(s1: String): String {
        var c: Cursor = sqLite.query("users", null, "Mobile=?", arrayOf(s1), null, null, null)
        if (c.count < 1) {
            return "name not found"
        }
        c.moveToFirst()

        return c.getString(c.getColumnIndex("Name"))+"\n"+ c.getString(c.getColumnIndex("Location"))
    }

    fun locupdate(s1: String, s2: String): Int {
        sqLite = writableDatabase
        val cv = ContentValues()
        cv.put("Location", s2)
        return sqLite.update("users", cv, "Name = ?", arrayOf(s1))
    }

    fun namedel(s1: String){
        sqLite = writableDatabase
        sqLite.delete("users", "Name=?", arrayOf(s1))
    }
}