/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author 703174
 */
public class Address {

    private String buildingNum;
    private String houseNum;
    private String streetName;
    private String city;
    private String province;
    private String postal;

    public Address() {
    }

    public Address(String buildingNum, String houseNum, String streetName, String city, String province, String postal) {
        this.buildingNum = buildingNum;
        this.houseNum = houseNum;
        this.streetName = streetName;
        this.city = city;
        this.province = province;
        this.postal = postal;
    }

    public String getBuildingNum() {
        return buildingNum;
    }

    public void setBuildingNum(String buildingNum) {
        this.buildingNum = buildingNum;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
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

    public JsonObject toJSON() {
        JsonObject jo = Json.createObjectBuilder()
                .add("appt", houseNum)
                .add("building", buildingNum)
                .add("street", streetName)
                .add("city", city)
                .add("province", province)
                .add("post", postal)
                .build();
        return jo;
    }

}
