import java.util.*;
public class ListaWeb{

    private ArrayList <Web> lista;


    public ListaWeb (){
        this.lista = new ArrayList<Web>();
    }

    public String id2String (int x){

        return this.lista.get(x).obtenerNombre();
    }

    public int obtenerNumWebs (){
        return this.lista.size();
    }

    public void añadirWeb (Web web){
        this.lista.add (web);
    }

    public Web devolverWebPorPos (int pos){
        return this.lista.get(pos);
    }

    public void quitarWeb (int id){
        this.lista.remove(id);
    }

    //TODO guardar web en ficheros
}
