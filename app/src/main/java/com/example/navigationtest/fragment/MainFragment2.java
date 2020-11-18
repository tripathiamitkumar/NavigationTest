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
import com.example.navigationtest.model.Sample;
import com.example.navigationtest.model.Test_Param;
import com.example.navigationtest.model.Test_Type;
import com.example.navigationtest.util.MasterDataUtil;

import java.util.List;

public class MainFragment2 extends Fragment {
    List<Test_Type> typeoftest;
    Spinner spinnerTypeOfTest,spinnerTestParameter;
    ArrayAdapter<Test_Type> arrayAdapter_typeoftest;
    ArrayAdapter<Test_Param> testParamArrayAdapter;
    private onMainFragment2BackBtnSelected listener3;
    private Button btn_add;
    String testtype,storeName, type_of_proof;
    private MasterDataUtil masterDataUtil = null;
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment2_main, container, false);
        masterDataUtil= MasterDataUtil.getInstance();
        spinnerTypeOfTest = (Spinner)view.findViewById(R.id.spinnerTypeOfTest);
        btn_add =(Button) view.findViewById(R.id.btn_f2m_add);
        typeoftest = masterDataUtil.getTestTypeList();
        arrayAdapter_typeoftest = new ArrayAdapter<Test_Type>(getContext(), android.R.layout.simple_spinner_dropdown_item, typeoftest);
        spinnerTypeOfTest.setAdapter(arrayAdapter_typeoftest);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        spinnerTestParameter = (Spinner) view.findViewById(R.id.spinnerTestParameter);

        spinnerTypeOfTest.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                  Test_Type test_type =(Test_Type)  adapterView.getItemAtPosition(pos);
                 if(pos==0){

                 }else {
                     testtype =test_type.getName();
                     List<Test_Param> test_paramList= masterDataUtil.getTestParamFromTestType(test_type.getName());
                     testParamArrayAdapter = new ArrayAdapter<Test_Param>(getContext(), android.R.layout.simple_spinner_dropdown_item, test_paramList);
                     spinnerTestParameter.setAdapter(testParamArrayAdapter);
                 }
                /*  if(test_paramList.size()==1){
                      setupDataInput(test_paramList.get(0).getName());
                  }*/
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        spinnerTestParameter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {

                    Test_Param test_param =(Test_Param) adapterView.getItemAtPosition(pos);
                    if(test_param.getId()!=0){
                        String name =test_param.getName();
                        setupDataInput(name);
                    }
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
            storeName =Store;
            String TypeOfStore = bundle.getString("SpinnerTypeOfStore");
            String TypeOfProof = bundle.getString("SpinnerTypeOfProof");
            type_of_proof =TypeOfProof;
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


             Sample sample=masterDataUtil.getSample(test_param,testtype,type_of_proof,storeName);
             boolean  isSampleAvailable= sample.isDataEntry();
             LinearLayout linearLayout =view.findViewById(R.id.linearLayoutDecisions);
            if(isSampleAvailable){
                int sampleSize = sample.getSampleSize();
                        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        int id =1110;
                        if(sampleSize<=1 || sampleSize>13){
                            int i=1;
                            LinearLayout row =new LinearLayout(getContext());
                            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,1f);
                            param.setMargins(10,5,0,0);
                            row.setOrientation(LinearLayout.HORIZONTAL);
                            row.setLayoutParams(p);
                            EditText editText = new EditText(getContext());
                            editText.setLayoutParams(param);
                            editText.setHint("Enter sample");
                            editText.setId(i+1);
                            editText.setBackgroundResource(R.drawable.round_shape_button);
                            editText.setTextSize(24);
                            editText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                            row.addView(editText);
                            linearLayout.addView(row);

                        } else {
                            int num= sampleSize/3;
                            int rem= sampleSize%3;
                            if(rem!=0){
                                num++;
                            }
                            int index=0;
                            for(int i=1;i<=num;i++){
                                LinearLayout row =new LinearLayout(getContext());
                                row.setOrientation(LinearLayout.HORIZONTAL);
                                row.setLayoutParams(p);
                                row.setId(++id);

                                for(int j=0;j<1;j++){

                                    LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,1f);
                                    param.setMargins(10,5,0,0);

                                    EditText editText = new EditText(getContext());
                                    editText.setLayoutParams(param);
                                    editText.setId(i+1);
                                    editText.setHint("S"+(++index));
                                    editText.setBackgroundResource(R.drawable.round_shape_button);
                                    editText.setTextSize(24);
                                    editText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                                    if(index<=sampleSize){
                                        row.addView(editText);
                                    }

                                    EditText editText1 = new EditText(getContext());
                                    editText1.setLayoutParams(param);
                                    editText1.setId(i+2);
                                    editText1.setBackgroundResource(R.drawable.round_shape_button);
                                    editText1.setTextSize(24);
                                    editText1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                                    editText1.setHint("S"+(++index));
                                    if(index<=sampleSize){
                                        row.addView(editText1);
                                    }

                                    EditText editText2 = new EditText(getContext());
                                    editText2.setLayoutParams(param);
                                    editText2.setId(i+3);
                                    editText2.setBackgroundResource(R.drawable.round_shape_button);
                                    editText2.setTextSize(24);
                                    editText2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                                    editText2.setHint("S"+(++index));
                                    if(index<=sampleSize){
                                        row.addView(editText2);
                                    }

                                }
                                linearLayout.addView(row);
                            }
                        }
            }else {
                LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                int id =1110,i=1;
                LinearLayout row =new LinearLayout(getContext());
                row.setOrientation(LinearLayout.HORIZONTAL);
                row.setLayoutParams(p);
                row.setId(++id);

                LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,1f);
                p.setMargins(10,5,0,0);
                EditText editText = new EditText(getContext());
                editText.setLayoutParams(param);
                editText.setId(i+1);
                editText.setBackgroundResource(R.drawable.round_shape_button);
                editText.setTextSize(24);
                editText.setHint("Enter sample");
                editText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                row.addView(editText);
                linearLayout.addView(row);

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
