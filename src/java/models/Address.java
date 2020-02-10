/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author 703174
 */
public class Address {
    private int buildingNum;
    private int houseNum;
    private String streetName;
    private String city;
    private String province;
    private String postal;

    public Address() {
    }

    public Address(int buildingNum, int houseNum, String streetName, String city, String province, String postal) {
        this.buildingNum = buildingNum;
        this.houseNum = houseNum;
        this.streetName = streetName;
        this.city = city;
        this.province = province;
        this.postal = postal;
    }

    public int getBuildingNum() {
        return buildingNum;
    }

    public void setBuildingNum(int buildingNum) {
        this.buildingNum = buildingNum;
    }

    public int getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(int houseNum) {
        this.houseNum = houseNum;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    
}
