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
        int digitos = 1;

        if (id != 0){
            digitos = (int)(Math.log10(id)+1);
        }

        try{
            Scanner entrada = new Scanner(new FileReader(System.getProperty("user.dir")+"\\src\\pld-arcs-1-N-2022-2023"));
            String linea = null;

            while (entrada.hasNext() && cont >= 0){
                linea = entrada.nextLine();
                cont--;
            }

            linea = linea.substring(6 + digitos);
            String [] partes = linea.split(" ### ");
            if (!partes[0].isEmpty()){
                cont = 0;
                while (cont < partes.length){

                    this.lista.get(id).añadirWebRelacioanada((this.id2String(Integer.parseInt(partes [cont]))),Integer.parseInt(partes [cont]));
                    cont ++;
                }
            }
        }
        catch (IOException e){e.printStackTrace();}
    }
    public ArrayList <Web> webOrdenada (){

        return null;
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
