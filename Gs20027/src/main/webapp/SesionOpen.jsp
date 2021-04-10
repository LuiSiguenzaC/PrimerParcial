<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido <%out.println(session.getAttribute("nombre"));%></h1><br>
        <p>El resultado de la  <%out.println(session.getAttribute("operacion"));%>  es:<%out.println(session.getAttribute("respuesta"));%> </p>
         <p>Los numeros primos comprendidos:<%out.println(session.getAttribute("primos"));%> </p>
        
    </body>
</html>

