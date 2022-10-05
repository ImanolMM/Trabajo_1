import java.util.ArrayList;
import java.util.Iterator;

public class Web implements Comparable <Web>{
    private ListaPClave pAsociadas;
    private ListaWeb wAsociadas;
    private String nombreWeb;
    private int id;

    public Web (String nombreWeb, int id){
        this.pAsociadas = new ListaPClave();
        this.wAsociadas = new ListaWeb();
        this.nombreWeb = nombreWeb;
        this.id = id;
    }
    public String obtenerNombre (){ //

        return this.nombreWeb;
    }

    public int obtenerId (){ //
        return this.id;
    }

    public void añadirWebRelacioanada(Web web) {
        this.wAsociadas.añadirWeb(web);
    }

    public ArrayList <String> buscarCombinaciones (){

        ArrayList <String> combinaciones = new ArrayList<String>();
        int i,d = 0;

        for (i = 0; i != d-1; i++){
            for (d = i+1; d <= this.nombreWeb.length(); d++){
                combinaciones.add(this.nombreWeb.substring(i,d));
            }
        }
        return combinaciones;
    }

    public String mismaCombinacion(ArrayList<String> listaCombs,String palabra){ //método para JUnit
        Iterator<String> itr = listaCombs.iterator();
        boolean esta = false;
        String comb = null;
        while (itr.hasNext() && esta == false) {
            if (itr.next() == palabra){
                comb = itr.next();
                esta = true;
            }
        }
        return comb;
    }

    public void añadirPalabraRelacionada (PClave palabra){
        this.pAsociadas.añadirPalabra(palabra);
    }

    public String obtenerPalabraPorPos(int pos){
        return this.pAsociadas.obtenerPalabraPorPos(pos).obtenerNombrePalabra();
    }

    public int compareTo (Web web){
        return this.obtenerNombre().compareTo(web.obtenerNombre());
    }

    public Web obtenerWebDeWasociadas (int id){
        return this.wAsociadas.devolverWebPorPos(id);
    }

}
