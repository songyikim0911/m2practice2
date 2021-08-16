package org.zerock.m2practice2.controller;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.zerock.m2practice2.dto.MemberDTO;
import org.zerock.m2practice2.service.MemberService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@Log4j2
@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("GET login");
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String mid = request.getParameter("mid");
        String mpw = request.getParameter("mpw");

        try {
            MemberDTO memberDTO = MemberService.INSTANCE.memberLogin(mid, mpw);

            HttpSession session = request.getSession();
            session.setAttribute("member", memberDTO);

            response.sendRedirect("/msg/list");

        }catch(Exception e ){
            log.error("login fail.." + e.getMessage());
            response.sendRedirect("/login?result = fail");

        }

    }
}
