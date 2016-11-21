package com.example.pustikom.adapterplay.com.example.pustikom.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.pustikom.adapterplay.com.example.pustikom.user.Student;

/**
 * Created by ACER on 11/11/2016.
 */

public class StudentDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "college.db";
    private static final int DATABASE_VERSION = 1;

    public StudentDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String sql = "CREATE TABLE " + StudentContract.TABLE_NAME + " " +
                StudentContract._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                StudentContract.COLUMN_STUDENT_NIM + "TEXT NOT NULL," +
                StudentContract.COLUMN_STUDENT_NAME + "TEXT NOT NULL," +
                StudentContract.COLUMN_STUDENT_GENDER + "INTEGER," +
                StudentContract.COLUMN_STUDENT_MAIL + "TEXT," +
                StudentContract.COLUMN_STUDENT_PHONE + "TEXT";
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        //empty
    }

    public void insertStudent(SQLiteDatabase database, Student student) {
        ContentValues values = new ContentValues();
        values.put(StudentContract.COLUMN_STUDENT_NIM, student.getNoreg());
        values.put(StudentContract.COLUMN_STUDENT_NAME, student.getName());
        values.put(StudentContract.COLUMN_STUDENT_GENDER, student.getGender());
        values.put(StudentContract.COLUMN_STUDENT_MAIL, student.getMail());
        values.put(StudentContract.COLUMN_STUDENT_PHONE, student.getPhone());
        database.insert(StudentContract.TABLE_NAME, null, values);
    }

    public void updateStudent(SQLiteDatabase wdb, Student student, String condition, String[] conditionArg) {
        ContentValues values = new ContentValues();
        values.put(StudentContract.COLUMN_STUDENT_NIM, student.getNoreg());
        values.put(StudentContract.COLUMN_STUDENT_NAME, student.getName());
        values.put(StudentContract.COLUMN_STUDENT_GENDER, student.getGender());
        values.put(StudentContract.COLUMN_STUDENT_MAIL, student.getMail());
        values.put(StudentContract.COLUMN_STUDENT_PHONE, student.getPhone());
        String condition = StudentContract._ID + " = ?, ";
        String conditionArgs = (Student.getId() + "");
        wdb.update(StudentContract.TABLE_NAME, values, condition, conditionArg);
    }

    public void deleteStudent(Student student) {
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(StudentContract.TABLE_NAME, StudentContract._ID + " = ?", new String[]{String.valueOf(student.getId())});
        database.close();
    }

}


