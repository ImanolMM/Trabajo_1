import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PClaveTest {

    PClave palabra1;
    Web web1;
    @Before
    public void setUp() throws Exception {
        palabra1 = new PClave("casino");
        web1 = new Web("casino.com",1);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void añadirWebRelacioanda() {
        palabra1.añadirWebRelacioanda(web1);
        assertEquals(palabra1.obtenerWebPorPosi(0),web1);
    }

    @Test
    public void obtenerWebPorPosi() {
    }
}