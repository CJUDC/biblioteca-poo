package view;

import java.util.Scanner;

public class Menu {

    //Main menú
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
                    System.out.println("Registra Libros");
                    pausar(scanner);
                    break;
                case 2:
                    System.out.println("Registra usuario");
                    pausar(scanner);
                    break;
                case 3:
                    System.out.println("logica prestamo");
                    pausar(scanner);
                    break;
                case 4:
                    System.out.println("logica Devolución");
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