package com.t2010a.hellot2010aagain.controller;

import com.t2010a.hellot2010aagain.entity.Student;
import com.t2010a.hellot2010aagain.model.MySqlStudentModel;
import com.t2010a.hellot2010aagain.model.StudentModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class DetailStudentServlet extends HttpServlet {

    private StudentModel studentModel;

    public DetailStudentServlet() {
        this.studentModel = new MySqlStudentModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rollNumber = req.getParameter("id");
        Student student = studentModel.findById(rollNumber);
        if (student == null) {
            req.setAttribute("message", "Student not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        } else {
            HttpSession session = req.getSession();
            ArrayList<Student> recentView =
                    (ArrayList<Student>) session.getAttribute("recentView");;
            if(recentView == null){
                recentView = new ArrayList<Student>();
            }
            boolean exist = false;
            for (int i = 0; i < recentView.size(); i++) {
                if(recentView.get(i).getRollNumber().equals(student.getRollNumber())){
                    exist = true;
                }
            }
            if(!exist){
                recentView.add(student);
                session.setAttribute("recentView", recentView);
            }
            req.setAttribute("student", student);
            req.getRequestDispatcher("/admin/students/detail.jsp").forward(req, resp);
        }

    }
}
