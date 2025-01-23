package marcos;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestConstructor {

    public void Constructor(){
        
        Persona name = new Persona();

        boolean resultado = name.getNombre() == null;
        assertTrue(resultado);

        assertNull(name.getNombre());
        assertNull(name.getApellido1());
        assertNull(name.getApellido2());
        assertNull(name.getCorreo());
        assertNull(name.getDni());
        assertNull(name.getFecNacimiento());
        assertNull(name.getMovil());

    } 
}