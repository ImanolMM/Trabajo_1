import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class WebTest {

    private Web web1,web2;

    @Before
    public void setUp() throws Exception {
        web1 = new Web("casapaco.com",1);
        web2 = new Web("jaaajaj.de",2);
    }

    @After
    public void tearDown() throws Exception {
        web1 = null;
        web2 = null;
    }

    @Test
    public void obtenerNombre() {
        assertEquals(web1.obtenerNombre(),"casapaco.com");
        assertEquals(web2.obtenerNombre(),"jaaajaj.de");
    }

    @Test
    public void obtenerId() {
        assertEquals(web1.obtenerId(),1);
        assertEquals(web2.obtenerId(),2);
    }

    @Test
    public void añadirWebRelacioanada() {
        web2.añadirWebRelacioanada(web1);
        ListaWeb lista = web2.obtenerWAsociadas();
        assertEquals(lista.obtenerNumWebs(),1);
    }

    @Test
    public void buscarCombinaciones() throws DosWebsConMismoIdException {
        String palabra1 = "casa";
        ArrayList<String> lista;
        lista = web1.buscarCombinaciones();
        String palabra2 = web1.mismaCombinacion(lista,palabra1);
        assertEquals(palabra1,palabra2);

        palabra1 = "";
        lista = web1.buscarCombinaciones();
        palabra2 = web1.mismaCombinacion(lista,palabra1);
        assertFalse(palabra1 == palabra2);

        palabra1 = "c";
        lista = web1.buscarCombinaciones();
        palabra2 = web1.mismaCombinacion(lista,palabra1);
        assertEquals(palabra1,palabra2);

        palabra1 = "aaa";
        lista = web2.buscarCombinaciones();
        palabra2 = web2.mismaCombinacion(lista,palabra1);
        assertEquals(palabra1,palabra2);
    }

    @Test
    public void añadirPalabraRelacionada() {
        PClave pClave = new PClave("hola");
        web2.añadirPalabraRelacionada(pClave);
        assertEquals("hola",web2.obtenerPAsociadas());
    }

    @Test
    public void obtenerPalabraPorPos() {
        PClave pClave = new PClave("hola");
        web2.añadirPalabraRelacionada(pClave);
        assertEquals("hola",web2.obtenerPalabraPorPos(1));
    }

}