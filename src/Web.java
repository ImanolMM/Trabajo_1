import java.util.ArrayList;

public class Web {
    //hola
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

    protected ListaWeb obtenerWebAsociadas (){
        return this.wAsociadas;
    }

    public String obtenerNombre (){ //

        return this.nombreWeb;
    }

    public int obtenerId (){ //
        return this.id;
    }

    public void añadirWebRelacioanada(String nomWeb, int id) {
        this.wAsociadas.añadirWeb(nomWeb,id);
    }

    public ArrayList <String> buscarCombinaciones (){

        ArrayList <String> combinaciones = new ArrayList<String>();
        int i,d = 0;

        for (i = 0; i != d-3; i++){
            for (d = i+3; d <= this.nombreWeb.length(); d++){
                combinaciones.add(this.nombreWeb.substring(i,d));
            }
        }
        return combinaciones;
    }

    public void añadirPalabraRelacionada (PClave palabra){
        this.pAsociadas.añadirPalabra(palabra.obtenerNombrePalabra());
    }

    public String obtenerPalabraPorPos(int pos){
        return this.pAsociadas.obtenerPalabraPorPos(pos).obtenerNombrePalabra();
    }

    public String mostrarWebRelacionada (int ind){
        return this.wAsociadas.id2String(ind);
    }
}
