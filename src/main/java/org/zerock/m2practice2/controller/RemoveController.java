package org.zerock.m2practice2.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.m2practice2.service.MsgService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@Log4j2
@WebServlet(name = "RemoveController", value = "/msg/remove")
public class RemoveController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("doPost");

        request.setCharacterEncoding("UTF-8");

        Long mno = Long.parseLong(request.getParameter("mno"));
        String who = request.getParameter("who");

        log.info("mno:" +mno);
        log.info("who:"+who);

        MsgService.INSTANCE.remove(mno, who);

        response.sendRedirect("/msg/list?whom=" +who);

    }
}
