package marcos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class MatriculaTest {

    @Test
    public void testConstructorAndGetters() {
        Alumno alumno = new Alumno("12345", true);
        Modulo modulo = new Modulo("Programacion", null, null, 200, null);
        Matricula matricula = new Matricula(alumno, modulo, 10, "2021-2022");
        assertEquals(alumno, matricula.getAlumno());
        assertEquals(modulo, matricula.getModulo());
        assertEquals(10, matricula.getNota());
        assertEquals("2021-2022", matricula.getCurso());
    }


    @Test
    public void testSetAlumno() {
        Alumno alumno = new Alumno("12345", true);
        Matricula matricula = new Matricula();
        matricula.setAlumno(alumno);
        assertEquals(alumno, matricula.getAlumno());
    }


    @Test
    public void testSetModulo() {
        Modulo modulo = new Modulo("Programacion", null, null, 200, null);
        Matricula matricula = new Matricula();
        matricula.setModulo(modulo);
        assertEquals(modulo, matricula.getModulo());
    }


    @Test
    public void testSetNota() {
        Matricula matricula = new Matricula();
        matricula.setNota(10);
        assertEquals(10, matricula.getNota());
    }


    @Test
    public void testSetCurso() {
        Matricula matricula = new Matricula();
        matricula.setCurso("2021-2022");
        assertEquals("2021-2022", matricula.getCurso());
    }


    @Test
    public void testToString() {
        Alumno alumno = new Alumno("12345", true);
        Modulo modulo = new Modulo("Programacion", null, null, 200, null);
        Matricula matricula = new Matricula(alumno, modulo, 10, "2021-2022");

        assertEquals("Matricula [alumno=Alumno [codigoXade=12345, autorizaTutores=true], modulo=Modulo [codigo=Programacion, nombre=null, descripcion=null, horas=200, sesiones=null], nota=10, curso=2021-2022]", matricula.toString());

        /**
         * Este estaba mal
         * 
         *   assertEquals("Matricula [alumno=Alumno [dni=12345, repetidor=true], modulo=Modulo [nombre=Programacion, horas=200], nota=10, curso=2021-2022]", matricula.toString());
        */
    }

    @Test
    public void testConstructorVacio() {
        Matricula matricula = new Matricula();
        assertEquals(null, matricula.getAlumno());
        assertEquals(null, matricula.getModulo());
        assertEquals(null, matricula.getNota());
        assertEquals(null, matricula.getCurso());
    }

}
