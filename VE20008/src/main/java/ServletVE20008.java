
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletVE20008 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            //INICIO DEL PROGRAMA
            int NumeroAritmetica1 = Integer.parseInt(request.getParameter("NumeroAritmetica1"));

            int NumeroAritmetica2 = Integer.parseInt(request.getParameter("NumeroAritmetica2"));
            int operacion = Integer.parseInt(request.getParameter("operacion"));
            String usuario;
            usuario = request.getParameter("usuario");
            int total = 0;

            String operacionAritmetica = Integer.toString(operacion);

            //OPERACIONES SUMA, RESTA, MULTIPLICACION Y DIVISION
            switch (operacion) {
                case 1:
                    total = NumeroAritmetica1 + NumeroAritmetica2;
                    operacionAritmetica = "suma";
                    break;
                case 2:
                    total = NumeroAritmetica1 - NumeroAritmetica2;
                    operacionAritmetica = "resta";
                    break;
                case 3:
                    total = NumeroAritmetica1 * NumeroAritmetica2;
                    operacionAritmetica = "multiplicacion";
                    break;
                case 4:
                    total = NumeroAritmetica1 / NumeroAritmetica2;
                    operacionAritmetica = "division";
                    break;
            }
            
            //DATOS
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Bienvenida al usuario</title>");
            out.println("</head>");
            out.println("<body style='background-color:IndianRed;'>");
            out.println("<h1>Bienvenido " + usuario + "</h1>");
            out.println("Respuetas al usuario : " + usuario);
            out.println("<br>");
            out.println("<br>");
            out.println("Los numeros son:");
            out.println("<br>");
            out.println("Primer numero: " + NumeroAritmetica1);
            out.println("<br>");
            out.println("Segundo numero: " + NumeroAritmetica2);
            out.println("<br>");
            out.println("El total de la " + operacionAritmetica + " es: " + total);
            out.println("<br>");
            out.println("<br>");
            out.println("Los numeros primos entre " + NumeroAritmetica1 + " y " + NumeroAritmetica2 + " son: ");

            //SOLUCION A MOSTRAR NUMEROS PRIMOS
            int OrdenNumeros = 0, NumerosPrimos = 0;
            if (NumeroAritmetica2 < NumeroAritmetica1) {
                for (int Valor1 = NumeroAritmetica2; Valor1 <= NumeroAritmetica1; Valor1++) {
                    int Contador = 0;
                    for (int Valor2 = 1; Valor2 <= Valor1; Valor2++) {
                        if (Valor1 % Valor2 == 0) {
                            Contador++;
                        }
                    }
                    if (Contador == 2) {
                        NumerosPrimos++;
                    }
                }
                int VectorPrimo[] = new int[NumerosPrimos];

                for (int Valor1 = NumeroAritmetica2; Valor1 <= NumeroAritmetica1; Valor1++) {
                    int contador = 0;
                    for (int Valor2 = 1; Valor2 <= Valor1; Valor2++) {
                        if (Valor1 % Valor2 == 0) {
                            contador++;
                        }

                    }
                    if (contador == 2) {
                        VectorPrimo[OrdenNumeros] = Valor1;
                        OrdenNumeros++;
                    }
                }
                for (int Valor1 = 0; Valor1 < OrdenNumeros; Valor1++) {
                    for (int Valor2 = Valor1 + 1; Valor2 < OrdenNumeros; Valor2++) {
                        if (VectorPrimo[Valor1] < VectorPrimo[Valor2]) {
                            int VariableResultadoVector = VectorPrimo[Valor1];
                            VectorPrimo[Valor1] = VectorPrimo[Valor2];
                            VectorPrimo[Valor2] = VariableResultadoVector;
                        }
                    }
                }
                for (int Valor1 = 0; Valor1 < OrdenNumeros; Valor1++) {
                    out.println(VectorPrimo[Valor1]);
                }
            }
            if (NumeroAritmetica1 < NumeroAritmetica2) {
                for (int Valor1 = NumeroAritmetica1; Valor1 <= NumeroAritmetica2; Valor1++) {
                    int Contador = 0;
                    for (int Valor2 = 1; Valor2 <= Valor1; Valor2++) {
                        if (Valor1 % Valor2 == 0) {
                            Contador++;
                        }
                    }
                    if (Contador == 2) {
                        NumerosPrimos++;
                    }
                }
                int VectorPrimo[] = new int[NumerosPrimos];

                for (int Valor1 = NumeroAritmetica1; Valor1 <= NumeroAritmetica2; Valor1++) {
                    int ContadorPrimo = 0;
                    for (int Valor2 = 1; Valor2 <= Valor1; Valor2++) {
                        if (Valor1 % Valor2 == 0) {
                            ContadorPrimo++;
                        }
                    }
                    if (ContadorPrimo == 2) {
                        VectorPrimo[OrdenNumeros] = Valor1;
                        OrdenNumeros++;
                    }
                }
                for (int Valor1 = 0; Valor1 < OrdenNumeros; Valor1++) {
                    for (int Valor2 = Valor1 + 1; Valor2 < OrdenNumeros; Valor2++) {
                        if (VectorPrimo[Valor1] < VectorPrimo[Valor2]) {
                            int VariableResultadoVector = VectorPrimo[Valor1];
                            VectorPrimo[Valor1] = VectorPrimo[Valor2];
                            VectorPrimo[Valor2] = VariableResultadoVector;
                        }
                    }
                }
                for (int Valor1 = 0; Valor1 < OrdenNumeros; Valor1++) {
                    out.println(VectorPrimo[Valor1]);
                }
                out.println("</body>");
                out.println("</html>");
            }
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