import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Arrays;
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

        return null ;//this.lista.get(id).obtenerWebAsociadas().obtenerArray();
    }

    /*public void buscarWebRelacionadas (int id) {
        int cont = id;
        System.out.println("webRelacionada: " + id);
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

                while (cont < partes.length){
                    this.binarySearch(id).añadirWebRelacioanada((this.id2String(Integer.parseInt(partes [cont]))),Integer.parseInt(partes [cont]));
                    cont ++;
                }
            }
        }
        catch (IOException e){e.printStackTrace();}
    }*/
    public ArrayList <Web> webOrdenada (){

        return null;
    }

    public Web binarySearch (int id){
        int primero = 0;
        int ultimo=this.lista.size() -1;
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
        if ( primero > ultimo ){
            System.out.println("No encontrado");
        }
        return this.lista.get (numId);
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
    public Web devolverWebPorPos (int pos){
        return this.lista.get(pos);
    }

    public void quitarWeb (String s){

    }

    //TODO guardar web en ficheros
}
