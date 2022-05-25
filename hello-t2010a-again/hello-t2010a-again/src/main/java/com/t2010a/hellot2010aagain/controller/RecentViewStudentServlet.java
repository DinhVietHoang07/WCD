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
import java.util.List;

public class RecentViewStudentServlet extends HttpServlet {
    private StudentModel studentModel;

    public RecentViewStudentServlet() {
        this.studentModel = new MySqlStudentModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Student> list = (ArrayList<Student>) session.getAttribute("recentView");
        if (list == null) {
            list = new ArrayList<>();
        }
        req.setAttribute("title", "Recent View");
        req.setAttribute("listStudent", list);
        req.getRequestDispatcher("/admin/students/list.jsp").forward(req, resp);
    }
}
