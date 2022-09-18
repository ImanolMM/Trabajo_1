public class Web {
    //hola
    private ListaPClave pAsociadas;
    private ListaWeb wAsociadas;
    private String nombreWeb;

    public Web (String nombreWeb){
        this.pAsociadas = new ListaPClave();
        this.wAsociadas = new ListaWeb();
        this. nombreWeb = nombreWeb;
    }

    public String obtenerNombre (){

        return this.nombreWeb;
    }

    public void añadirWebRelacioanada(String nomWeb) {
        this.wAsociadas.añadirWeb(nomWeb);
    }

    public String mostrarWebRelacionada (int ind){
        return this.wAsociadas.id2String(ind);
    }
}
