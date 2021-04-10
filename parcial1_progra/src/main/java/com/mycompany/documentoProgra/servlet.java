
package com.mycompany.documentoProgra;

import java.util.Arrays;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Index", urlPatterns = {"/Index"})
public class servlet extends HttpServlet {

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
       String nombre = request.getParameter("Nombre");
        String digito_1 = request.getParameter("digito_1");
        String digito_2 = request.getParameter("digito_2");
        String operacion = request.getParameter("digito_3");

        int dig_1 = Integer.parseInt(digito_1);
        int dig_2 = Integer.parseInt(digito_2);
        int dig_3 = Integer.parseInt(operacion);
        int resultado,limite;
        double result;

        if(dig_1 >dig_2){
            limite = dig_1 - dig_2;
        }else{
            limite = dig_2 - dig_1;
        }
        int[] primos = new int[(limite + 1)];

        int contador = 0;
        if (dig_2 > dig_1) {
            for (int i = dig_1; i <= dig_2; i++) {
                if (esPrimo(i)) {
                    primos[contador] = i;
                }
                contador++;
            }
        }else{
           for (int i = dig_2; i <= dig_1; i++) {
                if (esPrimo(i)) {
                    primos[contador] = i;
                }
                contador++;
            } 
        }

        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Index</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<h2>Bienvenid@ </h2>");

            switch (dig_3) {
                case 1:
                    resultado = dig_1 + dig_2;
                    out.println("<p>" + nombre + " el resultado  es: " + resultado + "</p>");
                    out.println("<p>Los numeros primos   son: </p>");
                    Arrays.sort(primos);  
                    for (int i = primos.length-1; i >= 0; i--) {
                        if(primos[i] != 0){
                            out.println("<p>" + Integer.toString(primos[i]) + "</p>");
                        }                        
                    }
                    break;
                case 2:
                    resultado = dig_1 - dig_2;
                    out.println("<p>" + nombre + " el resultado  es: " + resultado + "</p>");
                    Arrays.sort(primos);  
                    for (int i = primos.length-1; i >= 0; i--) {
                        if(primos[i] != 0){
                            out.println("<p>" + Integer.toString(primos[i]) + "</p>");
                        }                        
                    }
                    break;
                case 3:
                    resultado = dig_1 * dig_2;
                    out.println("<p>" + nombre + " el resultado  es: " + resultado + "</p>");
                    Arrays.sort(primos);  
                    for (int i = primos.length-1; i >= 0; i--) {
                        if(primos[i] != 0){
                            out.println("<p>" + Integer.toString(primos[i]) + "</p>");
                        }                        
                    }
                    break;
                case 4:
                    result = dig_1 / dig_2;
                    out.println("<p>" + nombre + " el resultado  es: " + result + "</p>");
                    Arrays.sort(primos);  
                    for (int i = primos.length-1; i >= 0; i--) {
                        if(primos[i] != 0){
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

