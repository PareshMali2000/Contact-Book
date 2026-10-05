package com.paresh.check;

import com.paresh.dao.StudentDao;
import com.paresh.model.Student;
import com.paresh.util.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Mainmethod {
    public static void main(String[] args) throws SQLException {
       //Connection c=  DBConnection.getConnection();
        //System.out.println("Got Connection");

        StudentDao studentDao = new StudentDao();
        /*boolean added = studentDao.addStudent(new Student(0,"Rahul",18,"IT","rahul@gmail.com"));
        System.out.println(added);*/


        List<Student> studentList =  studentDao.viewAllStudents();
        System.out.println(studentList);

        /*Student s = studentDao.searchById(1);
        System.out.println(s)*/;

        boolean updated = studentDao.updateStudent(1,"Kedar",22,"Java","k@gmail.com");
        System.out.println(updated);

        boolean isDeleted = studentDao.deleteStudent(1);
        System.out.println(isDeleted);
    }
}
