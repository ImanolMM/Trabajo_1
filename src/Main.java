import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {
//hola
    private static ListaWeb webs;
    private static ListaPClave palabras;
    private static ListaWebRelacionadas webRelacionadas;
    private static boolean cargado;

    protected static void cargarArchivos(){
        try{
            webs = new ListaWeb();
            palabras = new ListaPClave();
            webRelacionadas = new ListaWebRelacionadas();

            Scanner entrada = new Scanner(new FileReader(System.getProperty("user.dir")+"\\src\\index-2022-2023"));
            String linea;

            while (entrada.hasNext()){ //loop de cargar webs
                linea = entrada.nextLine();
                String []partes = linea.split(":");
                webs.añadirWeb(partes [1], Integer.parseInt(partes [0]));
            }

            entrada = new Scanner(new FileReader(System.getProperty("user.dir")+"\\src\\pld-arcs-1-N-2022-2023"));

            int asd= 0;
            while (entrada.hasNext()){
                linea = entrada.nextLine();
                String [] partes = linea.split(" ---> ");
                System.out.println(asd);

                if (partes.length > 1) {
                    linea = partes [1];
                    partes = linea.split(" ### ");
                    webRelacionadas.añadirWebRelacionadas(partes);
                }
                else{
                    webRelacionadas.añadirWebRelacionadas(null);
                }
                asd++;
            }

            entrada = new Scanner(new FileReader(System.getProperty("user.dir")+"\\src\\words.txt"));
            while (entrada.hasNext()){ // loop de cargar palabras
                linea = entrada.nextLine();
                palabras.añadirPalabra(linea);
            }
            cargado = true;
            entrada.close();

            cargarWebrelacionadas();
        }
        catch (IOException e){e.printStackTrace();}

    }
    public static void cargarWebrelacionadas (){
        int ind = 0;
        int cont = 0;
        String [] idWebs;

        while (ind < webs.obtenerNumWebs()){ //loop de buscar las webs relacionadas
            idWebs= webRelacionadas.obtenerListaWebs(ind);
            while (idWebs != null && cont < idWebs.length){
                webs.binarySearch(ind).añadirWebRelacioanada(webs.binarySearch(ind).obtenerNombre(),Integer.parseInt(idWebs[cont]));
                cont ++;
            }
            cont = 0;
            ind ++;
            System.out.println(ind);
        }
        cont =0;
        while (cont < webs.binarySearch(20).obtenerWebAsociadas().obtenerNumWebs()){ //TODO falta arreglar los nombres de las webs
            System.out.println(cont +"  :  " + webs.binarySearch(20).obtenerWebAsociadas().devolverWebPorPos(cont).obtenerId());
            cont ++;
        }


    }
    public static void prueba(){
        cargarArchivos();
        webs.enlacesSaientes("0-100.com.cn");
    }
    public static void main(String[] args){

        prueba();
        String p1 = "a";
        String p2 = "b";
        //System.out.println(p1.compareTo(p2));
    }

}
