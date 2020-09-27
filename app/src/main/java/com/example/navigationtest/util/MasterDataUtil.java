package com.example.navigationtest.util;

import com.example.navigationtest.model.Location;
import com.example.navigationtest.model.Proof_Number;
import com.example.navigationtest.model.Section;
import com.example.navigationtest.model.Store;
import com.example.navigationtest.model.Test_Param;
import com.example.navigationtest.model.Test_Type;
import com.example.navigationtest.model.Type_Of_Proof;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MasterDataUtil {

       private static MasterDataUtil masterDataUtil =null;
       private List<Location> locationList;
       private List<Section> sectionListList;
       private Map<String,List<Store>> storeLocationMap =new HashMap<>() ;
       private Map<String,List<Test_Param>> testParamMap= new HashMap<>();
       private List<Type_Of_Proof> type_of_proofList;
       private List<Proof_Number> proofNumberList;
       private Map<String,Boolean> dataentryFromTestParam = new HashMap<>();
       private List<Test_Type> testTypeList= new ArrayList<>();
       private MasterDataUtil(){
       }

       public static MasterDataUtil getInstance() {

           synchronized (MasterDataUtil.class) {
               if (masterDataUtil == null) {
                   masterDataUtil = new MasterDataUtil();
               }
           }
           return masterDataUtil;
       }

    private  List<Store> getStorePerSection(String location){
             List<Store> list=new ArrayList<>();
             if(location.equals("UNIT-01")){
                 list.add(new Store(0,"Select"));
                 list.add(new Store(1,"Primer Electric 1A/L (Filled)"));
                 list.add(new Store(2,"Primer Electric 1A/L (Filled)(HEAVY PROOF)"));
                 list.add(new Store(3,"Primer Electric 1A/L (Empty)"));
                 list.add(new Store(4,"Primer Electric 1A/L (Empty)(HEAVY PROOF)"));
                 list.add(new Store(5,"Combination Case Ignition Primer GUV-7 (filled)"));
                 list.add(new Store(6,"Combination Case Ignition Primer GUV-7 (filled) Pilot Lot"));
                 list.add(new Store(7,"Combination Case Ignition Primer GUV-7 (Empty)"));
                 list.add(new Store(8,"Combination Case Ignition Primer GUV-7 (Empty) Pilot Lot"));
                 list.add(new Store(9,"PRIMER PERCUSSION Q.F.CARTRIDGE 18A (FILLED)"));
                 list.add(new Store(10,"Primer Sleeve KB-30 (Filled)"));
                 list.add(new Store(11,"Cartg. Bomb 51mm (FTT) Filled"));
                 list.add(new Store(12,"Cartg. Bomb 51mm (FTT) Filled First Lot"));
             }
            if(location.equals("UNIT-03")){
                int i=0;
                list.add(new Store(i,"Select"));
                list.add(new Store(++i,"Igniting Primer NO:.1 MG 8"));
                list.add(new Store(++i,"Cap 78mg QFGG"));
                list.add(new Store(++i,"Cap Complete for Primary Cartg. for Mortar Bomb 51mm (3G CAP)"));
                list.add(new Store(++i,"Cap Conducting Composition"));
                list.add(new Store(++i,"Primer Detonator A-30-T"));
                list.add(new Store(++i,"Charged Electric Fuze"));
                list.add(new Store(++i,"Igniting Primer KB-3B"));
                list.add(new Store(++i,"Igniting Primer NO: .1 Sleeve"));
                list.add(new Store(++i,"Detonator 135mg LZY"));
                list.add(new Store(++i,"Detonator 356mg LZ"));
            }
            if(location.equals("UNIT-04")){
                int i=0;
                list.add(new Store(i,"Select"));
                list.add(new Store(++i,"Fuze Mine Anti-Tank 2B ND (Filled)"));
                list.add(new Store(++i,"Fuze Mine Anti-Tank 2B ND (Filled)(FIRST LOT)"));
                list.add(new Store(++i,"Fuze Mine Anti-Tank 2B ND (Empty)"));
                list.add(new Store(++i,"Fuze Mine Anti-Tank 2B ND (Empty)(FIRST LOT)"));
                list.add(new Store(++i,"Fuze Mine Anti-Tank 4A ND (Filled)"));
                list.add(new Store(++i,"Fuze Mine Anti-Tank 4A ND (Filled)(FIRST LOT)"));
                list.add(new Store(++i,"Fuze Mine Anti-Tank 4A ND (Empty)"));
                list.add(new Store(++i,"Fuze Mine Anti-Tank 4A ND (Empty)(FIRST LOT)"));
                list.add(new Store(++i,"Fuze Percussion DA No .117 MK-20(Filled)"));
                list.add(new Store(++i,"Fuze Percussion DA No 117 MK-20(Filled) First Lot/ Pilot Lot"));
                list.add(new Store(++i,"Fuze Percussion DA No 117 MK-20(Empty)"));
                list.add(new Store(++i,"Fuze Percussion DA No.117 MK-20(Empty)(Advance samples)"));
                list.add(new Store(++i,"Fuze Percussion DA No.117 MK-20(Empty) (First Lot)"));
                list.add(new Store(++i,"Fuze Percussion DA5A (Filled)"));
                list.add(new Store(++i,"Fuze Percussion DA5A (Filled)(First Lot)"));
                list.add(new Store(++i,"Fuze Percussion DA5A (Empty Filled)"));
                list.add(new Store(++i,"Fuze Percussion DA5A(Empty Filled)(First Lot)"));
                list.add(new Store(++i,"Fuze Percussion DA5A(Empty Filled)(Advance samples)"));
                list.add(new Store(++i,"Fuze A670M (Filled) sample size is 39 Nos"));
                list.add(new Store(++i,"Fuze A670M (Filled)Every 3rd Lot Sample size is 89 Nos"));
                list.add(new Store(++i,"Mortar Bomb 51mm HE2A (Filled)"));
                list.add(new Store(++i,"Mortar Bomb 51mm HE2A (Filled) Every 15th Lot"));

            }
            if(location.equals("UNIT-06")){
                int i=0;
                list.add(new Store(i,"Select"));
                list.add(new Store(++i,"Propellant Matching Proof of Primer KB-30"));
            }
            if(location.equals("UNIT-10")){
                int i=0;
                list.add(new Store(i,"Select"));
                list.add(new Store(++i,"Mine AT 4D ND (Filled)"));
            }
            return list;
    }

        public List<Location> getLocationList(){
            locationList =new ArrayList<Location>();
            locationList.add(new Location(0,"Select"));
            locationList.add(new Location(1,"UNIT-03"));
            locationList.add(new Location(2,"UNIT-04"));
            locationList.add(new Location(3,"UNIT-15"));
            locationList.add(new Location(4,"DONGABAHAL"));
            locationList.add(new Location(5,"From GPS"));
            return locationList;
       }
       public List<Section> getSectionList() {
           sectionListList = new ArrayList<>();
           sectionListList.add(new Section(0, "SELECT"));
           sectionListList.add(new Section(1, "UNIT-01"));
           sectionListList.add(new Section(2, "UNIT-03"));
           sectionListList.add(new Section(3, "UNIT-04"));
           sectionListList.add(new Section(4, "UNIT-06"));
           sectionListList.add(new Section(5, "UNIT-10"));
           setUp();
           return sectionListList;
       }
       private void setUp(){
           for(Section section: sectionListList){
               storeLocationMap.put(section.getName(), getStorePerSection(section.getName()));
           }
       }

       public List<Store> getStoreFromSection(String section){
                 return storeLocationMap.get(section);
       }
       public List<Type_Of_Proof> getType_of_proofs(){
           type_of_proofList= new ArrayList<>();
           type_of_proofList.add(new Type_Of_Proof(0,"Select"));
           type_of_proofList.add(new Type_Of_Proof(1,"STATIC"));
           type_of_proofList.add(new Type_Of_Proof(2,"STATIC/P"));
           type_of_proofList.add(new Type_Of_Proof(3,"STATIC/RP"));
           type_of_proofList.add(new Type_Of_Proof(4,"DYNAMIC"));
           return  type_of_proofList;

       }
       public List<Proof_Number> getProof_numbers(){
           proofNumberList =new ArrayList<>();
           proofNumberList.add(new Proof_Number(0,"Select"));
           proofNumberList.add(new Proof_Number(1,"First Proof"));
           proofNumberList.add(new Proof_Number(2,"Reproof"));
           proofNumberList.add(new Proof_Number(3,"Double Reproof"));
           return proofNumberList;
       }

       public List<Test_Type> getTestTypeList(){
           int i=0;
           testTypeList.add(new Test_Type(i,"Select"));
           testTypeList.add(new Test_Type(++i,"Checking of resistance against jolting"));
           testTypeList.add(new Test_Type(++i,"Sensitivity to piercing at upper limit (5cm) after jolting test"));
           testTypeList.add(new Test_Type(++i,"Sensitivity to piercing at lower limit(0.5cm)"));
           testTypeList.add(new Test_Type(++i,"Sensitivity to piercing at upper limit(5cm) after holding in the desiccators"));
           testTypeList.add(new Test_Type(++i,"Functioning Proof Test"));
           testTypeList.add(new Test_Type(++i,"Drop test(from every 10th lot)"));
           testTypeList.add(new Test_Type(++i,"Drop Test"));
           testTypeList.add(new Test_Type(++i,"Sensitivity test"));
           testTypeList.add(new Test_Type(++i,"Firing test"));
           testTypeList.add(new Test_Type(++i,"Delay Proof"));
           testTypeList.add(new Test_Type(++i,"Rough Usage (Drop test)"));
           testTypeList.add(new Test_Type(++i,"Impact test"));
           testTypeList.add(new Test_Type(++i,"Jolt test"));
           testTypeList.add(new Test_Type(++i,"Initiation test (after impact test)"));
           testTypeList.add(new Test_Type(++i,"Initiation test (after jolt test)"));
           testTypeList.add(new Test_Type(++i,"Initiation test (after impact/Jolt test where ever single defect observed)"));
           testTypeList.add(new Test_Type(++i,"Initiation test (after impact/Jolt test whereever double defect observed)"));
           testTypeList.add(new Test_Type(++i,"Resistance Test"));
           testTypeList.add(new Test_Type(++i,"Functioning delay test"));
           testTypeList.add(new Test_Type(++i,"Sensitivity to piercing from upper limit (after jolt test)"));
           testTypeList.add(new Test_Type(++i,"Sensitivity to piercing from lower limit"));
           testTypeList.add(new Test_Type(++i,"Sensitivity to piercing from upper limit (after impact test)"));
           testTypeList.add(new Test_Type(++i,"Sensitivity to piercing with Duralumin pin"));
           testTypeList.add(new Test_Type(++i,"Sensitivity to impact at upper limit"));
           testTypeList.add(new Test_Type(++i,"Sensitivity to impact at lower limit"));
           testTypeList.add(new Test_Type(++i,"Sensitivity to impact at upper limit in 100% humid condition"));
           testTypeList.add(new Test_Type(++i,"Pressure bar test"));
           testTypeList.add(new Test_Type(++i,"Flash Delivery test"));
           testTypeList.add(new Test_Type(++i,"Resistance test (Electrical test)"));
           testTypeList.add(new Test_Type(++i,"Flash test"));
           testTypeList.add(new Test_Type(++i,"Time to function"));
           testTypeList.add(new Test_Type(++i,"Rough Usage test (Jolt test and Drop Test followed by Resistance test)"));
           testTypeList.add(new Test_Type(++i,"Rough Usage test (Vibration test followed by Resistance test)"));
           testTypeList.add(new Test_Type(++i,"Functioning Delay test after Jolt Test"));
           testTypeList.add(new Test_Type(++i,"Environmental Conditioning test (5 Samples after jolt test)"));
           testTypeList.add(new Test_Type(++i,"Water immersion test followed by Flash Test (5 samples after Environment conditioning test and 3 samples after jolt test)"));
           testTypeList.add(new Test_Type(++i,"Environmental Conditioning test (13 Samples after jolt test)"));
           testTypeList.add(new Test_Type(++i,"Water immersion test followed by Flash Test (13 samples after Environment conditioning test and 13 samples after jolt test)"));
           testTypeList.add(new Test_Type(++i,"Functioning Proof by Percussion Method"));
           testTypeList.add(new Test_Type(++i,"Delay test (by elecrical method)"));
           testTypeList.add(new Test_Type(++i,"Functioning Test"));
           testTypeList.add(new Test_Type(++i,"Checking  of maximum Pressure at normal temperature (25±10)°C"));
           testTypeList.add(new Test_Type(++i,"Checking of time interval from the moment of impact on striker to the start of rising of Pressure curve:T1 (at  normal temperature (25±1++i)°C)"));
           testTypeList.add(new Test_Type(++i,"Checking of Time interval from start of rising of the Pressure curve to the moment of attending the maximum:T2 (at normal temperature (25±10)°C)"));
           testTypeList.add(new Test_Type(++i,"Checking  of maximum Pressure at temperature +60°C"));
           testTypeList.add(new Test_Type(++i,"Checking of time interval from the moment of impact on striker to the start of rising of Pressure curve:T1 (at temperature (+60±3)°C)"));
           testTypeList.add(new Test_Type(++i,"Checking of Time interval from start of rising  of the Pressure curve to the moment of attending the maximum:T2 (at temperature (+60±3)°C)"));
           testTypeList.add(new Test_Type(++i,"Checking  of maximum Pressure at temperature (-60±3)°C"));
           testTypeList.add(new Test_Type(++i,"Checking of time interval from the moment of impact on striker to the start of rising of Pressure curve:T1 (at temperature (-60±3)°C)"));
           testTypeList.add(new Test_Type(++i,"Checking of Time interval from start of rising  of the Pressure curve to the moment of attending the maximum:T2 (at temperature (-60±3)°C)"));
           testTypeList.add(new Test_Type(++i,"Complete detonation of the Fuze Anti removal"));
           testTypeList.add(new Test_Type(++i,"Non functioning test"));
           testTypeList.add(new Test_Type(++i,"Functioning of Fuze"));
           testTypeList.add(new Test_Type(++i,"Static Detonation Proof"));
           testTypeList.add(new Test_Type(++i,"Sealing Proof"));
           testTypeList.add(new Test_Type(++i,"Dynamic Proof"));
           testTypeList.add(new Test_Type(++i,"Functioning and Velocity proof test"));
           testTypeList.add(new Test_Type(++i,"Functioning proof with Ch-I and Ch-II Sample Size 60"));
           testTypeList.add(new Test_Type(++i,"Velocity  Proof with Ch-I Sample Size 30"));
           testTypeList.add(new Test_Type(++i,"Velocity  Proof with Ch-II Sample Size 30"));
           testTypeList.add(new Test_Type(++i,"Wild Round while firing with Ch-I Sample Size 30"));
           testTypeList.add(new Test_Type(++i,"Wild Round while firing with Ch-II Sample Size 30"));
           testTypeList.add(new Test_Type(++i,"After wild round elimination (with Ch-I)"));
           testTypeList.add(new Test_Type(++i,"After wild round elimination (with Ch-II)"));
           testTypeList.add(new Test_Type(++i,"Self Destruction test at Ambient Temp"));
           testTypeList.add(new Test_Type(++i,"Self Destruction test at +50°C±3°C"));
           testTypeList.add(new Test_Type(++i,"Self Destruction test at -50°C±3°C"));
           testTypeList.add(new Test_Type(++i,"Hammer Masset Test at 10th tooth"));
           testTypeList.add(new Test_Type(++i,"Hammer Masset Test at 15th tooth"));
           testTypeList.add(new Test_Type(++i,"Hammer Masset Test at 23rd tooth"));
           testTypeList.add(new Test_Type(++i,"Water immersion test"));
           testTypeList.add(new Test_Type(++i,"Complete detonation of Filled Mine AT 4D ND"));
           testTypeList.add(new Test_Type(++i,"Complete Detonation and Range Proof"));
           testTypeList.add(new Test_Type(++i,"Complete Detonation Proof"));
           testTypeList.add(new Test_Type(++i,"Complete Detonation and Range Proof Conditioned at-30°C for 8 Hours"));
           testTypeList.add(new Test_Type(++i,"Complete Detonation and Range Proof Conditioned at +50 °C for 8 Hours"));
           setUpTestParam();
           return testTypeList;
       }


       private void setUpTestParam(){

            for(Test_Type test_type :testTypeList){
                testParamMap.put(test_type.getName(), getTestparamofTestType(test_type.getName()));
            }
       }

       private List<Test_Param> getTestparamofTestType(String testType){
           List<Test_Param> test_params =new ArrayList<>();
           int i=0;
           if(testType.equals("Checking of resistance against jolting")){
               test_params.add(new Test_Param(++i,"Sustaining of samples"));
           }
           if(testType.equals("Sensitivity to piercing at upper limit (5cm) after jolting test")){
               test_params.add(new Test_Param(++i,"Functioning of Detonator"));
           }
           if(testType.equals("Sensitivity to piercing at lower limit(0.5cm)")){
               test_params.add(new Test_Param(++i,"No Ignition at lower limit"));
           }
           if(testType.equals("Sensitivity to piercing at upper limit(5cm) after holding in the desiccators")){
               test_params.add(new Test_Param(++i,"Burning of igniting primers"));
           }
           if(testType.equals("Sensitivity to piercing at upper limit (5cm) after jolting test")){
               test_params.add(new Test_Param(++i,"Functioning of Detonator"));
           }
           if(testType.equals("Sensitivity to piercing at upper limit (5cm) after jolting test")){
               test_params.add(new Test_Param(++i,"Functioning of Detonator"));
           }
           for(Test_Param param: test_params){
               setupDataSampleOftestParam(param.getName());
           }
           return test_params;
       }

       private void setupDataSampleOftestParam(String testParam){
            if(testParam.equals("Sustaining of samples")) {
                dataentryFromTestParam.put(testParam, false);
            }
            else if(testParam.equals("Functioning of Detonator")) {
                dataentryFromTestParam.put(testParam, false);
            }
            else if(testParam.equals("No Ignition at lower limit")) {
                dataentryFromTestParam.put(testParam, false);
            }
            else if(testParam.equals("Burning of igniting primers")) {
                dataentryFromTestParam.put(testParam, false);
            }
            else if(testParam.equals("Burning of igniting primers")) {
                dataentryFromTestParam.put(testParam, false);
            }
            else if(testParam.equals("Burning of igniting primers")) {
                dataentryFromTestParam.put(testParam, false);
            }
            else if(testParam.equals("Functioning of Cap")) {
                dataentryFromTestParam.put(testParam, false);
            }
            else if(testParam.equals("Functioning (Firing) of Cap")) {
                dataentryFromTestParam.put(testParam, false);
            }
            else if(testParam.equals("Delay time (in µ Sec)")) {
                dataentryFromTestParam.put(testParam, false);
            }
            else if(testParam.equals("Mean (in µ Sec)")) {
                dataentryFromTestParam.put(testParam, false);
            }

       }

       public List<Test_Param> getTestParamFromTestType(String test_type) {
           return testParamMap.get(test_type);
       }

       public boolean getDataSampleFromTestParam(String test_param) {
           return dataentryFromTestParam.get(test_param);
       }
}
