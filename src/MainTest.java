import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class MainTest {
    Main main;
    @Before
    public void setUp() throws Exception {
        main = new Main();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void cargarPalabras() {

    }

    @Test
    public void cargarWebs() throws IOException {
        main.cargarWebs("index-2022-2023"); //cargar los archivos
        assertEquals(main.devolverWebs().devolverWebPorId(0).obtenerNombre(), "0-00.pl"); //la primera web se llama "0-00.pl"
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