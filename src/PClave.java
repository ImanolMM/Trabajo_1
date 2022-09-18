public class PClave {
    //hola
    private String palabra;
    private ListaWeb wAsociadas;

    public PClave (String palabra){
        this.palabra = palabra;
        this.wAsociadas = new ListaWeb();
    }

    public String obtenerPalabra (){
        return this.palabra;
    }
}
