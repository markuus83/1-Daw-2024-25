import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {

        /**
         * LEEMOS O ARQUIVO .CSV E, UTILIZANDO UNHA CLASE RECORD, ENGADIMOS OS DATOS NUN ARRAYLIST
         */
        String rutaFicheiro = "./src/spotify.csv";
        ArrayList<Datos> datos = new ArrayList<>();

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaFicheiro))) {
            //Saltamos a cabeceira
            lector.readLine();
            String liña;

            //Bucle que vai leer todas liñas ata o final
            while ((liña = lector.readLine()) != null) {

                // Separamos os distintos campos do ficheiro
                String[] campos = liña.split(",", -1); 

                if (campos.length >= 6) { 

                    try {
                        
                        //Casteamos os datos segundo o precismoe
                        LocalDate data = LocalDate.parse(campos[0].trim()); 
                        Integer position = Integer.parseInt(campos[1].trim());
                        String song = campos[2].trim();
                        String artist = campos[3].trim(); 
                        Integer duration = Integer.parseInt(campos[5].trim());

                        //Engadimos ó ArrayList
                        datos.add(new Datos(data, position, song, artist, duration));

                    } catch (Exception e) {
                        System.out.println("Erro ao analizar liña: " + liña);
                        e.printStackTrace();
                    }

                }
            }

        } catch (IOException io) {
            System.out.println("Erro: " + io.getMessage());
        }

        /**
         * INICIO DOS STREAMS()
         */

    //1. Imprime os artistas que tiveron un número 1 no ano 2023
        System.out.println("\n1. Número 1 no ano 2023: ");

        datos   .stream() //Iniciamos o Stream
                .filter(n -> n.getData().getYear() == 2023 && n.getPosition() == 1) //Filtramos 
                .map(n -> n.getArtist()) //Convertimos a unha lista de artistas
                .distinct() //Evitamos repetidos
                .forEach(n -> System.out.println("\t- "+n)); //Imprimimos



    //2.Indica o número de canción diferentes que foron número 1 en 2024
        System.out.println("\n2. Cancións que foron número 1 en 2024: ");

        long numeroCancionsTop1 = 
            datos   .stream() //Iniciamos o Stream
                    .filter(n -> n.getData().getYear() == 2024 && n.getPosition() == 1) //Filtramos
                    .count(); //Contamos

        System.out.println("\tExisitiron "+numeroCancionsTop1+" cancións que foron Top 1 en 2024.");



    //3.Indica as cancións de Aitana que estiveron nas 10 primeiras posicións das máis escoitadas.
        System.out.println("\n3. Cancións de Aitana no top 10: ");

        datos   .stream() //Iniciamos o Stream
                .filter(n -> n.getArtist().contains("Aitana") && n.getPosition() <= 10) //Filtramos -> Interpretamos cancións de Aitana como única artista
                .map(n -> n.getSong()) //Convertimos a unha lista de cancións
                .distinct() //Eliminamos repetidos
                .forEach(n -> System.out.println("\t- "+n)); //Imprimimos



    //4.Indica as cancións que foron máis escoitadas durante o mes de agosto de 2024.
        System.out.println("\n4. Cancións máis escoitadas en Agosto de 2024: ");

        datos   .stream() //Iniciamo o Stream
                .filter(n -> n.getData().getMonthValue() == 8 && n.getPosition() == 1) //Filtramos
                .map(n -> n.getSong()) //Convertimos a unha lista de cancións
                .distinct() //Eliminamos repetidos
                .forEach(n -> System.out.println("\t- "+n)); //Imprimimos



    //5.Indica as posicións diferentes que obtiveron as cancións de Aitana ordenadas de menor a maior nunha cadea de texto separada por comas
        System.out.println("\n5. Posicións de aitana ordenadas de menor a maior: ");

        String resposta = datos.stream()
                .filter(n -> n.getArtist().contentEquals("Aitana")) // Só cancións onde Aitana é a única artista
                .map(n -> n.getPosition()) // Extraemos as posicións
                .distinct() // Eliminamos repetidos
                .sorted((c1,c2) -> c1.compareTo(c2)) // Ordenamos de menor a maior directamente
                .map(i -> i.toString()) // Convertimos a texto
                .collect(Collectors.joining(", ", "\t", "")); // Unimos nunha soa cadea, con tabulación ao inicio

        System.out.println(resposta);

        


    //6.Indica a posición máis alta de escoitadas que chegou unha canción de “Cris Mj”.
        System.out.println("\n6. Posición máis alta que acadou 'Cris Mj': ");

        //Convertimos a un optional para evitar o casteo de datos 
        Optional<Integer> posicionCris = 
        datos   .stream()
                .filter(n -> n.getArtist().contains("Cris Mj"))
                .map(n -> n.getPosition())
                .distinct()
                .sorted() 
                .limit(1)
                .findFirst();        
        //Imprimimos
        System.out.println("\tA posición máis alta acadada foi: "+posicionCris.get()+".");


    
    //7.Agrupa as cancións por artista nun map.
        System.out.println("\n7. Agrupar as cancións por artistas nun map: ");

        /**
         * ACLARACIÓN:
         * 
         * Tras intentar eliminar as diferentes cancións duplicadas do map de cada artista, buscando por StackOverflow apareceu unha solución interesante: Utilizar un Set.
         * 
         * Un Set contén internamente un método .equals() que non permite duplicados, polo que ao atopar a mesma canción do artista, non permite engadilo novamente.
         */

        Map<String, Set<String>> mapaArtistas = 
        
        datos   .stream() //Iniciamos o Stream 
                .collect(Collectors.groupingBy( //Agrupamos por artista
                                                    c -> c.getArtist(), //Función que agrupa por artista
                                                    Collectors.mapping( //Agregamos os datos
                                                                        c -> c.getSong(), Collectors.toSet() //Función que agrupa por canción
                                                                        ) 
                                                )
                        );

        //Recorremos o mapa e imprimimos os datos
        //mapaArtistas.forEach((artista, canciones) -> System.out.println("\n\tArtista: " + artista + "\n\t\t- " + String.join("\n\t\t- ", canciones)));

       

    // 8.Indica a número de cancións que superan os 6 minutos que estiveron nas 5 primeiras posicións.
        System.out.println("\n8. Número de cancións que superan os 6 minutos que estiveron nas 5 primeiras posicións: ");

        long cantidadeTotal =
        datos   .stream() //Iniciamos o Stream
                .filter(n -> n.getPosition() <= 5 && n.getDuration_ms() > 6*60000) //Filtramos
                .count(); //Contamos
        
        //Imprimimos
        System.out.println("\tExisten "+cantidadeTotal+" cancións.");
    }

}
