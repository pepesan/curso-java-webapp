<%--
  Created by IntelliJ IDEA.
  User: pepesan
  Date: 31/1/22
  Time: 5:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Prueba de paso de parametros</title>
</head>
<body>
<p><a href="${pageContext.request.contextPath}/index.jsp">Inicio</a> </p>
<p>The data from servlet: ${data}</p>
<p>Numero pasado a la vista: ${numero}</p>
<p>Numero pasado a la vista: ${numero2}</p>

</body>
</html>

