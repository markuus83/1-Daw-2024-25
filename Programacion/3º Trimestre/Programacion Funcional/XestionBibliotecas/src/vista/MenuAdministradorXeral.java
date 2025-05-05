package vista;

import controlador.XestionBibliotecas;

public class MenuAdministradorXeral extends Menu{

    @Override
    protected void mostrar() {
        boolean menuActivo = true;

        while (menuActivo) {
            System.out.println("\nBenvido ao menu de Administradores Xerais: ");
            System.out.println("\t1. Nova Biblioteca: ");
            System.out.println("\t2. Novo Libro: ");
            System.out.println("\t3. Saír: ");

            int option = getInt("> ");

            switch (option) {
                case 1 -> {

                    String nome = getString("\nIngrese o nome: ");
                    String direccion = getString("Ingrese a dirección: ");
                    String cidade = getString("Ingrese a cidade: ");
                    String provincia = getString("Ingrese a provincia: ");

                    try {
                        XestionBibliotecas.getInstance().ingresarBiblioteca(nome, direccion, cidade, provincia);
                    } catch (Exception e) {
                        System.out.println("Erro: "+e.getMessage());
                    }

                }

                case 2 -> {
                }

                case 3 -> {
                }
            
                default -> {
                }
            }
        }
        
    }
    
}
