package com.example.navigationtest;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class MainFragment2 extends Fragment {
    ArrayList<String> typeoftest;
    Spinner spinnerTypeOfTest,spinnerTestParameter;
    ArrayAdapter<String> arrayAdapter_typeoftest, arrayAdapter_testparameter;
    private onMainFragment2BackBtnSelected listener3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2_main, container, false);
      spinnerTypeOfTest = (Spinner)view.findViewById(R.id.spinnerTypeOfTest);
        typeoftest = new ArrayList<>();
        typeoftest.add("Select");
        typeoftest.add("Checking of resistance against jolting");
        typeoftest.add("Sensitivity to piercing at upper limit (5cm) after jolting test");
        typeoftest.add("Sensitivity to piercing at lower limit(0.5cm)");
        typeoftest.add("Sensitivity to piercing at upper limit(5cm) after holding in the desiccators");
        typeoftest.add("Functioning Proof Test");
        typeoftest.add("Drop test(from every 10th lot)");
        typeoftest.add("Drop Test");
        typeoftest.add("Sensitivity test");
        typeoftest.add("Firing test");
        typeoftest.add("Delay Proof");
        typeoftest.add("Rough Usage (Drop test)");
        typeoftest.add("Impact test");
        typeoftest.add("Jolt test");
        typeoftest.add("Initiation test (after impact test)");
        typeoftest.add("Initiation test (after jolt test)");
        typeoftest.add("Initiation test (after impact/Jolt test where ever single defect observed)");
        typeoftest.add("Initiation test (after impact/Jolt test whereever double defect observed)");
        typeoftest.add("Resistance Test");
        typeoftest.add("Functioning delay test");
        typeoftest.add("Sensitivity to piercing from upper limit (after jolt test)");
        typeoftest.add("Sensitivity to piercing from lower limit");
        typeoftest.add("Sensitivity to piercing from upper limit (after impact test)");
        typeoftest.add("Sensitivity to piercing with Duralumin pin");
        typeoftest.add("Sensitivity to impact at upper limit");
        typeoftest.add("Sensitivity to impact at lower limit");
        typeoftest.add("Sensitivity to impact at upper limit in 100% humid condition");
        typeoftest.add("Pressure bar test");
        typeoftest.add("Flash Delivery test");
        typeoftest.add("Resistance test (Electrical test)");
        typeoftest.add("Flash test");
        typeoftest.add("Time to function");
        typeoftest.add("Rough Usage test (Jolt test and Drop Test followed by Resistance test)");
        typeoftest.add("Rough Usage test (Vibration test followed by Resistance test)");
        typeoftest.add("Functioning Delay test after Jolt Test");
        typeoftest.add("Environmental Conditioning test (5 Samples after jolt test)");
        typeoftest.add("Water immersion test followed by Flash Test (5 samples after Environment conditioning test and 3 samples after jolt test)");
        typeoftest.add("Environmental Conditioning test (13 Samples after jolt test)");
        typeoftest.add("Water immersion test followed by Flash Test (13 samples after Environment conditioning test and 13 samples after jolt test)");
        typeoftest.add("Functioning Proof by Percussion Method");
        typeoftest.add("Delay test (by elecrical method)");
        typeoftest.add("Functioning Test");
        typeoftest.add("Checking  of maximum Pressure at normal temperature (25±10)°C");
        typeoftest.add("Checking of time interval from the moment of impact on striker to the start of rising of Pressure curve:T1 (at  normal temperature (25±10)°C)");
        typeoftest.add("Checking of Time interval from start of rising of the Pressure curve to the moment of attending the maximum:T2 (at normal temperature (25±10)°C)");
        typeoftest.add("Checking  of maximum Pressure at temperature +60°C");
        typeoftest.add("Checking of time interval from the moment of impact on striker to the start of rising of Pressure curve:T1 (at temperature (+60±3)°C)");
        typeoftest.add("Checking of Time interval from start of rising  of the Pressure curve to the moment of attending the maximum:T2 (at temperature (+60±3)°C)");
        typeoftest.add("Checking  of maximum Pressure at temperature (-60±3)°C");
        typeoftest.add("Checking of time interval from the moment of impact on striker to the start of rising of Pressure curve:T1 (at temperature (-60±3)°C)");
        typeoftest.add("Checking of Time interval from start of rising  of the Pressure curve to the moment of attending the maximum:T2 (at temperature (-60±3)°C)");
        typeoftest.add("Complete detonation of the Fuze Anti removal");
        typeoftest.add("Non functioning test");
        typeoftest.add("Functioning  of Fuze");
        typeoftest.add("Static Detonation Proof");
        typeoftest.add("Sealing Proof");
        typeoftest.add("Dynamic Proof");
        typeoftest.add("Functioning and Velocity proof test");
        typeoftest.add("Functioning proof with Ch-I and Ch-II Sample Size 60");
        typeoftest.add("Velocity  Proof with Ch-I Sample Size 30");
        typeoftest.add("Velocity  Proof with Ch-II Sample Size 30");
        typeoftest.add("Wild Round while firing with Ch-I Sample Size 30");
        typeoftest.add("Wild Round while firing with Ch-II Sample Size 30");
        typeoftest.add("After wild round elimination (with Ch-I)");
        typeoftest.add("After wild round elimination (with Ch-II)");
        typeoftest.add("Self Destruction test at Ambient Temp");
        typeoftest.add("Self Destruction test at +50°C±3°C");
        typeoftest.add("Self Destruction test at -50°C±3°C");
        typeoftest.add("Hammer Masset Test at 10th tooth");
        typeoftest.add("Hammer Masset Test at 15th tooth");
        typeoftest.add("Hammer Masset Test at 23rd tooth");
        typeoftest.add("Water immersion test");
        typeoftest.add("Complete detonation of Filled Mine AT 4D ND");
        typeoftest.add("Complete Detonation and Range Proof");
        typeoftest.add("Complete Detonation Proof");
        typeoftest.add("Complete Detonation and Range Proof Conditioned at-30°C for 8 Hours");
        typeoftest.add("Complete Detonation and Range Proof Conditioned at +50 °C for 8 Hours");

        arrayAdapter_typeoftest = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, typeoftest);
        spinnerTypeOfTest.setAdapter(arrayAdapter_typeoftest);

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
