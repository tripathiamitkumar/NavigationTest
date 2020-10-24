package com.example.navigationtest.model;

import java.util.Objects;

public class Test_Type {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Test_Type(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test_Type test_type = (Test_Type) o;
        return Objects.equals(name, test_type.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
