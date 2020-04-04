package models;

import java.sql.Date;

/**
 * This class contains information and operations to create a vaccines object.
 *
 * @author Hans Cabrera
 */
public class Vaccines {

    private Date da2pp;
    private Date rabies;
    private Date bordetella;

    /**
     * Default constructor.
     */
    public Vaccines() {

    }

    /**
     * Constructor to set all the attributes.
     *
     * @param da2pp DA2PP expiration date.
     * @param rabies Rabies vaccine expiration date.
     * @param bordetella Bordetella vaccine expiration date.
     */
    public Vaccines(Date da2pp, Date rabies, Date bordetella) {
        this.da2pp = da2pp;
        this.rabies = rabies;
        this.bordetella = bordetella;
    }

    /**
     * Gets the DA2PP expiration date.
     *
     * @return The DA2PP expiration date.
     */
    public Date getDa2pp() {
        return da2pp;
    }

    /**
     * Sets the DA2PP expiration date.
     *
     * @param da2pp The DA2PP expiration date.
     */
    public void setDa2pp(Date da2pp) {
        this.da2pp = da2pp;
    }

    /**
     * Gets the Rabies vaccine expiration date.
     *
     * @return The Rabies vaccine expiration date.
     */
    public Date getRabies() {
        return rabies;
    }

    /**
     * Sets the Rabies vaccine expiration date.
     *
     * @param rabies The Rabies vaccine expiration date.
     */
    public void setRabies(Date rabies) {
        this.rabies = rabies;
    }

    /**
     * Gets the Bordetella vaccine expiration date.
     *
     * @return The Bordetella vaccine expiration date.
     */
    public Date getBordetella() {
        return bordetella;
    }

    /**
     * Sets the Bordetella vaccine expirationdate.
     *
     * @param bordetella The Bordetella vaccine expiration date.
     */
    public void setBordetella(Date bordetella) {
        this.bordetella = bordetella;
    }

}
