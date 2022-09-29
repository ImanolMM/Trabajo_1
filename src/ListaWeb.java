import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//hola
public class ListaWeb{

    private HashMap <Integer, Web> lista;

    public ListaWeb (){
        this.lista = new HashMap<Integer,Web>();
    }

    public String id2String (int x){

        return this.lista.get(x).obtenerNombre();
    }
    public int obtenerNumWebs (){
        return this.lista.size();
    }
    public void añadirWeb (Web web){
        this.lista.put (web.obtenerId(), web);
    }
    public Web devolverWebPorPos (int pos){
        return this.lista.get(pos);
    }
    public void quitarWeb (int id){
        this.lista.remove(id);
    }

    //TODO guardar web en ficheros
}
