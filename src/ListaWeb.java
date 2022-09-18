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
        int cont = id;

        try{
            Scanner entrada = new Scanner(new FileReader(System.getProperty("user.dir")+"\\src\\pld-arcs-1-N-2022-2023"));
            String linea = null;

            while (entrada.hasNext() && cont >= 0){
                linea = entrada.nextLine();
                cont --;
            }

            linea = linea.substring(8);
            String [] partes = linea.split(" ### ");
            int ind = 0;

            while (ind < partes.length){
                this.lista.get(id).añadirWebRelacioanada(this.id2String(Integer.parseInt(partes [ind]))); //eficienia???
                System.out.println(partes [ind]);
                ind ++;
            }
        }
        catch (IOException e){e.printStackTrace();}
        System.out.println(lista.get(1).mostrarWebRelacionada(1));
            return null; // hay que dovolverlo de manera literal o print ln?
    }
    public ArrayList <Web> webOrdenada (){

        return null;
    }

    public ArrayList <Web> word2Webs (String s){

        return null;
    }

    public void añadirWeb (String s){
        this.lista.add (new Web(s));
    }

    public void quitarWeb (String s){

    }

    //TODO guardar web en ficheros
}
