package marcos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MatriculaTest {
    
    private Matricula matricula;
    private Alumno alumno;
    private Modulo modulo;

    @BeforeEach
    void setUp() {
        alumno = new Alumno("Juan Perez", "12345678A"); // Suponiendo un constructor de Alumno
        modulo = new Modulo("Matemáticas", "M101"); // Suponiendo un constructor de Modulo
        matricula = new Matricula(alumno, modulo, 85, "2024");
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals(alumno, matricula.getAlumno());
        assertEquals(modulo, matricula.getModulo());
        assertEquals(85, matricula.getNota());
        assertEquals("2024", matricula.getCurso());
    }

    @Test
    void testSetAlumno() {
        Alumno nuevoAlumno = new Alumno("Maria Lopez", "87654321B");
        matricula.setAlumno(nuevoAlumno);
        assertEquals(nuevoAlumno, matricula.getAlumno());
    }

    @Test
    void testSetModulo() {
        Modulo nuevoModulo = new Modulo("Física", "F102");
        matricula.setModulo(nuevoModulo);
        assertEquals(nuevoModulo, matricula.getModulo());
    }

    @Test
    void testSetNota() {
        matricula.setNota(90);
        assertEquals(90, matricula.getNota());
    }

    @Test
    void testSetCurso() {
        matricula.setCurso("2025");
        assertEquals("2025", matricula.getCurso());
    }

    @Test
    void testToString() {
        String expected = "Matricula [alumno=" + alumno + ", modulo=" + modulo + ", nota=85, curso=2024]";
        assertEquals(expected, matricula.toString());
    }
}
