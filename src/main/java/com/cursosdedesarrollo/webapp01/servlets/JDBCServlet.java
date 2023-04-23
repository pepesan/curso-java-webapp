package com.cursosdedesarrollo.webapp01.servlets;

import com.cursosdedesarrollo.webapp01.common.Conexion;
import com.cursosdedesarrollo.webapp01.entities.Language;
import com.cursosdedesarrollo.webapp01.repositories.LanguageRepository;
import com.cursosdedesarrollo.webapp01.repositories.LanguageRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(
        name = "JDBCServlet",
        urlPatterns = {"/jdbc"},
        loadOnStartup = 1
)
public class JDBCServlet extends HttpServlet {

    private  Conexion conection = new Conexion();

    private LanguageRepository languageRepository;

    public JDBCServlet(){
        super();
        languageRepository = new LanguageRepositoryImpl(conection);
        System.out.println(languageRepository);
    }

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        this.handleRequest(request, response);
    }
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        this.handleRequest(request, response);
    }

    protected void doPut(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        this.handleRequest(request, response);
    }

    protected void doDelete(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        this.handleRequest(request, response);
    }

    public void handleRequest(HttpServletRequest request,
    HttpServletResponse response) throws IOException, ServletException {
        var listado = this.languageRepository.findAll();
        response.setContentType("application/json;charset=UTF-8");
        ServletOutputStream out = response.getOutputStream();
        // Imprimir datos en la salida JSON
        StringBuilder salida = new StringBuilder();
        salida.append("[");
        for (Language language : listado) {
            salida.append(language.toJson());
            salida.append(",");
        }
        salida.deleteCharAt(salida.length() - 1);
        salida.append("]");
        out.print(salida.toString());
        // Cerrar la salida
        out.close();
    }
}
