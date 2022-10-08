import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main{
    private static HashWeb webs;
    private static HashListaWebRelacionadas webRelacionadas;
    private static HashPalabras palabrasMap;

    public Main (){
        webs = new HashWeb();
        palabrasMap = new HashPalabras();
        webRelacionadas = new HashListaWebRelacionadas();
    }
    public static void cargarArchivos(String nomClave, String nomWeb, String nomRelaciones){
        try{
            cargarPalabras(nomClave);
            cargarWebs(nomWeb);
            cargarWebRelacionadas(nomRelaciones);

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
                    webs.añadirWebAHash(partes[1], Integer.parseInt(partes [0]));
                }
                else{
                    throw new LineaMalException();
                }
            } catch (DosWebsConMismoIdException e) {e.printStackTrace();} catch (LineaMalException e) {e.printStackTrace();}
        }
        entrada.close();
    }
    public static void cargarWebRelacionadas (String nomRelaciones) throws IOException {
        webRelacionadas = new HashListaWebRelacionadas();
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
    public static void cargarRelacionesWebs () throws DosWebsConMismoIdException{
        String [] idWebs;
        int ind,cont =0;

        for (ind = 0; ind < webs.obtenerNumWebs(); ind++){
            idWebs= webRelacionadas.obtenerListaWebs(ind);

            for (cont =0; idWebs != null && cont < idWebs.length; cont++){
                webs.devolverWebPorId(ind).añadirWebRelacioanada(webs.devolverWebPorId(Integer.parseInt(idWebs[cont])));
            }
        }
    }

    public static void cargarRelacionesPalabras () throws DosWebsConMismoIdException{

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

    protected HashListaWebRelacionadas devolverWebRelacionadas (){ //para los JUnits
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
