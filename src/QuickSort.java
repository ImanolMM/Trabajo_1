import java.util.ArrayList;
import java.util.HashMap;

public class QuickSort <Web extends Comparable<Web>>{

    public void quickSort(Web [] laTabla){

        quickSort(laTabla, 0, laTabla.length-1);
    }
    private void quickSort(Web[] tabla, int inicio, int fin){
        if ( fin - inicio > 0 ) { // hay más de un elemento en la tabla
            int indiceParticion = particion(tabla, inicio, fin);
            quickSort(tabla, inicio, indiceParticion - 1);
            quickSort(tabla, indiceParticion + 1, fin);

        }
    }
    private int particion(Web[] tabla, int i, int f){
        Web pivote = tabla[i];
        int izq = i;
        int der = f;
        while ( izq < der ){
            while ( tabla[izq].compareTo(pivote) <= 0 && izq < der)
                izq++;
            while ( tabla[der].compareTo(pivote) > 0 )
                der--;
            if ( izq < der )
                swap(tabla, izq, der);
        }
        tabla[i] = tabla[der];
        tabla[der] = pivote;
        return der;
    }
    private void swap(Web[] tabla, int one, int two) {
        Web temp = tabla[one];
        tabla[one] = tabla[two];
        tabla[two] = temp;
    }

}