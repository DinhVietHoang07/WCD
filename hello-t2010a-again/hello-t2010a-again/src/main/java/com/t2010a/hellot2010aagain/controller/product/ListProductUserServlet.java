package com.t2010a.hellot2010aagain.controller.product;

import com.t2010a.hellot2010aagain.entity.Product;
import com.t2010a.hellot2010aagain.model.MySqlProductModel;
import com.t2010a.hellot2010aagain.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListProductUserServlet extends HttpServlet {
    private ProductModel productModel;

    public ListProductUserServlet() {
        this.productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productModel.findAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/user/page/products.jsp").forward(req, resp);
    }
}
