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

    public void añadirWeb (String nombre, int id) throws DosWebsConMismoIdException{

        if (this.lista.get(id) != null){
            this.lista.put (id, new Web(nombre, id));
        }
        else {
            throw new DosWebsConMismoIdException();
        }
    }

    public Web devolverWebPorPos (int pos){
        return this.lista.get(pos);
    }

    public void quitarWeb (int id){
        this.lista.remove(id);
    }

    public ArrayList <Web> devolverArrayOrdenado (){
        ArrayList <Web> hasTabla = new ArrayList <Web>(this.lista.values());
        Collections.sort(hasTabla);
        return hasTabla;
    }

}
