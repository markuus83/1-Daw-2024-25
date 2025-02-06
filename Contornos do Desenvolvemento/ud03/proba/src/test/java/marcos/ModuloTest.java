package marcos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ModuloTest {
    
    @Test
    public void testSetCodigo() {
        Modulo modulo = new Modulo();
        modulo.setCodigo("M01");
        assertEquals("M01", modulo.getCodigo());
    }

    @Test
    public void testSetNombre() {
        Modulo modulo = new Modulo();
        modulo.setNombre("Programación");
        assertEquals("Programación", modulo.getNombre());
    }

    @Test
    public void testSetDescripcion() {
        Modulo modulo = new Modulo();
        modulo.setDescripcion("Aprender a programar");
        assertEquals("Aprender a programar", modulo.getDescripcion());
    }
    
    @Test
    public void testSetHoras() {
        Modulo modulo = new Modulo();
        modulo.setHoras(100);
        assertEquals(100, modulo.getHoras());
    }

    @Test
    public void testSetSesiones() {
        Modulo modulo = new Modulo();
        modulo.setSesiones(50);
        assertEquals(50, modulo.getSesiones());
    }

    @Test
    public void testToString() {
        Modulo modulo = new Modulo();
        modulo.setCodigo("M01");
        modulo.setNombre("Programación");
        modulo.setDescripcion("Aprender a programar");
        modulo.setHoras(100);
        modulo.setSesiones(50);
        assertEquals("Modulo [codigo=M01, nombre=Programación, descripcion=Aprender a programar, horas=100, sesiones=50]", modulo.toString());
    }

    @Test
    public void testConstructor() {
        Modulo modulo = new Modulo("M01", "Programación", "Aprender a programar", 100, 50);
        assertEquals("M01", modulo.getCodigo());
        assertEquals("Programación", modulo.getNombre());
        assertEquals("Aprender a programar", modulo.getDescripcion());
        assertEquals(100, modulo.getHoras());
        assertEquals(50, modulo.getSesiones());
    }

    @Test
    public void testConstructorVacio1() {
        Modulo modulo = new Modulo();
        assertEquals(null, modulo.getCodigo());
        assertEquals(null, modulo.getNombre());
        assertEquals(null, modulo.getDescripcion());
        assertEquals(null, modulo.getHoras());
        assertEquals(null, modulo.getSesiones());
    }

    @Test
    public void testSetCodigoVacio() {
        Modulo modulo = new Modulo();
        modulo.setCodigo(null);
        assertEquals(null, modulo.getCodigo());
    }

    @Test
    public void testSetNombreVacio() {
        Modulo modulo = new Modulo();
        modulo.setNombre(null);
        assertEquals(null, modulo.getNombre());
    }

    @Test
    public void testSetDescripcionVacio() {
        Modulo modulo = new Modulo();
        modulo.setDescripcion(null);
        assertEquals(null, modulo.getDescripcion());
    }

    @Test
    public void testSetHorasVacio() {
        Modulo modulo = new Modulo();
        modulo.setHoras(null);
        assertEquals(null, modulo.getHoras());
    }

    @Test
    public void testSetSesionesVacio() {
        Modulo modulo = new Modulo();
        modulo.setSesiones(null);
        assertEquals(null, modulo.getSesiones());
    }

    @Test
    public void testToStringVacio() {
        Modulo modulo = new Modulo();
        assertEquals("Modulo [codigo=null, nombre=null, descripcion=null, horas=null, sesiones=null]", modulo.toString());
    }

}

