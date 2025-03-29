import java.util.Optional;

public class Exercicio2{

    public static void main(String[] args) throws Exception {

        /////////////// Test producto escalar
        int[][] vectores1 = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 1, 0, -1 },
            { 3, 3, 3, 3 }
        };
        int[][] vectores2 = {
            { 4, 5, 6 },
            { 1, 1, 1 },
            { -1, 0, 1 },
            { 2, 2, 2 }
        };

        for (int i = 0; i < vectores1.length; i++) {
            Optional<Integer> resultado = productoEscalar(vectores1[i], vectores2[i]);
            if (resultado.isPresent())
                System.out.println("O producto escalor dos vectores é " + resultado.get());
            else
                System.out.println("Non se pode calcular o producto escalar");
        }

        /////////////////// Test distancia dous puntos
        double[][] puntos1 = {
            { 1.0, 2.0 },
            { 3.0, 4.0 },
            { 0.0, 0.0 },
            { 1.0 }
        };
        double[][] puntos2 = {
            { 4.0, 6.0 },
            { 0.0, 0.0 },
            { 1.0, 1.0 },
            { 2.0, 3.0 }
        };

        for (int i = 0; i < puntos1.length; i++) {
            Optional<Double> resultado = distanciaEntreDousPuntos(puntos1[i], puntos2[i]);
            if (resultado.isPresent())
                System.out.println("A distancia entre dous puntos é: " + resultado.get());
            else
                System.out.println("Non se pode calcular a distancia entre estes dous puntos");
        }

        /////////////////// Test matriz identidade
        int[][][] matrices = {
            {
                { 1, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 1 }
            },
            {
                { 1, 0, 0 },
                { 0, 1, 0 },
                { 1, 0, 1 }
            },
            {
                { 1, 0 },
                { 0, 1 }
            },
            {
                { 1, 0, 0 },
                { 0, 2, 0 },
                { 0, 0, 1 }
            },
            {
                { 1, 0, 0 },
                { 0, 1, 0 }
            }
        };

        for (int i = 0; i < matrices.length; i++) {
            boolean identidade = eMatrizIdentidade(matrices[i]);
            System.out.println("A matriz" + (identidade ? " é " : " non é ") + "unha matriz identidade.");
        }

    }


    public static Optional<Integer> productoEscalar(int[] vector1, int[] vector2){

    }

    public static Optional<Double> distanciaEntreDousPuntos(double[] vector1, double[] vector2){


    }

    public static boolean eMatrizIdentidade(int[][] matriz){

        
    }
}