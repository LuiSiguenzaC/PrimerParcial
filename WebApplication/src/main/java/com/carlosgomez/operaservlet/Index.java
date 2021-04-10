/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosgomez.operaservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */


@WebServlet(name = "Index", urlPatterns = {"/Index"})
public class Index extends HttpServlet {

    public static boolean esPrimo(int numero) {
        int contador = 2;
        boolean primo = true;
        while ((primo) && (contador != numero)) {
            if (numero % contador == 0) {
                primo = false;
            }
            contador++;
        }
        return primo;
    }
    
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

        String nombres = request.getParameter("Nombres");
        String numero1 = request.getParameter("Numero1");
        String numero2 = request.getParameter("Numero2");
        String operacion = request.getParameter("Numero3");

        int num1 = Integer.parseInt(numero1);
        int num2 = Integer.parseInt(numero2);
        int num3 = Integer.parseInt(operacion);
        int resultado,limite;
        double result;

        if(num1 >num2){
            limite = num1 - num2;
        }else{
            limite = num2 - num1;
        }
        int [] primos = new int[(limite + 1)];

        int contador = 0;
        if (num2 > num1) {
            for (int i = num1; i <= num2; i++) {
                if (esPrimo(i)) {
                    primos[contador] = i;
                }
                contador++;
            }
        }else{
           for (int i = num2; i <= num1; i++) {
                if (esPrimo(i)) {
                    primos[contador] = i;
                }
                contador++;
            }
        }
                
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Index</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<h2>Bienvenido señor " + nombres + "</h2>");

            switch (num3) {
                case 1:
                    resultado = num1 + num2;
                    out.println("<p>" + nombres + " el resultado de la suma es: " + resultado + "</p>");
                    out.println("<p>Los numeros primos entre " + num1 + " y " + num2 + " numeros son: </p>");
                    Arrays.sort(primos);  
                    for (int i = primos.length-1; i >= 0; i--) {
                        if(primos[i] != 0){
                            out.println("<p>" + Integer.toString(primos[i]) + "</p>");
                        }                        
                    }
                    break;
                case 2:
                    resultado = num1 - num2;
                    out.println("<p>" + nombres + " el resultado de la resta es: " + resultado + "</p>");
                    out.println("<p>Los numeros primos entre " + num1 + " y " + num2 + " numeros son: </p>");
                    Arrays.sort(primos);  
                    for (int i = primos.length-1; i >= 0; i--) {
                        if(primos[i] != 0){
                            out.println("<p>" + Integer.toString(primos[i]) + "</p>");
                        }                        
                    }
                    break;
                case 3:
                    resultado = num1 * num2;
                    out.println("<p>" + nombres + " el resultado de la multipliacion es: " + resultado + "</p>");
                    out.println("<p>Los numeros primos entre " + num1 + " y " + num2 + " numeros son: </p>");
                    Arrays.sort(primos);
                    for (int i = primos.length - 1; i >= 0; i--) {
                        if (primos[i] != 0) {
                            out.println("<p>" + Integer.toString(primos[i]) + "</p>");
                        }
                    }
                    break;
                case 4:
                    result = num1 / num2;
                    out.println("<p>" + nombres + " el resultado de la division es: " + result + "</p>");
                    out.println("<p>Los numeros primos entre " + num1 + " y " + num2 + " numeros son: </p>");
                    Arrays.sort(primos);
                    for (int i = primos.length - 1; i >= 0; i--) {
                        if (primos[i] != 0) {
                            out.println("<p>" + Integer.toString(primos[i]) + "</p>");
                        }
                    }
                    break;
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
