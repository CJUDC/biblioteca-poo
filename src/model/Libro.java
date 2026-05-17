package model;

public class Libro {

    //Atributos
    private int ISBN;
    private String title;
    private String author;
    private int stock;
    public Prestamo prestamo;

    //Constructor
    public Libro(String title, String author, int stock){
        this.setTitle(title);
        this.setAuthor(author);
        this.setStock(stock);
    }

    //Métodos

    //Getters


    public int getISBN() {
        return ISBN;
    }

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


    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

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
