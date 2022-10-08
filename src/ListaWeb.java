import java.io.*;
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

    public void añadirWeb (Web web) throws DosWebsConMismoIdException{
        int id = web.obtenerId();
        if (this.lista.get(id) == null){
            this.lista.add(web);
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

    public void añadirWebYArchivo (Web web){
        this.lista.add(web);
        try(FileWriter fw = new FileWriter(System.getProperty("user.dir")+"\\src\\index-2022-2023", true);
            PrintWriter out = new PrintWriter(fw))
        {
            out.println();
            out.print(web.obtenerId() + ":"+ web.obtenerNombre());
        } catch (IOException e) {

        }
    }
    
    public ArrayList <Web> obtenerArray (){
        return this.lista;
    }
}
