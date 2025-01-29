package marcos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CicloTest {

    private Ciclo ciclo;
    private Nivel nivel;
    private Centro centro;

    @BeforeEach
    public void setUp() {
        nivel = new Nivel("Superior");
        centro = new Centro(1, "Centro de Pruebas", "Localidad", "Calle", "1", 12345);
        ciclo = new Ciclo("C001", "Ciclo de Pruebas", nivel, centro);
    }

    @Test
    public void testGetCodigo() {
        assertEquals("C001", ciclo.getCodigo());
    }

    @Test
    public void testSetCodigo() {
        ciclo.setCodigo("C002");
        assertEquals("C002", ciclo.getCodigo());
    }

    @Test
    public void testGetNombre() {
        assertEquals("Ciclo de Pruebas", ciclo.getNombre());
    }

    @Test
    public void testSetNombre() {
        ciclo.setNombre("Nuevo Ciclo");
        assertEquals("Nuevo Ciclo", ciclo.getNombre());
    }

    @Test
    public void testGetNivel() {
        assertEquals(nivel, ciclo.getNivel());
    }

    @Test
    public void testSetNivel() {
        Nivel nuevoNivel = new Nivel("Medio");
        ciclo.setNivel(nuevoNivel);
        assertEquals(nuevoNivel, ciclo.getNivel());
    }

    @Test
    public void testGetCentro() {
        assertEquals(centro, ciclo.getCentro());
    }

    @Test
    public void testSetCentro() {
        Centro nuevoCentro = new Centro(2, "Nuevo Centro", "Nueva Localidad", "Nueva Calle", "2", 54321);
        ciclo.setCentro(nuevoCentro);
        assertEquals(nuevoCentro, ciclo.getCentro());
    }

    @Test
    public void testToString() {
        String expected = "Ciclo [codigo=C001, nombre=Ciclo de Pruebas, nivel=Nivel [nivel=Superior], centro=Centro [codigo=1, nombre=Centro de Pruebas, localidad=Localidad, calle=Calle, numero=1, codigoPostal=12345]]";
        assertEquals(expected, ciclo.toString());
    }
}