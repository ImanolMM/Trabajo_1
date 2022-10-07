import java.util.HashMap;

public class HashListaWebRelacionadas {
    private HashMap <Integer, String []>lista;


    protected HashListaWebRelacionadas(){
        this.lista= new HashMap <Integer, String []>();
    }

    protected void añadirWebRelacionadas ( int idWeb, String [] partes){
        this.lista.put(idWeb, partes);
    }

    protected String [] obtenerListaWebs (int id){
        return this.lista.get (id);
    }
}
