package com.t2010a.hellot2010aagain.controller.product;

import com.t2010a.hellot2010aagain.entity.Product;
import com.t2010a.hellot2010aagain.entity.Student;
import com.t2010a.hellot2010aagain.model.MySqlProductModel;
import com.t2010a.hellot2010aagain.model.MySqlStudentModel;
import com.t2010a.hellot2010aagain.model.ProductModel;
import com.t2010a.hellot2010aagain.model.StudentModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListProductServlet extends HttpServlet {

    private ProductModel productModel;

    public ListProductServlet() {
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getAttribute("message"));
        List<Product> list = productModel.findAll();
        req.setAttribute("title", "List Product");
        req.setAttribute("list", list);
        req.getRequestDispatcher("/admin/products/list.jsp").forward(req, resp);
    }
}
