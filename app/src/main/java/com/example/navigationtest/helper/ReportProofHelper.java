package com.example.navigationtest.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.navigationtest.model.Sample;
import com.example.navigationtest.model.Test_Type;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

public class ReportProofHelper extends SQLiteOpenHelper {
    Context context;
    public static final String DB_NAME ="cmc_tproof";
    public static final String TABLE_NAME ="t_result";
    private static final int DB_VERSION = 2;
    private static final String COLUMN_ID = "id";
    public static final String COLUMN_TESTTYPE="testtype";
    public static final String COLUMN_TESTPARAM="testparam";
    public static final String DT_OF_TEST = "dt_of_test";
    public static final String OBSERVATION = "observation";
    public static final String RESULT = "result";
    public static final String FLAG = "flag";
    public static final String ITEM_CD= "item_cd";


    public ReportProofHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
        this.context = context;
    }


    public ReportProofHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="CREATE TABLE " + TABLE_NAME + " (\n" +
                "    " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    " + COLUMN_TESTTYPE + " varchar(200) NOT NULL,\n" +
                "    " + COLUMN_TESTPARAM + " varchar(200) NOT NULL,\n" +
                "    " + DT_OF_TEST + " varchar(20) NOT NULL,\n" +
                "    " + OBSERVATION + " varchar(200) NOT NULL,\n" +
                "    " + RESULT + " varchar(10) NOT NULL,\n" +
                "    " + ITEM_CD + " varchar(20) NOT NULL,\n" +
                "    " + FLAG + " TINYINT NOT NULL\n" +
                ");";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // Create tables again
        onCreate(sqLiteDatabase);
    }

    public void addReport(Sample sample){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TESTTYPE, sample.getTypeOfTestId());
        contentValues.put(COLUMN_TESTPARAM, sample.getTestparamId());
        contentValues.put(DT_OF_TEST, sample.getDate());
        contentValues.put(OBSERVATION, sample.getObservation());
        contentValues.put(RESULT, sample.getResult());
        contentValues.put(ITEM_CD, sample.getItem_cd());
        contentValues.put(FLAG, sample.getFlag());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    public List<Sample> getAllReport(){
        SQLiteDatabase db= this.getReadableDatabase();
        List<Sample> sampleList =new ArrayList<>();
        Cursor cursor= db.rawQuery("SELECT * from "+TABLE_NAME, null);
        if (cursor.moveToFirst()){
            do {
                // Passing values
                String test_Type= cursor.getString(cursor.getColumnIndex(COLUMN_TESTTYPE));
                String test_Param = cursor.getString(cursor.getColumnIndex(COLUMN_TESTPARAM));
                String dateTest = cursor.getString(cursor.getColumnIndex(DT_OF_TEST));
                String obs = cursor.getString(cursor.getColumnIndex(OBSERVATION));
                String result = cursor.getString(cursor.getColumnIndex(RESULT));
                Sample sample= new Sample();
                sample.setTestparamId(test_Param);
                sample.setTypeOfTestId(test_Type);
                sample.setDate(dateTest);
                sample.setObservation(obs);
                sample.setResult(result);

                sampleList.add(sample);
                // Do something Here with values
            } while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return sampleList;
    }

    public List<Sample> getAllReport(String date){
        SQLiteDatabase db= this.getReadableDatabase();
        List<Sample> sampleList =new ArrayList<>();
        Cursor cursor= db.rawQuery("SELECT * from "+ TABLE_NAME +" where "+DT_OF_TEST+"=? ", new String[]{date});
        if (cursor.moveToFirst()){
            do {
                // Passing values
                String test_Type= cursor.getString(cursor.getColumnIndex(COLUMN_TESTTYPE));
                String test_Param = cursor.getString(cursor.getColumnIndex(COLUMN_TESTPARAM));
                String dateTest = cursor.getString(cursor.getColumnIndex(DT_OF_TEST));
                String obs = cursor.getString(cursor.getColumnIndex(OBSERVATION));
                String result = cursor.getString(cursor.getColumnIndex(RESULT));
                Sample sample= new Sample();
                sample.setTestparamId(test_Param);
                sample.setTypeOfTestId(test_Type);
                sample.setDate(dateTest);
                sample.setObservation(obs);
                sample.setResult(result);

                sampleList.add(sample);
                // Do something Here with values
            } while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return sampleList;
    }
}
