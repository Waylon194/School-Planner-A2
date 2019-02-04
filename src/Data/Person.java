package Data;

public class Person {
    private int age;
    private String firstName;
    private String additive;
    private String lastName;

    /**
     * @param firstName first name of the person
     * @param additive middle additive of the person
     * @param lastName last name of the person
     * @param age age of the person
     */

    public Person (String firstName, String additive, String lastName, int age) {
        this.firstName = firstName;
        this.additive = additive;
        this.lastName = lastName;
        this.age = age;
    }

    /**
     * gets the age of the person
     * @return age
     */

    public int getAge () {
        return age;
    }

    /**
     * set the age of the person
     * @param age = age
     */

    public void setAge (int age) {
        this.age = age;
    }

    /**
     * gets the first name of the person
     * @return firstName
     */

    public String getFirstName () {
        return firstName;
    }

    /**
     * set the first name of the person
     * @param firstName = firstName
     */

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    /**
     * get the middle name of the person
     * @return additive
     */

    public String getAdditive () {
        return additive;
    }

    /**
     * set the middle name of the person
     * @param additive = additive
     */

    public void setAdditive (String additive) {
        this.additive = additive;
    }

    /**
     * get the last name of the person
     * @return lastName
     */

    public String getLastName () {
        return lastName;
    }

    /**
     * set the last name of the person
     * @param lastName = lastName
     */

    public void setLastName (String lastName) {
        this.lastName = lastName;

    }

}