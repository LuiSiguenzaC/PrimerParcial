/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package josuek.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author isma
 */
public class SumaServlet extends HttpServlet {

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
            out.println("<title>Servlet SumaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            String user=request.getParameter("user");
            String numero1 = request.getParameter("numero1");
            String numero2 = request.getParameter("numero2");
            String suma = request.getParameter("sumar");
            String resta = request.getParameter("restar");
            String multiplicacion = request.getParameter("multiplicar");
            String division = request.getParameter("dividir");
           double resultado=0;
        
          out.println("BIENVENIDO/@  "+user);
         out.println("<br>");
          if (suma!=null){
              resultado = Double.parseDouble(numero1)+Double.parseDouble(numero2);
            out.println("El resultado de la suma es = " + resultado);
             
          }else{
              
              if(resta!=null){
                  resultado = Integer.parseInt(numero1)-Integer.parseInt(numero2); 
                  out.println("El resultado de la resta es = " + resultado);
              }else{
                  
              }if(multiplicacion!=null){
                  resultado = Integer.parseInt(numero1)*Integer.parseInt(numero2); 
                  out.println("El resultado de la multiplicacion es = " + resultado);
              }else{
                  if(division!=null){
                     resultado = (Double.parseDouble(numero1))/(Double.parseDouble(numero2));  
                     out.println("El resultado de la division es = " + resultado);
                  }else{
                      
                  }
              }
          
        }
           out.println("<br>");
           
           
            int limite2 = Integer.parseInt(numero2);
           int limite1 = Integer.parseInt(numero1);
          for(int i=limite1;i<limite2;i++){
              int creciente=2;
              boolean esprimo=true;
              while(esprimo && creciente < i){
              if(i%creciente ==0){
                  esprimo=false;
              }
              else{
                  creciente++;
              }   
              }
              if(esprimo){
                out.println(i+" Es primo \n");
              }
                 
             
          }
         
           for(int i=limite2;i<limite1;i++){
              int creciente=2;
              boolean esprimo=true;
              while(esprimo && creciente < i){
              if(i%creciente ==0){
                  esprimo=false;
              }
              else{
                  creciente++;
              }   
              }
              if(esprimo){
                
                  out.println(i+" Es primo \n");
               
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
