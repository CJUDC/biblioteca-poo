package model;

import java.util.ArrayList;

public class Prestamo {
  private int prestamoId;
  public Usuario usuario;
  public Libro libro;
  public boolean state;

  public Prestamo(Usuario usuario, Libro libro, boolean state){
    this.usuario = usuario;
    this.libro = libro;
    this.state = state;
  }

  //Getters
  public int getPrestamoId() {
    return prestamoId;
  }
}

