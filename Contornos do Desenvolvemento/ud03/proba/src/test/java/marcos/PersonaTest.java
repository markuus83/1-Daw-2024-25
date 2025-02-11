package marcos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class PersonaTest {

    @Test
    void testPersona() {
        Persona persona = new Persona("12345678A", "Pepito", "Pérez", "123456789");
        assertEquals("12345678A", persona.getDni());
        assertEquals("Pepito", persona.getNombre());
        assertEquals("Pérez", persona.getApellidos());
        assertEquals("123456789", persona.getTelefono());
    }

    @Test
    void testModulo() {
        Modulo modulo = new Modulo("Programación", "Pepito", "Aprender a programar", 100, 10);
        assertEquals("Programación", modulo.getCodigo());
        assertEquals("Pepito", modulo.getNombre());
        assertEquals("Aprender a programar", modulo.getDescripcion());
        assertEquals(100, modulo.getHoras());
        assertEquals(10, modulo.getSesiones());
    }

    @Test
    void testMatricula() {
        Alumno alumno = new Alumno("12345678A", true);
        Modulo modulo = new Modulo("Programación", "Pepito", "Aprender a programar", 100, 10);
        Matricula matricula = new Matricula(alumno, modulo, 10, "2021/2022");
        assertEquals(alumno, matricula.getAlumno());
        assertEquals(modulo, matricula.getModulo());
        assertEquals(10, matricula.getNota());
        assertEquals("2021/2022", matricula.getCurso());
    }

    @Test
    void testGetAlumno() {
        Alumno alumno = new Alumno("12345678A", true);
        Modulo modulo = new Modulo("Programación", "Pepito", "Aprender a programar", 100, 10);
        Matricula matricula = new Matricula(alumno, modulo, 10, "2021/2022");
        assertEquals(alumno, matricula.getAlumno());
    }


    @Test
    void testSetAlumno() {
        Alumno alumno = new Alumno("12345678A", true);
        Modulo modulo = new Modulo("Programación", "Pepito", "Aprender a programar", 100, 10);
        Matricula matricula = new Matricula();
        matricula.setAlumno(alumno);
        assertEquals(alumno, matricula.getAlumno());
    }

    @Test
    void testGetModulo() {
        Alumno alumno = new Alumno("12345678A", true);
        Modulo modulo = new Modulo("Programación", "Pepito", "Aprender a programar", 100, 10);
        Matricula matricula = new Matricula(alumno, modulo, 10, "2021/2022");
        assertEquals(modulo, matricula.getModulo());
    }

    @Test
    void testSetModulo() {
        Alumno alumno = new Alumno("12345678A", true);
        Modulo modulo = new Modulo("Programación", "Pepito", "Aprender a programar", 100, 10);
        Matricula matricula = new Matricula();
        matricula.setModulo(modulo);
        assertEquals(modulo, matricula.getModulo());
    }

    @Test
    void testGetNota() {
        Alumno alumno = new Alumno("12345678A", true);
        Modulo modulo = new Modulo("Programación", "Pepito", "Aprender a programar", 100, 10);
        Matricula matricula = new Matricula(alumno, modulo, 10, "2021/2022");
        assertEquals(10, matricula.getNota());
    }

    @Test
    void testSetNota() {
        Alumno alumno = new Alumno("12345678A", true);
        Modulo modulo = new Modulo("Programación", "Pepito", "Aprender a programar", 100, 10);
        Matricula matricula = new Matricula();
        matricula.setNota(10);
        assertEquals(10, matricula.getNota());
    }

    @Test
    void testGetCurso() {
        Alumno alumno = new Alumno("12345678A", true);
        Modulo modulo = new Modulo("Programación", "Pepito", "Aprender a programar", 100, 10);
        Matricula matricula = new Matricula(alumno, modulo, 10, "2021/2022");
        assertEquals("2021/2022", matricula.getCurso());
    }

    @Test
    void testSetCurso() {
        Alumno alumno = new Alumno("12345678A", true);
        Modulo modulo = new Modulo("Programación", "Pepito", "Aprender a programar", 100, 10);
        Matricula matricula = new Matricula();
        matricula.setCurso("2021/2022");
        assertEquals("2021/2022", matricula.getCurso());
    }

    @Test
    void testToString() {
        Alumno alumno = new Alumno("12345678A", true);
        Modulo modulo = new Modulo("Programación", "Pepito", "Aprender a programar", 100, 10);
        Matricula matricula = new Matricula(alumno, modulo, 10, "2021/2022");
        assertEquals("Matricula [alumno=Alumno [codigoXade=12345678A, autorizaTutores=true], modulo=Modulo [codigo=Programación, nombre=Pepito, descripcion=Aprender a programar, horas=100, sesiones=10], nota=10, curso=2021/2022]", matricula.toString());
    }

}