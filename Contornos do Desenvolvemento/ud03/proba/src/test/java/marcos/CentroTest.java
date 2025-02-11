package marcos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


public class CentroTest {
    
    @Test
    public void testConstructorAndGetters() {
        Centro centro = new Centro(1, "IES Abastos", "Valencia", "Calle de los Abastos", "10", 46023);
        assertEquals(1, centro.getCodigo());
        assertEquals("IES Abastos", centro.getNombre());
        assertEquals("Valencia", centro.getLocalidad());
        assertEquals("Calle de los Abastos", centro.getCalle());
        assertEquals("10", centro.getNumero());
        assertEquals(46023, centro.getCodigoPostal());
    }

    @Test
    public void testSetCodigo() {
        Centro centro = new Centro();
        centro.setCodigo(2);
        assertEquals(2, centro.getCodigo());
    }

    @Test
    public void testSetNombre() {
        Centro centro = new Centro();
        centro.setNombre("IES Abastos");
        assertEquals("IES Abastos", centro.getNombre());
    }

    @Test
    public void testSetLocalidad() {
        Centro centro = new Centro();
        centro.setLocalidad("Valencia");
        assertEquals("Valencia", centro.getLocalidad());
    }

    @Test
    public void testSetCalle() {
        Centro centro = new Centro();
        centro.setCalle("Calle de los Abastos");
        assertEquals("Calle de los Abastos", centro.getCalle());
    }

    @Test
    public void testSetNumero() {
        Centro centro = new Centro();
        centro.setNumero("10");
        assertEquals("10", centro.getNumero());
    }

    @Test
    public void testSetCodigoPostal() {
        Centro centro = new Centro();
        centro.setCodigoPostal(46023);
        assertEquals(46023, centro.getCodigoPostal());
    }

    @Test
    public void testToString() {
        Centro centro = new Centro(1, "IES Abastos", "Valencia", "Calle de los Abastos", "10", 46023);
        assertEquals("Centro [codigo=1, nombre=IES Abastos, localidad=Valencia, calle=Calle de los Abastos, numero=10, codigoPostal=46023]", centro.toString());
    }

    @Test
    public void testEquals() {
        Centro centro1 = new Centro(1, "IES Abastos", "Valencia", "Calle de los Abastos", "10", 46023);
        Centro centro2 = new Centro(1, "IES Abastos", "Valencia", "Calle de los Abastos", "10", 46023);
        assertFalse(centro1.equals(centro2));
    }
    
    @Test
    public void testHashCode() {
        Centro centro1 = new Centro(1, "IES Abastos", "Valencia", "Calle de los Abastos", "10", 46023);
        Centro centro2 = new Centro(1, "IES Abastos", "Valencia", "Calle de los Abastos", "10", 46023);
        assertFalse(centro1.hashCode() == centro2.hashCode());
    }

  

}
