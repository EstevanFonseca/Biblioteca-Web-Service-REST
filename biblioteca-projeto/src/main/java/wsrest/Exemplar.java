package wsrest;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Table(name="exemplares")

public class Exemplar {

	@Id @GeneratedValue
	
	private long id_exemplar;
	private long numero;
	private long fileira;
	private long prateleira;
	private String status;
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	private Livro livro;
	
	public Exemplar() {
		
	}
	public Exemplar(long id_exemplar, long numero, long fileira, long prateleira, String status) {
		super();
		this.id_exemplar = id_exemplar;
		this.numero = numero;
		this.fileira = fileira;
		this.prateleira = prateleira;
		this.status = status;
	}
	public long getId_exemplar() {
		return id_exemplar;
	}
	public void setId_exemplar(long id_exemplar) {
		this.id_exemplar = id_exemplar;
	}
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public long getFileira() {
		return fileira;
	}
	public void setFileira(long fileira) {
		this.fileira = fileira;
	}
	public long getPrateleira() {
		return prateleira;
	}
	public void setPrateleira(long prateleira) {
		this.prateleira = prateleira;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	
}
