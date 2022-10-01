import java.util.*;
public class ListaWeb{

    private ArrayList <Web> lista;


    protected ListaWeb (){
        this.lista = new ArrayList<Web>();
    }

    protected String id2String (int x){

        return this.lista.get(x).obtenerNombre();
    }

    protected int obtenerNumWebs (){
        return this.lista.size();
    }

    protected void añadirWeb (Web web){
        this.lista.add (web);
    }

    protected Web devolverWebPorPos (int pos){
        return this.lista.get(pos);
    }

    protected void quitarWeb (int id){
        this.lista.remove(id);
    }

    //TODO guardar web en ficheros
}
