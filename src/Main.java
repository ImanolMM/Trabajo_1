import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
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

            entrada = new Scanner(new FileReader(System.getProperty("user.dir")+"\\src\\index-2022-2023"));
            while (entrada.hasNext()){
                linea = entrada.nextLine();
                String []partes = linea.split(":");
                palabras.añadirPalabra(partes [1]);
            }
            cargado = true;
            entrada.close();
        }
        catch (IOException e){e.printStackTrace();}
        return webs;
    }
    public static void prueba(){
        cargarArchivos();
        System.out.println(webs.id2String(1));
    }
    public static void main(String[] args){
        prueba();
    }
}
