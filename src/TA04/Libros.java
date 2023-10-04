package TA04;

import java.io.Serializable;

public class Libros implements Serializable {

	private static final long serialVersionUID = -4721874573042368631L;
	private int Id;
	private String ISBN;
	private String Titulo;
	private String Autor;
	private String Genero;
	private int Ejem;

	public Libros (int Id, String ISBN, String Titulo, String Autor, String Genero, int Ejem){
		this.setId(Id);
		this.setISBN(ISBN);
		this.setTitulo(Titulo);
		this.setAutor(Autor);
		this.setGenero(Genero);
		this.setEjem(Ejem);
	}
	public Libros () {
		
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getAutor() {
		return Autor;
	}
	public void setAutor(String autor) {
		Autor = autor;
	}
	public String getGenero() {
		return Genero;
	}
	public void setGenero(String genero) {
		Genero = genero;
	}
	public int getEjem() {
		return Ejem;
	}
	public void setEjem(int ejem) {
		Ejem = ejem;
	}

}
