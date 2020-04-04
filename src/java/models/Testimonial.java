package models;

/**
 * This class contains information and operations to create a testimonial
 * object.
 *
 * @author Hans Cabrera
 */
public class Testimonial {

    private int id;
    private String username;
    private String contents;
    private boolean approved;

    /**
     * Default constructor.
     */
    public Testimonial() {
    }

    /**
     * Constructor to set all the attributes.
     *
     * @param id The id number.
     * @param username The username.
     * @param contents The contents.
     * @param approved If the testimonial has been approved.
     */
    public Testimonial(int id, String username, String contents, boolean approved) {
        this.id = id;
        this.username = username;
        this.contents = contents;
        this.approved = approved;
    }

    /**
     * Gets the id number.
     *
     * @return The id number.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id number.
     *
     * @param id The id number.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the username.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     *
     * @param username The username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the contents.
     *
     * @return The contents.
     */
    public String getContents() {
        return contents;
    }

    /**
     * Sets the contents.
     *
     * @param contents The contents.
     */
    public void setContents(String contents) {
        this.contents = contents;
    }

    /**
     * Indicates if the testimonial has been approved by an administrator.
     *
     * @return true if the testimonial has been approved by an administrator.
     */
    public boolean isApproved() {
        return approved;
    }

    /**
     * Sets if the testimonial has been approved by an administrator.
     *
     * @param approved If the testimonial has been approved by an administrator.
     */
    public void setApproved(boolean approved) {
        this.approved = approved;
    }

}
