# Ejemplo de uso de Arquetipo Webapp Maven
# Compilación
<code>$ mvn clean compile</code>
# Empaquetado
<code>$ mvn clean compile package</code>
# Despliegue en Tomcat 10 embebido
<code>mvn clean package org.codehaus.cargo:cargo-maven3-plugin:run</code>
## referencia
https://codehaus-cargo.github.io/cargo/Tomcat+10.x.html

parámetro para cambiar el puerto:
-Dcargo.servlet.port=9001
# Acceso a la aplicación
[URL a la aplicación](http://localhost:8080/webapp01)

# TODO
* Todas las consultas se hacen desde una única conexión a BBDD
* No estamos reflejando ningún tipo de error ante entradas que puedan fallar
* No estamos manejando datos JSON pasados por el Body
* No estamos manejando realmente las excepciones
* Dividir el código en un controlador y no dejar el código en el Servlet