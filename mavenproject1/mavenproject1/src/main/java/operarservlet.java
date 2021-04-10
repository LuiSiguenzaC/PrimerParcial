/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class operarservlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet operarservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet operarservlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            String user = request.getParameter("user");
            String n1 = request.getParameter("n1");
            String n2 = request.getParameter("n2");
            String suma = request.getParameter("sumar");
            String resta = request.getParameter("restar");
            String multi = request.getParameter("multiplicar");
            String div = request.getParameter("dividir");
           double resultado;
            
            out.println("BIENVENIDO/@  "+user);
            out.println("<br>");
            if (suma!=null){
                resultado = Double.parseDouble(n1)+Double.parseDouble(n2);
                out.println("<p>El resultado de la suma es = " + resultado+"</p>");  
            }else{
                if(resta!=null){
                    resultado = Double.parseDouble(n1)-Double.parseDouble(n2); 
                    out.println("<p>El resultado de la resta es = " + resultado+"</p>");
                }else{

                }if(multi!=null){
                    resultado = Double.parseDouble(n1)*Double.parseDouble(n2); 
                    out.println("<p>El resultado de la multiplicacion es = " + resultado+"</p>");
                }else{
                    if(div!=null){
                       resultado = (Double.parseDouble(n1))/(Double.parseDouble(n2));  
                       out.println("<p>El resultado de la division es = " + resultado+"</p>");
                    }else{

                    }
                }
          
        }
           out.println("<br>");
           
           
            int lim2 = Integer.parseInt(n2);
            int lim1 = Integer.parseInt(n1);
            for(int i=lim1;i<lim2;i++){
              int aumen=2;
              int esprimo=1;
              while(esprimo<1 && aumen < i){
              if(i%aumen ==0){
                  esprimo=0;
              }
              else{
                  aumen++;
              }   
              }
              if(esprimo==1){
                out.println(i+" Es primo \n");
              }
                 
             
          }
         
           for(int i=lim2;i<lim1;i++){
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
                
                  out.println(i+" Es primo <br>");
               
              }
                 
             
          }

            out.println("<h1>Servlet central at " + request.getContextPath() + "</h1>");
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
