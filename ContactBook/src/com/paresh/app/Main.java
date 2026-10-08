package com.paresh.app;

import com.paresh.model.Contact;
import com.paresh.service.ContactService;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ContactService contactService = new ContactService();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Enter 1 for add Contact");
            System.out.println("Enter 2 for delete Contact");
            System.out.println("Enter 3 for update Contact");
            System.out.println("Enter 4 for search Contact");
            System.out.println("Enter 5 for view all Contacts");
            System.out.println("Enter 6 for Filter Contacts");
            System.out.println("Enter 7 for sort by  Contacts");
            System.out.println("Enter 0 for exit");

            System.out.println("Enter Choice: ");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter contact name: " );
                    String name = scanner.next();
                    System.out.println("Enter phone number: " );
                    long phone_number = scanner.nextLong();
                    System.out.println("Enter contact email: " );
                    String email = scanner.next();
                    System.out.println("Enter contact Category: " );
                    String category = scanner.next();
                    Contact c = new Contact(0,name,phone_number,email,category);
                    boolean added = contactService.addContact(c);
                    System.out.println(added?"contact added":"contact not added");
                    break;

                    case 2:
                    System.out.println("Enter contact Name: ");
                    String contactName = scanner.next();
                    boolean deleted = contactService.deleteContact(contactName);
                    System.out.println(deleted?"Deleted": "Not found");
                    break;

                    case 3:
                        System.out.println("Enter Contact ID:");
                        int cid = scanner.nextInt();
                        System.out.println("Enter contact name: " );
                        String cname = scanner.next();
                        System.out.println("Enter phone number: " );
                        long cphone_number = scanner.nextLong();
                        System.out.println("Enter contact email: " );
                        String cemail = scanner.next();
                        System.out.println("Enter contact Category: " );
                        String ccategory = scanner.next();

                        boolean updated = contactService.updateContact(cid,cname,cphone_number,cemail,ccategory);
                        System.out.println(updated?"updated":"not updated");
                        break;

                    case 4:
                    System.out.println("enter name: ");
                    String conName = scanner.next();
                    List<Contact> contacts = contactService.searchByName(conName);
                    for(Contact c1: contacts){
                        System.out.println(c1);
                    }
                    break;

                    case 5:
                    contactService.viewAllContacts();
                    break;

                case 6:
                    System.out.println("Enter category: ");
                    String sortCategory = scanner.next();
                    List<Contact> contacts1 = contactService.filterByCategory(sortCategory);
                    for(Contact c2: contacts1){
                        System.out.println(c2);
                    }
                    break;
                case 7:
                    List<Contact> sortByName = contactService.sortByName();
                    for(Contact contact2: sortByName){
                        System.out.println(contact2);
                    }
                    break;


                    default:
                    System.out.println("Invalid choice! ");
                    break;
            }

            if(choice == 0){
                break;
            }
        }
    }
}
