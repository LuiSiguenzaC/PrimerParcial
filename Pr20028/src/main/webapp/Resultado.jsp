<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Respuesta</title>
    </head>
    <body>
        <h1>Bienvenido <%out.print(session.getAttribute("usuario"));%></h1><br>
        <p>El resutado de la <%out.print(session.getAttribute("operacion"));%> es: <%out.print(session.getAttribute("result"));%> </p>
        <p>Los numeros primos entre los numeros son: <%out.print(session.getAttribute("salida"));%>  </p>
    </body>
</html>
