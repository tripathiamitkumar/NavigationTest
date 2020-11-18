package com.example.navigationtest.fragment;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.navigationtest.R;
import com.example.navigationtest.helper.ReportProofHelper;
import com.example.navigationtest.model.Sample;

import java.util.Calendar;
import java.util.List;

public class ReportFragment extends Fragment {

    ReportProofHelper reportProofHelper;
    EditText edtDate;
    private Calendar mcalendar;
    private int day,month,year;
    private Button btn_f3_search1;
    private   TableLayout layout;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_third,container,false);
        edtDate =(EditText) view.findViewById(R.id.textView54);
        mcalendar= Calendar.getInstance();
        day=mcalendar.get(Calendar.DAY_OF_MONTH);
        year=mcalendar.get(Calendar.YEAR);
        month=mcalendar.get(Calendar.MONTH);
        layout = (TableLayout) view.findViewById(R.id.tableLayout);
        btn_f3_search1 =(Button) view.findViewById(R.id.btn_f3_search1);

        btn_f3_search1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtDate.getText().length()>1){
                    String date= edtDate.getText().toString();
                    String data[]= date.split("/");
                    if(data.length==3){
                        date= data[2]+"-"+data[1]+"-"+data[0];
                        generateReport(date);
                    }
                } else {
                    edtDate.setFocusable(true);
                    edtDate.setError("Please select date!");
                }

            }
        });

        edtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), listener, year,month,day);
                datePickerDialog.show();
            }

            DatePickerDialog.OnDateSetListener listener=new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
                {
                    edtDate.setText(dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
                }
            };
        });
        reportProofHelper =new ReportProofHelper(getContext());
        generateReport("");
        return view;
    }

    public void generateReport(String date){

         try {
             layout.removeAllViews();
             TableRow tbrow0 = new TableRow(getContext());
             TextView tv0 = new TextView(getContext());
             tv0.setGravity(Gravity.LEFT);
             tv0.setText("Test Type");
             tv0.setTypeface(null, Typeface.BOLD);
             tv0.setTextSize(19);
             tv0.setPadding(0,20,0,0);
             tbrow0.addView(tv0);
             TextView tv1 = new TextView(getContext());
             tv1.setText("Test Parameter");
             tv1.setTypeface(null, Typeface.BOLD);
             tv1.setTextSize(19);
             tv1.setPadding(0,20,0,0);
             tv1.setGravity(Gravity.LEFT);
             tbrow0.addView(tv1);
             TextView tv2 = new TextView(getContext());
             tv2.setText("Date of Test");
             tv2.setTypeface(null, Typeface.BOLD);
             tv2.setGravity(Gravity.LEFT);
             tv2.setPadding(0,20,0,0);
             tv2.setTextSize(19);
             tbrow0.addView(tv2);
             TextView tv3 = new TextView(getContext());
             tv3.setText("Observation");
             tv3.setGravity(Gravity.LEFT);
             tv3.setTypeface(null, Typeface.BOLD);
             tv3.setPadding(0,20,0,0);
             tv3.setTextSize(19);
             tbrow0.addView(tv3);
             TextView tv4 = new TextView(getContext());
             tv4.setText("Result");
             tv4.setGravity(Gravity.LEFT);
             tv4.setPadding(0,20,0,0);
             tv4.setTextSize(19);
             tv4.setTypeface(null, Typeface.BOLD);
             tbrow0.addView(tv4);
             layout.addView(tbrow0);

             List<Sample> sampleList =null;
             if(date!=null && !date.equals("")){
                 sampleList=reportProofHelper.getAllReport(date);
             } else {
                 sampleList=reportProofHelper.getAllReport();
             }
             for(Sample sample :sampleList){

                 TableRow tbrow = new TableRow(getContext());
                 TextView t1v = new TextView(getContext());
                 t1v.setPadding(0,20,0,0);
                 t1v.setGravity(Gravity.LEFT);
                 if(sample.getTypeOfTestId().length()>17){
                     t1v.append(sample.getTypeOfTestId().substring(0,12));
                     t1v.append("\n");
                     t1v.append(sample.getTypeOfTestId().substring(12));
                 } else {
                     t1v.setText("" + sample.getTypeOfTestId());
                 }


                 tbrow.addView(t1v);
                 TextView t2v = new TextView(getContext());
                 t2v.setText(sample.getTestparamId());
                 t2v.setPadding(0,20,0,0);
                 t2v.setGravity(Gravity.LEFT);
                 tbrow.addView(t2v);
                 TextView t3v = new TextView(getContext());
                 t3v.setText(sample.getDate());
                 t3v.setPadding(0,20,0,0);
                 t3v.setGravity(Gravity.LEFT);
                 tbrow.addView(t3v);
                 TextView t4v = new TextView(getContext());
                 t4v.setGravity(Gravity.LEFT);
                 t4v.setPadding(0,20,0,0);
                 t4v.setText(sample.getObservation());
                 tbrow.addView(t4v);
                 TextView t5v = new TextView(getContext());
                 t5v.setGravity(Gravity.LEFT);
                 t5v.setPadding(0,20,0,0);
                 if(sample.getResult()!=null && sample.getResult().equals("1")){
                     t5v.setText("Accept");
                     t5v.setTextColor(Color.GREEN);
                 }else {
                     t5v.setText("Reject");
                     t5v.setTextColor(Color.RED);
                 }

                 tbrow.addView(t5v);
                 layout.addView(tbrow);

             }


         }catch (Exception e) {

             e.printStackTrace();
        }

    }

}
