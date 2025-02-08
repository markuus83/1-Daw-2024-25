/**
 * 1. Crea o enumerando TipoCombustible no paquete utils os seguintes tipos de combustible: diésel, gasolina e eléctrico.
 * 
 * 2. Crea a clase Vehículo no paquete concesionario coas seguintes características:
 * 
 * 
    Crea un método estático que comprobe que o formato da matricula que se lle pasa por parámetro é correcto. Este componse de 4 números e 3 consonantes maiúsculas a continuación.

    Esta clase debe de almacenar a matrícula do vehículo, a marca, o modelo, o tipo de combustible e a velocidade actual.

    Ademais debes almacenar o número de obxectos creados desta clase.

    Crea unha variable estática na clase que indique a velocidade máxima que pode circular un vehículo, cun valor inicial de 120 km/h. Esta velocidade pódese modificar ao longo dunha execución.

    Crea getters e setters necesarios.

    Crea un construtor que reciba como parámetros a matricula, marca e modelo. O tipo de combustible por defecto será gasolina. A velocidade inicial é de 0 km/h. Comproba que o formato da matrícula sexa correcto, senón almacena a matricula 0000XXX.

    Crea outro construtor que ademais dos parámetros do anterior reciba o tipo de combustible.

    Documenta os construtores.

    Crea un método privado que reciba unha velocidade (pode ser positiva ou negativa) e aumente ou diminúa a velocidade do vehículo segundo se o valor recibido é positivo ou negativo. En todo caso, a velocidade non poderá ser maior que a velocidade máxima nin menor que 0.

    Crea un método público void acelerar() que aumente a velocidade do vehículo en 10km/h. Utiliza o método privado creado anteriormente para a modificación da velocidade.

    Crea un método público void acelerar(int velocidade) que aumente a velocidade do vehículo segundo o parámetro indicado. Utiliza o método privado creado anteriormente para a modificación da velocidade.

    Crea un método público void decelerar() que diminúa a velocidade do vehículo en 10km/h. Utiliza o método privado creado anteriormente para a modificación da velocidade.

    Crea un método público void decelerar(int velocidade) que diminúa a velocidade do vehículo segundo o parámetro indicado. Utiliza o método privado creado anteriormente para a modificación da velocidade.

    Documenta os métodos.

 */

import concesionario.Vehiculo;
import utils.TipoCombustible;

public class Main {

    public static void main(String[] args) {

        System.out.println(Vehiculo.getNumeroTotalVehiculos()); // 0
        
        Vehiculo leon = new Vehiculo("1234CGF", "SEAT", "León");
        System.out.println(Vehiculo.getNumeroTotalVehiculos()); // 1
        Vehiculo c3 = new Vehiculo("6894DEF", "Citroen", "C3", TipoCombustible.ELECTRICO);
        System.out.println(Vehiculo.getNumeroTotalVehiculos()); // 2

        System.out.println(leon.getMatricula() + " " + leon.getTipoCombustible()); // 1234CGF GASOLINA
        System.out.println(c3.getMatricula() + " " + c3.getTipoCombustible()); // 0000XXX ELECTRICO

        leon.acelerar(20);
        leon.acelerar();
        System.out.println(leon.getVelocidade()); // 30.0

        leon.acelerar(100);
        System.out.println(leon.getVelocidade()); // 120.0

        leon.decelerar();
        leon.decelerar(200);
        System.out.println(leon.getVelocidade()); // 0.0

        Vehiculo.setVelocidadeMaxima(130);

        leon.acelerar(125);
        System.out.println(leon.getVelocidade()); // 125.0

    }
    
}