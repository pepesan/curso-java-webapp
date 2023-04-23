<%--
  Created by IntelliJ IDEA.
  User: pepesan
  Date: 31/1/22
  Time: 5:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="application/json;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
[<c:forEach items="${listado}" var="element">
    {
        "id": "${element.languageId}",
        "name": "${element.name}",
        "lastUpdate": "${element.lastUpdate}"
    }
</c:forEach>
]
