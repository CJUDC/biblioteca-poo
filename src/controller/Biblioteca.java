package controller;

import model.Libro;
import model.Usuario;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Biblioteca {

    //Atributos
    public String name;
    public ArrayList<Libro> libros = new ArrayList<>();


    Random random = new Random();
    public ArrayList<Usuario> usuarios = new ArrayList<>();


    public void addUser(){
        var usuario = new Usuario();

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        usuario.setName(sc.nextLine());


        System.out.println("Ingrese su Email: ");
        usuario.setEmail(sc.nextLine());

        usuario.setUserID(random.nextInt());

        usuarios.add(usuario);
    }

    public void displayUser(){
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

        System.out.println("Ingrese el nombre del libro: ");
        libro.setTitle(sc.nextLine());


        System.out.println("Ingrese el autor del libro: ");
        libro.setAuthor(sc.nextLine());

        System.out.println("Ingrese el código ISBN del libro: ");
        libro.setISBN(sc.nextInt());

        System.out.println("Ingrese el stock disponible del libro: ");
        libro.setStock(sc.nextInt());
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

}
