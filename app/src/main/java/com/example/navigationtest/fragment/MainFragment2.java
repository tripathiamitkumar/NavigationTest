package com.example.navigationtest.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.navigationtest.R;
import com.example.navigationtest.model.Test_Param;
import com.example.navigationtest.model.Test_Type;
import com.example.navigationtest.util.DataMapping;
import com.example.navigationtest.util.DataSetup;
import com.example.navigationtest.util.MasterDataUtil;

import java.util.ArrayList;
import java.util.List;

public class MainFragment2 extends Fragment {
    List<Test_Type> typeoftest;
    Spinner spinnerTypeOfTest,spinnerTestParameter;
    ArrayAdapter<Test_Type> arrayAdapter_typeoftest;
    ArrayAdapter<Test_Param> testParamArrayAdapter;
    private onMainFragment2BackBtnSelected listener3;

    private DataSetup dataSetup;
    private MasterDataUtil masterDataUtil = null;
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment2_main, container, false);
        masterDataUtil= MasterDataUtil.getInstance();
        dataSetup = new DataMapping(masterDataUtil);
        spinnerTypeOfTest = (Spinner)view.findViewById(R.id.spinnerTypeOfTest);
        typeoftest = dataSetup.getTestTypeList();
        arrayAdapter_typeoftest = new ArrayAdapter<Test_Type>(getContext(), android.R.layout.simple_spinner_dropdown_item, typeoftest);
        spinnerTypeOfTest.setAdapter(arrayAdapter_typeoftest);
        spinnerTestParameter = (Spinner) view.findViewById(R.id.spinnerTestParameter);

        spinnerTypeOfTest.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                  Test_Type test_type =(Test_Type)  adapterView.getItemAtPosition(pos);
                  List<Test_Param> test_paramList= masterDataUtil.getTestParamFromTestType(test_type.getName());
                  testParamArrayAdapter = new ArrayAdapter<Test_Param>(getContext(), android.R.layout.simple_spinner_dropdown_item, test_paramList);
                  spinnerTestParameter.setAdapter(testParamArrayAdapter);
                  if(test_paramList.size()==1){
                      setupDataInput(test_paramList.get(0).getName());
                  }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        spinnerTestParameter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                    Test_Param test_param =(Test_Param) adapterView.getItemAtPosition(pos);
                    String name =test_param.getName();
                    setupDataInput(name);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        Bundle bundle = getArguments();
        if (getArguments() != null) {
            String Location = bundle.getString("SpinnerLocation");
            String Section = bundle.getString("SpinnerSection");
            String Store = bundle.getString("SpinnerStore");
            String TypeOfStore = bundle.getString("SpinnerTypeOfStore");
            String TypeOfProof = bundle.getString("SpinnerTypeOfProof");
            String ProofNumber = bundle.getString("SpinnerProofNumber");
            String LotNumber = bundle.getString("EditTxt_LotNumber");
            String ProofSlipNumber = bundle.getString("EditTxt_ProofSlipNumber");
            String date = bundle.getString("DateToActivate");
            TextView location_f2m = (TextView) view.findViewById(R.id.txtView_location_f2m);
            TextView section_f2m = (TextView) view.findViewById(R.id.txtView_section_f2m);
            TextView date_f2m = (TextView) view.findViewById(R.id.txtView_date_f2m);
            TextView store_f2m = (TextView) view.findViewById(R.id.txtView_store_f2m);
            TextView typeOfStore_f2m = (TextView) view.findViewById(R.id.txtView_typeOfStore_f2m);
            TextView typeOfProof_f2m = (TextView) view.findViewById(R.id.txtView_typeOfProof_f2m);
            TextView proofNumber_f2m = (TextView) view.findViewById(R.id.txtView_proofNumber_f2m);
            TextView lotNumber_f2m = (TextView) view.findViewById(R.id.txtView_lotNumber_f2m);
            TextView proofSlipNumber_f2m = (TextView) view.findViewById(R.id.txtView_proofSlipNumber_f2m);
            location_f2m.setText(Location);
            section_f2m.setText(Section);
            date_f2m.setText(date);
            store_f2m.setText(Store);
            typeOfStore_f2m.setText(TypeOfStore);
            typeOfProof_f2m.setText(TypeOfProof);
            proofNumber_f2m.setText(ProofNumber);
            lotNumber_f2m.setText(LotNumber);
            proofSlipNumber_f2m.setText(ProofSlipNumber);
        }
        Button backbtn_of_mainfragment2 = view.findViewById(R.id.btn_f2m_back);
        backbtn_of_mainfragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener3.onButtonSeleted3();
            }
        });
        return view;
    }

    private void setupDataInput(String test_param){

            boolean  isSampleAvailable= masterDataUtil.getDataSampleFromTestParam(test_param);
            if(isSampleAvailable){
                        LinearLayout linearLayout =view.findViewById(R.id.linearLayoutDecisions);
                        int id =1110;
                        for(int i=1;i<=3;i++){

                            LinearLayout row =new LinearLayout(getContext());
                            row.setOrientation(LinearLayout.HORIZONTAL);
                            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                            row.setLayoutParams(p);
                            row.setId(++id);

                            p.setMargins(10,5,0,0);
                            EditText editText = new EditText(getContext());
                            editText.setLayoutParams(p);
                            editText.setId(i+3);





                        }
            }

    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof MainFragment2.onMainFragment2BackBtnSelected) {
            listener3 = (MainFragment2.onMainFragment2BackBtnSelected) context;
        } else {
            throw new ClassCastException(context.toString() + "must implement listener");

        }
    }

    public interface
    onMainFragment2BackBtnSelected {
        public void onButtonSeleted3();
    }
}
