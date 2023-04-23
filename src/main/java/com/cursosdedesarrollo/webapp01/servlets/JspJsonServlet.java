package com.cursosdedesarrollo.webapp01.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(
        name = "JspJsonServlet",
        urlPatterns = "/jspjson",
        loadOnStartup = 1
)
public class JspJsonServlet extends HttpServlet {
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
        request.getRequestDispatcher("/WEB-INF/json.jsp")
                .forward(request, response);
    }
}
