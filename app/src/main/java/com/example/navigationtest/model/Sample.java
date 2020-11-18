package com.example.navigationtest.model;

import java.io.Serializable;

public class Sample implements Serializable {

       private int id;
       private int sampleSize;
       private String sectionId;
       private String date;
       private String item_cd;
       private String result;
       private String observation;
       private String storeId;
       private String proofNoId;
       private String typeOfProofId;
       private String typeOfTestId;
       private String testparamId;
       private boolean isDataEntry;
       private float gtPassCondition;
       private float eqPassCondition;
       private float lsPasscondition;
       private float gtFailCondition;
       private float eqFailCondition;
       private float lsFailCondition;
       private float gtReproofCondition;
       private float eqReproofCondition;
       private float lsReproofCondition;
       private float gtDoubleReProofCondition;
       private float eqDoubleReproofCondition;
       private float lsDoubleReproofCondition;
       private float gtInvestigation;
       private float eqInvestigation;
       private float lsInvestigation;
       private String flag= "0";

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSampleSize() {
        return sampleSize;
    }

    public void setSampleSize(int sampleSize) {
        this.sampleSize = sampleSize;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getProofNoId() {
        return proofNoId;
    }

    public void setProofNoId(String proofNoId) {
        this.proofNoId = proofNoId;
    }

    public String getTypeOfProofId() {
        return typeOfProofId;
    }

    public void setTypeOfProofId(String typeOfProofId) {
        this.typeOfProofId = typeOfProofId;
    }

    public String getTypeOfTestId() {
        return typeOfTestId;
    }

    public void setTypeOfTestId(String typeOfTestId) {
        this.typeOfTestId = typeOfTestId;
    }

    public String getTestparamId() {
        return testparamId;
    }

    public void setTestparamId(String testparamId) {
        this.testparamId = testparamId;
    }

    public boolean isDataEntry() {
        return isDataEntry;
    }

    public void setDataEntry(boolean dataEntry) {
        isDataEntry = dataEntry;
    }

    public float getGtPassCondition() {
        return gtPassCondition;
    }

    public void setGtPassCondition(float gtPassCondition) {
        this.gtPassCondition = gtPassCondition;
    }

    public float getEqPassCondition() {
        return eqPassCondition;
    }

    public void setEqPassCondition(float eqPassCondition) {
        this.eqPassCondition = eqPassCondition;
    }

    public float getLsPasscondition() {
        return lsPasscondition;
    }

    public void setLsPasscondition(float lsPasscondition) {
        this.lsPasscondition = lsPasscondition;
    }

    public float getGtFailCondition() {
        return gtFailCondition;
    }

    public void setGtFailCondition(float gtFailCondition) {
        this.gtFailCondition = gtFailCondition;
    }

    public float getEqFailCondition() {
        return eqFailCondition;
    }

    public void setEqFailCondition(float eqFailCondition) {
        this.eqFailCondition = eqFailCondition;
    }

    public float getLsFailCondition() {
        return lsFailCondition;
    }

    public void setLsFailCondition(float lsFailCondition) {
        this.lsFailCondition = lsFailCondition;
    }

    public float getGtReproofCondition() {
        return gtReproofCondition;
    }

    public void setGtReproofCondition(float gtReproofCondition) {
        this.gtReproofCondition = gtReproofCondition;
    }

    public float getEqReproofCondition() {
        return eqReproofCondition;
    }

    public void setEqReproofCondition(float eqReproofCondition) {
        this.eqReproofCondition = eqReproofCondition;
    }

    public float getLsReproofCondition() {
        return lsReproofCondition;
    }

    public void setLsReproofCondition(float lsReproofCondition) {
        this.lsReproofCondition = lsReproofCondition;
    }

    public float getGtDoubleReProofCondition() {
        return gtDoubleReProofCondition;
    }

    public void setGtDoubleReProofCondition(float gtDoubleReProofCondition) {
        this.gtDoubleReProofCondition = gtDoubleReProofCondition;
    }

    public float getEqDoubleReproofCondition() {
        return eqDoubleReproofCondition;
    }

    public void setEqDoubleReproofCondition(float eqDoubleReproofCondition) {
        this.eqDoubleReproofCondition = eqDoubleReproofCondition;
    }

    public float getLsDoubleReproofCondition() {
        return lsDoubleReproofCondition;
    }

    public void setLsDoubleReproofCondition(float lsDoubleReproofCondition) {
        this.lsDoubleReproofCondition = lsDoubleReproofCondition;
    }

    public float getGtInvestigation() {
        return gtInvestigation;
    }

    public void setGtInvestigation(float gtInvestigation) {
        this.gtInvestigation = gtInvestigation;
    }

    public float getEqInvestigation() {
        return eqInvestigation;
    }

    public void setEqInvestigation(float eqInvestigation) {
        this.eqInvestigation = eqInvestigation;
    }

    public float getLsInvestigation() {
        return lsInvestigation;
    }

    public void setLsInvestigation(float lsInvestigation) {
        this.lsInvestigation = lsInvestigation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getItem_cd() {
        return item_cd;
    }

    public void setItem_cd(String item_cd) {
        this.item_cd = item_cd;
    }
}
