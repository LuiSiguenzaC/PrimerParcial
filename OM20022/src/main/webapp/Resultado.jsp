

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session= "true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
    </head>
    <body>
        <h1><%out.println(session.getAttribute("user"));%></h1>
        <%  String numero1 = request.getParameter("numero1");
            String numero2 = request.getParameter("numero2");

            String suma = request.getParameter("suma");
            String resta = request.getParameter("resta");
            String multiplicacion = request.getParameter("multiplicacion");
            String division = request.getParameter("division");
            int resultado;
            int limite;
            if (suma != null) {
                resultado = Integer.parseInt(numero1) + Integer.parseInt(numero2);
                out.println("El resultado de la suma es: " + resultado);
                ;%><br>Los números primos del resultado son:<%
                        limite = resultado;
                        for (int i = 1; i < limite; i++) {
                            int contador = 0;
                            for (int j = 1; j <= i; j++) {
                                if (i % j == 0) {
                                    contador++;
                                }
                            }
                            if (contador == 2) {
                                out.println(i);
                            }
                        }
                    }
                    if (resta != null) {
                        resultado = Integer.parseInt(numero1) - Integer.parseInt(numero2);
                        out.println("El resultado de la resta es: " + resultado);
                        ;%><br>Los números primos del resultado son:<%
                                limite = resultado;
                                for (int i = 1; i < limite; i++) {
                                    int contador = 0;
                                    for (int j = 1; j <= i; j++) {
                                        if (i % j == 0) {
                                            contador++;
                                        }
                                    }
                                    if (contador == 2) {
                                        out.println(i);
                                    }
                                }
                            }
                            if (multiplicacion != null) {
                                resultado = Integer.parseInt(numero1) * Integer.parseInt(numero2);
                                out.println("El resultado de la multiplicación es: " + resultado);
                                ;%><br>Los números primos del resultado son:<%
        limite = resultado;
        for (int i = 1; i < limite; i++) {
            int contador = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    contador++;
                }
            }
            if (contador == 2) {
                out.println(i);
            }
        }
    }
    if (division != null) {
        resultado = Integer.parseInt(numero1) / Integer.parseInt(numero2);
        out.println("El resultado de la división es: " + resultado);
        ;%><br>Los números primos del resultado son:<%
        limite = resultado;
        for (int i = 1; i < limite; i++) {
            int contador = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    contador++;
                }
            }
            if (contador == 2) {
                out.println(i);
            }
        }
    }
    ;%>
    </body>
</html>
