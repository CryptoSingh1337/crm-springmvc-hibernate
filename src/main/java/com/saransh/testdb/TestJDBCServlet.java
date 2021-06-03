package com.saransh.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by CryptoSingh1337 on 5/31/2021
 */

@WebServlet("/testdb")
public class TestJDBCServlet extends HttpServlet {

    public static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String url = "jdbc:mysql://localhost:3306/web_customer_tracker";
        String username = "springstudent";
        String password = "springstudent";
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            res.getWriter().println("Connected to " + url + "!");
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
