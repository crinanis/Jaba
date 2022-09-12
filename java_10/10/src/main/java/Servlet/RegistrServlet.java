package Servlet;

import User.users;
import db.DBConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.codec.digest.DigestUtils;

@WebServlet(name = "RegistrServlet", value = "/registr")
public class RegistrServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String hashPassword = DigestUtils.md5Hex(password);
        users usercheck = null;
        if (login.isEmpty()  || password.isEmpty()) {
            req.setAttribute("result", "Поля не заполнены");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("registr.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            try {
                DBConnection dataBaseHandler = new DBConnection();
                usercheck = dataBaseHandler.GetByUsername(login, password);
                if (usercheck!=null ) {
                    req.setAttribute("result", "Пользователь с таким логином уже существует");
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("registr.jsp");
                    requestDispatcher.forward(req, resp);
                }
                else {
                    users user = new users(login, password, "user");
                    dataBaseHandler.AddUser(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(req, resp);

        }

    }
}