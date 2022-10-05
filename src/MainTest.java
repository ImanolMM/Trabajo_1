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
    public void cargarPalabras() throws IOException {
        main1.cargarPalabras("words.txt"); //cargar archivo normal
        assertNotNull(main1.devolverPalabras().obtenerPClave("aardvark"));//existe

        main2.cargarPalabras("cargarPalabrasTest1");// una línea vacía añade un "" No afecta a la ejecución

        main2.cargarPalabras("cargarPalabrasTest2"); // un archivo vacío
    }

    @Test
    public void cargarWebs() throws IOException {
        main1.cargarWebs("index-2022-2023"); //cargar los archivos
        assertEquals(main1.devolverWebs().devolverWebPorId(0).obtenerNombre(), "0-00.pl"); //la primera web se llama "0-00.pl"
        assertEquals(main1.devolverWebs().devolverWebPorId(main1.devolverWebs().obtenerNumWebs() -1).obtenerNombre(), "zzzz6666.com"); // la ultima web

        main2.cargarWebs("cargarWebTest1"); //una línea está sin ":" entonces salta una lineaMalEception pero el resto se guarda bien
        assertNull(main2.devolverWebs().devolverWebPorId(1));
        assertEquals(main2.devolverWebs().devolverWebPorId(3).obtenerNombre(),"0-200.com");

        main1.cargarWebs("cargarWebTest2"); //archivo vacío, no hace nada
    }

    @Test
    public void cargarWebrelacionadas() throws IOException {
        main1.cargarWebRelacionadas("pld-arcs-1-N-2022-2023");// archivo normal
        assertEquals(main1.devolverWebRelacionadas().obtenerListaWebs(0)[0],"521000");

        main2.cargarWebRelacionadas("cargarWebRelacionadasTest1");// una línea vacía + los id no están en orden
        assertEquals(main2.devolverWebRelacionadas().obtenerListaWebs(4) [0],"244381"); //TODO hay que hacerlo hashmap

        main1.cargarWebRelacionadas("cargarWebRelacionadasTest2");// archivo vacío
    }
    @Test
    public void cargarRelacionesWebs() throws IOException{
        main1.cargarWebs("index-2022-2023");
        main1.cargarWebRelacionadas("pld-arcs-1-N-2022-2023");
        main1.cargarRelacionesWebs();
        assertEquals(main1.devolverWebs().devolverWebPorId(0).obtenerWebDeWasociadas(0).obtenerId(),521000); //La web 0 en su lista de websRelacionadas tiene en su primera posicion la web 521000

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