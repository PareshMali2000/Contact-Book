package com.paresh.app;

import com.paresh.model.Student;
import com.paresh.service.StudentService;
//import com.paresh.util.FileHandler;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentService service = new StudentService();
        //FileHandler handler = new FileHandler();
        while (true){

            System.out.println("1 for add Student");
            System.out.println("2 for update Student");
            System.out.println("3 for delete Student");
            System.out.println("4 for Search Student");
            System.out.println("5 for view Students");
            System.out.println("0 for exit");

            System.out.println("Enter the Choice: ");
            int choice = scanner.nextInt();



            switch (choice){
                case 0:
                    System.out.println("Thank you, exiting...");
                    break;
                case 1:
//
                    System.out.println("Enter Student name: " );
                    String name = scanner.next();
                    System.out.println("Enter Student age: " );
                    int age = scanner.nextInt();
                    System.out.println("Enter Student course: " );
                    String course = scanner.next();
                    System.out.println("Enter Student Email: " );
                    String email = scanner.next();
                    Student student = new Student(0,name,age,course,email);
                    boolean added = service.addStudent(student);
                    System.out.println(added ? "Student Added Successfully" : "Email already exists");
                    break;

                case 2:
                    System.out.println("Enter Id to update: ");
                    int id = scanner.nextInt();
                    System.out.println("Enter new name: ");
                    String name1 = scanner.next();
                    System.out.println("Enter new age: ");
                    int age1 = scanner.nextInt();
                    System.out.println("Enter new course: ");
                    String course1= scanner.next();
                    System.out.println("Enter new email: ");
                    String email1 = scanner.next();

                    boolean updated = service.updateStudent(id,name1,age1,course1,email1);
                    System.out.println(updated ? "Student updated successfully": "Student not found");
                    break;

                case 3:
                    System.out.println("Enter Student ID: ");
                    int sid = scanner.nextInt();
                   boolean isDeleted = service.deleteStudent(sid);
                    System.out.println(isDeleted ? "Student Deleted successfully" : "Student not found ");
                    break;

                case 4:
                    System.out.println("Enter Student ID: ");
                    int sid1 = scanner.nextInt();
                    Student s = service.searchById(sid1);
                    if(s!=null){
                    System.out.println(s);
                    }else {
                        System.out.println("Student not found");
                    }
                    break;

                case 5:
                    List<Student> studentList =service.viewAllStudents();
                    for(Student s1: studentList){
                        System.out.println(s1);
                    }
                    break;
                default:
                    System.out.println(" Invalid choice!! Enter valid choice");
                    break;

            }

            if(choice == 0){
                System.out.println("thankyou");
                break;
            }
        }
    }
}
