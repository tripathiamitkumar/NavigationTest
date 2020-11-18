package com.example.navigationtest.fragment;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.navigationtest.R;
import com.example.navigationtest.helper.ReportProofHelper;
import com.example.navigationtest.model.Location;
import com.example.navigationtest.model.Sample;
import com.example.navigationtest.model.Section;
import com.example.navigationtest.model.Store;
import com.example.navigationtest.model.Test_Param;
import com.example.navigationtest.model.Test_Type;
import com.example.navigationtest.model.Type_Of_Proof;
import com.example.navigationtest.util.MasterDataUtil;
import com.example.navigationtest.util.WebConstant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProofFragment extends Fragment implements DatePickerDialog.OnDateSetListener {
    ImageButton selectDate;
    TextView dateToActivate;
    TextView selectedDate,txtLotNo,txtProofQty,txtProofType,txtProofLocation,txtProofQcc,txtProofShedule;
    EditText  edtproofSlip , edtepcode;
    Spinner spinnerTyofTest,spinnerTestParam;
    String dataEntryForEachSample= "", sam_cd= "", tst_cd= "", pro_sen_cd="0" ,pro_insp_dt="", pro_sqrec= "" ,pro_rch="" , pro_rej_cd="";
    boolean isDataEntryforEachSample =false;
    List<Test_Type> testTypeList  = new ArrayList<>();
    List<Test_Param> testParamList = new ArrayList<>();
    ArrayAdapter<Test_Type> testTypeArrayAdapter;
    ArrayAdapter<Test_Param> testParamArrayAdapter;
    RequestQueue requestQueue;
    private List<EditText> editTextList = new ArrayList<EditText>();
    View view;
    String testType,testParam;
    double upperLimit,lowerLimit;
    private MasterDataUtil masterDataUtil = null;
    private Button btn_view, btnAdd;
    int index= 0;
    String result = "0";
    ReportProofHelper reportProofHelper;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private onFragmentBtnSelected listener;
    private onMainFragment2BtnSelected listener1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        requestQueue =Volley.newRequestQueue(getContext());
        masterDataUtil =MasterDataUtil.getInstance();
        selectedDate = (TextView) view.findViewById(R.id.selectedDate);
        edtproofSlip= (EditText) view.findViewById(R.id.edtproofSlip);
        btn_view =(Button) view.findViewById(R.id.btn_view);
        edtepcode =(EditText) view.findViewById(R.id.edtepcode);
        txtLotNo= (TextView) view.findViewById(R.id.txtLotNo);
        txtProofQty= (TextView) view.findViewById(R.id.txt4);
        txtProofType= (TextView) view.findViewById(R.id.txt5);
        txtProofLocation= (TextView) view.findViewById(R.id.txt6);
        txtProofShedule= (TextView) view.findViewById(R.id.txt7);
        txtProofQcc= (TextView) view.findViewById(R.id.txt8);
        spinnerTyofTest= (Spinner) view.findViewById(R.id.spinnerTypeOfTest);
        spinnerTestParam =(Spinner) view.findViewById(R.id.spinnerTypeOfParam);
        btnAdd=(Button) view.findViewById(R.id.btn_f2m_add);
        reportProofHelper= new ReportProofHelper(getContext());
        selectDate = (ImageButton) view.findViewById(R.id.SelectDate); // getting the image button in fragment_blank.xml
        dateToActivate = (TextView) view.findViewById(R.id.selectedDate); // getting the TextView in fragment_blank.xml

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    StringBuffer buffer= new StringBuffer();
                    ArrayList<Double> doubles = new ArrayList<>();
                    int i=0;
                    for(EditText editText :editTextList){
                        i++;
                         String sampleData= editText.getText().toString();
                         if(sampleData.length()==0){
                             editText.requestFocus();
                             editText.setError("this cant be empty! only numeric ");
                             break;
                         } else {
                            double sample= Double.parseDouble(sampleData);
                            doubles.add(sample);
                         }
                         if(i==editTextList.size()){
                             buffer.append(sampleData+" ");
                         }else {
                             buffer.append(sampleData+", ");
                         }
                    }
                    int counter=0;
                    double totalTestPm= 0;
                    for(Double aDouble : doubles){
                        totalTestPm= totalTestPm+ aDouble;
                         if(index==1){
                                if(aDouble == lowerLimit){
                                    result ="1";
                                }
                         } else {
                                if(aDouble >=lowerLimit && aDouble<=upperLimit){
                                    counter++;
                                }
                         }
                    }
                    if(counter== doubles.size()){
                        result ="1";
                    }
                    Sample sample = new Sample();
                    sample.setTestparamId(testParam);
                    sample.setTypeOfTestId(testType);
                    sample.setResult(result);
                    String item_cd= edtepcode.getText().toString();
                    sample.setItem_cd(item_cd);
                    sample.setObservation(buffer.toString());
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String dateTime= dateFormat.format(Calendar.getInstance().getTime());
                    sample.setDate(dateTime);
                    reportProofHelper.addReport(sample);
                    String proofSlip= edtproofSlip.getText().toString();
                    String lotNo =txtLotNo.getText().toString();
                    Bundle bundle = new Bundle();
                    bundle.putString("testParam",testParam);
                    bundle.putString("testType",testType);
                    bundle.putString("lotNo",lotNo);
                    bundle.putString("proofSlip",proofSlip);
                    bundle.putString("dateTime",dateTime);
                    bundle.putString("observation",buffer.toString());
                    bundle.putString("result",result);
                    ResultFragment resultFragment =new ResultFragment();
                    resultFragment.setArguments(bundle);
                    String pro_type_cd= txtProofType.getText().toString();
                    DecimalFormat decimalFormat =new DecimalFormat("#.##");
                    String pro_tst_pm= decimalFormat.format(totalTestPm);
                    String pro_obs = "" ;
                    if(!isDataEntryforEachSample){
                        if(sam_cd.equals("S")){
                            pro_obs= "Sustained:"+pro_tst_pm;
                        } else {
                            pro_obs= "Functioned:"+pro_tst_pm;
                        }
                    } else {
                        pro_obs= decimalFormat.format(totalTestPm);
                    }
                    String pro_dop= dateTime;
                    String pro_remark="";
                    new PostToServer().execute(lotNo,pro_type_cd, pro_tst_pm,pro_sen_cd, pro_type_cd,pro_dop,proofSlip,pro_obs,pro_remark,item_cd, pro_insp_dt,pro_sqrec,pro_rch,pro_rej_cd);
                    getFragmentManager().beginTransaction().replace(R.id.container_fragment,resultFragment).commit();

            }
        });


        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtproofSlip.getText().length()==0){
                    edtproofSlip.requestFocus();
                    edtproofSlip.setError("Proof Slip Number is Required!");
                } else {
                    String proofslipNo= edtproofSlip.getText().toString();
                    fetchProofData(proofslipNo);
                }

            }
        });
        spinnerTestParam.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {

                    if(pos!=0){
                        Test_Param test_param =(Test_Param) adapterView.getItemAtPosition(pos);
                        double sap_size= Double.parseDouble(test_param.getSampleSize());
                        setupDataInput((int)sap_size, isDataEntryforEachSample);
                        upperLimit = test_param.getUpperLimit();
                        lowerLimit= test_param.getLowerLimit();
                        testType = test_param.getTestType();
                        testParam = test_param.getName();

                    }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerTyofTest.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {

                  Test_Type test_type =(Test_Type) adapterView.getItemAtPosition(pos);
                  List<Test_Param> test_paramList =masterDataUtil.getTestParamFromTestType(test_type.getName());
                  if(test_paramList.size()!=0){

                         if(test_paramList.size()>1){
                                List<Test_Param> test_params= new ArrayList<>();
                                test_params.add(new Test_Param(0,"Select Test Param"));
                                for(Test_Param test_param: test_paramList){
                                    test_params.add(test_param);
                                }
                             testParamArrayAdapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_dropdown_item,test_params);
                             spinnerTestParam.setAdapter(testParamArrayAdapter);
                         } else {
                             testParamArrayAdapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_dropdown_item,test_paramList);
                             spinnerTestParam.setAdapter(testParamArrayAdapter);

                             Test_Param test_param =(Test_Param) testParamArrayAdapter.getItem(0);
                             testParam = test_param.getName();
                             testType = test_param.getTestType();
                             double sap_szie= Double.parseDouble(test_param.getSampleSize());
                             if(dataEntryForEachSample!=null && dataEntryForEachSample.equals("C")){
                                 isDataEntryforEachSample = true;
                                 setupDataInput((int)sap_szie, true);
                             } else{
                                 setupDataInput((int)sap_szie, false);
                             }
                         }
                  }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

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


    private void fetchProofData(String proofslipNo){


        try {
            ProgressDialog progressDialog = new ProgressDialog(getContext());
            progressDialog.setMessage("please wait...");
            progressDialog.show();
            String URL= WebConstant.PROOFURL+"?proof_slip_no="+proofslipNo+"";
            JsonObjectRequest jsonObjectRequest  =new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                        if(response!=null){

                               try {
                                   JSONArray jsonArray = response.getJSONArray("tproof");
                                   for(int i=0;i<jsonArray.length();i++){

                                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                                        String lot_no= jsonObject.getString("lot_no");
                                        String pro_lotqty =jsonObject.getString("pro_lotqty");
                                        String pro_qcc= jsonObject.getString("pro_qcc");
                                        String pro_loc= jsonObject.getString("pro_loc");
                                        String itm_cd= jsonObject.getString("itm_cd");
                                        String pro_typ_cd= jsonObject.getString("pro_typ_cd");
                                        pro_insp_dt= jsonObject.getString("pro_insp_dt");
                                        pro_sen_cd= jsonObject.getString("pro_sen_cd");
                                        pro_sqrec= jsonObject.getString("pro_sqrec");
                                        pro_rch= jsonObject.getString("pro_rch");
                                        pro_rej_cd= jsonObject.getString("pro_rej_cd");
                                        JSONArray array =jsonObject.getJSONArray("test_data");
                                        edtepcode.setText(itm_cd);
                                        txtProofQty.setText(pro_lotqty);
                                        txtLotNo.setText(lot_no);
                                        txtProofType.setText(pro_typ_cd);
                                        txtProofLocation.setText(pro_loc);
                                        txtProofShedule.setText(pro_insp_dt);
                                        txtProofQcc.setText(pro_qcc);

                                        for(int j=0;j<array.length();j++){

                                               JSONObject obj =   array.getJSONObject(j);
                                               String samplesze= obj.getString("sam_siz");
                                               String tst_type= obj.getString("tst_type");
                                               String tst_pm= obj.getString("tst_pm");
                                               String res_cd= obj.getString("res_cd");
                                               String low_lim= obj.getString("low_lim");
                                               String upp_lim= obj.getString("upp_lim");
                                               sam_cd= obj.getString("sam_cd");
                                               tst_cd= obj.getString("tst_cd");
                                               dataEntryForEachSample =res_cd;
                                               Test_Param test_param = new Test_Param(j+1, tst_pm);
                                               test_param.setTestType(tst_type);
                                               test_param.setSampleSize(samplesze);
                                               test_param.setUpperLimit(Double.parseDouble(upp_lim));
                                               test_param.setLowerLimit(Double.parseDouble(low_lim));
                                               testParamList.add(test_param);
                                               Test_Type test_type = new Test_Type(j+1, tst_type);
                                               if(!testTypeList.contains(test_type)){
                                                   testTypeList.add(test_type);
                                               }
                                        }
                                       Map<String,List<Test_Param>> testParamMap= testParamList.stream().collect(Collectors.groupingBy(Test_Param::getTestType,Collectors.toList()));
                                       masterDataUtil.setTestTypeList(testTypeList);
                                       masterDataUtil.setTestParamMap(testParamMap);
                                       testTypeArrayAdapter =new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_dropdown_item,testTypeList);
                                       spinnerTyofTest.setAdapter(testTypeArrayAdapter);
                                       progressDialog.dismiss();
                                   }
                               }catch(JSONException e) {
                                   e.printStackTrace();
                                   progressDialog.dismiss();
                               }
                        }else {
                            Toast.makeText(getContext(),"Network Error!",Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                        }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    progressDialog.dismiss();
                }
            });
            requestQueue.add(jsonObjectRequest);
        }catch (Exception e)
        {
            e.printStackTrace();
        }

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

    private void setupDataInput(int sampleSize, boolean isSampleAvailable){
        editTextList.clear();
        index =0;
        LinearLayout linearLayout =view.findViewById(R.id.linearLayoutDecisions);
        linearLayout.removeAllViews();
        if(isSampleAvailable){
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
                editTextList.add(editText);
                row.addView(editText);
                linearLayout.addView(row);

            } else {
                int num= sampleSize/3;
                int rem= sampleSize%3;
                if(rem!=0){
                    num++;
                }
                index=0;
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
                        editTextList.add(editText);
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
                        editTextList.add(editText);
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
                        editTextList.add(editText);
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
            editTextList.add(editText);
            row.addView(editText);
            linearLayout.addView(row);
            index++;
        }

    }


    private class PostToServer extends AsyncTask<String,Void,JSONObject> {

        ProgressDialog progressDialog = null;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog =new ProgressDialog(getContext());
            progressDialog.setMessage("loading...");
            progressDialog.show();
        }

        @Override
        protected JSONObject doInBackground(String... strings) {

            try {

                StringRequest stringRequest = new StringRequest(Request.Method.POST, WebConstant.PROOFINSERTURL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response!=null){
                            Log.e("Volley Response", Objects.requireNonNull(response));
                        } else {
                            Log.e("Volley Response", "Response is NUll");
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley Error", Objects.requireNonNull(error.getMessage()));
                    }
                }
                ) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("lot_no",strings[0]);
                        params.put("pro_type_cd",strings[1]);
                        params.put("pro_tst_pm",strings[2]);
                        params.put("pro_tst_sen_cd",strings[3]);
                        params.put("pro_tst_cd",strings[4]);
                        params.put("pro_dop",strings[5]);
                        params.put("pro_pslip",strings[6]);
                        params.put("pro_obs",strings[7]);
                        params.put("pro_rmk",strings[8]);
                        params.put("pro_itm",strings[9]);
                        params.put("pro_insp_dt",strings[10]);
                        params.put("pro_sqrec",strings[11]);
                        params.put("pro_rch",strings[12]);
                        params.put("pro_rej_cd",strings[13]);
                        return params;
                    }
                };
                requestQueue.getCache().clear();
                requestQueue.add(stringRequest);
            }catch (Exception e) {
                e.printStackTrace();
            }
            return new JSONObject();
        }

        @Override
        protected void onPostExecute(JSONObject jsonObject) {
            progressDialog.dismiss();
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
