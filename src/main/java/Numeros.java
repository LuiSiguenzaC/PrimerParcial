/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 */
public class Numeros {

    public int mayor(int num1, int num2) {

        if (num1 > num2) {
            return num1;
        }
        return num2;
    }

    public int menor(int num1, int num2) {

        if (num1 < num2) {
            return num1;
        }
        return num2;
    }

    public boolean numPrimosxd(int num) {

        int contar = 2;
        boolean primerDato = true;

        while (contar <= (num / 2)) {

            if (num % contar == 0) {
                primerDato = false;

                break;
            }
            contar++;
        }

        return primerDato;

    }

    public int primoConteo(int num1, int num2) {

        int fin = mayor(num1, num2);
        int inicioContar = menor(num1, num2);
        int contar = 0;

        for (int i = inicioContar; i <= fin; i++) {

            if (numPrimosxd(i)) {
                contar++;
            }
        }
        return contar;
    }

    public int[] valorAgend(int num1, int num2) {

        int fin = mayor(num1, num2);
        int contar = menor(num1, num2);
        int finalxd = primoConteo(num1, num2);

        int primos[] = new int[finalxd];

        int inicio = 0;
        for (int i = contar; i <= fin; i++) {
            if (numPrimosxd(i)) {
                primos[inicio] = i;
                inicio++;
            }

        }

        return primos;
    }

    public void cuentaVector(int almacenDato[]) {

        int finalxd = almacenDato.length;

        int dato[] = new int[finalxd];
        int inicio = finalxd - 1;

        for (int i = 0; i < finalxd; i++) {
            dato[i] = almacenDato[inicio];

            inicio--;
        }

        inicio = 0;
        for (int i : dato) {
            almacenDato[inicio] = i;
            inicio++;
        }
    }

    public void mostrar(int almacenDato[]) {

        for (int i : almacenDato) {
            System.out.println(i);
        }
    }
}
