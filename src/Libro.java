import java.util.ArrayList;
import java.util.Date;

public class Libro {

    //Atributos
    private String title;
    private String author;
    public String realeaseDate;
    private int stock;

    //Constructor
    public Libro(String title, String author, String realeaseDate){
        this.setTitle(title);
        this.setAuthor(author);
        this.realeaseDate = realeaseDate;
    }

    //Métodos

    //Getters
    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return  this.author;
    }

    public int getStock() {
        return stock;
    }

    //Setters
    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
