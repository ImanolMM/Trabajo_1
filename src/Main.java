import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main{
    private static HashWeb webs;
    private static ListaWebRelacionadas webRelacionadas;
    private static HashMap <String,PClave> palabrasMap;


    protected static void cargarArchivos(){
        try{
            webs = new HashWeb();
            palabrasMap = new HashMap<String,PClave>();
            webRelacionadas = new ListaWebRelacionadas();

            String linea;
            BufferedReader entrada = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\words.txt"));

            while ((linea = entrada.readLine()) != null){ // loop de cargar palabras
                palabrasMap.put( linea, new PClave(linea));
            }

            entrada = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\index-2022-2023"));

            int prueba = 0;
            while ((linea = entrada.readLine()) != null){ //loop de cargar webs
                String []partes = linea.split(":");
                webs.añadirWeb(new Web(partes[1], Integer.parseInt(partes [0])));
            }

            entrada = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\pld-arcs-1-N-2022-2023"));

            prueba= 0;// para pruebas
            while ((linea = entrada.readLine()) != null){ // loop de cargar las relaciones de webs
                String [] partes = linea.split(" ---> ");
                //System.out.println(prueba);

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
            entrada.close();

            cargarWebrelacionadas();
            CargarRelacionesPalabras();

        }
        catch (IOException e){e.printStackTrace();}

    }

    protected static void cargarWebrelacionadas (){
        String [] idWebs;
        int ind,cont =0;

        for (ind = 0; ind < webs.obtenerNumWebs(); ind++){ //loop de buscar las webs relacionadas
            idWebs= webRelacionadas.obtenerListaWebs(ind);
            for (cont =0; idWebs != null && cont < idWebs.length; cont++){
                webs.devolverWebPorPos(ind).añadirWebRelacioanada(webs.devolverWebPorPos(Integer.parseInt(idWebs[cont])));
            }
            //System.out.println(ind);
        }
    }

    protected static void CargarRelacionesPalabras (){
        ArrayList<String> combinaciones;
        for (int ind = 0; ind < webs.obtenerNumWebs(); ind++){
            Web web = webs.devolverWebPorPos(ind);
            combinaciones = web.buscarCombinaciones();
            //System.out.println("PALABRAS:  "+ind);

            for (int ind2 = 0; ind2 < combinaciones.size(); ind2 ++){
                PClave palabraClave = palabrasMap.get(combinaciones.get(ind2));

                if (palabraClave != null){
                    web.añadirPalabraRelacionada(palabraClave);
                    palabraClave.añadirWebRelacioanda(web);
                }
            }
        }
    }

    protected static void prueba(){
        HashWeb prueba = new HashWeb();
        prueba.añadirWeb(new Web("aaaaaa",0));
        prueba.añadirWeb(new Web("bbbbbb",1));

        QuickSort sort = null;

        sort.quickSort(prueba.convertirArray());
        /*cargarArchivos();
        for (int i= 0; i< 50; i++){
            System.out.println(palabrasMap.get("casino").obtenerWebPorPosi(i).obtenerNombre());
        }

        for (int i = 0; i < 40; i++){
            System.out.println(webs.devolverWebPorPos(21).obtenerPalabraPorPos(i));
        }*/

    }

    public static void main(String[] args){
        prueba();
    }
}
