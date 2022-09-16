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

    protected static ListaWeb cargarWebs(String nomF){
        try{
            Scanner entrada = new Scanner(new FileReader(nomF));
            String linea;

            while (entrada.hasNext()){
                linea = entrada.nextLine();
                String []partes = linea.split(":");
                webs.añadirWeb(partes [1]);
            }
            entrada.close();
        }
        catch (IOException e){e.printStackTrace();}
        return webs;
    }
    public static void prueba(){
        cargarWebs("index-2022-2023");
        System.out.println(webs.id2String(1));
    }
    public static void main(String[] args){
        prueba();
    }
}
