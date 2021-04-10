/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.zamora.programac.PaquetEjercicio;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dali
 */
public class ServletEjercicio extends HttpServlet {

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
        String num1=request.getParameter("num1");//primer numero
        int numero1=Integer.parseInt(num1);
        String num2=request.getParameter("num2");//segundo numero
        int numero2=Integer.parseInt(num2);
        String opcion=request.getParameter("operacion");//operacion a elegir
        int opciones=Integer.parseInt(opcion);
        int respuesta;
        
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletEjercicio</title>");            
            out.println("</head>");
            out.println("<body>");
            switch (opciones) {//codigo principal
                case 1:
                    respuesta = numero1 + numero2;
                    out.println("<p>" + "El resultado de la suma es:" + respuesta + "</p>");

                case 2:
                    respuesta = numero1 - numero2;
                    out.println("<p>" + "El resultado de la resta es:" + respuesta + "</p>");

                case 3:
                    respuesta = numero1 * numero2;
                    out.println("<p>" + "El resultado de la multiplicacion es:" + respuesta + "</p>");

                case 4:
                    respuesta = numero1 / numero2;
                    out.println("<p>" + "El resultado de la division es:" + respuesta + "</p>");
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
