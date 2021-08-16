package org.zerock.m2practice2.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.m2practice2.dto.MemberDTO;
import org.zerock.m2practice2.dto.MsgDTO;
import org.zerock.m2practice2.service.MsgService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@WebServlet(name = "ListController", value = "/msg/list")
public class ListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Object memberObj = session.getAttribute("member");

        if(memberObj==null){
            response.sendRedirect("/login");
            return;
        }

        MemberDTO memberDTO = (MemberDTO)memberObj;

        String user = memberDTO.getMid();

        Map<String, List<MsgDTO>> result = MsgService.INSTANCE.getList(user);

        request.setAttribute("Receive", result.get("R"));
        request.setAttribute("Send", result.get("S"));

        request.getRequestDispatcher("/WEB-INF/msg/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
