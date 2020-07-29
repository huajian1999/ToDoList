package com.hbue.servlet;

import com.hbue.model.Work;
import com.hbue.service.Impl.WorkServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/AddWorkServlet")
public class AddWorkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String description = request.getParameter("description");
        HttpSession session = request.getSession();
        Integer listId = Integer.parseInt(session.getAttribute("listId").toString());
        Work work = new Work(description,"未完成", listId);
        WorkServiceImpl workService = new WorkServiceImpl();
        workService.addWork(work);
        request.getRequestDispatcher("FindAllWorkServlet").forward(request,response);
    }
}
