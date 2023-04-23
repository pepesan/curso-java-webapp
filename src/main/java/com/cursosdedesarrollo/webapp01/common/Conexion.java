package com.cursosdedesarrollo.webapp01.common;

import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;

import static com.cursosdedesarrollo.webapp01.common.Config.*;


@Data
public class Conexion {

    private Connection connection;

    public Conexion(){
        loadDriver();
        connect();
    }

    Conexion( Connection connection){
        loadDriver();
        this.connection = connection;
    }

    private void loadDriver(){
        try {
            Class.forName (DRIVER_NAME)
                    .newInstance ();
        }catch (Exception e){
            System.out.printf("Fallo en la carga del driver");
        }
    }


    private void connect(){
        try {

            // Apertura de la Conexión a BBDD
            connection = DriverManager
                    .getConnection (URL, USERNAME, PASSWORD);
            System.out.println(connection);
            System.out.println("Aplicación Conectada Correctamente");
        }catch (Exception e){
            System.out.printf("Error");
        }

    }

}
