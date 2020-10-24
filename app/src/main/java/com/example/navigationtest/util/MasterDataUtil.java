package com.example.navigationtest.util;

import com.example.navigationtest.model.Location;
import com.example.navigationtest.model.Proof_Number;
import com.example.navigationtest.model.Sample;
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

    private static MasterDataUtil masterDataUtil = null;
    private List<Location> locationList =new ArrayList<>();
    private List<Section> sectionListList =new ArrayList<>();
    private Map<String, List<Store>> storeLocationMap = new HashMap<>();
    private Map<String, List<Test_Param>> testParamMap = new HashMap<>();
    private List<Type_Of_Proof> type_of_proofList =new ArrayList<>();
    private List<Proof_Number> proofNumberList =new ArrayList<>();
    private Map<String, Boolean> dataentryFromTestParam = new HashMap<>();
    private List<Test_Type> testTypeList = new ArrayList<>();
    private List<Sample> sampleList = new ArrayList<>();

    public List<Test_Type> getTestTypeList() {
        return testTypeList;
    }

    public List<Sample> getSampleList() {
        return sampleList;
    }

    public void setSampleList(List<Sample> sampleList) {
        this.sampleList = sampleList;
    }

    public void setSectionListList(List<Section> sectionListList) {
        this.sectionListList = sectionListList;
    }

    public Map<String, List<Store>> getStoreLocationMap() {
        return storeLocationMap;
    }

    public void setStoreLocationMap(Map<String, List<Store>> storeLocationMap) {
        this.storeLocationMap = storeLocationMap;
    }

    public void setTestParamMap(Map<String, List<Test_Param>> testParamMap) {
        this.testParamMap = testParamMap;
    }

    public List<Type_Of_Proof> getType_of_proofList() {
        return type_of_proofList;
    }

    public void setType_of_proofList(List<Type_Of_Proof> type_of_proofList) {
        this.type_of_proofList = type_of_proofList;
    }

    public List<Proof_Number> getProofNumberList() {
        return proofNumberList;
    }

    public void setProofNumberList(List<Proof_Number> proofNumberList) {
        this.proofNumberList = proofNumberList;
    }

    public void setTestTypeList(List<Test_Type> testTypeList) {
        this.testTypeList = testTypeList;
    }

    private MasterDataUtil() {
    }

    public static MasterDataUtil getInstance() {

        synchronized (MasterDataUtil.class) {
            if (masterDataUtil == null) {
                masterDataUtil = new MasterDataUtil();
            }
        }
        return masterDataUtil;
    }




    public List<Location> getLocationList() {
        locationList = new ArrayList<Location>();
        locationList.add(new Location(0, "Select"));
        locationList.add(new Location(1, "UNIT-03"));
        locationList.add(new Location(2, "UNIT-04"));
        locationList.add(new Location(3, "UNIT-15"));
        locationList.add(new Location(4, "DONGABAHAL"));
        locationList.add(new Location(5, "From GPS"));
        return locationList;
    }

    public List<Section> getSectionList() {
        return sectionListList;
    }
    public List<Store> getStoreFromSection(String section) {
        return storeLocationMap.get(section);
    }

    public List<Proof_Number> getProof_numbers() {
        return proofNumberList;
    }

    public List<Test_Param> getTestParamFromTestType(String test_type) {
        return testParamMap.get(test_type);
    }

    public boolean getDataSampleFromTestParam(String test_param) {
        return dataentryFromTestParam.get(test_param);
    }

    public Sample getSample(String test_param , String test_type, String type_of_proof,String store) {

        for(Sample sample: getSampleList()){

             if(sample.getTestparamId().equals(test_param) && test_type.equals(sample.getTypeOfTestId())
                     && sample.getTypeOfProofId().equals(type_of_proof)
                     && sample.getStoreId().equals(store)
                     ){
                    return sample;
             }

        }

        return null;
    }
}
