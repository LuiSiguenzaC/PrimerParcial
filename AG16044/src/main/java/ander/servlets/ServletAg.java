/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ander.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anderson
 */
public class ServletAg extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletAg</title>");            
            out.println("</head>");
            out.println("<body>");
            String nombre=request.getParameter("nombre");
            String numero1=request.getParameter("numero1");
            String numero2=request.getParameter("numero2");
            String Suma=request.getParameter("sumar");
            String Resta=request.getParameter("restar");
            String Multiplicar=request.getParameter("multiplicar");
            String Dividir=request.getParameter("dividir");
            int resultado=0;
            String operacion="";
            int contador=0;
            if(Suma!=null){
            operacion="suma";
                resultado=Integer.parseInt(numero1)+Integer.parseInt(numero2);
            }else if(Resta!=null){
            operacion="resta";
                resultado=Integer.parseInt(numero1)-Integer.parseInt(numero2);
            }else if(Multiplicar!=null){
            operacion="multiplicacion";
                resultado=Integer.parseInt(numero1)*Integer.parseInt(numero2);    
            }else{
            operacion="division";
                resultado=Integer.parseInt(numero1)/Integer.parseInt(numero2); 
            }
            out.println(nombre+" el resultado de la "+operacion+" es:"+resultado);
            for(int inicio=1; inicio<resultado; inicio++){
            contador=0;
            if(inicio%resultado==0){
            contador++;
}
}  
        out.println(" los numeros primos son:"+contador); 


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
