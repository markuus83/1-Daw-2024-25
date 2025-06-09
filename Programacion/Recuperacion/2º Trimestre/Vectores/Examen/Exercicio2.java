package Examen;

import java.util.Optional;

public class Exercicio2 {
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


    /**
     * Método encargado de devover o produto escalar de dous vectores. Comproba que os vectores teñen o mesmo tamaño. Senón é así, devolver o obxecto Option baleiro.
     * 
     * Explicación de producto escalar -> Dados os vectores U=[u1, u2, u3, etc...] e V=[v1, v2, v3, v4, etc...] o produto escalar é u1*v1 + u2*v2 + u3*v3 + ...
     */
    public static Optional<Integer> productoEscalar(int[] vector1, int[] vector2){

        if (vector1.length != vector2.length || vector1 == null || vector2 == null) {
            return Optional.empty();
        }

        int sumaTotal = 0;
        for (int i = 0; i < vector1.length; i++) {
            sumaTotal += vector1[i]*vector2[i];
        }

        return Optional.of(sumaTotal);

    }


    /**
     * Método encargado de devolver a distancia entre dous puntos pero tan só se os puntos teñen 2 elementos. En caso contrario devolve o obxecto Optional baleiro.
     * 
     * Para cada vector, o primeiro elemento correspóndese coa coordenada X e o segundo coa coordenada Y.
     */
    public static Optional<Double> distanciaEntreDousPuntos(double[] vector1, double[] vector2){

        //RECALCULAR LA DISTANCIA ENTRE DOS PUNTOS
        //RECALCULAR LA DISTANCIA ENTRE DOS PUNTOS
        //RECALCULAR LA DISTANCIA ENTRE DOS PUNTOS
        //RECALCULAR LA DISTANCIA ENTRE DOS PUNTOS
        //RECALCULAR LA DISTANCIA ENTRE DOS PUNTOS
        //RECALCULAR LA DISTANCIA ENTRE DOS PUNTOS
        //RECALCULAR LA DISTANCIA ENTRE DOS PUNTOS
        //RECALCULAR LA DISTANCIA ENTRE DOS PUNTOS
        //RECALCULAR LA DISTANCIA ENTRE DOS PUNTOS
        //RECALCULAR LA DISTANCIA ENTRE DOS PUNTOS

        int distancia1 = vector1.length;
        int distancia2 = vector2.length;

        if (distancia1 != 2 || distancia1 != distancia2  ) {
            return Optional.empty();
        }

        double suma1 = vector1[0]+vector1[1];
        double suma2 = vector2[0]+vector2[1];
        
        return Optional.of(Math.pow(suma1, suma1)+Math.pow(suma2, suma2));
    }

    

    /**
     * Método encargado de comprobar que unha matriz é identidade.
     * 
     * Unha matriz identidade é aquela que é cadrada (mesmo número de filas que de columnas) e que todos os elementos da diagonal principal son 1 e o resto 0.
     */
    public static boolean eMatrizIdentidade(int[][] matriz){

        int filas = matriz.length;
        int columnas = matriz[0].length;

        // Se non é cuadrática 
        if(filas != columnas){
            return false;
        }
            
    
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {

                // Se coincide a diagonal e o valor na matriz é distinto de 1 -> False
                if (i == j && matriz[i][j]!=1) {
                    return false;
                }

                // O resto da matriz (o que non é diagonal) e o valor na matriz é distinto de 0 -> False
                if (i!=j && matriz[i][j]!=0) {
                    return false;
                }
            }    
        }
        return true;

    }
}

