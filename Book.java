/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
 //Edit made on the website 
 
package AddressBook;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The book to hold the addresses.  
 * Creates a list of addresses from a database
 * 
 * @author Alex Wikstrom
 */
public final class Book {
    
        ArrayList<Address> addresses = new ArrayList<Address>();
        Connection conn;
        ResultSet rs;
        
 /**
 *
 * Constructor retrieves and builds all info into a book
 * @throws java.sql.SQLException - Updates and Reads a database
 */
        
    public Book() throws SQLException
    {
        
        CreateConnection();
        PopulatePhoneBook();
        
        CreateConnection();
        conn.Close();

        
    }
    
    /**
     * Fills all fields in the object array with database info.
     * @throws SQLException - Requests entire table. 
     */
    public void PopulatePhoneBook() throws SQLException
    {
        Statement stat = conn.createStatement();
        rs =  stat.executeQuery("SELECT * FROM APP.\"Book\" ORDER BY \"LastName\" ASC");

        String[] personString = new String[10];


        while (rs.next()) {
            int id = rs.getInt("Address_Id");
            personString[0] = Integer.toString(id);
            personString[1] = rs.getString("FirstName");
            personString[2] = rs.getString("LastName");
            personString[3] = rs.getString("Email");
            personString[4] = rs.getString("Address1");
            personString[5] = rs.getString("Address2");
            personString[6] = rs.getString("City");
            personString[7] = rs.getString("State");
            personString[8] = rs.getString("Zip");
            personString[9] = rs.getString("Phone");

            Address addAddress = new Address(personString);
            addresses.add(addAddress);
        }
    }
    
    /**
     *
     * @return gives the length of the address book - integer
     */
    public int GetLengthBook()
    {
        return addresses.size();
    }
    
    /**
     *
     * @param counter counter passed from iteration, it's the chosen address number
     * @return returns the Address' Last Name, First Name
     */
    public String LastFirst(int counter){

         return addresses.get(counter).getLastName() + ", " + addresses.get(counter).getFirstName();

    }
    
    /**
     *
     * @param chosenName chosen from a box of names
     * @return information about the chosen name
     */
    public String[] GetChosenInfo(String chosenName)
    {
        int chosenItem = 0;
        chosenName = chosenName.split(",")[0];

        for(int i = 0; i < GetLengthBook(); i++)
        {
            String itemLastName = addresses.get(i).getLastName();
            if (chosenName.equals(itemLastName))
                 chosenItem = i;
        }
        
        return addresses.get(chosenItem).ChosenArray();
    }
    
    /**
     *
     */
    public final void CreateConnection()
    {
            try {
                conn = SimpleDataSource.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    /**
     *
     * @param sub Sub comes as an array ready for the database insertion
     * @throws SQLException - Insert address
     */
    public void InsertAddress(String[] sub) throws SQLException
    {
                
        CreateConnection();

        Statement stat = conn.createStatement();
        stat.executeUpdate("INSERT INTO APP.\"Book\" "
                + "(\"FirstName\", \"LastName\", \"Email\", \"Phone\", \"Address1\", \"Address2\", \"City\", \"State\", \"Zip\")    "
                + "VALUES ('" + sub[0] + "','" + sub[1] + "','" + sub[2] + "','" + sub[3] + "','" + sub[4] + "','" + sub[5] + "','" + sub[6] + "','" + sub[7] + "','" + sub[8] + "')");
    
        PopulatePhoneBook();
    }
    
    /**
     *
     * @param sub Substring comes as Lastname, Firstname
     * @throws SQLException - Deletes addresses with with this name
     */
    public void DeleteAddress(String sub) throws SQLException
    {
                
        CreateConnection();
        
        String sub2 = sub.split(", ")[1];
        sub = sub.split(", ")[0];

        Statement stat = conn.createStatement();
        stat.executeUpdate("DELETE FROM APP.\"Book\" "
                + "WHERE \"LastName\" = \'" + sub + "\'"
                + "AND \"FirstName\" = \'" + sub2 + "\'");
        PopulatePhoneBook();
    }
}
