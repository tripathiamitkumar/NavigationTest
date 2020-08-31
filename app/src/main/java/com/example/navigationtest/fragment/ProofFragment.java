package com.example.navigationtest.fragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.navigationtest.R;

import java.util.ArrayList;

public class ProofFragment extends Fragment implements DatePickerDialog.OnDateSetListener {
    ImageButton selectDate;
    TextView dateToActivate;
    TextView selectedDate;
    EditText editTxt_LotNumber, editTxt_ProofSlipNumber;
    Spinner spinnerLocation,spinnerSection, spinnerStore, spinnerTypeOfStore, spinnerTypeOfProof, spinnerProofNumber;
    ArrayList<String> section;
    ArrayList<String> arrayList_Select, arrayList_UNIT_01, arrayList_UNIT_03, arrayList_UNIT_04, arrayList_UNIT_06, arrayList_UNIT_10;
    ArrayAdapter<String> arrayAdapter_section, arrayAdapter_store;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private onFragmentBtnSelected listener;
    private onMainFragment2BtnSelected listener1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        spinnerLocation = (Spinner) view.findViewById(R.id.spinnerLocation);
        spinnerSection = (Spinner) view.findViewById(R.id.spinnerSection);
        spinnerStore = (Spinner) view.findViewById(R.id.spinnerStore);

        spinnerTypeOfStore = (Spinner) view.findViewById(R.id.spinnerTypeOfStore);
        spinnerTypeOfProof = (Spinner) view.findViewById(R.id.spinnerTypeOfProof);
        spinnerProofNumber = (Spinner) view.findViewById(R.id.spinnerProofNumber);
        editTxt_LotNumber = (EditText) view.findViewById(R.id.editTxt_LotNumber);
        editTxt_ProofSlipNumber = (EditText) view.findViewById(R.id.editTxt_ProofSlipNumber);
        selectedDate = (TextView) view.findViewById(R.id.selectedDate);

        section = new ArrayList<>();
        section.add("Select");
        section.add("UNIT-01");
        section.add("UNIT-03");
        section.add("UNIT-04");
        section.add("UNIT-06");
        section.add("UNIT-10");

        arrayAdapter_section = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, section);
        spinnerSection.setAdapter(arrayAdapter_section);

        arrayList_Select = new ArrayList<>();
        arrayList_Select.add("Select");

        arrayList_UNIT_01 = new ArrayList<>();
        arrayList_UNIT_01.add("Select");
        arrayList_UNIT_01.add("Primer Electric 1A/L (Filled)");
        arrayList_UNIT_01.add("Primer Electric 1A/L (Filled)(HEAVY PROOF)");
        arrayList_UNIT_01.add("Primer Electric 1A/L (Empty)");
        arrayList_UNIT_01.add("Primer Electric 1A/L (Empty)(HEAVY PROOF)");
        arrayList_UNIT_01.add("Combination Case Ignition Primer GUV-7 (filled)");
        arrayList_UNIT_01.add("Combination Case Ignition Primer GUV-7 (filled) Pilot Lot");
        arrayList_UNIT_01.add("Combination Case Ignition Primer GUV-7 (Empty)");
        arrayList_UNIT_01.add("Combination Case Ignition Primer GUV-7 (Empty) Pilot Lot");
        arrayList_UNIT_01.add("PRIMER PERCUSSION Q.F.CARTRIDGE 18A (FILLED)");
        arrayList_UNIT_01.add("Primer Sleeve KB-30 (Filled) ");
        arrayList_UNIT_01.add("Cartg. Bomb 51mm (FTT) Filled");
        arrayList_UNIT_01.add("Cartg. Bomb 51mm (FTT) Filled First Lot");


        arrayList_UNIT_03 = new ArrayList<>();
        arrayList_UNIT_03.add("Select");
        arrayList_UNIT_03.add("Igniting Primer NO:.1 MG 8");
        arrayList_UNIT_03.add("Cap 78mg QFGG");
        arrayList_UNIT_03.add("Cap Complete for Primary Cartg. for Mortar Bomb 51mm (3G CAP)");
        arrayList_UNIT_03.add("Cap Conducting Composition");
        arrayList_UNIT_03.add("Primer Detonator A-30-T");
        arrayList_UNIT_03.add("Charged Electric Fuze");
        arrayList_UNIT_03.add("Igniting Primer KB-3B");
        arrayList_UNIT_03.add("Igniting Primer NO: .1 Sleeve");
        arrayList_UNIT_03.add("Detonator 135mg LZY");
        arrayList_UNIT_03.add("Detonator 356mg LZ");


        arrayList_UNIT_04 = new ArrayList<>();
        arrayList_UNIT_04.add("Select");
        arrayList_UNIT_04.add("Fuze Mine Anti-Tank 2B ND (Filled)");
        arrayList_UNIT_04.add("Fuze Mine Anti-Tank 2B ND (Filled)(FIRST LOT)");
        arrayList_UNIT_04.add("Fuze Mine Anti-Tank 2B ND (Empty)");
        arrayList_UNIT_04.add("Fuze Mine Anti-Tank 2B ND (Empty)(FIRST LOT)");
        arrayList_UNIT_04.add("Fuze Mine Anti-Tank 4A ND (Filled)");
        arrayList_UNIT_04.add("Fuze Mine Anti-Tank 4A ND (Filled)(FIRST LOT)");
        arrayList_UNIT_04.add("Fuze Mine Anti-Tank 4A ND (Empty)");
        arrayList_UNIT_04.add("Fuze Mine Anti-Tank 4A ND (Empty)(FIRST LOT)");
        arrayList_UNIT_04.add("Fuze Percussion DA No .117 MK-20(Filled)");
        arrayList_UNIT_04.add("Fuze Percussion DA No 117 MK-20(Filled) First Lot/ Pilot Lot");
        arrayList_UNIT_04.add("Fuze Percussion DA No 117 MK-20(Empty)");
        arrayList_UNIT_04.add("Fuze Percussion DA No.117 MK-20(Empty)(Advance samples)");
        arrayList_UNIT_04.add("Fuze Percussion DA No.117 MK-20(Empty) (First Lot)");
        arrayList_UNIT_04.add("Fuze Percussion DA5A (Filled)");
        arrayList_UNIT_04.add("Fuze Percussion DA5A (Filled)(First Lot)");
        arrayList_UNIT_04.add("Fuze Percussion DA5A (Empty Filled)");
        arrayList_UNIT_04.add("Fuze Percussion DA5A(Empty Filled)(First Lot)");
        arrayList_UNIT_04.add("Fuze Percussion DA5A(Empty Filled)(Advance samples)");
        arrayList_UNIT_04.add("Fuze A670M (Filled) sample size is 39 Nos");
        arrayList_UNIT_04.add("Fuze A670M (Filled)Every 3rd Lot Sample size is 89 Nos");
        arrayList_UNIT_04.add("Mortar Bomb 51mm HE2A (Filled)");
        arrayList_UNIT_04.add("Mortar Bomb 51mm HE2A (Filled) Every 15th Lot");


        arrayList_UNIT_06 = new ArrayList<>();
        arrayList_UNIT_06.add("Select");
        arrayList_UNIT_06.add("Propellant Matching Proof of Primer KB-30");


        arrayList_UNIT_10 = new ArrayList<>();
        arrayList_UNIT_10.add("Select");
        arrayList_UNIT_10.add("Mine AT 4D ND (Filled)");


        spinnerSection.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0) {
                    arrayAdapter_store = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, arrayList_Select);
                    //String text = spinnerSection.getItemAtPosition(position).toString();
                    Toast.makeText(spinnerSection.getContext(), "Please Select Section Items", Toast.LENGTH_SHORT).show();

                }
                if (position == 1) {
                    arrayAdapter_store = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, arrayList_UNIT_01);
                    // String text = spinnerSection.getItemAtPosition(position).toString();
                    //Toast.makeText(spinnerSection.getContext(), text, Toast.LENGTH_SHORT).show();
                    Toast.makeText(spinnerSection.getContext(), "Section UNIT-01 Selected", Toast.LENGTH_SHORT).show();
                }
                if (position == 2) {
                    arrayAdapter_store = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, arrayList_UNIT_03);
                    //String text = spinnerSection.getItemAtPosition(position).toString();
                    //Toast.makeText(spinnerSection.getContext(), text, Toast.LENGTH_SHORT).show();
                    Toast.makeText(spinnerSection.getContext(), "Section UNIT-03 Selected", Toast.LENGTH_SHORT).show();
                }
                if (position == 3) {
                    arrayAdapter_store = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, arrayList_UNIT_04);
                    //String text = spinnerSection.getItemAtPosition(position).toString();
                    //Toast.makeText(spinnerSection.getContext(), text, Toast.LENGTH_SHORT).show();
                    Toast.makeText(spinnerSection.getContext(), "Section UNIT-04 Selected", Toast.LENGTH_SHORT).show();
                }
                if (position == 4) {
                    arrayAdapter_store = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, arrayList_UNIT_06);
                    //String text = spinnerSection.getItemAtPosition(position).toString();
                    //Toast.makeText(spinnerSection.getContext(), text, Toast.LENGTH_SHORT).show();
                    Toast.makeText(spinnerSection.getContext(), "Section UNIT-06 Selected", Toast.LENGTH_SHORT).show();
                }
                if (position == 5) {
                    arrayAdapter_store = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, arrayList_UNIT_10);
                    // String text = spinnerSection.getItemAtPosition(position).toString();
                    // Toast.makeText(spinnerSection.getContext(), text, Toast.LENGTH_SHORT).show();
                    Toast.makeText(spinnerSection.getContext(), "Section UNIT-10 Selected", Toast.LENGTH_SHORT).show();
                }
                spinnerStore.setAdapter(arrayAdapter_store);


            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        selectDate = (ImageButton) view.findViewById(R.id.SelectDate); // getting the image button in fragment_blank.xml
        dateToActivate = (TextView) view.findViewById(R.id.selectedDate); // getting the TextView in fragment_blank.xml
        Button clickme = view.findViewById(R.id.load);
        Button btn_for_mainfragment2 = view.findViewById(R.id.gotomainfragment2);

        btn_for_mainfragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener1.onButtonSeleted1();
                String location = spinnerLocation.getSelectedItem().toString();
                String section = spinnerSection.getSelectedItem().toString();
                String store = spinnerStore.getSelectedItem().toString();
                String typeOfStore = spinnerTypeOfStore.getSelectedItem().toString();
                String typeOfProof = spinnerTypeOfProof.getSelectedItem().toString();
                String proofNumber = spinnerProofNumber.getSelectedItem().toString();
                String lotNumber = editTxt_LotNumber.getText().toString();
                String proofSlipNumber = editTxt_ProofSlipNumber.getText().toString();
                String selectedDate = dateToActivate.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("SpinnerLocation",location);
                bundle.putString("SpinnerSection",section);
                bundle.putString("SpinnerStore", store);
                bundle.putString("SpinnerTypeOfStore", typeOfStore);
                bundle.putString("SpinnerTypeOfProof", typeOfProof);
                bundle.putString("SpinnerProofNumber", proofNumber);
                bundle.putString("EditTxt_LotNumber", lotNumber);
                bundle.putString("EditTxt_ProofSlipNumber", proofSlipNumber);
                bundle.putString("DateToActivate", selectedDate);

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MainFragment2 mainFragment2 = new MainFragment2();
                mainFragment2.setArguments(bundle);
                fragmentTransaction.replace(R.id.container_fragment, mainFragment2);
                fragmentTransaction.commit();

            }
        });


        clickme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onButtonSeleted();
            }
        });
        // return view;
        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DialogFragment newFragment = new DatePickerFragment();
                newFragment.setTargetFragment(ProofFragment.this, 0);
                newFragment.show(getFragmentManager(), "datePicker");
            }
        });
        return view;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) { // what should be done when a date is selected
        StringBuilder sb = new StringBuilder().append(dayOfMonth).append("/").append(monthOfYear + 1).append("/").append(year);
        String formattedDate = sb.toString();
        dateToActivate.setText(formattedDate);
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof onFragmentBtnSelected) {
            listener = (onFragmentBtnSelected) context;
        }
        if (context instanceof onMainFragment2BtnSelected) {
            listener1 = (onMainFragment2BtnSelected) context;
        } else {
            throw new ClassCastException(context.toString() + "must implement listener");

        }

    }


    public interface
    onFragmentBtnSelected {
        public void onButtonSeleted();
    }

    public interface
    onMainFragment2BtnSelected {
        public void onButtonSeleted1();


    }


}
