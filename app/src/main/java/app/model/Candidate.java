package app.model;

/**
 * Created by User on 15/11/2016.
 */

public class Candidate {
    public String   _id;
    public String firstName;
    public String lastName;
    public String office;

    public Candidate(String firstName, String lastName, String office)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.office = office;
    }
}
