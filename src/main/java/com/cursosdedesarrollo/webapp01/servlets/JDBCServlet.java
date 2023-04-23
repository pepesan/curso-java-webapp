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
        // System.out.println(request.getParameterMap());
        System.out.println("Method: "+ request.getMethod());
        System.out.println("Action: " + request.getParameter("action"));
        switch (request.getParameter("action")) {
            case "list":
                this.list(request, response);
                break;
            case "create":
                this.create(request, response);
                break;
            case "read":
                this.read(request, response);
                break;
            case "update":
                this.update(request, response);
                break;
            case "delete":
                this.delete(request, response);
                break;
            default:
                this.list(request, response);
                break;

        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Recoger el Id del elemento a buscar
        Integer id = Integer.parseInt(request.getParameter("id"));
        // buscar en la bbdd el elemento con ese id
        Language language = this.languageRepository.findById(id);
        System.out.println(language);
        // Devolver la respuesta
        response.setContentType("application/json;charset=UTF-8");
        ServletOutputStream out = response.getOutputStream();
        // Imprimir datos en la salida JSON
        StringBuilder salida = new StringBuilder();
        if (!language.getLanguageId().equals(0)) {
            // Eliminar el objeto de la bbdd
            this.languageRepository.deleteById(id);
            response.setStatus(200);
            salida.append(language.toJson());
        }else {
            response.setStatus(404);
            salida.append("{" +
                    "\"error\": \"No existe el elemento con ese id\""+
                    "}");
        }
        out.print(salida.toString());
        // Cerrar la salida
        out.close();
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Recoger el Id del elemento a buscar
        Integer id = Integer.parseInt(request.getParameter("id"));
        // buscar en la bbdd el elemento con ese id
        Language language = this.languageRepository.findById(id);
        // Recoger los datos desde la petición
        String name = request.getParameter("name");
        String lastUpdate = request.getParameter("lastUpdate");
        // Modifico el objeto con los datos de la petición
        language.setName(name);
        language.setLastUpdate(lastUpdate);
        // guardar los datos en la bbdd
        languageRepository.updateById(id, language);
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(200);
        ServletOutputStream out = response.getOutputStream();
        // Imprimir datos en la salida JSON
        StringBuilder salida = new StringBuilder();
        salida.append(language.toJson());
        out.print(salida.toString());
        // Cerrar la salida
        out.close();
    }

    private void read(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Recoger el Id del elemento a buscar
        Integer id = Integer.parseInt(request.getParameter("id"));
        // buscar en la bbdd el elemento con ese id
        Language language = this.languageRepository.findById(id);
        // Deveolver la respuesta
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(200);
        ServletOutputStream out = response.getOutputStream();
        // Imprimir datos en la salida JSON
        StringBuilder salida = new StringBuilder();
        salida.append(language.toJson());
        out.print(salida.toString());
        // Cerrar la salida
        out.close();
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Recoger los datos desde la petición
        String name = request.getParameter("name");
        String lastUpdate = request.getParameter("lastUpdate");
        // limpio los campos de posibles inyecciones
        // validaciones de los campos
        // Crear el objeto del leguaje a meter en la BBDD
        Language language = new Language();
        language.setName(name);
        language.setLastUpdate(lastUpdate);
        System.out.println(language);
        languageRepository.insert(language);
        // Deveolver la respuesta
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(200);
        ServletOutputStream out = response.getOutputStream();
        // Imprimir datos en la salida JSON
        StringBuilder salida = new StringBuilder();
        salida.append(language.toJson());
        out.print(salida.toString());
        // Cerrar la salida
        out.close();
    }

    public void list(HttpServletRequest request,
                     HttpServletResponse response) throws IOException, ServletException{
        var listado = this.languageRepository.findAll();
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(200);
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
