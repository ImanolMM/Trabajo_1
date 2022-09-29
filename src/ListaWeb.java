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
    public Web binarySearch (int id){
        int primero = 0;
        int ultimo= this.lista.size() -1;
        int mid = (primero + ultimo)/2;
        int numId = 0;
        boolean salir = false;

        while( primero <= ultimo && !salir ){

            if ( this.lista.get(mid).obtenerId() < id ){
                primero = mid + 1;

            }else if ( this.lista.get(mid).obtenerId() == id ) {
                numId = mid;
                salir = true;
            }
            else{
                ultimo = mid - 1;
            }
            mid = (primero + ultimo)/2;
        }
        return this.lista.get (numId);
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

    public void quitarWeb (String s){

    }

    //TODO guardar web en ficheros
}
