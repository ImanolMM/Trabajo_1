import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListaWebTest {

    private ListaWeb lista1;
    private Web web1,web2,web3,web4;

    @Before
    public void setUp() {
        Web web1 = new Web("pica.si",0);
        Web web2 = new Web("gill.q",1);
        Web web3 = new Web("www.youtube.com",2);
        lista1 = new ListaWeb();
        lista1.añadirWeb(web1);
        lista1.añadirWeb(web2);
        lista1.añadirWeb(web3);
    }

    @After
    public void tearDown(){
        lista1 = null;
    }

    @Test
    public void id2String() {
        assertEquals("pica.si",lista1.id2String(0));
        assertEquals("gill.q",lista1.id2String(1));
    }

    @Test
    public void obtenerNumWebs() {
        assertEquals(3,lista1.obtenerNumWebs());
    }

    @Test
    public void devolverWebPorPos() {
        Web web4 = new Web("si.p",5);
        lista1.añadirWeb(web4);
        assertEquals(web4,lista1.devolverWebPorPos(3));
    }

    @Test
    public void quitarWeb() {
        lista1.quitarWeb(1);
        assertEquals(1,lista1.obtenerNumWebs());
    }
}