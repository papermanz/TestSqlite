package com.minhhieu.testsqlite.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.minhhieu.testsqlite.model.Student;

import java.util.ArrayList;
import java.util.List;

public class DBManager extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="students_manager";
    public static final String TABLE_NAME ="students";
    public static final String ID ="id";
    public static final String NAME ="name";
    public static final String PHONE_NUMBER ="phone";
    public static final String ADDRESS ="address";
    public static final String EMAIL ="email";
    private static int VERSION = 1;
    private Context context;

    // truy vấn database
    private String SQLQuery = "CREATE TABLE " + TABLE_NAME + " (" +
            ID + " integer primary key, "+
            NAME + " TEXT, " +
            EMAIL + " TEXT, " +
            PHONE_NUMBER + " TEXT, " +
            ADDRESS +" TEXT)";


    public DBManager(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }

    // gọi database 1 lần duy nhất, khi lưu dữ liệu thứ 2 trở đi sẽ không gọi nữa
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addStudent (Student student){
        SQLiteDatabase db = this.getWritableDatabase();
        // contentvalues là nơi put giá trị của table vào
        ContentValues values = new ContentValues();
        values.put(NAME, student.getmName());
        values.put(EMAIL, student.getmEmail());
        values.put(PHONE_NUMBER, student.getmPhone());
        values.put(ADDRESS,student.getmAddress());
        //insert truyền dự liệu vào bảng
        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public List<Student> getAllStudent(){
        List<Student> listStudent = new ArrayList<>();
        String selectQuery = "SELECT * FROM "+ TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();//đọc và chỉnh sửa database
        Cursor cursor = db.rawQuery(selectQuery,null); //( câu lệnh truy vấn, điều kiện truy vấn), Curs nhận kết quả trả về

        //movetofirst kết quả trả vế có ít nhất một kết quả
        //movetonext tiếp theo có kết quả
        if(cursor.moveToFirst()){
            do{
                Student student = new Student();
                student.setmID(cursor.getInt(0));
                student.setmName(cursor.getString(1));
                student.setmAddress(cursor.getString(2));
                student.setmPhone(cursor.getString(3));
                student.setmEmail(cursor.getString(4));
                listStudent.add(student);
            }while (cursor.moveToNext());
        }
        db.close();
        return listStudent;
    }
}
