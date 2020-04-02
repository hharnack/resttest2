package models;

/**
 * 
 * @author Hans Cabrera
 */
public class Testimonial {

    private int id;
    private String username;
    private String contents;
    private boolean approved;

    public Testimonial() {
    }

    public Testimonial(int id, String username, String contents, boolean approved) {
        this.id = id;
        this.username = username;
        this.contents = contents;
        this.approved = approved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return contents;
    }

    public void setContent(String contents) {
        this.contents = contents;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

}
