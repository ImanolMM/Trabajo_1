import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main{
    private static HashWeb webs;
    private static ListaWebRelacionadas webRelacionadas;
    private static HashPalabras palabrasMap;

    public Main (){
        webs = new HashWeb();
        palabrasMap = new HashPalabras();
        webRelacionadas = new ListaWebRelacionadas();
    }
    public static void cargarArchivos(String nomClave, String nomWeb, String nomRelaciones){
        try{
            cargarPalabras(nomClave);
            cargarWebs(nomWeb);
            cargarWebrelacionadas(nomRelaciones);

            cargarRelacionesWebs();
            cargarRelacionesPalabras();

        }
        catch (IOException e){e.printStackTrace();}

    }
    public static void cargarPalabras (String nomClave) throws IOException {
        palabrasMap = new HashPalabras();
        String linea;
        BufferedReader entrada = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\" + nomClave));

        while ((linea = entrada.readLine()) != null){ // loop de cargar palabras

            palabrasMap.añadirPClave( linea, new PClave(linea));
        }
        entrada.close();
    }
    public static void cargarWebs (String nomWeb) throws IOException {
        webs = new HashWeb();
        String linea;
        BufferedReader entrada = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\" + nomWeb));

        while ((linea = entrada.readLine()) != null){ //loop de cargar webs
            try{
                String []partes = linea.split(":");
                if (partes.length > 1){
                    webs.añadirWeb(partes[1], Integer.parseInt(partes [0]));
                }
                else{
                    throw new LineaMalException();
                }
            } catch (DosWebsConMismoIdException e) {e.printStackTrace();} catch (LineaMalException e) {e.printStackTrace();}
        }
        entrada.close();
    }
    public static void cargarWebrelacionadas (String nomRelaciones) throws IOException {
        webRelacionadas = new ListaWebRelacionadas();
        String linea;
        BufferedReader entrada = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\" + nomRelaciones));

        while ((linea = entrada.readLine()) != null){ // loop de cargar las relaciones de webs
            String [] partes = linea.split(" ---> ");

            if (partes.length > 1) {
                int webId = Integer.parseInt(partes [0]);
                linea = partes [1];
                partes = linea.split(" ### ");
                webRelacionadas.añadirWebRelacionadas(webId, partes);
            }
        }
        entrada.close();
    }
    public static void cargarRelacionesWebs (){
        String [] idWebs;
        int ind,cont =0;

        for (ind = 0; ind < webs.obtenerNumWebs(); ind++){
            idWebs= webRelacionadas.obtenerListaWebs(ind);

            for (cont =0; idWebs != null && cont < idWebs.length; cont++){
                webs.devolverWebPorId(ind).añadirWebRelacioanada(webs.devolverWebPorId(Integer.parseInt(idWebs[cont])));
            }
        }
    }

    public static void cargarRelacionesPalabras (){

        ArrayList<String> combinaciones;
        for (int ind = 0; ind < webs.obtenerNumWebs(); ind++){
            Web web = webs.devolverWebPorId(ind);
            combinaciones = web.buscarCombinaciones();
            //System.out.println("PALABRAS:  "+ind);

            for (int ind2 = 0; ind2 < combinaciones.size(); ind2 ++){
                PClave palabraClave = palabrasMap.obtenerPClave(combinaciones.get(ind2));

                if (palabraClave != null){
                    web.añadirPalabraRelacionada(palabraClave);
                    palabraClave.añadirWebRelacioanda(web);
                }
            }
        }
    }

    protected HashWeb devolverWebs (){ //para los JUnits
        return webs;
    }

    protected ListaWebRelacionadas devolverWebRelacionadas (){ //para los JUnits
        return webRelacionadas;
    }

    protected HashPalabras devolverPalabras (){ //para los JUnits
        return palabrasMap;
    }


    public static void prueba(){
        cargarArchivos("words.txt","index-2022-2023","pld-arcs-1-N-2022-2023");
    }

    public static void main(String[] args){
        prueba();
    }
}
