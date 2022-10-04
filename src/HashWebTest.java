import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HashWebTest {
    private static Web web1;
    private static Web web2;
    private static Web web3;
    private static Web webmismo;
    private static HashWeb lista1;
    private static HashWeb lista2;
    private static HashWeb lista3;

    private static ArrayList<Web> hasTabla;


    @BeforeEach
    void setUp() throws DosWebsConMismoIdException {
        //inicializaciones
        web1 = new Web("aaaaaaa", 1);
        webmismo=new Web("dfghjk",1);
        web2 = new Web("bbbbbbb", 2);
        web3 = new Web("ccccccc", 3);
        lista1 = new HashWeb();
        lista2 = new HashWeb();
        lista3=new HashWeb();
        hasTabla = new ArrayList <Web>();


        //añadir las webs
        lista1.añadirWeb(web1.obtenerNombre(),web1.obtenerId());
        lista1.añadirWeb(web2.obtenerNombre(),web2.obtenerId());
        lista1.añadirWeb(web3.obtenerNombre(),web3.obtenerId());
        lista2.añadirWeb(web1.obtenerNombre(),web1.obtenerId());
        lista2.añadirWeb(web2.obtenerNombre(),web2.obtenerId());
        hasTabla.add(web1);
        hasTabla.add(web2);
        hasTabla.add(web3);



    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void id2String() {
        //id normal
        assertEquals("aaaaaaa",lista1.id2String(web1.obtenerId()));




    }

    @Test
    void obtenerNumWebs() {
        //caso simple
        assertEquals(3,lista1.obtenerNumWebs());
        //0 si no hay webs
        assertEquals(0,lista3.obtenerNumWebs());
    }

    @Test
    void añadirWeb() {
        //lanza excepcion si tienen mismo id
        assertThrows(DosWebsConMismoIdException.class,
                ()->{
            lista1.añadirWeb(webmismo.obtenerNombre(),webmismo.obtenerId());
                });

    }

    @Test
    void devolverWebPorPos() {
        //caso simple
        assertEquals(web2.obtenerNombre(),lista1.devolverWebPorPos(2).obtenerNombre());
        //que no coincida con la pos
        assertNotEquals(web3,lista2.devolverWebPorPos(2));
    }

    @Test
    void quitarWeb() {
        //caso simple
    }

    @Test
    void devolverArrayOrdenado() {

        lista1.devolverArrayOrdenado();

        //caso simple

    }
}