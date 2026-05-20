package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Prestamo {
  private int prestamoId;
  public Usuario usuario;
  public Libro libro;
  public boolean state;
  public Date fecha;

  public Prestamo(Usuario usuario, Libro libro, boolean state, Date fecha){
    this.usuario = usuario;
    this.libro = libro;
    this.state = state;
    this.fecha = fecha;
  }

  //Getters
  public int getPrestamoId() {
    return prestamoId;
  }
}

