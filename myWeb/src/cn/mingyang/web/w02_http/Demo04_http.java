package cn.mingyang.web.w02_http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/Demo04_http")
public class Demo04_http extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null){
            System.out.println(line);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

    }
}
