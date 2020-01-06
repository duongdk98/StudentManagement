package dao.impl;

import connection.ConnectionUtils;
import dao.StudentDAO;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    private static final int SUCESS = 0;

    @Override
    public List<Student> findAll() {
        String query = "SELECT s.id, s.name, s.dob FROM students s";
        List<Student> students = new ArrayList<>();
        try (Connection cn = ConnectionUtils.getConnection();
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                students.add(new Student(rs.getInt(1), rs.getString(2), rs.getDate(3)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return students;
    }

    @Override
    public List<Student> findStudentByNameIsContaining(String q) {
        List<Student> listStudent = new ArrayList<>();
        String query = "SELECT s.id, s.name, s.dob FROM students s WHERE s.name LIKE '%"+ q +"'";
        try (Connection cn = ConnectionUtils.getConnection();
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                listStudent.add(new Student(rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listStudent;
    }

    @Override
    public Student findOne(int id) {
        String query = "SELECT s.id, s.name, s.dob FROM students s WHERE s.id =?";
        Student student = null;
        try (Connection cn = ConnectionUtils.getConnection();
             PreparedStatement ps = cn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {

                String name = rs.getString("name");
                Date dob = rs.getDate("dob");
                student = new Student(id, name, dob);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return student;
    }

    @Override
    public boolean save(Student student) throws SQLException {
        String query = "INSERT INTO studdents(id, name, dob) VALUES (?,?,?)";
        boolean rowInsert;
        try (Connection cn = ConnectionUtils.getConnection();
             PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setDate(3, student.getDob());
            rowInsert = ps.executeUpdate() > SUCESS;
        }
        return rowInsert;
    }

    @Override
    public boolean update(Student student) throws SQLException {
        String query = "UPDATE students SET name=?, dob=? WHERE id=?";
        boolean rowUpdate;
        try (Connection cn = ConnectionUtils.getConnection();
             PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setString(1, student.getName());
            ps.setDate(2, student.getDob());
            ps.setInt(3, student.getId());

            rowUpdate = ps.executeUpdate() > SUCESS;
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String query = "DELETE FROM students WHERE id=?";
        boolean rowDelete;
        try (Connection cn = ConnectionUtils.getConnection();
             PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setInt(1, id);
            rowDelete = ps.executeUpdate() > SUCESS;
        }
        return rowDelete;
    }
}
