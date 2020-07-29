package com.hbue.servlet;

import com.hbue.model.AList;
import com.hbue.service.Impl.ListServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateListServlet")
public class UpdateListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        AList alist = new AList(id,name);
        ListServiceImpl listService = new ListServiceImpl();
        listService.updateList(alist);
        request.getRequestDispatcher("FindAllListServlet").forward(request,response);
    }
}
