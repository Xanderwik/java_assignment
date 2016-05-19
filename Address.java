/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBook;

/**
 * The Address Object 
 * Holds all info for one Address
 * @author Alex Wikstrom
 */

public class Address {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String phone;
    
 /**
 *
 * @param personString Assigns a new Address with it's fields
 */
    
    Address(String[] personString) {
        this.id = personString[0];
        this.firstName = personString[1];
        this.lastName = personString[2];
        this.email = personString[3];
        this.address1 = personString[4];
        this.address2 = personString[5];
        this.city = personString[6];
        this.state = personString[7];
        this.zip = personString[8];
        this.phone = personString[9];

        
    }
    
 /**
 *
 * Returns all displayable information from the object
 * @return first, last, email, add1, add2, city, state, zip, phone
 */
    
    public String[] ChosenArray()
    {
        String[] returnArray = new String[9];
        
        returnArray[0] = this.firstName;
        returnArray[1] = this.lastName;
        returnArray[2] = this.email;
        returnArray[3] = this.address1;
        returnArray[4] = this.address2;
        returnArray[5] = this.city;
        returnArray[6] = this.state;
        returnArray[7] = this.zip;
        returnArray[8] = this.phone;
        
        return returnArray;
    }
    
    
    
    

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the address1
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * @param address1 the address1 to set
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * @return the address2
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * @param address2 the address2 to set
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
}
