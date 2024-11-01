package com.recipesharing.servlets;

import com.recipesharing.database.DBManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("register".equals(action)) {
            registerUser(request, response);
        } else if ("login".equals(action)) {
            loginUser(request, response);
        }
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        DBManager dbManager = new DBManager(); // Create an instance of DBManager
        try (Connection conn = dbManager.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO users (username, password, email) VALUES (?, ?, ?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.executeUpdate();
            response.sendRedirect("Login.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbManager.closeConnection(); // Close the connection if needed
        }
    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        DBManager dbManager = new DBManager(); // Create an instance of DBManager
        try (Connection conn = dbManager.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                request.getSession().setAttribute("username", username);
                response.sendRedirect("Profile.jsp");
            } else {
                response.sendRedirect("Login.jsp?error=Invalid credentials");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbManager.closeConnection(); // Close the connection if needed
        }
    }
}
