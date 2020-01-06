package service.impl;

import dao.StudentDAO;
import dao.impl.StudentDAOImpl;
import model.Student;
import service.StudentService;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    public List<Student> listStudent() {
        return studentDAO.findAll();
    }

    @Override
    public List<Student> searchStudent(String q) {
        return studentDAO.findStudentByNameIsContaining(q);
    }

    @Override
    public Student getStudent(int id) {
        return studentDAO.findOne(id);
    }

    @Override
    public boolean addStudent(Student student) throws SQLException {
        return studentDAO.save(student);
    }

    @Override
    public boolean editStudent(Student student) throws SQLException {
        return studentDAO.update(student);
    }

    @Override
    public boolean removeStudent(int id) throws SQLException {
        return studentDAO.delete(id);
    }
}
