import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


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

            String linea;
            BufferedReader entrada = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\words.txt"));

            while ((linea = entrada.readLine()) != null){ // loop de cargar palabras
                palabras.añadirPalabra(linea);
            }

            entrada = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\index-2022-2023"));

            //prueba
            int prueba = 0;
            while ((linea = entrada.readLine()) != null){ //loop de cargar webs
                String []partes = linea.split(":");
                webs.añadirWeb(partes [1], Integer.parseInt(partes [0]));
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
            cargarPalabras();

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

    public static void cargarPalabras (){

        for (int pos = 0; pos< webs.obtenerNumWebs(); pos ++){
            Web web = webs.devolverWebPorPos(pos);
            System.out.println("asdasdasd:_  " + pos);
            for (int ind = 0; ind < palabras.obtenerNumPalabras();ind++){
                PClave palabra = palabras.obtenerPalabraPorPos(ind);

                if (web.obtenerNombre().contains(palabra.obtenerNombrePalabra())){
                    web.añadirPalabraRelacionada(palabra);
                    palabra.añadirWebRelacioanda(web);
                }
            }
        }
    }

    public static void prueba(){
        cargarArchivos();
        for (int ind = 0; ind >=0; ind++){
            System.out.println(webs.devolverWebPorPos(11).obtenerPalabraPorPos(ind));
        }

    }
    public static void main(String[] args){
        prueba();
    }

}
