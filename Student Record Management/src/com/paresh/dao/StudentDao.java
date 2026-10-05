package com.paresh.dao;

import com.paresh.model.Student;
import com.paresh.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    public boolean addStudent(Student s){
        String sql = "Insert into Student(name, age, course, email) values(?,?,?,?)";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setString(1,s.getName());
            statement.setInt(2,s.getAge());
            statement.setString(3,s.getCourse());
            statement.setString(4,s.getEmail());

            int rowAffected = statement.executeUpdate();
            return rowAffected > 0;


        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<Student> viewAllStudents(){
        List<Student> students = new ArrayList<>();
        String sql = "select * from Student";

        try(Connection conn = DBConnection.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql)){

            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String course = rs.getString("course");
                String email = rs.getString("email");

                students.add(new Student(id,name,age,course,email));

            }


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return students;

    }

    public Student searchById(int id){
        String sql = "Select * from Student where id = ?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)){

            statement.setInt(1,id);

            try(ResultSet rs = statement.executeQuery()){
                if(rs.next()){
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    String course = rs.getString("course");
                    String email = rs.getString("email");

                    return new Student(id,name,age, course,email );
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }


    public boolean updateStudent(int id,String name, int age, String course, String email){
        String sql = "update Student SET name=?, age=?,course=?,email=? where id=?";
        try(Connection con = DBConnection.getConnection();
            PreparedStatement statement= con.prepareStatement(sql)){


            statement.setString(1,name);
            statement.setInt(2,age);
            statement.setString(3,course);
            statement.setString(4,email);
            statement.setInt(5,id);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected >0;


        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    public boolean deleteStudent(int id){
        String sql = "Delete from Student where id=?";
        try(Connection conn = DBConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setInt(1,id);
            int rowDeleted = statement.executeUpdate();

            return rowDeleted > 0;

        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
