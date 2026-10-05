package com.paresh.util;

import com.paresh.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private static final String FILE_PATH = "students.txt";

    public List<Student> loadStudents(){
        List<Student> students = new ArrayList<>();
        try( BufferedReader bf = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while((line = bf.readLine() ) != null ){
                try {
                    String[] parts = line.split("\\|");
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    String course = parts[3];
                    String email = parts[4];
                    Student s = new Student(id, name, age, course, email);
                    students.add(s);
                }catch (Exception e){
                    System.out.println("Skipping malformed line: " + line + " (" + e.getMessage() + ")");
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return students;
    }

    public void saveStudents(List<Student> students){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH) )){
                for(Student s : students){
                    bw.write(s.toFileString());
                    bw.newLine();
                }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }



}
