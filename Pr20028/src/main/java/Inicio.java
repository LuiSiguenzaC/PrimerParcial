
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            String usuario, numeroUno, numeroDos, operacion, result, salida = "";
            int numUno, numDos, resultado = 0, numeros[], hasta = 0, fila = 0;
            HttpSession sesion = request.getSession();
            usuario = request.getParameter("nameUser");
            numeroUno = request.getParameter("primerNum");
            numeroDos = request.getParameter("segundoNum");
            operacion = request.getParameter("operaciones");
            numUno = Integer.parseInt(numeroUno);
            numDos = Integer.parseInt(numeroDos);
            if (operacion.equals("Suma")) {
                resultado = numUno + numDos;
            }
            if (operacion.equals("Resta")) {
                resultado = numUno - numDos;
            }
            if (operacion.equals("Multiplicacion")) {
                resultado = numUno * numDos;
            }
            if (operacion.equals("Division")) {
                resultado = numUno / numDos;
            }
            result = String.valueOf(resultado);
            if (numUno > numDos) {//para cuando el primer numero es mayor
                for (int i = numDos; i < numUno; i++) {
                    int count = 0;
                    for (int j = 1; j <= i; j++) {
                        if (i % j == 0) {
                            count++;
                        }
                    }
                    if (count == 2) {
                        hasta = hasta + 1;
                    }
                }
                numeros = new int[hasta];
                for (int i = numDos; i < numUno; i++) {
                    int count = 0;
                    for (int j = 1; j <= i; j++) {
                        if (i % j == 0) {
                            count++;
                        }
                    }
                    if (count == 2) {

                        numeros[fila] = i;
                        fila++;

                    }

                }
                for (int i = hasta - 1; i >= 0; i--) {
                    salida = salida + numeros[i] + "\t";
                }

            }
            if (numUno < numDos) {//para cuando es mayor el segundo
                for (int i = numUno; i < numDos; i++) {
                    int count = 0;
                    for (int j = 1; j <= i; j++) {
                        if (i % j == 0) {
                            count++;
                        }
                    }
                    if (count == 2) {
                        hasta = hasta + 1;
                    }
                }
                numeros = new int[hasta];
                for (int i = numUno; i < numDos; i++) {
                    int count = 0;
                    for (int j = 1; j <= i; j++) {
                        if (i % j == 0) {
                            count++;
                        }
                    }
                    if (count == 2) {

                        numeros[fila] = i;
                        fila++;

                    }

                }
                for (int i = hasta - 1; i >= 0; i--) {
                    salida = salida + numeros[i] + "\t";
                }

            }
            if (numUno < 0 && numDos < 0) {//cuando son negativos 
                salida = "Los numeros primos son mayores 1";
            }
            
            sesion.setAttribute("salida",salida);
            sesion.setAttribute("result", result);
            sesion.setAttribute("operacion", operacion);
            sesion.setAttribute("usuario", usuario);
            response.sendRedirect("Resultado.jsp");
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
