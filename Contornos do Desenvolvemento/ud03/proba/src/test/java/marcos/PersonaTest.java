package marcos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class PersonaTest {

    @Test
    public void testSetNombre() {
        Persona persona = new Persona();
        persona.setNombre("Pepe");
        assertEquals("Pepe", persona.getNombre());
    }

    @Test
    public void testSetApellido1() {
        Persona persona = new Persona();
        persona.setApellido1("Gonzalez");
        assertEquals("Gonzalez", persona.getApellido1());
    }

    @Test
    public void testSetApellido2() {
        Persona persona = new Persona();
        persona.setApellido2("Pereira");
        assertEquals("Pereira", persona.getApellido2());
    }

    @Test
    public void testSetEdad() {
        Persona persona = new Persona();
        persona.setEdad(30);
        assertEquals(30, persona.getEdad());
    }

    @Test
    public void testSetDni() {
        Persona persona = new Persona();
        persona.setDni("12345678A");
        assertEquals("12345678A", persona.getDni());
    }

    @Test
    public void testToString() {
        Persona persona = new Persona();
        persona.setNombre("Pepe");
        persona.setApellido("Gonzalez");
        persona.setEdad(30);
        persona.setDni("12345678A");
        assertEquals("Persona [nombre=Pepe, apellido=Gonzalez, edad=30, dni=12345678A]", persona.toString());
    }
}