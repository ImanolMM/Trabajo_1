import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.SimpleTimeZone;


public class Main{
//hola
    private static ListaWeb webs;
    private static ListaWebRelacionadas webRelacionadas;
    private static HashMap <String,PClave> palabrasMap;

    private static boolean cargado;

    protected static void cargarArchivos(){
        try{
            webs = new ListaWeb();
            palabrasMap = new HashMap<String,PClave>();
            webRelacionadas = new ListaWebRelacionadas();

            String linea;
            BufferedReader entrada = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\words.txt"));

            while ((linea = entrada.readLine()) != null){ // loop de cargar palabras
                palabrasMap.put( linea, new PClave(linea));
            }

            entrada = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\index-2022-2023"));

            //prueba
            int prueba = 0;
            while ((linea = entrada.readLine()) != null){ //loop de cargar webs
                String []partes = linea.split(":");
                webs.añadirWeb(partes [1], Integer.parseInt(partes [0]));
                //System.out.println(prueba);
                //prueba++;
            }

            entrada = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\pld-arcs-1-N-2022-2023"));

            prueba= 0;// para pruebas
            while ((linea = entrada.readLine()) != null){ // loop de cargar las relaciones de webs
                String [] partes = linea.split(" ---> ");
                System.out.println(prueba);

                if (partes.length > 1) {
                    linea = partes [1];
                    partes = linea.split(" ### ");
                    webRelacionadas.añadirWebRelacionadas(partes);
                }
                else{
                    webRelacionadas.añadirWebRelacionadas(null);
                }
                prueba++;
            }
            cargado = true;
            entrada.close();

            cargarWebrelacionadas();
            CargarRelacionesPalabras();

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
                webs.devolverWebPorPos(ind).añadirWebRelacioanada(""/*webs.binarySearch(Integer.parseInt(idWebs [cont])).obtenerNombre()*/, Integer.parseInt(idWebs[cont]));
                cont ++;
            }
            cont = 0;
            ind ++;
            System.out.println(ind);
        }

        //pruebas
        cont =0;
        int idWeb= 20;
        while (cont < webs.binarySearch(idWeb).obtenerWebAsociadas().obtenerNumWebs()){
            System.out.println(cont +"  :  " + webs.binarySearch(idWeb).obtenerWebAsociadas().devolverWebPorPos(cont).obtenerId() + "  nombre:  " + webs.binarySearch(idWeb).obtenerWebAsociadas().devolverWebPorPos(cont).obtenerNombre());
            cont ++;
        }


    }

    public static void CargarRelacionesPalabras (){
        ArrayList<String> combinaciones;
        for (int ind = 0; ind < webs.obtenerNumWebs(); ind++){
            Web web = webs.devolverWebPorPos(ind);
            combinaciones = web.buscarCombinaciones();
            System.out.println("PALABRAS:  "+ind);

            for (int ind2 = 0; ind2 < combinaciones.size(); ind2 ++){
                PClave palabraClave = palabrasMap.get(combinaciones.get(ind2));

                if (palabraClave != null){
                    web.añadirPalabraRelacionada(palabraClave);
                    palabraClave.añadirWebRelacioanda(web);
                }
            }
        }
    }


    public static void prueba(){
        cargarArchivos();
        for (int i= 0; i< 50; i++){
            System.out.println(palabrasMap.get("casino").obtenerWebPorPosi(i).obtenerNombre());
        }


    }
    public static void main(String[] args){
        prueba();
    }

}
