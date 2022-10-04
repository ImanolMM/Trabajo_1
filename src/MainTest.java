import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class MainTest {
    Main main1;
    Main main2;
    @Before
    public void setUp() throws Exception {
        main1 = new Main();
        main2 = new Main();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void cargarPalabras() {

    }

    @Test
    public void cargarWebs() throws IOException {
        main1.cargarWebs("index-2022-2023"); //cargar los archivos
        assertEquals(main1.devolverWebs().devolverWebPorId(0).obtenerNombre(), "0-00.pl"); //la primera web se llama "0-00.pl"
        assertEquals(main1.devolverWebs().devolverWebPorId(main1.devolverWebs().obtenerNumWebs() -1).obtenerNombre(), "zzzz6666.com"); // la ultima web

        main2.cargarWebs("cargarWebTest1"); //una línea está sin ":" entonces salta una lineaMalEception pero el resto se guarda bien
        assertNull(main2.devolverWebs().devolverWebPorId(1));
        assertEquals(main2.devolverWebs().devolverWebPorId(3).obtenerNombre(),"0-200.com");

        main1.cargarWebs("cargarWebTest2"); //archivo vcacío, no hace nada
    }

    @Test
    public void cargarWebrelacionadas() {
    }

    @Test
    public void cargarRelacionesWebs() {
    }

    @Test
    public void cargarRelacionesPalabras() {
    }

    @Test
    public void devolverWebs() {
    }

    @Test
    public void devolverWebRelacionadas() {
    }

    @Test
    public void obtenerPClave() {
    }
}