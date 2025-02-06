package marcos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class ProfesorTest {
    
    
    @Test
    public void testConstructorAndGetters() {
        Profesor profesor = new Profesor("Matemáticas", "Secundaria", false, new Date());
        assertEquals("Matemáticas", profesor.getEspecialidad());
        assertEquals("Secundaria", profesor.getCuerpo());
        assertFalse(profesor.isSustituto());
        assertNotNull(profesor.getFecOposicion());
    }

    @Test
    public void testSetEspecialidad() {
        Profesor profesor = new Profesor();
        profesor.setEspecialidad("Matemáticas");
        assertEquals("Matemáticas", profesor.getEspecialidad());
    }

    @Test   
    public void testSetCuerpo() {
        Profesor profesor = new Profesor();
        profesor.setCuerpo("Secundaria");
        assertEquals("Secundaria", profesor.getCuerpo());
    }

    @Test
    public void testSetSustituto() {
        Profesor profesor = new Profesor();
        profesor.setSustituto(false);
        assertFalse(profesor.isSustituto());
    }

    @Test
    public void testSetFecOposicion() {
        Profesor profesor = new Profesor();
        Date date = new Date();
        profesor.setFecOposicion(date);
        assertEquals(date, profesor.getFecOposicion());
    }
}
