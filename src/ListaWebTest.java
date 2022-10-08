import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListaWebTest {

    private ListaWeb lista1;
    private Web web1,web2,web3,web4;

    @Before
    public void setUp() throws DosWebsConMismoIdException {
        Web web1 = new Web("pica.si",0);
        Web web2 = new Web("gill.q",1);
        Web web3 = new Web("www.youtube.com",3);
        Web web4 = new Web("www.mjo.s",3);
        lista1 = new ListaWeb();
        lista1.añadirWeb(web1);
        lista1.añadirWeb(web2);
        lista1.añadirWeb(web3);
    }

    @After
    public void tearDown() throws DosWebsConMismoIdException{
        lista1 = null;
        web1 = null;
        web2 = null;
        web3 = null;
        web4 = null;
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
    public void añadirWeb() {
        assertThrows(DosWebsConMismoIdException.class,
                ()->{
                    lista1.añadirWeb(web4);
                });
    }

    @Test
    public void devolverWebPorPos() {
        assertEquals(web1,lista1.devolverWebPorPos(0));
    }

    @Test
    public void quitarWeb() {
        lista1.quitarWeb(1);
        assertEquals(1,lista1.obtenerNumWebs());
    }
}