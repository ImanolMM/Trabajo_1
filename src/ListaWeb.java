import java.util.ArrayList;

public class ListaWeb{

    private ArrayList <Web> lista;

    public ListaWeb (){

        this.lista = new ArrayList<Web>();
    }

    public String id2String (int x){

        return this.lista.get(x).obtenerNombre();
    }

    public int string2Id(String s){

        return 1;
    }

    public ArrayList <Web> enlacesSaientes (String s){

        return null;
    }

    public ArrayList <Web> webOrdenada (){

        return null;
    }

    public ArrayList <Web> word2Webs (String s){

        return null;
    }

    public void añadirWeb (String s){
        this.lista.add (new Web("s"));
    }

    public void quitarWeb (String s){

    }

    //TODO guardar web en ficheros
}
