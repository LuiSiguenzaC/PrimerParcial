/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MemeK
 */
public class operacion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            //declarando variables desde el index
            String user;
            int numero1 = Integer.parseInt(request.getParameter("numero1"));
            int numero2 = Integer.parseInt(request.getParameter("numero2"));
            int operacion = Integer.parseInt(request.getParameter("operacion"));
            user = request.getParameter("user");
            int resultado = 0;
            String opers = Integer.toString(operacion);

            //operaciones aritmeticas
            switch (operacion) {
                case 1:
                    resultado = numero1 + numero2;
                    opers = "suma";
                    break;
                case 2:
                    resultado = numero1 - numero2;
                    opers = "resta";
                    break;
                case 3:
                    resultado = numero1 * numero2;
                    opers = "multiplicacion";
                    break;
                case 4:
                    resultado = numero1 / numero2;
                    opers = "division";
                    break;
            }

            //imprimiendo todos los datos
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Bienvenida</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Bienvenido " + user + "</h1>");
            out.println("Sus numeros son:");
            out.println("<br>");
            out.println("<br>");
            out.println("Primer numero: " + numero1);
            out.println("<br>");
            out.println("<br>");
            out.println("Segundo numero: " + numero2);
            out.println("<br>");
            out.println("<br>");
            out.println(user + ", el resultado de la " + opers + " es: " + resultado);
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("Los numeros primos que estan en el rango de " + numero1 + " y " + numero2 + " son: ");

            //numeros primos
            int primos = 0;
            int orden = 0;
            if (numero2 < numero1) {
                for (int i = numero2; i <= numero1; i++) {
                    int count = 0;
                    for (int j = 1; j <= i; j++) {
                        if (i % j == 0) {
                            count++;
                        }
                    }
                    if (count == 2) {
                        primos++;
                    }
                }
                int vec[] = new int[primos];

                for (int i = numero2; i <= numero1; i++) {
                    int contador = 0;
                    for (int j = 1; j <= i; j++) {
                        if (i % j == 0) {
                            contador++;
                        }

                    }
                    if (contador == 2) {
                        vec[orden] = i;
                        orden++;
                    }
                }
                for (int i = 0; i < orden; i++) {
                    for (int j = i + 1; j < orden; j++) {
                        if (vec[i] < vec[j]) {
                            int aux = vec[i];
                            vec[i] = vec[j];
                            vec[j] = aux;
                        }
                    }
                }
                for (int i = 0; i < orden; i++) {
                    out.println(vec[i]);
                }
            }
            if (numero1 < numero2) {
                for (int i = numero1; i <= numero2; i++) {
                    int count = 0;
                    for (int j = 1; j <= i; j++) {
                        if (i % j == 0) {
                            count++;
                        }
                    }
                    if (count == 2) {
                        primos++;
                    }
                }
                int vec[] = new int[primos];

                for (int i = numero1; i <= numero2; i++) {
                    int contador = 0;
                    for (int j = 1; j <= i; j++) {
                        if (i % j == 0) {
                            contador++;
                        }

                    }
                    if (contador == 2) {
                        vec[orden] = i;
                        orden++;
                    }
                }
                for (int i = 0; i < orden; i++) {
                    for (int j = i + 1; j < orden; j++) {
                        if (vec[i] < vec[j]) {
                            int aux = vec[i];
                            vec[i] = vec[j];
                            vec[j] = aux;
                        }
                    }
                }
                for (int i = 0; i < orden; i++) {
                    out.println(vec[i]);
                }
            }
            out.println("</body>");
            out.println("</html>");
        }
    }
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
