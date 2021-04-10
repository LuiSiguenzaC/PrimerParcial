
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/Bienvenida"})
public class Bienvenida extends HttpServlet {

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
     String nombre,numerUno,numerDos,operacion,respuesta, salida="";
     int  numeroUno,numeroDos,resultado=0,numeros[] ,hasta=0,fila=0;
     HttpSession sesion=request.getSession();
     nombre=request.getParameter("nombreUsuario");
     numerUno=request.getParameter("numeroUno");
    numerDos=request.getParameter("numeroDos");
operacion=request.getParameter("operaciones");
 numeroUno=Integer.parseInt(numerUno);
 numeroDos=Integer.parseInt(numerDos);

    if (operacion.equals("Suma")){
resultado=numeroUno+numeroDos;


}

    if (operacion.equals("Resta")){
resultado=numeroUno-numeroDos;
}
 if (operacion.equals("Multiplicacion")){
resultado=numeroUno*numeroDos;

}

    if (operacion.equals("Division")){
resultado=numeroUno/numeroDos;
}

respuesta=String.valueOf(resultado);
 if(numeroUno>numeroDos){//primer numero es mayor
  for(int i=numeroDos;i<numeroUno;i++){
            int count=0;
            for(int j=1;j<=i;j++){
                if(i%j==0){
                    count++;
                }
            }
            if(count==2){
                hasta=hasta+1;
            }
        }
       numeros= new int[hasta];
        for(int i=numeroDos;i<numeroUno;i++){
            int count=0;
            for(int j=1;j<=i;j++){
                if(i%j==0){
                    count++;
                }
            }
            if(count==2){
          
                    numeros[fila]=i;
                    fila++;
                   
                }
                
            }
        for(int i=hasta-1;i>=0;i--){
           
           salida=salida+numeros[i]+"\t";


        }
      

}
if (numeroUno<numeroDos){//segundo numero es mayor
  for(int i=numeroUno;i<numeroDos;i++){
            int count=0;
            for(int j=1;j<=i;j++){
                if(i%j==0){
                    count++;
                }
            }
            if(count==2){
                hasta=hasta+1;
            }
        }
       numeros= new int[hasta];
        for(int i=numeroUno;i<numeroDos;i++){
            int count=0;
            for(int j=1;j<=i;j++){
                if(i%j==0){
                    count++;
                }
            }
            if(count==2){
          
                    numeros[fila]=i;
                    fila++;
                   
                }
                
            }
        for(int i=hasta-1;i>=0;i--){
           
           salida=salida+numeros[i]+"\t";
        }
         

}
if(numeroUno<0 && numeroDos<0){
salida="Los numeros primos son mayores a 1";
}
sesion.setAttribute("primos",salida);
sesion.setAttribute("respuesta",respuesta);
sesion.setAttribute("operacion",operacion);
sesion.setAttribute("nombre",nombre);
response.sendRedirect("SesionOpen.jsp");


 
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
