package marcos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class NivelTest {
    
    @Test
    public void testSetNivel() {
        Nivel nivel = new Nivel();
        nivel.setNivel("Básico");
        assertEquals("Básico", nivel.getNivel());
    }
    
    @Test
    public void testToString() {
        Nivel nivel = new Nivel();
        nivel.setNivel("Básico");
        assertEquals("Nivel [nivel=Básico]", nivel.toString());
    }

    @Test
    public void testConstructor() {
        Nivel nivel = new Nivel("Básico");
        assertEquals("Básico", nivel.getNivel());
    }

    @Test
    public void testEquals() {
        Nivel nivel1 = new Nivel("Básico");
        Nivel nivel2 = new Nivel("Básico");
        assertFalse(nivel1.equals(nivel2));
    }

    @Test
    public void testNotEquals() {
        Nivel nivel1 = new Nivel("Básico");
        Nivel nivel2 = new Nivel("Avanzado");
        assertFalse(nivel1.equals(nivel2));
    }

    @Test
    public void testHashCode() {
        Nivel nivel1 = new Nivel("Básico");
        Nivel nivel2 = new Nivel("Básico");
        assertFalse(nivel1.hashCode() == nivel2.hashCode());
    }

    @Test
    public void testNotHashCode() {
        Nivel nivel1 = new Nivel("Básico");
        Nivel nivel2 = new Nivel("Avanzado");
        assertFalse(nivel1.hashCode() == nivel2.hashCode());
    }

    @Test
    public void testHashCodeEquals() {
        Nivel nivel1 = new Nivel("Básico");
        Nivel nivel2 = new Nivel("Básico");
        assertFalse(nivel1.hashCode() == nivel2.hashCode());
    }
}
