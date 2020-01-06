package controller;

import model.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/")
public class StudentController extends HttpServlet {

    private StudentService studentService;

    @Override
    public void init(ServletConfig config) {
        studentService = new StudentServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        try {
            switch (action) {
                case "/new":
                    showFormAddStudent(req, resp);
                    break;
                case "/insert":
                    addStudent(req, resp);
                    break;
                case "/delete":
                    removeStudent(req, resp);
                    break;
                case "/edit":
                    showFormEditStudent(req, resp);
                    break;
                case "/update":
                    editStudent(req, resp);
                    break;
                case "/search":
                    searchStudent(req, resp);
                    break;
                default:
                    listStudent(req, resp);
                    break;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void showFormAddStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rq = req.getRequestDispatcher("studentform.jsp");
        rq.forward(req, resp);
    }

    private void showFormEditStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = studentService.getStudent(id);
        req.setAttribute("student", student);
        RequestDispatcher rq = req.getRequestDispatcher("studentform.jsp");
        rq.forward(req, resp);
    }

    private void listStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = studentService.listStudent();
        req.setAttribute("listStudent", students);
        RequestDispatcher rq = req.getRequestDispatcher("index.jsp");
        rq.forward(req, resp);
    }

    private void addStudent(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String dob = req.getParameter("dob");
        SimpleDateFormat df = new SimpleDateFormat("yyyy/mm/dd");
        try {
            Date date = (Date) df.parse(dob);

            Student student = new Student(id, name, date);
            studentService.addStudent(student);
        } catch (ParseException e) {
            System.out.println(e);
        }
        resp.sendRedirect("list");

    }

    private void editStudent(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String dob = req.getParameter("dob");
        SimpleDateFormat df = new SimpleDateFormat("yyyy/mm/dd");
        try {
            Date date = (Date) df.parse(dob);

            Student student = new Student(id, name, date);
            studentService.editStudent(student);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("list");

    }

    private void removeStudent(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        studentService.removeStudent(id);
        resp.sendRedirect("list");

    }

    private void searchStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String q = req.getParameter("search");
        List<Student> students = studentService.searchStudent(q);
        req.setAttribute("listStudent", students);
        RequestDispatcher rq = req.getRequestDispatcher("index.jsp");
        rq.forward(req, resp);

    }

}
