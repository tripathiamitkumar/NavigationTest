package com.example.navigationtest.util;

import com.example.navigationtest.model.Location;
import com.example.navigationtest.model.Section;
import com.example.navigationtest.model.Store;
import com.example.navigationtest.model.Test_Param;
import com.example.navigationtest.model.Test_Type;
import com.example.navigationtest.model.Type_Of_Proof;

import java.util.List;

public interface DataSetup {

        public List<Location> getAllLocation();
        public List<Section> getAllSection();
        public List<Store> getStoreFromSection(String section);
        public List<Test_Type> getTestTypeList();
        public List<Test_Param> getTestParamList(String test_type);
        public List<Type_Of_Proof> getTypeOfProofList();

}
