public class PClave {
    private String palabra;
    private ListaWeb wAsociadas;

    protected PClave (String palabra){
        this.palabra = palabra;
        this.wAsociadas = new ListaWeb();
    }

    protected String obtenerNombrePalabra (){
        return this.palabra;
    }

    protected void añadirWebRelacioanda (Web web){
        this.wAsociadas.añadirWeb(web);
    }

    protected Web obtenerWebPorPosi (int pos){
        return this.wAsociadas.devolverWebPorPos(pos);
    }
}
