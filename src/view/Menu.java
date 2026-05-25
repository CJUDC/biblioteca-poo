package view;

import controller.Biblioteca;
import model.Libro;
import model.Prestamo;
import model.Usuario;
import Enum.ResultadoPrestamo;

import java.sql.SQLOutput;
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
                    break;
                case 2:
                    iniciarGestionUsuarios();
                  //  pausar(scanner);
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
       // scanner.close();
    }

    //Menú Gestión libros
    public void iniciarGestionLibros(){
        do {
            System.out.println("\n===== Gestión de Libros =====");
            System.out.println("1. Registrar Libro");
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
                    String titulo = leerTexto("Ingrese el título del libro: ");
                    String autor = leerTexto("Ingrese el autor del libro: ");
                    int ISBN = leerEntero("Ingrese el ISBN del libro: ");
                    int stock = leerEntero("Ingrese el stock del libro: ");
                    biblioteca.addBook(titulo, autor, ISBN, stock);
                    pausar(scanner);
                    break;
                case 2:
                    displayBook();
                    pausar(scanner);
                    break;
                case 3:
                    biblioteca.buscarLibroXISBN();
                    pausar(scanner);
                    break;
                case 4:
                    biblioteca.buscarLibroXTitulo();
                    pausar(scanner);
                    break;
                case 5:
                    biblioteca.eliminarLibro();
                    pausar(scanner);
                    break;
                case 0:
                    iniciar();
                    break;
                default:
                    System.out.println("\nOpción inválida!!!");
            }

        } while (opc != 0);
    }

    public void iniciarGestionUsuarios(){
        do {
            System.out.println("\n===== GESTIÓN DE USUARIOS =====");
            System.out.println("1. Registrar Usuario");
            System.out.println("2. Ver usuarios");
            System.out.println("3. Buscar Usuario por ID");
            System.out.println("4. Eliminar Usuario");
            System.out.println("0. Volver");

            System.out.println("\nElija una opción:");
            opc = scanner.nextInt();
            scanner.nextLine();

            switch (opc) {
                case 1:
                    String nombre = leerTexto("\nIngrese el nombre: ");
                    String correo = leerTexto("Ingrese el correo: ");
                    int id = leerEntero("Ingrese el id: ");
                    biblioteca.addUser(nombre, correo, id);
                    pausar(scanner);
                    break;
                case 2:
                    displayUser();
                    pausar(scanner);
                    break;
                case 3:
                    biblioteca.displayUsuarioEncontradoXID();
                    pausar(scanner);
                    break;
                case 4:
                    biblioteca.eliminarUsuario();
                    pausar(scanner);
                    break;
                case 0:
                    iniciar();
                    break;
                default:
                    System.out.println("\nOpción inválida!!!");

            }

        } while (opc != 0);
    }

    public void iniciarGestionPrestamos(){
        do {
            System.out.println("\n===== GESTIÓN DE PRÉSTAMOS =====");
            System.out.println("1. Prestar Libro");
            System.out.println("2. Devolver Libro");
            System.out.println("3. Ver préstamos activos");
            System.out.println("4. Ver historial de préstamos");
            System.out.println("0. Volver");

            System.out.println("\nElija una opción:");
            opc = scanner.nextInt();
            scanner.nextLine();

            switch (opc) {
                case 1:
                    int userID = leerEntero("\nIngrese el id del usuario: ");
                    int ISBN = leerEntero("Ingrese el ISBN del libro a prestar: ");
                    opcionPrestarLibro(userID, ISBN);
                    pausar(scanner);
                    break;
                case 2:
                    displayPrestamo();
                    biblioteca.devolverLibro();
                    pausar(scanner);
                    break;
                case 3:
                    displayPrestamo();
                    pausar(scanner);
                    break;
                case 4:
                    displayHistorial();
                    pausar(scanner);
                    break;
                case 0:
                    iniciar();
                    break;
                default:
                    System.out.println("\nOpción inválida!!!");
            }
        } while (opc != 0);
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

    public void displayUser(){

        if(biblioteca.getUsuarios().isEmpty()){
            System.out.println("\nNo hay ningún Usuario registrado");
            return;
        }

        for (Usuario usuario : biblioteca.getUsuarios()){
            System.out.println("\n-------------------------");
            System.out.println("ID: " + usuario.getUserID());
            System.out.println("Nombre: " + usuario.getName());
            System.out.println("Email: " + usuario.getEmail());
        }
    }

    public void displayBook() {
        if (biblioteca.getLibros().isEmpty()) {
            System.out.println("No hay libros registrados en la biblioteca.");
            return;
        }
        System.out.println("--- Lista de Libros ---");
        for (Libro libro : biblioteca.getLibros()) {
            System.out.println("Título: " + libro.getTitle() +
                    " | Autor: " + libro.getAuthor() +
                    " | ISBN: " + libro.getISBN() +
                    " | Stock: " + libro.getStock());
        }
    }

    public void displayPrestamo(){

        System.out.println("----------------------Lista de Préstamos--------------------");

        boolean hayActivos = false;

        for(Prestamo prestamo : biblioteca.getPrestamos()){

            if(prestamo.state){
                System.out.println("\nUsuario: " + prestamo.usuario.getName());
                System.out.println("Libro: " + prestamo.libro.getTitle());
                System.out.println("Fecha préstamo: " + prestamo.fecha);
                System.out.println("Estado: ACTIVO");

                hayActivos = true;
            }
        }

        if(!hayActivos) System.out.println("\nNo hay prestamos activos!");

    }

    public void displayHistorial(){

        for (Prestamo prestamo : biblioteca.getPrestamos()){
            System.out.println("Usuario: " + prestamo.usuario.getName());
            System.out.println("Libro: " + prestamo.libro.getTitle());
            System.out.println("Fecha préstamo: " + prestamo.fecha);
            String estado = (prestamo.state) ? "Estado: ACTIVO" : "Estado: INACTIVO";
            System.out.println(estado);
            System.out.println(" ");
        }
    }


    //Utilidades

    public String leerTexto(String prompt){
        System.out.println(prompt);
        return scanner.nextLine().trim();
    }

    public int leerEntero(String prompt){
        while(true){
            System.out.println(prompt);
            try{
                return Integer.parseInt(scanner.nextLine().trim());
            } catch(Exception e){
                System.out.println("⚠ Por favor ingrese un número válido.");
            }
        }
    }

    public void opcionPrestarLibro(int id, int ISBN) {


        ResultadoPrestamo resultado = biblioteca.addPrestamo(id, ISBN);

        switch (resultado) {
            case EXITO:
                System.out.println("\n¡Préstamo creado exitosamente!");
                break;
            case USUARIO_O_LIBRO_INVALIDO:
                System.out.println("\nUsuario o libro inválido.");
                break;
            case SIN_STOCK:
                System.out.println("\nLibro no disponible para prestar.");
                break;
            case LIMITE_ALCANZADO:
                System.out.println("\nHa superado el máximo de préstamos (3).");
                break;
            case YA_TIENE_ESE_LIBRO:
                System.out.println("\nEl usuario ya tiene este libro prestado.");
                break;
        }
    }
}