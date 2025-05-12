package modelo.libros;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;

import modelo.usuarios.Cliente;
import utiles.excepcions.ClienteSancionado;
import utiles.excepcions.PrestamoActivo;

public class Prestamo implements Serializable{
    
    public static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Exemplar exemplar;
    private Cliente cliente;
    private LocalDate dataPrestamo;
    private Optional<LocalDate> dataDevolucion;
    private LocalDate dataLimite;

    public Prestamo(Exemplar exemplar, Cliente cliente) throws PrestamoActivo, ClienteSancionado {
        this.setExemplar(exemplar);
        this.setCliente(cliente);
        this.dataPrestamo = LocalDate.now();
        this.dataLimite = calcularDataLimite();
        this.dataDevolucion = Optional.empty(); 
    }

    //Getters&Setters
    public Exemplar getExemplar() {
        return exemplar;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getDataPrestamo() {
        return dataPrestamo;
    }

    public Optional<LocalDate> getDataDevolucion() {
        return dataDevolucion;
    }

    public LocalDate getDataLimite() {
        return dataLimite;
    }

    public String getDataPrestamoTexto() {
        return dataPrestamo.format(FORMATO);
    }

    /**
     * Método que devolve a data de devolución do préstamo nunha cadena de texto
     */
    public String getDataDevolucionTexto() {
        return dataDevolucion
                .map(d -> d.format(FORMATO))
                .orElse("Non devolto");
    }

    public String dataLimiteTexto() {
        return dataLimite.format(FORMATO);
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    /**
     * Método que calcula a data límite de devolución do préstamo
     */
    private LocalDate calcularDataLimite() {
        LocalDate limite = dataPrestamo.plusWeeks(2);
        if (limite.getDayOfWeek() == DayOfWeek.SUNDAY) {
            limite = limite.plusDays(1);
        }
        return limite;
    }

    public void devolver() {
        this.dataDevolucion = Optional.of(LocalDate.now());
    }

    public boolean estaDevolto() {
        return dataDevolucion != null;
    }

    public boolean foiDevoltoForaDePrazo() {
        return dataDevolucion
                .map(data -> data.isAfter(dataLimite))
                .orElse(false);
    }

    /**
     * Método que verifica se un cliente ten sancións activas. 
     */
    public static boolean tenSancion(Cliente cliente) {
        ArrayList<Prestamo> historial = cliente.getHistorialPrestamos();
        int count = 0;
        LocalDate haiUnAno = LocalDate.now().minusYears(1);

        for (Prestamo p : historial) {
            if (p.getDataPrestamo().isAfter(haiUnAno) && p.foiDevoltoForaDePrazo()) {
                count++;
            }
        }
        return count >= 2;
    }

    
    
    public void setCliente(Cliente cliente) throws PrestamoActivo, ClienteSancionado {
        if (cliente.tenPrestamoActivo()) {
            throw new PrestamoActivo("Préstamo activo!");
        }
        if (tenSancion(cliente)) {
            throw new ClienteSancionado("Cliente sancionado!");
        }

        this.cliente = cliente;
        cliente.engadirPrestamo(this); 
    }

    
}
