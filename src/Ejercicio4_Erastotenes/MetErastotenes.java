package Ejercicio4_Erastotenes;

import java.util.Scanner;

public class MetErastotenes {
    /**
     * pedimos un número entero mayor que 0 y lo devolvemos por parámetro al main
     * @return numero: lo introduce el usuario
     */
    public static int pedirNumero() {
        Scanner scanner=new Scanner(System.in);
        int numero = 0;
        System.out.println("Introduzca un numero positovo mayor que 0");
        boolean valido=false;
        while (!valido){
            try {
                numero=scanner.nextInt();
                if (numero<=0){
                    System.out.println("introduzca un numero positivo");
                    scanner.nextLine();
                }
                else {
                    valido=true;
                }
            }
            catch (Exception e){
                System.out.println("valor no válido, ha de ser entero mayor que 0");
                scanner.nextLine();
            }
        }
        return numero;
    }

    /**
     * caragamos el array con los números impares a partir del 3. La casilla 0 la rellenamos directamente
     * con el valor 3 para continuar. para garantizar que no introducimos un número mayor que el introducido
     * por pantalla, lo validamos antes de incluirlo en el array
     * @param arrayOriginal
     * @param numero
     */
    public static void cargarArray(int[] arrayOriginal, int numero) {
        arrayOriginal[0]=3;
        int i=1, calculo=0;
        boolean continuar=true;
        while (continuar){
            calculo=arrayOriginal[i-1]+2;//si el valor de la casilla más 2 es menor que el número introducido
            //por pantalla, lo mentemos en el array y continuamos, si no, paramos, ponemos continuar a false.
            if (calculo <=numero){
                arrayOriginal[i]=calculo;
                i++;
            }
            else {
                continuar = false;
            }
        }
    }

    /**
     * para rutilizar el mismo arraym en lugar de borrar los números no primos, los multiplico por -1
     * ya que cuando i vale 9 o un número no primo, previamente se habría puesto a 0 con lo que el
     * algoritmo no funciona. Por ese motivo, todas las comprobaciones están realizadas con los  valores
     * absolutos del contenido de las casillas
     * @param arrayOriginal
     * @param numero
     */
    public static void buscarPrimos(int[] arrayOriginal,int numero) {
        int i=0;
        int limite =Math.abs((int) Math.sqrt(numero));
        while (Math.abs(arrayOriginal[i])<limite){
            int j=i;
            while (j+Math.abs(arrayOriginal[i]) <arrayOriginal.length){
                j=Math.abs(arrayOriginal[i])+j;
                if (arrayOriginal[j]> 0) {//solo pongo en negativo los números si no están ya en negativo
                    arrayOriginal[j] *= -1;
                }
            }
            i++;
        }
    }

    public static void mostrarNumPrimos(int[] arrayOriginal) {
        for (int i=1; i< arrayOriginal.length; i++){
            if (arrayOriginal[i]>0)
                System.out.println(arrayOriginal[i]);
        }
    }
}
