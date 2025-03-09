import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<Usuario> personas = new ArrayList<>();
        boolean programaActivo = true; // Controla el funcionamiento del programa

        while (programaActivo) {
            
            System.out.println("\n--------------");
            System.out.println("\nMenú de inicio");
            System.out.println("\t1. Iniciar sesión");
            System.out.println("\t2. Rexistrarse");
            System.out.println("\t3. Saír");

            System.out.print("Ingrese a opción desexada: ");
            int option = scanner.nextInt();
            
            switch (option) {

                case 1 -> {

                    scanner.nextLine(); // Limpiar buffer

                    System.out.print("Ingrese o teu USUARIO: ");
                    String nomeUsuarioInicio = scanner.nextLine();

                    System.out.print("Ingrese o CONTRASINAL: ");
                    String contrasinalStringInicio = scanner.nextLine();

                    Usuario usuarioActivo = null;

                    for (Usuario usuario : personas) {
                        if (usuario.iniciarSesion(nomeUsuarioInicio, contrasinalStringInicio)) {
                            usuarioActivo = usuario;
                            System.out.println("Benvido " + usuario.getNomeDePila());
                            break;
                        }
                    }

                    if (usuarioActivo == null) {
                        System.out.println("Erro: Usuario ou contrasinal incorrectos.");
                    } else {
                        boolean sesionIniciada = true;

                        while (sesionIniciada) { // Menú principal do usuario

                            scanner.nextLine(); // Limpiar buffer

                            System.out.println("\n---------------");
                            System.out.println("\nMenú Principal");
                            System.out.println("\t1. Modificar nome");
                            System.out.println("\t2. Ingresar tarefa pendente");
                            System.out.println("\t3. Mostrar tarefas pendentes");
                            System.out.println("\t4. Marcar tarefa como realizada");
                            System.out.println("\t5. Mostrar tarefas pendentes nas próximas 48 horas");
                            System.out.println("\t6. Mostrar tarefas realizadas");
                            System.out.println("\t7. Mostrar tarefas pendentes sobrepasadas");
                            System.out.println("\t8. Cerrar sesión");

                            System.out.print("Seleccione unha opción: ");
                            int option2 = scanner.nextInt();

                            switch (option2) {

                                // Modificar nome de Pila
                                case 1 -> {
                                    scanner.nextLine(); // Limpiar buffer

                                    System.out.print("Ingrese o seu novo nome de pila: ");
                                    String novoNome = scanner.nextLine();

                                    usuarioActivo.setNomeDePila(novoNome);
                                    System.out.println("Nome actualizado con éxito.");
                                }

                                // Ingresar tarefa pendente
                                case 2 -> {
                                    scanner.nextLine(); // Limpiar buffer

                                    System.out.print("Ingrese o TÍTULO da tarefa: ");
                                    String titulo = scanner.nextLine();

                                    System.out.print("Ingrese a DESCRICIÓN da tarefa: ");
                                    String descricion = scanner.nextLine();

                                    System.out.print("Ingrese a DATA LÍMITE da tarefa: ");
                                    String dataLimiteString = scanner.nextLine();

                                    // Crear unha nova tarefa e engadila á lista de tarefas pendentes do usuario activo
                                    Tarefa novaTarefa = new Tarefa(titulo, descricion, dataLimiteString);
                                    usuarioActivo.agregarTarefaPendente(novaTarefa);

                                    System.out.println("Tarefa engadida correctamente.");
                                }

                                // Mostrar tarefas pendentes
                                case 3 -> {
                                    scanner.nextLine(); // Limpiar buffer

                                    System.out.println("Tarefas pendentes:");
                                    boolean tarefasEncontradas = false;

                                    // Mostrar tarefas pendentes do usuario activo
                                    for (Tarefa tarefa : usuarioActivo.getTarefasPendentes()) {
                                        System.out.println("Título: " + tarefa.getTitulo());
                                        tarefasEncontradas = true;
                                    }

                                    // Se non hai tarefas pendentes, mostrar unha mensaxe
                                    if (!tarefasEncontradas) {
                                        System.out.println("Non hai tarefas pendentes.");
                                    }
                                }

                                // Marcar tarefa como realizada
                                case 4 -> {
                                    scanner.nextLine(); // Limpiar buffer
                                    System.out.println("Tarefas pendentes para marcar como realizadas:");
                                    boolean tarefasEncontradas = false;

                                    // Mostrar tarefas pendentes para marcar como realizadas
                                    for (Tarefa tarefa : usuarioActivo.getTarefasPendentes()) {
                                        System.out.println("Título: " + tarefa.getTitulo());
                                        tarefasEncontradas = true;
                                    }

                                    //Se hai tarefas pendentes, permitir ao usuario seleccionar unha para marcar como realizada
                                    if (tarefasEncontradas) {
                                        System.out.print("Seleccione a tarefa para marcar como realizada: ");
                                        String tituloTarefaRealizada = scanner.nextLine();

                                        // Buscar a tarefa seleccionada na lista de tarefas pendentes do usuario activo
                                        Tarefa tarefaRealizada = null;
                                        for (Tarefa tarefa : usuarioActivo.getTarefasPendentes()) {
                                            if (tarefa.getTitulo().equals(tituloTarefaRealizada)) {
                                                tarefaRealizada = tarefa;
                                                break;
                                            }
                                        }
                                        
                                        // Marcar a tarefa como realizada 
                                        if (tarefaRealizada != null) {
                                            usuarioActivo.marcarTarefaComoRealizada(tarefaRealizada);
                                            System.out.println("Tarefa marcada como realizada.");
                                        } else {
                                            System.out.println("Tarefa non atopada.");
                                        }
                                    } else {
                                        System.out.println("Non hai tarefas pendentes.");
                                    }
                                }

                                // Mostrar tarefas pendentes nas próximas 48 horas
                                case 5 -> {
                                    scanner.nextLine(); // Limpiar buffer
                                
                                    System.out.println("Tarefas pendentes nas próximas 48 horas:");
                                
                                    ArrayList<Tarefa> tarefas48Horas = usuarioActivo.getPendentes48horas();
                                
                                    if (tarefas48Horas.isEmpty()) {
                                        System.out.println("Non hai tarefas pendentes nas próximas 48 horas.");
                                    } else {
                                        for (Tarefa tarefa : tarefas48Horas) {
                                            System.out.println("Título: " + tarefa.getTitulo());
                                        }
                                    }
                                }
                                

                                // Mostrar tarefas realizadas
                                case 6 -> {
                                    scanner.nextLine(); // Limpiar buffer

                                    System.out.println("Tarefas realizadas:");

                                    boolean tarefasEncontradas = false;

                                    // Mostrar tarefas realizadas do usuario activo
                                    for (Tarefa tarefa : usuarioActivo.getTarefasRealizadas()) {
                                        System.out.println("Título: " + tarefa.getTitulo());
                                        System.out.println("Descrición: " + tarefa.getDescricion());
                                        System.out.println("Data de inicio: " + tarefa.getDataInicio().format(Tarefa.formato_data));
                                        System.out.println("Data límite: " + tarefa.getDataLimite().format(Tarefa.formato_data));
                                        tarefasEncontradas = true;
                                    }

                                    // Se non hai tarefas realizadas, mostrar unha mensaxe
                                    if (!tarefasEncontradas) {
                                        System.out.println("Non hai tarefas realizadas.");
                                    }
                                }

                                // Mostrar tarefas pendentes 
                                case 7 -> {
                                    scanner.nextLine(); // Limpiar buffer
                                
                                    System.out.println("Tarefas pendentes sobrepasadas:");
                                
                                    ArrayList<Tarefa> tarefasRetrasadas = usuarioActivo.getTarefasRetrasadas();
                                
                                    if (tarefasRetrasadas.isEmpty()) {
                                        System.out.println("Non hai tarefas pendentes sobrepasadas.");
                                    } else {
                                        
                                        for (Tarefa tarefa : tarefasRetrasadas) {
                                            System.out.println("Título: " + tarefa.getTitulo());
                                            System.out.println("Descrición: " + tarefa.getDescricion());
                                            System.out.println("Data de inicio: " + tarefa.getDataInicio().format(Tarefa.formato_data));
                                            System.out.println("Data límite: " + tarefa.getDataLimite().format(Tarefa.formato_data));
                                        }
                                    }
                                }
                                

                                // Cerrar sesión
                                case 8 -> {
                                    System.out.println("Pechando sesión...");
                                    sesionIniciada = false;
                                }

                                // Opción inválida
                                default -> {
                                    System.out.println("Opción non válida.");
                                }
                            }
                        }
                    }
                }

                case 2 -> {
                    scanner.nextLine(); // Limpiar buffer
                
                    System.out.print("Ingrese o teu NOME DE PILA: ");
                    String nomePilaRexistro = scanner.nextLine();
                
                    System.out.print("Ingrese o teu USUARIO: ");
                    String nomeUsuarioRexistro = scanner.nextLine();
                
                    // Non permitir que se rexistre un usuario con un nome de usuario xa existente
                    if (Usuario.existeUsuario(personas, nomeUsuarioRexistro)) {
                        System.out.println("Erro: O nome de usuario xa existe. Escolla outro.");
                    } else {
                        System.out.print("Ingrese o CONTRASINAL: ");
                        String contrasinalStringRexistro = scanner.nextLine();
                
                        System.out.print("Confirme o CONTRASINAL: ");
                        String contrasinalConfirmacion = scanner.nextLine();
                
                        if (contrasinalStringRexistro.equals(contrasinalConfirmacion)) {
                            Usuario usuario = new Usuario(nomeUsuarioRexistro, nomePilaRexistro, contrasinalStringRexistro);
                            personas.add(usuario);
                            System.out.println("Rexistro aceptado.");
                        } else {
                            System.out.println("Erro: Os contrasinais non coinciden.");
                        }
                    }
                }

                // Saír
                case 3 -> {
                    System.out.println("Saíndo...");
                    programaActivo = false;
                }

                default -> {
                    System.out.println("Erro: Opción inválida.");
                }
            }
        }
    }
}
