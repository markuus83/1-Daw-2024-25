


//#TODO -> MODIFICAR EL MÉTODO INICIARSESION DE LA CLASE USUARIO, PARA QUE SIMPLEMENTE ME VALIDE EL HASH DE LA CONTRASEÑA CON EL HASH EXISTENTE LIGADO AL USUARIO




import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<Usuario> personas = new ArrayList<Usuario>();

        boolean ejecutando = true;
        
        while (ejecutando) {
            
            boolean rexistrando = true;
            boolean ingresado = false;

            // MENÚ DE INICIO DE SESIÓN
            while (rexistrando) {

                // Limpiamos el búfer del Scanner
                scanner.nextLine();

                System.out.println("\n--------------");
                System.out.println("\nMenú de inicio");
                System.out.println("\t1. Iniciar sesión");
                System.out.println("\t2. Rexistrarse");
                System.out.println("\t3. Saír");

                System.out.print("Ingrese a opción desexada: ");
                int option = scanner.nextInt();

                switch (option) {
                    case 1 -> {
                        // Limpiamos el búfer del Scanner
                        scanner.nextLine();

                        System.out.print("Ingrese o teu USUARIO: ");
                        String nomeUsuarioInicio = scanner.nextLine();

                        System.out.print("Ingrese o CONTRASINAL: ");
                        String contrasinalStringInicio = scanner.nextLine();

                        for (Usuario usuario : personas) {
                            if (usuario.getNomeUsuario().equals(nomeUsuarioInicio) &&
                                usuario.getClaveHash().equals(HashPassword.hashPassword(contrasinalStringInicio))) {
                                
                                ingresado = true;
                                rexistrando = false;
                                break;
                            }
                        }

                        if (!ingresado) {
                            System.out.println("Erro: Usuario ou contrasinal incorrectos.");
                        }
                    }
                        
                    case 2 -> {
                        // Limpiamos el búfer del Scanner
                        scanner.nextLine();

                        System.out.print("Ingrese o teu NOME DE PILA: ");
                        String nomePilaRexistro = scanner.nextLine();

                        System.out.print("Ingrese o teu USUARIO: ");
                        String nomeUsuarioRexistro = scanner.nextLine();

                        System.out.print("Ingrese o CONTRASINAL: ");
                        String contrasinalStringRexistro = scanner.nextLine();

                        Usuario usuario = new Usuario(nomeUsuarioRexistro, nomePilaRexistro, contrasinalStringRexistro);
                        personas.add(usuario);

                        System.out.println("Rexistro exitoso. Agora pode iniciar sesión.");
                    }    
                    
                    case 3 -> {
                        System.out.println("Saíndo...");
                        ejecutando = false;
                        rexistrando = false;
                    }
                    
                    default -> System.out.println("Erro: Opción inválida.");
                }
            }

            while (ingresado) {
                System.out.println("\nBenvido ao sistema!");
                System.out.println("\t1. Cerrar sesión");
                System.out.print("Seleccione unha opción: ");
                
                int opcionSesion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el búfer

                if (opcionSesion == 1) {
                    ingresado = false;
                    System.out.println("Sesión pechada.");
                } else {
                    System.out.println("Opción non válida.");
                }
            }
        }

        scanner.close();
    }
}
