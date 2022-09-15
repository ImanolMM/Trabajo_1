public class Web {
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
}
