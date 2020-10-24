package com.example.navigationtest.model;

import com.opencsv.bean.CsvBindByName;

import java.io.Serializable;

public class CsvDataModel implements Serializable {

      @CsvBindByName(column = "UNIT", required = true)
      private String unit;

      @CsvBindByName(column = "STORE", required = true)
      private String store;

      @CsvBindByName(column = "PROOF_NO", required = true)
      private String proofNo;

      @CsvBindByName(column = "TYPE_OF_PROOF", required = true)
      private String tyOfProof;

      @CsvBindByName(column = "SAMPLE_SIZE", required = true)
      private String sampleSize;

      @CsvBindByName(column = "TYPE_OF_TEST", required = true)
      private String typeOfTest;

      @CsvBindByName(column = "TEST_PARAM", required = true)
      private String testParam;

      @CsvBindByName(column = "DATA_ENTRY", required = true)
      private String dataEntry;

    @CsvBindByName(column = "GT_PASS_CONDITION")
    private String gtPassCondition;

    @CsvBindByName(column = "EQ_PASS_CONDITION")
    private String eqPassCondition;

    @CsvBindByName(column = "LS_PASS_CONDITION")
    private String lsPassCondition;

    @CsvBindByName(column = "GT_FAIL_CONDITION")
    private String gtFailCondition;
    @CsvBindByName(column = "EQ_FAIL_CONDITION")
    private String eqFailCondition;
    @CsvBindByName(column = "LS_FAIL_CONDITION")
    private String lsFailCondition;


    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getProofNo() {
        return proofNo;
    }

    public void setProofNo(String proofNo) {
        this.proofNo = proofNo;
    }

    public String getTyOfProof() {
        return tyOfProof;
    }

    public void setTyOfProof(String tyOfProof) {
        this.tyOfProof = tyOfProof;
    }

    public String getSampleSize() {
        return sampleSize;
    }

    public void setSampleSize(String sampleSize) {
        this.sampleSize = sampleSize;
    }

    public String getTypeOfTest() {
        return typeOfTest;
    }

    public void setTypeOfTest(String typeOfTest) {
        this.typeOfTest = typeOfTest;
    }

    public String getTestParam() {
        return testParam;
    }

    public void setTestParam(String testParam) {
        this.testParam = testParam;
    }

    public String getDataEntry() {
        return dataEntry;
    }

    public void setDataEntry(String dataEntry) {
        this.dataEntry = dataEntry;
    }

    public String getGtPassCondition() {
        return gtPassCondition;
    }

    public void setGtPassCondition(String gtPassCondition) {
        this.gtPassCondition = gtPassCondition;
    }

    public String getEqPassCondition() {
        return eqPassCondition;
    }

    public void setEqPassCondition(String eqPassCondition) {
        this.eqPassCondition = eqPassCondition;
    }

    public String getLsPassCondition() {
        return lsPassCondition;
    }

    public void setLsPassCondition(String lsPassCondition) {
        this.lsPassCondition = lsPassCondition;
    }

    public String getGtFailCondition() {
        return gtFailCondition;
    }

    public void setGtFailCondition(String gtFailCondition) {
        this.gtFailCondition = gtFailCondition;
    }

    public String getEqFailCondition() {
        return eqFailCondition;
    }

    public void setEqFailCondition(String eqFailCondition) {
        this.eqFailCondition = eqFailCondition;
    }

    public String getLsFailCondition() {
        return lsFailCondition;
    }

    public void setLsFailCondition(String lsFailCondition) {
        this.lsFailCondition = lsFailCondition;
    }
}
