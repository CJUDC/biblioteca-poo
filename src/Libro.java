import java.util.Date;

public class Libro {

    //Atributos
    private String title;
    private String author;
    public String realeaseDate;

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

    //Setters
    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }
}
