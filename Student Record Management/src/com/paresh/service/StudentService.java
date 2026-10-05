package com.paresh.service;

import com.paresh.dao.StudentDao;
import com.paresh.model.Student;

import java.util.List;

public class StudentService {
    private final StudentDao studentDao = new StudentDao();


    public boolean addStudent(Student student){
        return studentDao.addStudent(student);
    }

    //ViewAllStudents
    public List<Student> viewAllStudents(){
        return studentDao.viewAllStudents();
    }

//SearchStudent By Id
    public Student searchById(int id){
       return studentDao.searchById(id);
    }


    //Update Student by Id
    public boolean updateStudent(int id, String name, int age, String course, String email){
        return studentDao.updateStudent(id,name,age,course,email);
    }

//delete Student by Id
    public boolean deleteStudent(int id){
        return studentDao.deleteStudent(id);
        }

    }




//for File save code
/*
package com.paresh.service;

import com.paresh.model.Student;
import com.paresh.util.FileHandler;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> students = new ArrayList<>();
    private int nextId;
private FileHandler handler = new FileHandler();


public StudentService(){
    students = handler.loadStudents();
    int maxId= 0;
   for(Student s: students){
       if(maxId < s.getId()){
         maxId = s.getId();
       }
   }
   nextId = maxId +1;

}
    //Add Student into the List
    public boolean addStudent(Student student){
       for(Student s : students){
           if(student.getEmail().equals(s.getEmail())){
               return false;
           }
       }
       student.setId(nextId);
       students.add(student);
       nextId++;
       handler.saveStudents(students);
       return true;
    }

    //ViewAllStudents
    public void viewAllStudents(){
        for(Student s: students){
            System.out.println(s);
        }
    }

//SearchStudent By Id
    public Student searchById(int id){
        for(Student s : students){
            if(s.getId() == id){
               return s;
            }
        }
        return null;
    }


    //Update Student by Id
    public boolean updateStudent(int id, String name, int age, String course, String email){
        for(Student s: students){
            if(s.getId() == id){
                s.setName(name);
                s.setCourse(course);
                s.setEmail(email);
                s.setAge(age);
                handler.saveStudents(students);
                return true;
            }
        }
        return false;
    }

//delete Student by Id
    public boolean deleteStudent(int id){
        for(Student s: students){
            if(s.getId()==id){
                students.remove(s);
                handler.saveStudents(students);
                return true;
            }
        }

        return false;
    }

}
*/