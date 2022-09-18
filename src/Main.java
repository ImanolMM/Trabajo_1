import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

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

            while (entrada.hasNext()){
                linea = entrada.nextLine();
                String []partes = linea.split(":");
                webs.añadirWeb(partes [1]);
            }
            entrada = new Scanner(new FileReader(System.getProperty("user.dir")+"\\src\\words.txt"));
            while (entrada.hasNext()){
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
        cargarArchivos();
        webs.enlacesSaientes("0-100.com.cn");
    }
    public static void main(String[] args){

        prueba();
        String p1 = "a";
        String p2 = "b";
        //System.out.println(p1.compareTo(p2));u
    }
}
