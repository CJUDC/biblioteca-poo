package model;

public class Libro {

    //Atributos
    private String title;
    private String author;
    public String realeaseDate;
    private int stock;
    public Prestamo prestamo;

    //Constructor
    public Libro(String title, String author, String realeaseDate, int stock){
        this.setTitle(title);
        this.setAuthor(author);
        this.realeaseDate = realeaseDate;
        this.setStock(stock);
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
