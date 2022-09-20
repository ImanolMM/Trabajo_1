import java.util.ArrayList;

public class Web {
    //hola
    private ListaPClave pAsociadas;
    private ListaWeb wAsociadas;
    private String nombreWeb; //id????????????????

    private int id;

    public Web (String nombreWeb, int id){
        this.pAsociadas = new ListaPClave();
        this.wAsociadas = new ListaWeb();
        this. nombreWeb = nombreWeb;
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

    public String mostrarWebRelacionada (int ind){
        return this.wAsociadas.id2String(ind);
    }
}
