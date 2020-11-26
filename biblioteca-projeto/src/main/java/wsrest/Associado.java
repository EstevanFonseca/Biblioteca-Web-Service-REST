package wsrest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="associados")
public class Associado {
	@Id @GeneratedValue
	private long cod_ass;
	private String nome;
	private String cpf;
	public Associado() {
		
	}
	public Associado(long cod_ass, String nome, String cpf) {
		super();
		this.cod_ass = cod_ass;
		this.nome = nome;
		this.cpf = cpf;
	}
	public long getCod_ass() {
		return cod_ass;
	}
	public void setCod_ass(long cod_ass) {
		this.cod_ass = cod_ass;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
