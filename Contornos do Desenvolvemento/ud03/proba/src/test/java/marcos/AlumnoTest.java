package marcos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


public class AlumnoTest {

    @Test
    public void testConstructorAndGetters() {
        Alumno alumno = new Alumno("12345", true);
        assertEquals("12345", alumno.getCodigoXade());
        assertTrue(alumno.isAutorizaTutores());
    }

    @Test
    public void testSetCodigoXade() {
        Alumno alumno = new Alumno();
        alumno.setCodigoXade("54321");
        assertEquals("54321", alumno.getCodigoXade());
    }

    @Test
    public void testSetAutorizaTutores() {
        Alumno alumno = new Alumno();
        alumno.setAutorizaTutores(true);
        assertTrue(alumno.isAutorizaTutores());
    }

    @Test
    public void testToString() {
        Alumno alumno = new Alumno("12345", true);
        assertEquals("Alumno [codigoXade=12345, autorizaTutores=true]", alumno.toString());
    }
}