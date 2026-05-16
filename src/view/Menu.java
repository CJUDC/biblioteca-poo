package view;

import controller.Biblioteca;

import java.util.Scanner;

public class Menu {

    Biblioteca biblioteca = new Biblioteca();

    Scanner scanner = new Scanner(System.in);
    int opc;


    public void iniciar() {
        do {
            System.out.println("===== BIBLIOTECA =====");
            System.out.println("1. Gestión de Libros");
            System.out.println("2. Gestión de Usuarios");
            System.out.println("3. Gestión de Prestamos");
            System.out.println("0. Salir");

            System.out.println("Elija una opción:");
            opc = scanner.nextInt();
            scanner.nextLine();

            switch (opc) {
                case 1:
                    limpiarPantalla();
                    iniciarGestionLibros();
                    pausar(scanner);
                    break;
                case 2:
                    iniciarGestionUsuarios();
                    pausar(scanner);
                    break;
                case 3:
                    iniciarGestionPrestamos();
                    pausar(scanner);
                    break;
                case 0:
                    System.out.println("Has salido!");
                    break;
                default:
                    System.out.println("\nOpción inválida!!!");

            }

        } while (opc != 0);
        scanner.close();
    }

    //menú Gestión libros
    public void iniciarGestionLibros(){
        do {
            System.out.println("===== Gestión de Libros =====");
            System.out.println("1. Registrar model.Libro");
            System.out.println("2. Ver todos los libros");
            System.out.println("3. Buscar libro por ISBN");
            System.out.println("4. Buscar libro por título");
            System.out.println("5. Eliminar libro");
            System.out.println("0. Volver");

            System.out.println("\nElija una opción:");
            opc = scanner.nextInt();
            scanner.nextLine();

            switch (opc) {
                case 1:
                    System.out.println("Registra Libros");
                    pausar(scanner);
                    break;
                case 2:
                    System.out.println("ve todos los libros");
                    pausar(scanner);
                    break;
                case 3:
                    System.out.println("logica busqueda por ISBN");
                    pausar(scanner);
                    break;
                case 4:
                    System.out.println("logica Busqueda por título");
                    pausar(scanner);
                    break;
                case 5:
                    System.out.println("Logica Eliminar libro");
                    break;
                case 0:
                    limpiarPantalla();
                    iniciar();
                    break;
                default:
                    System.out.println("\nOpción inválida!!!");
            }

        } while (opc != 0);
        scanner.close();
    }

    public void iniciarGestionUsuarios(){
        do {
            System.out.println("===== GESTIÓN DE USUARIOS =====");
            System.out.println("1. Registrar model.Usuario");
            System.out.println("2. Ver usuarios");
            System.out.println("3. Buscar model.Usuario por ID");
            System.out.println("4. Eliminar model.Usuario");
            System.out.println("0. Volver");

            System.out.println("\nElija una opción:");
            opc = scanner.nextInt();
            scanner.nextLine();

            switch (opc) {
                case 1:
                    System.out.println("Logica registrar");
                    pausar(scanner);
                    break;
                case 2:
                    System.out.println("logica ver usuarios");
                    pausar(scanner);
                    break;
                case 3:
                    System.out.println("logica buscar usuario");
                    pausar(scanner);
                    break;
                case 4:
                    System.out.println("logica eliminar usuario");
                    pausar(scanner);
                    break;
                case 0:
                    iniciar();
                    break;
                default:
                    System.out.println("\nOpción inválida!!!");

            }

        } while (opc != 0);
        scanner.close();
    }

    public void iniciarGestionPrestamos(){
        do {
            System.out.println("===== GESTIÓN DE PRÉSTAMOS =====");
            System.out.println("1. Prestar model.Libro");
            System.out.println("2. Devolver model.Libro");
            System.out.println("3. Ver préstamos activos");
            System.out.println("4. Ver historial de préstamos");
            System.out.println("0. Volver");

            System.out.println("\nElija una opción:");
            opc = scanner.nextInt();
            scanner.nextLine();

            switch (opc) {
                case 1:
                    System.out.println("Logica prestar libro");
                    pausar(scanner);
                    break;
                case 2:
                    System.out.println("logica devolver libro");
                    pausar(scanner);
                    break;
                case 3:
                    System.out.println("logica ver prestamo");
                    pausar(scanner);
                    break;
                case 4:
                    System.out.println("logica ver historial de prestamos");
                    pausar(scanner);
                    break;
                case 0:
                    iniciar();
                    break;
                default:
                    System.out.println("\nOpción inválida!!!");

            }

        } while (opc != 0);
        scanner.close();

    }

    // Método para pausar y esperar al usuario
    public static void pausar(Scanner sc) {
        System.out.println("\nPresione Enter para volver al menú...");
        sc.nextLine();
    }

    // Método para limpiar según el sistema operativo
    public static void limpiarPantalla () {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Si falla, simplemente imprime líneas en blanco para "desplazar" el texto
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }
}