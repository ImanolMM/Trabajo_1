public class PClave {
    //hola
    private String palabra;
    private ListaWeb wAsociadas;

    public PClave (String palabra){
        this.palabra = palabra;
        this.wAsociadas = new ListaWeb();
    }

    public String obtenerNombrePalabra (){
        return this.palabra;
    }

    public void añadirWebRelacioanda (Web web){
        this.wAsociadas.añadirWeb(web.obtenerNombre(),web.obtenerId());
    }
}
