package com.example.navigationtest.util;

import com.example.navigationtest.model.Location;
import com.example.navigationtest.model.Section;
import com.example.navigationtest.model.Store;
import com.example.navigationtest.model.Test_Param;
import com.example.navigationtest.model.Test_Type;

import java.util.List;

public class DateMapping implements DataSetup {
    @Override
    public List<Location> getAllLocation() {
        return null;
    }

    @Override
    public List<Section> getAllSection() {
        return null;
    }

    @Override
    public List<Store> getStoreFromLocation(String location) {
        return null;
    }

    @Override
    public List<Test_Type> getTestTypeList() {
        return null;
    }

    @Override
    public List<Test_Param> getTestParamList(String test_type) {
        return null;
    }
}
