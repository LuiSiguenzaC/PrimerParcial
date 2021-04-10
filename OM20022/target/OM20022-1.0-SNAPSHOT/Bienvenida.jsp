

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session= "true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenida</title>
    </head>
    <body>
        <h1>Bienvenido <%out.println(session.getAttribute("user"));%></h1>
        <form name="login" action="Resultado.jsp" method="POST">            
            Ingrese el primer número
            <input type="number" name="numero1" id="numero1" required="">
            <br>
            Ingrese el segundo número
            <input type="number" name="numero2" id="numero2" required="">
            <br>
            <label>Operación :</label>
            <br>
            <input type="submit" name="suma" Value="Suma"><br>
            <input type="submit" name="resta" Value="Resta"><br>
            <input type="submit" name="multiplicacion" Value="Multiplicación"><br>
            <input type="submit" name="division" Value="División"><br>
            
        </form>
    </body>
</html>
