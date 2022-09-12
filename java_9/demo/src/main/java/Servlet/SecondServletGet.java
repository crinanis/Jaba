package Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Locale;


@WebServlet(name = "SecondServletGet", urlPatterns = "/SecondServletGet")
public class SecondServletGet extends HttpServlet {

    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }
    protected  void  doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getAttribute("Name").toString();
        request.setAttribute("Name",name);
    response.sendRedirect("Help");//переадресация

    }
}