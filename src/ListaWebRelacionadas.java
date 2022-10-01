import java.util.ArrayList;

public class ListaWebRelacionadas {
    private ArrayList <String []> lista;


    protected ListaWebRelacionadas (){
        this.lista= new ArrayList<String[]>();
    }

    protected void añadirWebRelacionadas (String [] partes){
        this.lista.add(partes);
    }

    protected String [] obtenerListaWebs (int id){
        return this.lista.get (id);
    }
}
