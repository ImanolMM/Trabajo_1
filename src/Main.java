import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Main {
//hola
    private static ListaWeb webs;
    private static ListaPClave palabras;
    private static boolean cargado;

    public Main (){
        webs = new ListaWeb();
        palabras = new ListaPClave();
        cargado = false;
    }

    protected static ListaWeb cargarArchivos(){
        try{
            webs = new ListaWeb();
            palabras = new ListaPClave();

            Scanner entrada = new Scanner(new FileReader(System.getProperty("user.dir")+"\\src\\index-2022-2023"));
            String linea;

            while (entrada.hasNext()){ //loop de cargar webs
                linea = entrada.nextLine();
                String []partes = linea.split(":");
                webs.añadirWeb(partes [1], Integer.parseInt(partes [0]));
            }
            int ind = 0;

            while (ind < webs.obtenerNumWebs()){ //loop de buscar las webs relacionadas
                webs.buscarWebRelacionadas(ind);
                ind ++;
            }

            entrada = new Scanner(new FileReader(System.getProperty("user.dir")+"\\src\\words.txt"));
            while (entrada.hasNext()){ // loop de cargar palabras
                linea = entrada.nextLine();
                palabras.añadirPalabra(linea);
            }
            cargado = true;
            entrada.close();
        }
        catch (IOException e){e.printStackTrace();}
        return webs;
    }

    public static void prueba(){

        String linea = "10 ---> ";
        String [] partes = linea.split(" ---> ");
        linea = partes [0];
        partes = linea.split(" ### ");
        System.out.println(partes.length);

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
