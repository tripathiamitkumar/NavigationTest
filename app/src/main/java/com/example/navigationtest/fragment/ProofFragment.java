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
import com.example.navigationtest.model.Location;
import com.example.navigationtest.model.Section;
import com.example.navigationtest.model.Store;
import com.example.navigationtest.model.Type_Of_Proof;
import com.example.navigationtest.util.DataMapping;
import com.example.navigationtest.util.DataSetup;
import com.example.navigationtest.util.MasterDataUtil;
import java.util.List;

public class ProofFragment extends Fragment implements DatePickerDialog.OnDateSetListener {
    ImageButton selectDate;
    TextView dateToActivate;
    TextView selectedDate;
    EditText editTxt_LotNumber, editTxt_ProofSlipNumber;
    Spinner spinnerLocation,spinnerSection, spinnerStore, spinnerTypeOfStore, spinnerTypeOfProof, spinnerProofNumber;
    List<Section> section;
    List<Location> locationList;
    ArrayAdapter<Location> locationArrayAdapter;
    ArrayAdapter<Section> arrayAdapter_section;
    ArrayAdapter<Store> arrayAdapter_store;
    ArrayAdapter<Type_Of_Proof> proofArrayAdapter;
    List<Type_Of_Proof> typeOfProofList;
    private DataSetup dataSetup;
    private List<Store> storeList;

    private MasterDataUtil masterDataUtil = null;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private onFragmentBtnSelected listener;
    private onMainFragment2BtnSelected listener1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        masterDataUtil =MasterDataUtil.getInstance();
        dataSetup = new DataMapping(masterDataUtil);
        spinnerLocation = (Spinner) view.findViewById(R.id.spinnerLocation);
        spinnerSection = (Spinner) view.findViewById(R.id.spinnerSection);
        spinnerStore = (Spinner) view.findViewById(R.id.spinnerStore);

        spinnerTypeOfStore = (Spinner) view.findViewById(R.id.spinnerTypeOfStore);
        spinnerTypeOfProof = (Spinner) view.findViewById(R.id.spinnerTypeOfProof);
        spinnerProofNumber = (Spinner) view.findViewById(R.id.spinnerProofNumber);
        editTxt_LotNumber = (EditText) view.findViewById(R.id.editTxt_LotNumber);
        editTxt_ProofSlipNumber = (EditText) view.findViewById(R.id.editTxt_ProofSlipNumber);
        selectedDate = (TextView) view.findViewById(R.id.selectedDate);
        locationList =dataSetup.getAllLocation();
        section = dataSetup.getAllSection();
        typeOfProofList= dataSetup.getTypeOfProofList();
        proofArrayAdapter =new ArrayAdapter<Type_Of_Proof>(getContext(), android.R.layout.simple_spinner_dropdown_item, typeOfProofList);
        arrayAdapter_section = new ArrayAdapter<Section>(getContext(), android.R.layout.simple_spinner_dropdown_item, section);
        locationArrayAdapter = new ArrayAdapter<Location>(getContext(),android.R.layout.simple_spinner_dropdown_item, locationList);
        spinnerLocation.setAdapter(locationArrayAdapter);
        spinnerSection.setAdapter(arrayAdapter_section);
        spinnerTypeOfProof.setAdapter(proofArrayAdapter);


        spinnerSection.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                Section section =(Section) spinnerSection.getItemAtPosition(position);
                if (position == 0) {
                    Toast.makeText(spinnerSection.getContext(), "Please Select Section Items", Toast.LENGTH_SHORT).show();
                } else {
                    storeList = dataSetup.getStoreFromSection(section.getName());
                    Toast.makeText(spinnerSection.getContext(), "Section "+section.getName()+" Selected", Toast.LENGTH_SHORT).show();
                    arrayAdapter_store = new ArrayAdapter<Store>(getContext(), android.R.layout.simple_spinner_dropdown_item, storeList);
                    spinnerStore.setAdapter(arrayAdapter_store);
                }
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
