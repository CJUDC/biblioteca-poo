import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    Libro libro = new Libro("principito", "Antoine de Saint-Exupéry", "04-01-1943");
    //Usuario usuario = new Usuario("carlos", "cjcm", "skrillex");



    public void addUser(Usuario usuario){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        usuario.setName(sc.nextLine());

        System.out.println("Ingrese su nombre de usuario: ");
        usuario.setUserName(sc.nextLine());

        System.out.println("Ingrese su contraseña: ");
        usuario.setPassword(sc.nextLine());
    }


}
