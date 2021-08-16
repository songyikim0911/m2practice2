package org.zerock.m2practice2.controller;

import org.zerock.m2practice2.dto.MsgDTO;
import org.zerock.m2practice2.service.MsgService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ReadController", value = "/msg/read")
public class ReadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long mno = Long.parseLong(request.getParameter("mno"));

        MsgDTO msgDTO = MsgService.INSTANCE.read(mno);

        request.setAttribute("dto", msgDTO);

        request.getRequestDispatcher("/WEB-INF/msg/read.jsp").forward(request,response);


    }

}
