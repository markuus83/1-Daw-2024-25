import java.util.Hashtable;

public class App {
    
    public static void main(String[] args) {

        Hashtable<Integer, Factura> facturas = new Hashtable<>();

        String[] dnis = new String[10];
        double[] prezos = new double[10];

        // Engadir datos aos vectores
        dnis[0] = "23977458G"; prezos[0] = -150.75; // Inválido Prezo
        dnis[1] = "39339438P"; prezos[1] = 200.00; // Válido
        dnis[2] = "34567890C"; prezos[2] = 99.99; // Inválido DNI
        dnis[3] = "45678901D"; prezos[3] = 50.50; // Inválido DNI
        dnis[4] = "10184419L"; prezos[4] = 300.00; // Vaĺido
        dnis[5] = "25679974Z"; prezos[5] = 450.00; // Vaĺido
        dnis[6] = "69013198L"; prezos[6] = -75.25; // Inválido Prezo
        dnis[7] = "89012345H"; prezos[7] = 125.75; // Inválido DNI
        dnis[8] = "54924888Z"; prezos[8] = 50.50; // Válido
        dnis[9] = "96396159P"; prezos[9] = -200.00; // Inválido Prezo

        for (int i = 0; i < prezos.length; i++) {
            //Xeramos un obxecto factura e engadimos dito obxecto ao HasTable dándolle un valor automático
            try {
                Factura factura = new Factura(dnis[i], prezos[i]);
                facturas.put(factura.getNumeroFactura(), factura);

            } catch (ExcepcionDNIInvalido  e) {
                System.out.println("Erro ao crear a factura: "+ e.getMessage());

            //Erros inesperados
            } catch (ExcepcionNumeroNegativo e) {
                System.out.println("Erro ao crear a factura: " + e.getMessage());
            }
        }

        System.out.println("\nFacturas: ");

        for (Factura factura : facturas.values()) {
            System.out.println(factura);
        }

    }
}
