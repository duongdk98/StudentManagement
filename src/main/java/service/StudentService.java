package service;

import model.Student;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> listStudent();

    List<Student> searchStudent(String q);

    Student getStudent(int id);

    boolean addStudent(Student student) throws SQLException;

    boolean editStudent(Student student) throws SQLException;

    boolean removeStudent(int id) throws SQLException;
}
