package com.hbue.servlet;

import com.hbue.model.AList;
import com.hbue.service.Impl.ListServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddListServlet")
public class AddListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf8");

        String name = request.getParameter("name");
        System.out.println(name);
        AList alist = new AList(name);
        ListServiceImpl listService = new ListServiceImpl();
        listService.addList(alist);
        request.getRequestDispatcher("FindAllListServlet").forward(request,response);
    }
}
