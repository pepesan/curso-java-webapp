package com.cursosdedesarrollo.webapp01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(
        name = "JspServlet",
        urlPatterns = "/jsp",
        loadOnStartup = 1
)
public class JspServlet extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        String datos = "Algunos datos";
        Integer numero = 12;
        Integer otroNumero = 13;
        request.setAttribute("data", datos);
        request.setAttribute("numero", numero);
        request.setAttribute("numero2",otroNumero);
        request.getRequestDispatcher("/WEB-INF/page.jsp")
                .forward(request, response);
    }
}
