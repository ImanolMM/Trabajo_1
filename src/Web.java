import java.util.ArrayList;

public class Web {
    private ListaPClave pAsociadas;
    private ListaWeb wAsociadas;
    private String nombreWeb;
    private int id;

    protected Web (String nombreWeb, int id){
        this.pAsociadas = new ListaPClave();
        this.wAsociadas = new ListaWeb();
        this.nombreWeb = nombreWeb;
        this.id = id;
    }
    protected String obtenerNombre (){ //

        return this.nombreWeb;
    }

    protected int obtenerId (){ //
        return this.id;
    }

    protected void añadirWebRelacioanada(Web web) {
        this.wAsociadas.añadirWeb(web);
    }

    protected ArrayList <String> buscarCombinaciones (){

        ArrayList <String> combinaciones = new ArrayList<String>();
        int i,d = 0;

        for (i = 0; i != d-1; i++){
            for (d = i+1; d <= this.nombreWeb.length(); d++){
                combinaciones.add(this.nombreWeb.substring(i,d));
            }
        }
        return combinaciones;
    }

    protected void añadirPalabraRelacionada (PClave palabra){
        this.pAsociadas.añadirPalabra(palabra);
    }

    protected String obtenerPalabraPorPos(int pos){
        return this.pAsociadas.obtenerPalabraPorPos(pos).obtenerNombrePalabra();
    }

    private int compareTo (Web web){
        return web.obtenerNombre().compareTo(web.obtenerNombre());
    }

}
