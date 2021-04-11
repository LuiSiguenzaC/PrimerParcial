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

/**
 *
 */
public class GM19008Servlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>calculadora de Operaciones Logicas</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            String Nombre = request.getParameter("txtNombre");
            String num1 = request.getParameter("txtNum1");
            String num2 = request.getParameter("txtNum2");
            String btnSumar = request.getParameter("btnSumar");
            String btnRestar = request.getParameter("btnRestar");
            String btnMultiplicar = request.getParameter("btnMultiplicar");
            String btnDividir = request.getParameter("btnDividir");
            Numeros primos = new Numeros();// llamamos la clase o metodo

            int VectorArray[] = primos.valorAgend(Integer.parseInt(num1), Integer.parseInt(num2));//ingresamos parametros y convertimos

            primos.cuentaVector(VectorArray);

            String numerosPrimos = "";

            int index = VectorArray.length - 1;
            for (int i = 0; i < VectorArray.length; i++) {
                if (i == index) {
                    numerosPrimos += VectorArray[i];
                } else {
                    numerosPrimos += VectorArray[i] + "-";
                }
            }
            if (btnSumar != null) {
                double resultado = Double.parseDouble(num1) + Double.parseDouble(num2);
                out.println("<h1>  Hola Bienvenido " + Nombre + "</h1><br>");
                out.println(" el resultado  es :" + resultado + ""
                        + "<h2> sus numeros primos son : </h2>"
                        + "<br>" + numerosPrimos + "<br>");
            }
            if (btnRestar != null) {
                double resultado = Double.parseDouble(num1) - Double.parseDouble(num2);
                out.println("<h1>Hola Bienvenido " + Nombre + "</h1><br>");
                out.println(" el resultado es :" + resultado + ""
                        + "<h2> sus numeros primos son : </h2>"
                        + "<br>" + numerosPrimos + "<br>");
            }
            if (btnMultiplicar != null) {
                double resultado = Double.parseDouble(num1) * Double.parseDouble(num2);
                out.println("<h1>Hola Bienvenido " + Nombre + "</h1><br>");
                out.println(" el resultado es :" + resultado + ""
                        + "<h2> sus numeros primos son : </h2>"
                        + "<br>" + numerosPrimos + "<br>");
            }
            if (btnDividir != null) {
                double resultado = Double.parseDouble(num1) / Double.parseDouble(num2);
                out.println("<h1> Hola Bienvenido " + Nombre + "</h1><br>");
                out.println(" el resultado es :" + resultado + ""
                        + "<h2> sus numeros primos son :  </h2>"
                        + "<br>" + numerosPrimos + "<br>");
            }
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        }
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
