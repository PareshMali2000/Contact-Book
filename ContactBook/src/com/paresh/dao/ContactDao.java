package com.paresh.dao;

import com.paresh.model.Contact;
import com.paresh.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDao {

    public boolean addContact(Contact contact){
        String sql = "INSERT into Contacts(name,phone_number,email,category) values (?,?,?,?)";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)){

            statement.setString(1,contact.getName());
            statement.setString(2,contact.getPhone_number());
            statement.setString(3,contact.getCategory());
            statement.setString(3,contact.getEmail());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;

        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

public boolean removeContact(int id){
        String sql = "delete from Contacts where id = ?";
        try(Connection conn = DBConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setInt(1,id);

            int removed = statement.executeUpdate();

            return removed > 0;
        }catch (SQLException e ){
            System.out.println(e.getMessage());
            return false;
        }

}


public List<Contact> viewAllContacts(){
        List<Contact> contactList = new ArrayList<>();
        String sql = "select * from Contacts";
        try(Connection conn = DBConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql)){

           ResultSet rs =  statement.executeQuery();
           while(rs.next()){
              int id = rs.getInt(1);
              String name = rs.getString(2);
              String phone_number = rs.getString(3);


           }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return contactList;
}

}
