package com.example.navigationtest.util;

import com.example.navigationtest.model.Location;
import com.example.navigationtest.model.Section;
import com.example.navigationtest.model.Store;
import com.example.navigationtest.model.Test_Param;
import com.example.navigationtest.model.Test_Type;
import com.example.navigationtest.model.Type_Of_Proof;

import java.util.List;

public class DataMapping implements DataSetup {

    private MasterDataUtil masterDataUtil;

    public DataMapping(MasterDataUtil masterDataUtil){
        this.masterDataUtil =masterDataUtil;
    }
    @Override
    public List<Location> getAllLocation() {
        return masterDataUtil.getLocationList();
    }

    @Override
    public List<Section> getAllSection() {
        return masterDataUtil.getSectionList();
    }

    @Override
    public List<Store> getStoreFromSection(String section) {
        return masterDataUtil.getStoreFromSection(section);
    }

    @Override
    public List<Test_Type> getTestTypeList() {
        return masterDataUtil.getTestTypeList();
    }

    @Override
    public List<Test_Param> getTestParamList(String test_type) {
        return masterDataUtil.getTestParamFromTestType(test_type);
    }

    @Override
    public List<Type_Of_Proof> getTypeOfProofList() {
        return masterDataUtil.getType_of_proofs();
    }
}
