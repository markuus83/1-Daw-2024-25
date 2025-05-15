package vista;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import controlador.XestionBibliotecas;
import modelo.usuarios.Usuario;
import utiles.enumerandos.TipoLinguaLibros;
import utiles.excepcions.BibliotecaTenAdmin;
import utiles.excepcions.BibliotecasNonExiste;
import utiles.excepcions.ExemplarExistente;
import utiles.excepcions.ExemplarInvalido;
import utiles.excepcions.ExemplarNonExiste;
import utiles.excepcions.ExemplarXaAsignado;
import utiles.excepcions.ISBNIncorrecto;
import utiles.excepcions.IndiceInvalido;
import utiles.excepcions.LibroExistente;
import utiles.excepcions.UsuarioExistente;

public class MenuAdministradorXeral extends MenuUsuario {

    public MenuAdministradorXeral(Usuario usuario) {
        super(usuario);
    }

    @Override
    protected void mostrar() {

        boolean menuActivo = true;

        while (menuActivo) {
            System.out.println("\n-----------------------");
            System.out.println("\nBenvido ao menu de Administradores Xerais: " + this.getUsuario().getNomeUsuario());
            System.out.println("\t1. Nova Biblioteca: ");
            System.out.println("\t2. Novo Libro: ");
            System.out.println("\t3. Ver Bibliotecas: ");
            System.out.println("\t4. Ver Libros: ");
            System.out.println("\t5. Asignar exemplares a unha biblioteca: ");
            System.out.println("\t6. Ingresar Administrador  de biblioteca: ");
            System.out.println("\t7. Saír: ");

            int option = getInt("> ");

            switch (option) {

                /**
                 * Nova Biblioteca
                 */
                case 1 -> {

                    String nome = getString("\nIngrese o nome: ");
                    String direccion = getString("Ingrese a dirección: ");
                    String cidade = getString("Ingrese a cidade: ");
                    String provincia = getString("Ingrese a provincia: ");

                    try {
                        XestionBibliotecas.getInstance().ingresarBiblioteca(nome, direccion, cidade, provincia);
                    } catch (Exception e) {
                        System.out.println("\nErro: " + e.getMessage());
                        break;
                    }
                    System.out.println("\nBiblioteca creada exitosamente!");

                }

                /**
                 * Novo Libro
                 */
                case 2 -> {
                    System.out.println("\nComo quere ingresar o novo libro:");
                    System.out.println("\t1. Liña de comandos:");
                    System.out.println("\t2. Cargándoo da base de datos:");

                    int option2 = getInt("> ");

                    switch (option2) {

                        /**
                         * Comandos
                         */
                        case 1 -> {

                            String titulo = getString("\nIngrese o título: ");
                            String editorial = getString("Ingrese a editorial: ");
                            String isbn = getString("Ingrese o ISBN: ");
                            int exemplares = getInt("Ingrese a cantidade de exemplares: ");
                            System.out.println("\nEn que lingua está o libro?");
                            System.out.println("\t1. Galego: ");
                            System.out.println("\t2. Castelán: ");
                            System.out.println("\t3. Ingés: ");

                            int optionLingua = getInt("> ");

                            TipoLinguaLibros tipo;

                            switch (optionLingua) {

                                case 1 -> {
                                    tipo = TipoLinguaLibros.GALEGO;
                                }

                                case 2 -> {
                                    tipo = TipoLinguaLibros.CASTELAN;
                                }

                                case 3 -> {
                                    tipo = TipoLinguaLibros.INGLES;
                                }

                                default -> {
                                    System.out.println("\nErro: Opción inválida!");
                                    continue;
                                }
                            }

                            try {

                                if (XestionBibliotecas.getInstance().existeLibro(isbn)) {

                                    XestionBibliotecas.getInstance().ingresarLibro(titulo, editorial, isbn, tipo,
                                            exemplares);

                                    XestionBibliotecas.getInstance().ingresarExemplares(exemplares, isbn);

                                    boolean engadirAutores = true;
                                    while (engadirAutores) {
                                        System.out.println("\nEscriba 'fin' para rematar: ");
                                        String autores = getString("Ingrese o autor/es: ");

                                        if (autores.toLowerCase().trim().equals("fin")) {
                                            engadirAutores = false;
                                            break;
                                        }
                                        XestionBibliotecas.getInstance().ingresarAutoresLibro(isbn, autores);
                                    }
                                }

                            } catch (ISBNIncorrecto | ExemplarInvalido | LibroExistente e) {
                                System.out.println("\nErro: " + e.getMessage());
                                break;
                            }
                            System.out.println("\nLibro e exemplares creados exitosamente!");

                        }

                        /**
                         * Engadir libro mediante un .CSV
                         */
                        case 2 -> {
                            String ruta = "Libros.csv";

                            System.out.println("\nOs libros dispoñibles son: ");
                            this.mostrarTitulosDisponiblesCSV();

                            System.out.print("Introduce o título do libro que queres dar de alta: ");
                            String tituloBuscado = getString("Ingrese o título: ");

                            try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {

                                reader.readLine(); // Saltar a cabeceira
                                String liña;
                                boolean atopado = false;

                                while ((liña = reader.readLine()) != null) {
                                    String[] campos = liña.split(",", -1);

                                    String titulo = campos[0].trim();

                                    if (!titulo.equalsIgnoreCase(tituloBuscado)) {
                                        continue; // Saltamos este libro
                                    }

                                    String editorial = campos[1].trim();
                                    TipoLinguaLibros lingua;

                                    switch (campos[2].trim()) {
                                        case "INGLES" -> lingua = TipoLinguaLibros.INGLES;
                                        case "ESPAÑOL" -> lingua = TipoLinguaLibros.CASTELAN;
                                        case "GALEGO" -> lingua = TipoLinguaLibros.GALEGO;
                                        default -> lingua = TipoLinguaLibros.GALEGO;
                                    }

                                    String[] autores = campos[3].split("&");
                                    String isbn = campos[4].trim();
                                    int numExemplares = Integer.parseInt(campos[5].trim());

                                    if (XestionBibliotecas.getInstance().existeLibro(isbn)) {
                                        XestionBibliotecas.getInstance().ingresarLibroConCSV(titulo, editorial, isbn, lingua, numExemplares, autores);
                                        XestionBibliotecas.getInstance().ingresarExemplares(numExemplares, isbn);
                                        atopado = true;
                                        break; // Xa cargamos o libro, non seguimos lendo
                                    }
                                }

                                if (!atopado) {
                                    System.out.println("Libro non atopado ou xa existe.");
                                } else {
                                    System.out.println("Libro cargado correctamente!");
                                }

                            } catch (IOException | ISBNIncorrecto | LibroExistente | ExemplarInvalido e) {
                                System.out.println("Erro: " + e.getMessage());
                            }
                        }

                        /**
                         * Default
                         */
                        default -> {
                            System.out.println("Erro: Opción non contemplada!");
                        }
                    }

                }

                /**
                 * Ver Bibliotecas
                 */
                case 3 -> {
                    System.out.println(XestionBibliotecas.getInstance().amosarBibliotecas());
                    break;
                }

                /**
                 * Ver Libros
                 */
                case 4 -> {
                    System.out.println(XestionBibliotecas.getInstance().amosarLibos());
                    break;
                }

                /**
                 * Asignar exemplares a unha biblioteca
                 */
                case 5 -> {

                    try {

                        if (XestionBibliotecas.getInstance().existenBibliotecas()) {

                            int idBiblioteca = getInt("\nIngrese o ID da biblioteca: ");
                            int idExemplar = getInt("Ingrese o ID do exemplar: ");

                            if (XestionBibliotecas.getInstance().existeExemplar(idExemplar)) {

                                //TODO - MODIFICADO AKI PARA FUTURA CORRECCIÓN
                                XestionBibliotecas.getInstance().exemplarXaAsignado(idExemplar);
                                XestionBibliotecas.getInstance().engadirExemplarABiblioteca(idBiblioteca, idExemplar);
                            }

                        }

                    } catch (BibliotecasNonExiste | IndiceInvalido | ExemplarXaAsignado | ExemplarExistente | ExemplarNonExiste e) {
                        System.out.println("\nErro: " + e.getMessage());
                        break;
                    }

                    System.out.println("\nExemplar engadido correctamente!");
                }

                /**
                 * Ingresar novo Administrador de Biblioteca
                 */
                case 6 -> {

                    try {

                        XestionBibliotecas.getInstance().existenBibliotecas();
                        

                        int idBiblioteca = getInt("\nIngrese o ID da biblioteca a engadir: ");

                        if (XestionBibliotecas.getInstance().bibliotecaNonTenAdmin(idBiblioteca)) {

                            String nomeUser = getString("Ingrese o nome de usuario: ");
                            String contrasinal = getString("Ingrese o contrasinal: ");

                            //TODO - MODIFICADO AKI PARA FUTURA CORRECCIÓN
                            XestionBibliotecas.getInstance().existeUsuario(nomeUser);

                            XestionBibliotecas.getInstance().ingresarAdministradorBiblioteca(nomeUser, contrasinal,
                                    idBiblioteca);
                        }

                    } catch (BibliotecasNonExiste | BibliotecaTenAdmin | UsuarioExistente | IndiceInvalido e) {
                        System.out.println("\nErro: " + e.getMessage());
                        break;
                    }
                    System.out.println("\nAdministrador de Biblioteca ingresado correctamente!");

                }

                /**
                 * Saír
                 */
                case 7 -> {
                    System.out.println("Saíndo...");
                    menuActivo = false;
                    break;
                }

                /**
                 * Erro
                 */
                default -> {
                    System.out.println("\nErro: Opción inválida!");
                    break;
                }
            }
        }
    }

    private void mostrarTitulosDisponiblesCSV() {
    String ruta = "Libros.csv";

    try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
        reader.readLine(); // Saltar la cabecera
        String linea;

        System.out.println("Títulos dispoñibles no CSV:");

        while ((linea = reader.readLine()) != null) {
            String[] campos = linea.split(",", -1);
            if (campos.length > 0) {
                System.out.println("- " + campos[0].trim());
            }
        }

    } catch (IOException e) {
        System.out.println("Erro lendo o ficheiro CSV: " + e.getMessage());
    }
}

}