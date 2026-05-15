import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Main menú
        var scanner = new Scanner(System.in);
        int opc;

        var bibi = new Biblioteca();


        do{

            System.out.println("\n--- Menú de opciones ---");
            System.out.println("1. Registrar Libro");
            System.out.println("2. Registrar Usuario");
            System.out.println("3. Prestar Libro");
            System.out.println("4. Devolver Libro");
            System.out.println("5. Ver Libro");
            System.out.println("6. Ver Usuario");
            System.out.println("7. Ver Prestamo");
            System.out.println("0. Salir");

            System.out.println("Elija una opción:");
            opc = scanner.nextInt();
            scanner.nextLine();

            switch (opc){
                case 1:
                    System.out.println("Registra Libros");
                    pausar(scanner);
                    break;
                case 2:
                    System.out.println("Registra usuario");
                    bibi.addUser();
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
                case 5:
                    System.out.println("Logica Ver libro");
                    pausar(scanner);
                    break;
                case 6:
                    System.out.println("Logica Ver Usuario");
                    bibi.displayUser();
                    pausar(scanner);
                    break;
                case 7:
                    System.out.println("Logica Ver prestamo");
                    pausar(scanner);
                    break;
                case 0:
                    System.out.println("Has salido");
                    break;
                default:
                    System.out.println("\nOpción inválida");
                    pausar(scanner);
            }

        } while(opc != 0);
        scanner.close();

    }

    // Método para pausar y esperar al usuario
    public static void pausar(Scanner sc) {
        System.out.println("\nPresione Enter para volver al menú...");
        sc.nextLine();
    }

    // Método para limpiar según el sistema operativo
    public static void limpiarPantalla() {
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
