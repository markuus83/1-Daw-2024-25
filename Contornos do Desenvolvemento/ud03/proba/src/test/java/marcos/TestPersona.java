package marcos;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class TestPersona {

    @Test
    public void comprobarNombre(){

        Persona mengano = new Persona();
        mengano.setNombre("Pepe");

        boolean resultado = mengano.getNombre() == "Pepe";

        assertTrue(resultado);

    }
}  