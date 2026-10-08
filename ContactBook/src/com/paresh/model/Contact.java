package com.paresh.model;

public class Contact{

    private int contactID;
    private String name;
    private String phone_number;
    private String email;
    private String category;


    public Contact() {
    }

    public Contact(int contactID, String name, String phone_number, String email, String category) {
        this.contactID = contactID;
        this.name = name;
        this.phone_number = phone_number;
        this.email = email;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContactID() {
        return contactID;
    }

    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactID=" + contactID +
                ", name='" + name + '\'' +
                ", phone_number=" + phone_number +
                ", email='" + email + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

