import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaPClaveTest {
    //hola
    private static PClave palabra;
    private static PClave palabra1;
    private static ListaPClave lista;
    private static ListaPClave listaVacia;

    @BeforeEach
    void setUp() {
        //inicializaciones
         lista=new ListaPClave();
         listaVacia=new ListaPClave();
         palabra=new PClave("abc");
         palabra1=new PClave("bbb");

         //añadir a la lista
         lista.añadirPalabra(palabra);
         lista.añadirPalabra(palabra1);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void web2Words() {

    }

    @Test
    void añadirPalabra() {
        // caso simple
        assertEquals(1,lista.obtenerNumPalabras());

    }

    @Test
    void obtenerNumPalabrasDeberiaSer2() {
        //caso simple
        assertEquals(2, lista.obtenerNumPalabras());
        //0 palabras
        assertEquals(0,listaVacia.obtenerNumPalabras());
    }


    @Test
    void obtenerPalabraPorPos() {
        //Posicion valida
        assertEquals("bbb",lista.obtenerPalabraPorPos(1).obtenerNombrePalabra());

        //Posicion no valida
        assertThrows(IndexOutOfBoundsException.class,
                ()->{
            lista.obtenerPalabraPorPos(-1);
                });

    }
}