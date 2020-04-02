package models;

import java.sql.Date;

/**
 *
 * @author Hans Cabrera
 */
public class Vaccines {

    private Date da2pp;
    private Date rabies;
    private Date bordetella;

    public Vaccines() {
    }

    public Vaccines(Date da2pp, Date rabies, Date bordetella) {
        this.da2pp = da2pp;
        this.rabies = rabies;
        this.bordetella = bordetella;
    }

    public Date getDa2pp() {
        return da2pp;
    }

    public void setDa2pp(Date da2pp) {
        this.da2pp = da2pp;
    }

    public Date getRabies() {
        return rabies;
    }

    public void setRabies(Date rabies) {
        this.rabies = rabies;
    }

    public Date getBordetella() {
        return bordetella;
    }

    public void setBordetella(Date bordetella) {
        this.bordetella = bordetella;
    }

}
