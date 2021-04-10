
package aREVALO.servletcc;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class servletCc extends HttpServlet {

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
            out.println("<title>Servlet servletCc</title>");            
            out.println("</head>");
            out.println("<body background=https://image.freepik.com/foto-gratis/numeros-colores-sobre-fondo-blanco-copia-espacio_23-2148416155.jpg>");
             out.println("<h2>"+"<center>"+"<br>"+"<br>");
       String nombre= request.getParameter("usuario");    
    String numero1= request.getParameter("numero1");
    String numero2= request.getParameter("numero2");
     String sumar= request.getParameter("Sumar");
      String restar= request.getParameter("Restar");
       String multiplicar= request.getParameter("Multiplicar");
        String dividir= request.getParameter("Dividir");
           String nPrimos = "";
        int resultado=0;
         double resultad=0;
         Primos pmos= new Primos();
           int Contenedor[] = pmos.guardarLP(Integer.parseInt(numero1), Integer.parseInt(numero2));
            pmos.conteoVector(Contenedor);
              int tamanio = Contenedor.length - 1;
            for (int posicion = 0; posicion < Contenedor.length; posicion++) {
                if (posicion == tamanio) {
                    nPrimos += Contenedor[posicion];
                } else {
                    nPrimos += Contenedor[posicion] + "||";
                }
            }
       if(sumar!=null){
       resultado=Integer.parseInt(numero1)+Integer.parseInt(numero2);
        out.println("Nombre del usuario: "+nombre+"<br>La operacion matematica seleccionada es Suma<br>"+"El Resultado de la suma es: "+resultado + "<h3> Numeros Primos en el rago de numero introducidos ["+numero1+";"+numero2+"]</h3>"
                        + "<br>" + nPrimos+ "");
        
       }else if(restar!=null){
       resultado=Integer.parseInt(numero1)-Integer.parseInt(numero2);
        out.println("Nombre del usuario: "+nombre+"<br>La operacion matematica seleccionada es Resta<br>"+"El Resultado de la resta es: "+resultado + "<h3> Numeros Primos en el rago de numero introducidos ["+numero1+";"+numero2+"]</h3>"
                        + "<br>" + nPrimos+ "");
       }else if(multiplicar !=null){
       resultado=Integer.parseInt(numero1)*Integer.parseInt(numero2);
       out.println("Nombre del usuario: "+nombre+"<br>La operacion matematica seleccionada es Multiplicacion<br>"+"El Resultado de la multiplicacion es: "+resultado + "<h3> Numeros Primos en el rago de numero introducidos ["+numero1+";"+numero2+"]</h3>"
                        + "<br>" + nPrimos+ "");
       }else if(dividir !=null){
       resultad=Double.parseDouble(numero1)/Double.parseDouble(numero2);
       out.println("Nombre del usuario: "+nombre+"<br>La operacion matematica seleccionada es Divicion<br>"+"El Resultado de la divicion es: "+resultad + "<h3> Numeros Primos en el rago de numero introducidos ["+numero1+";"+numero2+"]</h3>"
                        + "<br>" + nPrimos+ "");
       }
       
 
    out.println("</center>"+"</h2>");
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
