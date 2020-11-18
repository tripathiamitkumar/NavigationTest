package com.example.navigationtest.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.navigationtest.R;

public class ResultFragment extends Fragment {
    private onThirdFragmentBtnSelected listener2;

    TextView txtProofSlip,txtLotno,txtdateofTest,txtTestType,txttestParam,txtObs,txtResult;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second,container,false);
        Button clickme2 = view.findViewById(R.id.loadThird);
        clickme2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener2.onButtonSeleted2();
            }
        });
        txtProofSlip= (TextView) view.findViewById(R.id.textView48);
        txtLotno= (TextView) view.findViewById(R.id.textView50);
        txtdateofTest= (TextView) view.findViewById(R.id.textView52);
        txtTestType= (TextView) view.findViewById(R.id.textView54);
        txttestParam= (TextView) view.findViewById(R.id.textView56);
        txtObs= (TextView) view.findViewById(R.id.textView58);
        txtResult= (TextView) view.findViewById(R.id.textView60);

        if(getArguments()!=null){

              Bundle bundle =getArguments();
              String testParam= bundle.getString("testParam");
              String testType= bundle.getString("testType");
              String lotNo= bundle.getString("lotNo");
              String proofSlip= bundle.getString("proofSlip");
              String dateTime= bundle.getString("dateTime");
              String observation= bundle.getString("observation");
              String result= bundle.getString("result");
              txtProofSlip.setText(proofSlip);
              txtLotno.setText(lotNo);
              txtdateofTest.setText(dateTime);
              txtTestType.setText(testType);
              txttestParam.setText(testParam);
              txtObs.setText(observation);
              String resultStr= "Rejected";
              txtResult.setTextColor(Color.RED);
              if(result!=null && result.equals("1")){
                  resultStr= "Accepted";
                  txtResult.setTextColor(Color.GREEN);
              }
              txtResult.setText(resultStr);
        }

        return view;
    }




    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof onThirdFragmentBtnSelected){
            listener2 = (onThirdFragmentBtnSelected) context;
        }else {
            throw new ClassCastException(context.toString() + "must implement listener");
        }
    }
    public interface onThirdFragmentBtnSelected{
        public void onButtonSeleted2();
    }
}
