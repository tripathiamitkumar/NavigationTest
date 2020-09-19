package com.example.navigationtest.util;

import com.example.navigationtest.model.Location;
import com.example.navigationtest.model.Section;
import com.example.navigationtest.model.Store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MasterDataUtil {

       private MasterDataUtil masterDataUtil =null;
       private List<Location> locationList;
       private List<Section> sectionListList;
       private Map<String,List<Store>> storeLocationMap =new HashMap<>() ;
       private MasterDataUtil(){
       }

       public MasterDataUtil getInstance() {

           synchronized (MasterDataUtil.class) {
               if (masterDataUtil == null) {
                   masterDataUtil = new MasterDataUtil();
               }
           }
           return masterDataUtil;
       }

    private  void setUpMap() {
             for(Location location : getLocationList()){
                  storeLocationMap.put(location.getName(), getStorePerLocation(location.getName()));
             }
    }

    private  List<Store> getStorePerLocation(String location){
             List<Store> list=new ArrayList<>();
             if(location.equals("U-03")){
                 list.add(new Store(1,"Igniting Primer NO : .1 MG 8"));
                 list.add(new Store(2,"Igniting Primer NO : .1 MG 8"));
                 list.add(new Store(3,"Igniting Primer NO : .1 MG 8"));
             }
            if(location.equals("U-01")){
                list.add(new Store(4,"Igniting Primer NO : .1 MG 8"));
                list.add(new Store(5,"Igniting Primer NO : .1 MG 8"));
                list.add(new Store(6,"Igniting Primer NO : .1 MG 8"));
            }
            if(location.equals("U-02")){
                list.add(new Store(7,"Igniting Primer NO : .1 MG 8"));
                list.add(new Store(8,"Igniting Primer NO : .1 MG 8"));
                list.add(new Store(9,"Igniting Primer NO : .1 MG 8"));
            }
            return list;
    }

        public List<Location> getLocationList(){
            locationList =new ArrayList<Location>();
            locationList.add(new Location(1,"U-02"));
            locationList.add(new Location(2,"U-03"));
            locationList.add(new Location(3,"U-04"));
            return locationList;
       }
       public List<Section> getSectionList(){
           sectionListList = new ArrayList<>();
           sectionListList.add(new Section(1, "Sec-1"));
           sectionListList.add(new Section(2, "Sec-1"));
           sectionListList.add(new Section(3, "Sec-1"));
           sectionListList.add(new Section(4, "Sec-1"));
           sectionListList.add(new Section(5, "Sec-1"));
           return sectionListList;
       }

       public List<Store> getStoreFromLcation(String location){
                 return storeLocationMap.get(location);
       }

}
