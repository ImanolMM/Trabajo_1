import java.util.ArrayList;

public class ListaPClave {
//hola
    private ArrayList <PClave> lista;

    public ListaPClave (){

        this.lista = new ArrayList<PClave>();
    }

    public ArrayList <PClave> web2Words (String s){

        return null;
    }

    public void añadirPalabra (PClave palabra){
        this.lista.add(palabra);
    }

    public int obtenerNumPalabras (){
        return this.lista.size();
    }

    public PClave obtenerPalabraPorPos (int pos){
        return this.lista.get(pos);
    }

}
