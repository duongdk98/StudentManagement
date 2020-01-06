package dao;

import model.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface StudentDAO {

    List<Student> findAll();

    List<Student> findStudentByNameIsContaining(String q);

    Student findOne(int id);

    boolean save(Student student) throws SQLException;

    boolean update(Student student) throws SQLException;

    boolean delete(int id) throws SQLException;


}
