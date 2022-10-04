import junit.framework.TestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class MainTest extends TestCase {
    private static Main main;
    @BeforeEach
    public void setUp() {
        main = new Main();
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    void cargarArchivos (){
        Main.cargarArchivos("words.txt","index-2022-2023","pld-arcs-1-N-2022-2023");
        assertEquals(main.devolverWebs().devolverWebPorPos(0).obtenerNombre(), "0-00.pl");
        //archivo con una línea sin :
        //archivo sin línea entre medias
        //archivo vacío

    }

    @Test
    void cargarRelacionesWebs() {

        //hashmap vacío
        //array de relaciones vacío
        //una web sin relaciones
        //relación con una web que no existe

    }

    @Test
    void cargarRelacionesPalabras() {
        //relaciones con una palabra vacía ""
    }
}