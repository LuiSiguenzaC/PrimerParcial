/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.industries.programacion.cg20028;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Robin
 */
public class PrimerParcial extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PrimerParcial</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            //out.println("<h1>Servlet PrimerParcial at " + request.getContextPath() + "</h1>");

            int num1 = Integer.parseInt(request.getParameter("numero1"));
            int num2 = Integer.parseInt(request.getParameter("numero2"));
            int contador1;
            int contador2;
            int inf = 0;
            int sup = 0;

            String nombre = request.getParameter("nombre");
            String suma = request.getParameter("botonSuma");
            String resta = request.getParameter("botonResta");
            String multiplicacion = request.getParameter("botonMultiplicacion");
            String divicion = request.getParameter("botonDivicion");
            String Primos = "";

            if (num1 > num2) {
                sup = num1;
                inf = num2;
            } else if (num1 < num2) {
                sup = num2;
                inf = num1;
            }

            Primos = "";
            for (contador1 = inf; contador1 <= sup; contador1++) {
                int contador = 0;
                for (contador2 = 1; contador2 <= contador1; contador2++) {
                    if ((contador1 % contador2) == 0) {
                        contador++;
                    }
                }
                if (contador == 2) {
                    Primos += contador1 + " ";
                }
            }

            String verPrimos[] = Primos.split(" ");
            Primos = "";
            for (int i = verPrimos.length - 1; i > 0; i--) {
                Primos += verPrimos[i] + "  ";
            }

            if (suma != null) {
                int resultado = num1 + num2;
                out.print("<H3> Bienvenido: " + nombre + "</H3><br>");
                out.print("<H3> El resultado de la suma es: </H3>" + resultado);
                out.print("<H3> Los números primos son: </H3>" + Primos);

            }
            if (resta != null) {
                int resultado = num1 - num2;
                out.print("<H3> Bienvenido: " + nombre + "</H3><br>");
                out.print("<H3> El resultado de la resta es: </H3>" + resultado);
                out.print("<H3> Los números primos son: </H3>" + Primos);

            }
            if (multiplicacion != null) {
                int resultado = num1 * num2;
                out.print("<H3> Bienvenido: " + nombre + "</H3><br>");
                out.print("<H3> El resultado de la multiplicación es: </H3> " + resultado);
                out.print("<H3> Los números primos son: </H3>" + Primos);

            }
            if (divicion != null) {
                int resultado = num1 / num2;
                out.print("<H3> Bienvenido: " + nombre + "</H3><br>");
                out.print("<H3> El resultado de la divición es: </H3>" + resultado);
                out.print("<H3> Los números primos son: </H3>" + Primos);

            }

            out.println("</center>");
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
