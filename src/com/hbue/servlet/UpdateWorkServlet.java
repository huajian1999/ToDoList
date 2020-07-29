package com.hbue.servlet;

import com.hbue.model.Work;
import com.hbue.service.Impl.WorkServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateWorkServlet")
public class UpdateWorkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        System.out.println("UpdateWorkServlet");

        Integer id = Integer.valueOf(request.getParameter("id"));
        String state = request.getParameter("state");
        Work work = new Work(id,state);
        WorkServiceImpl workService = new WorkServiceImpl();
        workService.updateWorkState(work);
        request.getRequestDispatcher("FindAllWorkServlet").forward(request,response);
    }
}
