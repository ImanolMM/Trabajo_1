import java.util.*;
public class HashWeb{

    private HashMap <Integer, Web> lista;


    public HashWeb (){
        this.lista = new HashMap<Integer, Web>();
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

    public ArrayList <Web> ordenar (){
        ArrayList <Web> hasTabla = new ArrayList <Web>(this.lista.values());
        Collections.sort(hasTabla);
        return hasTabla;
    }

}
