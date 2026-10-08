package com.paresh.service;


import com.paresh.model.Contact;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ContactService {
    private List<Contact> contacts = new ArrayList<>();
    private int nextId = 1;

    public boolean addContact(Contact c) {
        for (Contact contact : contacts) {
            if (contact.getPhone_number() == c.getPhone_number()) {
                return false;
            }
        }
        c.setContactID(nextId);
        contacts.add(c);
        nextId++;
        return true;
    }

    public void viewAllContacts() {
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }

    public List<Contact> searchByName(String name) {
        List<Contact> list = new ArrayList<>();
        for (Contact c : contacts) {
            if (c.getName().toLowerCase().contains(name.toLowerCase())) {
                list.add(c);
            }
        }
        return list;
    }

    public boolean updateContact(int contactID, String name, long phone_number, String email, String category) {
        for (Contact c : contacts) {
         if(c.getContactID() == contactID) {
             c.setName(name);
             c.setPhone_number(phone_number);
             c.setCategory(category);
             c.setEmail(email);
             return true;
         }
        }
        return false;
    }


    public boolean deleteContact(String name) {
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                contacts.remove(c);
                return true;
            }
        }
        return false;
    }

    public List<Contact> filterByCategory(String category) {
        List<Contact> list = new ArrayList<>();
        for (Contact c : contacts) {
            if (category.equalsIgnoreCase(c.getCategory())) {
                list.add(c);
            }
        }
        return list;
    }


    public List<Contact> sortByName() {
        Collections.sort(contacts, (c1, c2) -> c1.getName().compareTo(c2.getName()));
        return contacts;
    }
}