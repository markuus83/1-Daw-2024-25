package marcos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class PersonaTest {

    @Test
    public void testPersona() {
        Persona persona = new Persona();
        assertTrue(persona instanceof Persona);
    }

    @Test
    public void testSetDni() {
        Persona persona = new Persona();
        persona.setDni("12345678A");
        assertEquals("12345678A", persona.getDni());
    }

    @Test
    public void testSetNombre() {
        Persona persona = new Persona();
        persona.setNombre("Juan");
        assertEquals("Juan", persona.getNombre());
    }

    @Test
    public void testSetApellido1() {
        Persona persona = new Persona();
        persona.setApellido1("García");
        assertEquals("García", persona.getApellido1());
    }

    @Test
    public void testSetApellido2() {
        Persona persona = new Persona();
        persona.setApellido2("Pérez");
        assertEquals("Pérez", persona.getApellido2());
    }

    @Test
    public void testSetCorreo() {
        Persona persona = new Persona();
        persona.setCorreo("miau");
        assertEquals("miau", persona.getCorreo());
    }

    @Test
    public void testSetMovil() {
        Persona persona = new Persona();
        persona.setMovil(666555444);
        assertEquals(666555444, persona.getMovil());
    }

    @Test
    public void testSetFecNacimiento() {
        Persona persona = new Persona();
        persona.setFecNacimiento(LocalDate.of(1990, 1, 1));
        assertEquals(LocalDate.of(1990, 1, 1), persona.getFecNacimiento());
    }

    @Test
    public void testSetIban() {
        Persona persona = new Persona();
        persona.setIban("ES1234567890");
        assertEquals("ES1234567890", persona.getIban());
    }

    @Test
    public void testToString() {
        Persona persona = new Persona();
        persona.setDni("12345678A");
        persona.setNombre("Juan");
        persona.setApellido1("García");
        persona.setApellido2("Pérez");
        persona.setCorreo("miau");
        persona.setMovil(666555444);
        persona.setFecNacimiento(LocalDate.of(1990, 1, 1));
        persona.setIban("ES1234567890");
        assertEquals(
                "Persona [dni=12345678A, nombre=Juan, apellido1=García, apellido2=Pérez, correo=miau, movil=666555444, fecNacimiento=1990-01-01, iban=ES1234567890]",
                persona.toString());
    }
}