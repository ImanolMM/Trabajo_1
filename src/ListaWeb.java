import java.io.*;
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

    protected void añadirWebYArchivo (Web web){
        this.lista.add(web);
        try(FileWriter fw = new FileWriter(System.getProperty("user.dir")+"\\src\\index-2022-2023", true);
            PrintWriter out = new PrintWriter(fw))
        {
            out.println();
            out.print(web.obtenerId() + ":"+ web.obtenerNombre());
        } catch (IOException e) {

        }
    }
}
