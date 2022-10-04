import java.util.HashMap;

public class HashPalabras {

    private HashMap<String,PClave> lista;

    public HashPalabras (){
        this.lista = new HashMap<String,PClave>();
    }

    public void añadirPClave (String nombre, PClave pClave){
        this.lista.put (nombre, pClave);
    }

    public PClave obtenerPClave (String nombre){
        return this.lista.get (nombre);
    }
}
