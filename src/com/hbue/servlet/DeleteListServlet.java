package com.hbue.servlet;

import com.hbue.service.Impl.ListServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteListServlet")
public class DeleteListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf8");
        Integer id = Integer.valueOf(request.getParameter("id"));
        ListServiceImpl listService = new ListServiceImpl();
        listService.deleteList(id);

        request.getRequestDispatcher("FindAllListServlet").forward(request,response);

    }
}
