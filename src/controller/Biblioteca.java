package controller;

import model.Libro;
import model.Prestamo;
import model.Usuario;

import java.time.LocalDate;
import java.util.*;

public class Biblioteca {

    //Atributos
    public String name;
    public ArrayList<Libro> libros = new ArrayList<>();


    Random random = new Random();
    public ArrayList<Usuario> usuarios = new ArrayList<>();
    public ArrayList<Prestamo> prestamos = new ArrayList<>();


    public void addUser(){
        var usuario = new Usuario();

        Scanner sc = new Scanner(System.in);
        //System.out.println("\nIngrese su nombre: ");
        //usuario.setName(sc.nextLine());
        usuario.setName("Carlos");

        System.out.println("Ingrese su Email: ");
       // usuario.setEmail(sc.nextLine());
        usuario.setEmail("ccastillom1@unicartagena.edu.co");

        usuario.setUserID(666);

        usuarios.add(usuario);
    }

    public void displayUser(){

        if(usuarios.isEmpty()){
            System.out.println("\nNo hay ningún Usuario registrado");
            return;
        }

        for (Usuario usuario : usuarios){
            System.out.println("\n-------------------------");
            System.out.println("ID: " + usuario.getUserID());
            System.out.println("Nombre: " + usuario.getName());
            System.out.println("Email: " + usuario.getEmail());
        }
    }

    public void addBook(){
        var libro = new Libro();
        Scanner sc = new Scanner(System.in);

        System.out.println("\nIngrese el nombre del libro: ");
       // libro.setTitle(sc.nextLine());
        libro.setTitle("principito");


        System.out.println("Ingrese el autor del libro: ");
        //libro.setAuthor(sc.nextLine());
        libro.setAuthor("Jon Snow");

        System.out.println("Ingrese el código ISBN del libro: ");
        //libro.setISBN(sc.nextInt());
        libro.setISBN(123);

        System.out.println("Ingrese el stock disponible del libro: ");
       // libro.setStock(sc.nextInt());
        libro.setStock(5);
        sc.nextLine();

        libros.add(libro);

        System.out.println("\nLibro registrado exitosamente!");
    }

    public void displayBook() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados en la biblioteca.");
            return;
        }
        System.out.println("--- Lista de Libros ---");
        for (Libro libro : libros) {
            System.out.println("Título: " + libro.getTitle() +
                    " | Autor: " + libro.getAuthor() +
                    " | ISBN: " + libro.getISBN() +
                    " | Stock: " + libro.getStock());
        }
    }

    public void addPrestamos(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su ID: ");
        int id = scanner.nextInt();

        System.out.println("Ingrese el ISBN del libro a prestar: ");
        int ISBN = scanner.nextInt();

        var usuarioEncontrado = buscarUsuario(id);
        var libroEncontrado = buscarLibro(ISBN);

        if(usuarioEncontrado == null || libroEncontrado == null){
            System.out.println("Usuario o libro inválido");
            return;
        }

        if(libroEncontrado.getStock() == 0){
            System.out.println("\nLibro no disponible para prestar!");
            System.out.println("\n| Stock: " + libroEncontrado.getStock());
            return;
        }

        if(prestamos.size() >= 3){
            System.out.println("\nUsted ha superado el mínimo de prestamos aceptado por la biblioteca");
            return;
        }

        Prestamo prestamo = new Prestamo(usuarioEncontrado, libroEncontrado, true, LocalDate.now());
        prestamos.add(prestamo);
        libroEncontrado.setStock(libroEncontrado.getStock() - 1);


        System.out.println("\n---------------------Préstamo Creado--------------------------");
        System.out.println("El usuario " + usuarioEncontrado.getName() + " ha realizado un préstamo con el/los libro: " + libroEncontrado.getTitle());

    }

    public void displayPrestamo(){

        System.out.println("----------------------Lista de Préstamos--------------------");

        for(Prestamo prestamo : prestamos){

            System.out.println("Usuario: " + prestamo.usuario.getName() + " | Libro: " + prestamo.libro.getTitle());
        }
    }

    public void displayUsuarioEncontradoXID(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nIngrese el ID del usuario a buscar: ");
        int id = scanner.nextInt();

        Usuario usuarioEncontrado = buscarUsuario(id);

        if(usuarioEncontrado == null){
            System.out.println("\nUsuario No encontrado!");
            return;
        }

        System.out.println("\nEl Usuario que busca es: ");
        System.out.println("Nombre: " + usuarioEncontrado.getName());
        System.out.println("Email: " + usuarioEncontrado.getEmail());
    }
    
    public Usuario buscarUsuario(int id){
        for(Usuario usuario: usuarios){
            if(usuario.getUserID() == id){
                return usuario;
            }
        }
        return null;
    }

    public void buscarLibroXISBN(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nIngrese el ISBN: ");
        int ISBN = scanner.nextInt();

        Libro libroEncontrado = buscarLibro(ISBN);

        if(libroEncontrado == null){
            System.out.println("\nLibro no encontrado ó no registrado");
            return;
        }

        System.out.println("-----------------------------------------------------");
        System.out.println("Libro: " + libroEncontrado.getTitle() +
                            " |Autor: " + libroEncontrado.getAuthor() +
                            " |Disponibilidad: " + libroEncontrado.getStock());
        System.out.println("-----------------------------------------------------");

    }

    public void buscarLibroXTitulo(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nIngrese el Título del libro: ");
        String titulo = scanner.nextLine().toLowerCase();

        for (Libro libro : libros){
            if (!Objects.equals(libro.getTitle(), titulo)){
                System.out.println("\nLibro no encontrado!");
                return;
            }

            System.out.println("\n----------------------------------");
            System.out.println("Libro: " + libro.getTitle());
            System.out.println("Autor: " + libro.getAuthor());
            System.out.println("Disponibilidad: " + libro.getStock());
            System.out.println("\n----------------------------------");

        }
    }

    public Libro buscarLibro(int ISBN){
        for(Libro libro: libros){
            if(libro.getISBN() == ISBN){
                return libro;
            }
        }
        return null;
    }

    public void eliminarLibro(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nIngrese el ISBN del Libro a eliminar: ");
        int ISBN = scanner.nextInt();

        Libro libroAEliminar = buscarLibro(ISBN);

        if (libroAEliminar == null){
            System.out.println("\nLibro no existente!");
            return;
        }

        libros.remove(libroAEliminar);

        System.out.println("\nLibro eliminado exitosamente!");

    }

    public void eliminarUsuario(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nIngrese el ID del usuario a eliminar");
        int id = scanner.nextInt();

        Usuario usuarioAEliminar = buscarUsuario(id);

        if (usuarioAEliminar == null){
            System.out.println("Usuario no existente!");
            return;
        }

        scanner.nextLine();

        System.out.println("\nDesea eliminar el usuario? S/N");
        String ans = scanner.nextLine().trim().toLowerCase();

        if (ans.equals("n")){
            System.out.println("\nUsuario no eliminado");
            return;
        } else if (ans.equals("s")){
            usuarios.remove(usuarioAEliminar);
            System.out.println("\nEl usuario ha sido eliminado exitosamente!");
        }
        else {
            System.out.println("\nOpción no válida. Operación cancelada.");
        }
    }

    public void devolverLibro(){

        displayPrestamo();

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nIngresa el ID del usuario: ");
        int id = scanner.nextInt();

        Usuario usuarioEncontrado = buscarUsuario(id);

        if (usuarioEncontrado == null){
            System.out.println("\nUsuario no existente NULL");
            return;
        }

        if(usuarioEncontrado.getUserID() != id){
            System.out.println("\nUsuario no existente");
            return;
        }

        System.out.println("\nIngrese el ISBN: ");
        int ISBN = scanner.nextInt();

        Libro libroEncontrado = buscarLibro(ISBN);

        if(libroEncontrado == null){
            System.out.println("\nLibro no encontrado ó no registrado");
            return;
        }

        libroEncontrado.setStock(libroEncontrado.getStock() + 1);

        System.out.println("\nEl libro " + libroEncontrado.getTitle() + " Ha sido devuelto exitosamente!");

    }


}
