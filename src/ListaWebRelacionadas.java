import java.util.ArrayList;

public class ListaWebRelacionadas {

    private ArrayList <String []> lista;

    public ListaWebRelacionadas (){
        this.lista= new ArrayList<String[]>();
    }

    public void añadirWebRelacionadas (String [] partes){
        this.lista.add(partes);
    }
    public String [] obtenerListaWebs (int id){
        return this.lista.get (id);
    }
}
