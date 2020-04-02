package models;

/**
 * This class contains information an operations to create a user's address.
 *
 * @author Hans Cabrera
 */
public class Address {

    private String buildingNum;
    private String houseNum;
    private String streetName;
    private String city;
    private String province;
    private String postal;

    /**
     * Default constructor.
     */
    public Address() {
    }

    /**
     * Constructor that instantiates all attributes.
     *
     * @param buildingNum The building number.
     * @param houseNum The house number.
     * @param streetName The street name.
     * @param city The city name.
     * @param province The province.
     * @param postal The postal code.
     */
    public Address(String buildingNum, String houseNum, String streetName, String city, String province, String postal) {
        this.buildingNum = buildingNum;
        this.houseNum = houseNum;
        this.streetName = streetName;
        this.city = city;
        this.province = province;
        this.postal = postal;
    }

    /**
     * Gets the building number.
     *
     * @return The building number.
     */
    public String getBuildingNum() {
        return buildingNum;
    }

    /**
     * Sets the building number.
     *
     * @param buildingNum The building number.
     */
    public void setBuildingNum(String buildingNum) {
        this.buildingNum = buildingNum;
    }

    /**
     * Gets the house number.
     *
     * @return The house number.
     */
    public String getHouseNum() {
        return houseNum;
    }

    /**
     * Sets the house number.
     *
     * @param houseNum The house number.
     */
    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    /**
     * Gets the street name.
     *
     * @return The street name.
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Sets the street name.
     *
     * @param streetName The street name.
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * Gets the city.
     *
     * @return The city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city.
     *
     * @param city The city.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the province.
     *
     * @return The province.
     */
    public String getProvince() {
        return province;
    }

    /**
     * Sets the province.
     *
     * @param province The province.
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * Gets the postal code.
     *
     * @return The postal code.
     */
    public String getPostal() {
        return postal;
    }

    /**
     * Sets the postal code.
     *
     * @param postal The postal code.
     */
    public void setPostal(String postal) {
        this.postal = postal;
    }
}
