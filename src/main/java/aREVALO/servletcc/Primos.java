package aREVALO.servletcc;

public class Primos {


  public int Superior(int numero1, int numero2){

        if (numero1 > numero2){
            return numero1;
        }
        return numero2;
    }

    public int inferior(int numero1, int numero2){

        if (numero1 < numero2){
            return numero1;
        }
        return numero2;
    }
    public boolean esPrimo(int numero) {


        int inicio = 2;
        boolean prmo = true;

        while (inicio<= (numero / 2)) {

            if (numero % inicio== 0) {
                prmo = false;

                break;
            }
            inicio++;
        }

        return prmo;

    }

    public  int contadorPrimos(int numero1, int numero2) {

        int fin = Superior(numero1,numero2);
        int iniciaConteo = inferior(numero1,numero2);
        int contar = 0;

        for (int i = iniciaConteo; i <= fin; i++) {

            if (esPrimo(i)) {
                contar++;
            }
        }
        return contar;
    }

    public int[] guardarLP (int numero1, int numero2) {

        int finaliza = Superior(numero1,numero2);
        int inicia= inferior(numero1,numero2);
        int tamanio = contadorPrimos(numero1, numero2);

        int contPrimos[] = new int[tamanio];

        int entrada = 0;
        for (int i = inicia; i <= finaliza; i++) {
            if (esPrimo(i)) {
                contPrimos[entrada] = i;
                entrada++;
            }

        }

        return contPrimos;
    }

    public void conteoVector(int vector[]) {

        int limite = vector.length;

        int dato[] = new int[limite];
        int entrada = limite - 1;

        for (int i = 0; i < limite; i++) {
            dato[i] = vector[entrada];

            entrada--;
        }

        entrada = 0;
        for (int i : dato) {
            vector[entrada] = i;
            entrada++;
        }
    }

    public void MostrarVector(int vectorcito[]) {

        for (int i : vectorcito) {
            System.out.println(i);
        }
    }

}
