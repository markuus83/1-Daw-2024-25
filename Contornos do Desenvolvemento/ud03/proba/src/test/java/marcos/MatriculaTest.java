package marcos;

import org.junit.jupiter.api.Test;

class MatriculaTest {

    @Test
    void testMatricula() {
        Alumno alumno = new Alumno("12345678A", true);
        Modulo modulo = new Modulo("Programación", "Pepito", "Aprender a programar", 100, 10);
        Matricula matricula = new Matricula(alumno, modulo, 10, "2021/2022");
        System.out.println(matricula);
    }

    @Test
    void testGetAlumno() {
        Alumno alumno = new Alumno("12345678A", true);
        Modulo modulo = new Modulo("Programación", "Pepito", "Aprender a programar", 100, 10);
        Matricula matricula = new Matricula(alumno, modulo, 10, "2021/2022");
        System.out.println(matricula.getAlumno());
    }

    @Test
    void testSetAlumno() {
        Alumno alumno = new Alumno("12345678A", true);
        Modulo modulo = new Modulo("Programación", "Pepito", "Aprender a programar", 100, 10);
        Matricula matricula = new Matricula();
        matricula.setAlumno(alumno);
        System.out.println(matricula.getAlumno());
    }

    @Test
    void testGetModulo() {
        Alumno alumno = new Alumno("12345678A", true);
        Modulo modulo = new Modulo("Programación", "Pepito", "Aprender a programar", 100, 10);
        Matricula matricula = new Matricula(alumno, modulo, 10, "2021/2022");
        System.out.println(matricula.getModulo());
    }

    @Test
    void testSetModulo() {
        Alumno alumno = new Alumno("12345678A", true);
        Modulo modulo = new Modulo("Programación", "Pepito", "Aprender a programar", 100, 10);
        Matricula matricula = new Matricula();
        matricula.setModulo(modulo);
        System.out.println(matricula.getModulo());
    }

    @Test
    void testGetNota() {
        Alumno alumno = new Alumno("12345678A", true);
        Modulo modulo = new Modulo("Programación", "Pepito", "Aprender a programar", 100, 10);
        Matricula matricula = new Matricula(alumno, modulo, 10, "2021/2022");
        System.out.println(matricula.getNota());
    }

    @Test
    void testSetNota() {
        Alumno alumno = new Alumno("12345678A", true);
        Modulo modulo = new Modulo("Programación", "Pepito", "Aprender a programar", 100, 10);
        Matricula matricula = new Matricula();
        matricula.setNota(10);
        System.out.println(matricula.getNota());
    }

    @Test
    void testGetCurso() {
        Alumno alumno = new Alumno("12345678A", true);
        Modulo modulo = new Modulo("Programación", "Pepito", "Aprender a programar", 100, 10);
        Matricula matricula = new Matricula(alumno, modulo, 10, "2021/2022");
        System.out.println(matricula.getCurso());
    }

    @Test
    void testSetCurso() {
        Alumno alumno = new Alumno("12345678A", true);
        Modulo modulo = new Modulo("Programación", "Pepito", "Aprender a programar", 100, 10);
        Matricula matricula = new Matricula();
        matricula.setCurso("2021/2022");
        System.out.println(matricula.getCurso());
    }

    @Test
    void testToString() {
        Alumno alumno = new Alumno("12345678A", true);
        Modulo modulo = new Modulo("Programación", "Pepito", "Aprender a programar", 100, 10);
        Matricula matricula = new Matricula(alumno, modulo, 10, "2021/2022");
        System.out.println(matricula.toString());
    }

    @Test
    void testMatriculaVacia() {
        Matricula matricula = new Matricula();
        System.out.println(matricula);
    }

    
}