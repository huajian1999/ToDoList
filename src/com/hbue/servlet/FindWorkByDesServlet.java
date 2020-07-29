package com.hbue.servlet;

import com.hbue.model.Work;
import com.hbue.service.Impl.WorkServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/FindWorkByDesServlet")
public class FindWorkByDesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //传input内容进来
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf8");


        if (request.getParameter("description") != null){
            String description = request.getParameter("description");
            WorkServiceImpl workService = new WorkServiceImpl();
            List<Work> doingList = workService.findDoingWorkByDes(description);
            List<Work> doneList = workService.findDoneWorkByDes(description);
            request.setAttribute("doingList",doingList);
            request.setAttribute("doneList",doneList);
            request.setAttribute("description",description);
        }
        request.getRequestDispatcher("search.jsp").forward(request,response);
    }
}
