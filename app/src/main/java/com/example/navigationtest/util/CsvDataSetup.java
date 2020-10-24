package com.example.navigationtest.util;

import android.content.Context;

import com.example.navigationtest.R;
import com.example.navigationtest.model.Proof_Number;
import com.example.navigationtest.model.Sample;
import com.example.navigationtest.model.Section;
import com.example.navigationtest.model.Store;
import com.example.navigationtest.model.Test_Param;
import com.example.navigationtest.model.Test_Type;
import com.example.navigationtest.model.Type_Of_Proof;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CsvDataSetup {

     MasterDataUtil masterDataUtil;
     Context context;
     public CsvDataSetup(Context context) {
         this.context= context;
         masterDataUtil= MasterDataUtil.getInstance();

     }

    public void setUpCsvFile() {
        int i=1;
        try {
            InputStream inputStream = context.getResources().openRawResource(R.raw.data);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(inputStream));
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
            String[] nextRecord;

            List<Section> sectionList = new ArrayList<>();
            List<Proof_Number> proofNumberList = new ArrayList<>();
            List<Type_Of_Proof> typeOfProofList = new ArrayList<>();
            List<Store> storeList = new ArrayList<>();
            List<Test_Type> testTypeList = new ArrayList<>();
            List<Test_Param> test_paramList = new ArrayList<>();
            List<Sample> sampleList = new ArrayList<>();
            Section section =new Section(0,"Select");
            Proof_Number proof_number = new Proof_Number(0,"Select");
            Type_Of_Proof typeOfProof = new Type_Of_Proof(0,"Select");
            Store store =new Store(0,"Select");
            store.setSectionName("");
            Test_Type test_type = new Test_Type(0,"Select");
            Test_Param test_param = new Test_Param(0,"Select");
            test_param.setTestType("");
            sectionList.add(section);
            proofNumberList.add(proof_number);
            typeOfProofList.add(typeOfProof);
            storeList.add(store);
            testTypeList.add(test_type);
            test_paramList.add(test_param);


            while ((nextRecord = csvReader.readNext()) != null) {

                    String unit ="";
                    if(nextRecord[0]!=null){
                         unit= nextRecord[0].trim();
                    }
                     section =new Section(i,unit);
                    if(!sectionList.contains(section)){
                        sectionList.add(section);
                    }
                    String storeName= "";
                    if(nextRecord[1]!=null){
                        storeName =nextRecord[1].trim();
                    }
                     store = new Store(i,storeName);
                    if(!storeList.contains(store)){
                        store.setSectionName(unit);
                        storeList.add(store);
                    }
                    String proof = "";
                    if(nextRecord[2]!=null){
                        proof =nextRecord[2].trim();
                    }
                     proof_number =new Proof_Number(i,proof);
                    if(!proofNumberList.contains(proof_number)){
                        proofNumberList.add(proof_number);
                    }

                    String type_of_proof = "";
                    if(nextRecord[3]!=null){
                        type_of_proof = nextRecord[3].trim();
                    }
                     typeOfProof = new Type_Of_Proof(i,type_of_proof);
                    if(!typeOfProofList.contains(typeOfProof)){
                        typeOfProofList.add(typeOfProof);
                    }

                    String sampleSize= "0";
                    int sample_size= 0;
                    if(nextRecord[4]!=null){
                        sampleSize =nextRecord[4].trim();
                    }
                    if(sampleSize!=null && !sampleSize.isEmpty()){
                        sample_size = Integer.parseInt(sampleSize);
                    }

                    String testType= "";
                    if(nextRecord[5]!=null){
                        testType =nextRecord[5].trim();
                    }
                     test_type =new Test_Type(i,testType);
                    if(!testTypeList.contains(test_type)){
                        testTypeList.add(test_type);
                    }

                    String testParam= "";
                    if(nextRecord[6]!=null){
                        testParam= nextRecord[6].trim();
                    }
                     test_param = new Test_Param(i,testParam);
                    test_param.setTestType(testType);
                    test_paramList.add(test_param);

                    String gtPassCondition= nextRecord[7].trim();
                    String eqPassCondition=  nextRecord[8].trim();
                    String lsPasscondition = nextRecord[9].trim();
                    String gtFailCondition = nextRecord[10].trim();
                    String eqFailCondition = nextRecord[11].trim();
                    String lsFailCondition = nextRecord[12].trim();
                    String gtReproofCondition= nextRecord[13].trim();
                    String eqReproofCondition= nextRecord[14].trim();
                    String lsReproofCondition= nextRecord[15].trim();
                    String gtDoubleReProofCondition= nextRecord[16].trim();
                    String eqDoubleReproofCondition= nextRecord[17].trim();
                    String lsDoubleReproofCondition= nextRecord[18].trim();
                    String gtInvestigation =nextRecord[20].trim();
                    String eqInvestigation =nextRecord[21].trim();
                    String lsInvestigation =nextRecord[22].trim();

                    if(gtPassCondition!=null && gtPassCondition.isEmpty()){
                        gtPassCondition= "-1";
                    }
                    if(eqPassCondition!=null && eqPassCondition.isEmpty()){
                        eqPassCondition= "-1";
                    }
                    if(lsPasscondition!=null && lsPasscondition.isEmpty()){
                        lsPasscondition= "-1";
                    }
                    if(gtFailCondition!=null && gtFailCondition.isEmpty()){
                        gtFailCondition= "-1";
                    }
                    if(eqFailCondition!=null && eqFailCondition.isEmpty()){
                        eqFailCondition= "-1";
                    }
                    if(lsFailCondition!=null && lsFailCondition.isEmpty()){
                        lsFailCondition= "-1";
                    }
                    if(gtReproofCondition!=null && gtReproofCondition.isEmpty()){
                        gtReproofCondition= "-1";
                    }
                    if(eqReproofCondition!=null && eqReproofCondition.isEmpty()){
                        eqReproofCondition= "-1";
                    }
                    if(lsReproofCondition!=null && lsReproofCondition.isEmpty()){
                        lsReproofCondition= "-1";
                    }
                    if(gtDoubleReProofCondition!=null && gtDoubleReProofCondition.isEmpty()){
                        gtDoubleReProofCondition= "-1";
                    }
                    if(eqDoubleReproofCondition!=null && eqDoubleReproofCondition.isEmpty()){
                        eqDoubleReproofCondition= "-1";
                    }
                    if(lsDoubleReproofCondition!=null && lsDoubleReproofCondition.isEmpty()){
                        lsDoubleReproofCondition= "-1";
                    }
                    if(gtInvestigation!=null && gtInvestigation.isEmpty()){
                        gtInvestigation= "-1";
                    }
                    if(eqInvestigation!=null && eqInvestigation.isEmpty()){
                        eqInvestigation= "-1";
                    }
                    if(lsInvestigation!=null && lsInvestigation.isEmpty()){
                        lsInvestigation= "-1";
                    }


                    String dataEntry = "0";
                    if(nextRecord[19]!=null){
                        dataEntry =nextRecord[19].trim();
                    }
                    boolean isDataEntry =false;
                    if(dataEntry!=null && dataEntry.equals("1")){
                        isDataEntry= true;
                    }

                    Sample sample = new Sample();
                    sample.setId(i);
                    sample.setDataEntry(isDataEntry);
                    sample.setSectionId(unit);
                    sample.setStoreId(storeName);
                    sample.setProofNoId(proof);
                    sample.setTypeOfProofId(type_of_proof);
                    sample.setSampleSize(sample_size);
                    sample.setTestparamId(testParam);
                    sample.setTypeOfTestId(testType);
                    float gtPass= Float.parseFloat(gtPassCondition);
                    float eqPass= Float.parseFloat(eqPassCondition);
                    float lsPass =Float.parseFloat(lsPasscondition);
                    float gtFail= Float.parseFloat(gtFailCondition);
                    float eqFail =Float.parseFloat(eqFailCondition);
                    float lsFail =Float.parseFloat(lsFailCondition);
                    float gtReproof =Float.parseFloat(gtReproofCondition);
                    float eqReproof =Float.parseFloat(eqReproofCondition);
                    float lsReproof =Float.parseFloat(lsReproofCondition);
                    float gtDoubleReproof= Float.parseFloat(gtDoubleReProofCondition);
                    float eqDoubleReproof= Float.parseFloat(eqDoubleReproofCondition);
                    float lsDoubleReproof= Float.parseFloat(lsDoubleReproofCondition);
                    float gtInvesti= Float.parseFloat(gtInvestigation);
                    float eqInvesti= Float.parseFloat(eqInvestigation);
                    float lsInvesti= Float.parseFloat(lsInvestigation);

                    sample.setGtPassCondition(gtPass);
                    sample.setEqPassCondition(eqPass);
                    sample.setLsPasscondition(lsPass);
                    sample.setGtFailCondition(gtFail);
                    sample.setEqFailCondition(eqFail);
                    sample.setLsFailCondition(lsFail);
                    sample.setGtReproofCondition(gtReproof);
                    sample.setEqReproofCondition(eqReproof);
                    sample.setLsReproofCondition(lsReproof);
                    sample.setGtDoubleReProofCondition(gtDoubleReproof);
                    sample.setEqDoubleReproofCondition(eqDoubleReproof);
                    sample.setLsDoubleReproofCondition(lsDoubleReproof);
                    sample.setGtInvestigation(gtInvesti);
                    sample.setEqInvestigation(eqInvesti);
                    sample.setLsInvestigation(lsInvesti);

                    sampleList.add(sample);

                i++;
            }
            masterDataUtil.setSectionListList(sectionList);
            masterDataUtil.setProofNumberList(proofNumberList);
            masterDataUtil.setType_of_proofList(typeOfProofList);
            masterDataUtil.setTestTypeList(testTypeList);
            masterDataUtil.setSampleList(sampleList);
            Map<String,List<Store>> storeLocationMap =storeList.stream().collect(Collectors.groupingBy(Store::getSectionName,Collectors.toList()));
            masterDataUtil.setStoreLocationMap(storeLocationMap);
            Map<String,List<Test_Param>> testParamMap= test_paramList.stream().collect(Collectors.groupingBy(Test_Param::getTestType,Collectors.toList()));
            masterDataUtil.setTestParamMap(testParamMap);

        } catch (Exception e) {
            System.out.println("Row= "+i);
            e.printStackTrace();
        }
     }

    }
