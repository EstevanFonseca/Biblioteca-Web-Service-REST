package wsrest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="livros")

public class Livro {
	
	@Id @GeneratedValue
	private long id;
	private long isbn;
	private String genero;
	private String autor;
	private String descricao;
	private String titulo;
	
	
	public Livro() {
		
	}
	
	public Livro(long id, long isbn, String genero, String autor, String descricao, String titulo) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.genero = genero;
		this.autor = autor;
		this.descricao = descricao;
		this.titulo = titulo;
	}
	
	public long getId_livro() {
		return id;
	}
	public void setId_livro(long id) {
		this.id = id;
	}
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	
}

