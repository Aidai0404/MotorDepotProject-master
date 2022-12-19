package com.peaksoft;

public class Driver {
    private int id;
     private String name;
     private String truck;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getTruck() {
        return truck;
    }

    public void setTruck(String truck) {
        this.truck = truck;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static Driver driver(int id,String name,String truck){
      Driver driver=new Driver();
        driver.id=id;
        driver.name=name;
        driver.truck=truck;
        return driver;
    }

    @Override
    public String toString() {
        return  +id+"| "+ name+" |"+truck;
    }
}
