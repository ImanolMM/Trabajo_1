import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
//hola
public class ListaWeb{

    private ArrayList <Web> lista;

    public ListaWeb (){

        this.lista = new ArrayList<Web>();
    }

    public String id2String (int x){

        return this.lista.get(x).obtenerNombre();
    }

    private Iterator<Web> getiterador (){
        return this.lista.iterator();
    }
    public int string2Id(String s){

        Iterator <Web> iterador = this.getiterador();
        boolean salir = false;
        int cont = 0;

        while (iterador.hasNext() && !salir){
            String web = iterador.next().obtenerNombre();

            if (s.equals(web)){
                salir = true;
            }
            else{
                cont ++;
            }
        }
        return cont;
    }

    public ArrayList <Web> enlacesSaientes (String nomWeb){
        int id = this.string2Id(nomWeb);

        return this.lista.get(id).obtenerWebAsociadas().obtenerArray();
    }

    public void buscarWebRelacionadas (int id) {
        int cont = id;
        System.out.println(id);
        try{
            Scanner entrada = new Scanner(new FileReader(System.getProperty("user.dir")+"\\src\\pld-arcs-1-N-2022-2023"));
            String linea = null;

            while (entrada.hasNext() && cont >= 0){
                linea = entrada.nextLine();
                cont--;
            }

            String [] partes = linea.split(" ---> ");

            if (partes.length > 1) {
                linea = partes [1];
                partes = linea.split(" ### ");
                cont = 0;

                while (cont < partes.length){ // hay que hacerlo por id no por posición
                    this.buscarWebPorId(id).añadirWebRelacioanada((this.id2String(Integer.parseInt(partes [cont]))),Integer.parseInt(partes [cont]));
                    cont ++;

                }// else?
            }
        }
        catch (IOException e){e.printStackTrace();}
    }
    public ArrayList <Web> webOrdenada (){

        return null;
    }

    public Web buscarWebPorId (int id){
        int ind = 0;
        boolean encontrado = false;
        while (ind < this.lista.size() && !encontrado){
            if (this.lista.get(ind).obtenerId() == id){
                encontrado = true;
            }
            else{
                ind ++;
            }
        }
        return this.lista.get(ind);
    }
    private ArrayList <Web> obtenerArray (){
        return this.lista;
    }

    public int obtenerNumWebs (){
        return this.lista.size();
    }

    public ArrayList <Web> word2Webs (String s){

        return null;
    }

    public void añadirWeb (String nomWeb, int id){
        this.lista.add (new Web(nomWeb, id));
    }

    public void quitarWeb (String s){

    }

    //TODO guardar web en ficheros
}
