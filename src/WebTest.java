import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class WebTest {

    private Web web1,web2,web3;
    private PClave p1;

    @Before
    public void setUp() throws Exception {
        web1 = new Web("casa.com",1);
        web2 = new Web("jaaajaj.de",2);
        web3 = new Web("hola.net",3);
        p1 = new PClave("hola");
    }

    @After
    public void tearDown() throws Exception {
        web1 = null;
        web2 = null;
        web3 = null;
        p1 = null;
    }

    @Test
    public void obtenerNombre() {
        assertEquals(web1.obtenerNombre(),"casa.com");
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
        ArrayList<String> lista = new ArrayList();
        lista.add("c");
        lista.add("ca");
        lista.add("cas");
        lista.add("casa");
        lista.add("casa.");
        lista.add("casa.c");
        lista.add("casa.co");
        lista.add("casa.com");
        lista.add("a");
        lista.add("as");
        lista.add("asa");
        lista.add("asa.");
        lista.add("asa.c");
        lista.add("asa.co");
        lista.add("asa.com");
        lista.add("s");
        lista.add("sa");
        lista.add("sa.");
        lista.add("sa.c");
        lista.add("sa.co");
        lista.add("sa.com");
        lista.add("a");
        lista.add("a.");
        lista.add("a.c");
        lista.add("a.co");
        lista.add("a.com");
        lista.add(".");
        lista.add(".c");
        lista.add(".co");
        lista.add(".com");
        lista.add("c");
        lista.add("co");
        lista.add("com");
        lista.add("o");
        lista.add("om");
        lista.add("m");
        assertEquals(lista,web1.buscarCombinaciones());
    }

    @Test
    public void obtenerPalabraPorPos() {
        PClave pClave = new PClave("hola");
        web2.añadirPalabraRelacionada(pClave);
        assertEquals("hola",web2.obtenerPalabraPorPos(0));
    }


    @Test
    public void añadirPalabraRelacionada() {
        web3.añadirPalabraRelacionada(p1);
        ListaPClave lista = web3.obtenerPAsociadas();
        assertEquals(lista.obtenerPalabraPorPos(0),p1);
    }

}