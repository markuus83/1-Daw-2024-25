import java.util.ArrayList;

import Contratos.Contrato;
import Contratos.ContratoEnPracticas;
import Contratos.ContratoIndefinido;
import Contratos.ContratoTemporal;
import Utils.TipoPagasExtra;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<Contrato> contratos = new ArrayList<>();

        ContratoIndefinido contratoIndefinido1 = new ContratoIndefinido("Charles", "Foster", "Kane", 35000.0, 0.18, TipoPagasExtra.normal);

        contratos.add(contratoIndefinido1);


        /////////////////////////////////////////


        ContratoIndefinido contratoIndefinido2 = new ContratoIndefinido("Rick", "Blaine", "", 65000.0, 0.25, TipoPagasExtra.prorrateada);

        contratos.add(contratoIndefinido2);


        /////////////////////////////////////////


        ContratoTemporal contratoTemporal1 = new ContratoTemporal("Cool", "Hand", "Luke", 10000.0, 0.6, "12/01/2025", 4);

        contratos.add(contratoTemporal1);

        
        /////////////////////////////////////////
        
        
        ContratoEnPracticas contratoEnPracticas = new ContratoEnPracticas("Harrison", "Smith", "", 15000.0, 0.2, "Desenvolvemento de Aplicacións Web");

        contratos.add(contratoEnPracticas);


        for (Contrato contrato : contratos) {
            System.out.println(contrato.toString());
        }
    }

}