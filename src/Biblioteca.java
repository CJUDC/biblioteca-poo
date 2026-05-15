import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Biblioteca {
    //Libro libro = new Libro("principito", "Antoine de Saint-Exupéry", "04-01-1943");
    //Usuario usuario = new Usuario("carlos", "cjcm", "skrillex");
    //Atributos
    public String name;
    public ArrayList<Libro> libros = new ArrayList<>();


    Random random = new Random();
    ArrayList<Usuario> usuarios = new ArrayList<>();


    public void addUser(){
        var usuario = new Usuario();

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        usuario.setName(sc.nextLine());


        System.out.println("Ingrese su nombre de usuario: ");
        usuario.setUserName(sc.nextLine());

        System.out.println("Ingrese su contraseña: ");
        usuario.setPassword(sc.nextLine());

        usuario.setUserID(random.nextInt());

        usuarios.add(usuario);
    }

    public void displayUser(){
        for (Usuario usuario : usuarios){
            System.out.println("Hola " + usuario.getName() + " tu username es " + usuario.getUserName() + " y tu id es " + usuario.getUserID());
        }
    }

    public void addBook(){
        var libro = new Libro("kaka", "jonas", "04/01/2000", 10);
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre del libro: ");
        libro.setTitle(sc.nextLine());

        System.out.println("Ingrese el autor del libro: ");
        libro.setAuthor(sc.nextLine());

        System.out.println("Ingrese la fecha de publicación del libro: ");
        libro.realeaseDate = sc.nextLine();

        System.out.println("Ingrese el stock disponible del libro: ");
        libro.setStock(sc.nextInt());

        libros.add(libro);
    }

}
