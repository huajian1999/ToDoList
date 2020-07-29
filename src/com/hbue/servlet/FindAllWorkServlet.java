package com.hbue.servlet;

import com.hbue.model.AList;
import com.hbue.model.Work;
import com.hbue.service.Impl.ListServiceImpl;
import com.hbue.service.Impl.WorkServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/FindAllWorkServlet")
public class FindAllWorkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf8");
        System.out.println("FindAllWorkServlet");

        HttpSession session = request.getSession();
        String listIdstr = "";
        if (request.getParameter("listId") != null) {
            listIdstr = request.getParameter("listId");
        }else if (session.getAttribute("listId") == null){
            request.getRequestDispatcher("welcome.jsp").forward(request,response);
            return;
        }

        //存在listId说明已切换清单，更改session中的listId
        if (!listIdstr.equals("") && listIdstr != null){
            session.removeAttribute("listId");//移除之前存入的listId
            session.setAttribute("listId",listIdstr);//换成新的
        }

        Integer listId = Integer.parseInt(session.getAttribute("listId").toString());
        WorkServiceImpl workService = new WorkServiceImpl();
        List<Work> doingList = workService.findDoingWork(listId);
        List<Work> doneList = workService.findDoneWork(listId);
        request.setAttribute("doingList",doingList);
        request.setAttribute("doneList",doneList);

        ListServiceImpl listService = new ListServiceImpl();
        AList list = listService.findListById(listId);
        request.setAttribute("listName",list.getName());

        request.getRequestDispatcher("work.jsp").forward(request,response);
    }
}
