package com.cursosdedesarrollo.webapp01;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(
        name = "JsonServlet",
        urlPatterns = "/json",
        loadOnStartup = 1
)
public class JsonServlet extends HttpServlet {
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        // Definir el tipo de salida
        response.setContentType("application/json;charset=UTF-8");
        ServletOutputStream out = response.getOutputStream();
        // Imprimir datos en la salida HTML
        out.print("{" +
                "\"nombre\": \"Juan\"," +
                "\"apellido\": \"Perez\"" +
                "}");
        // Cerrar la salida
        out.close();
    }
}
