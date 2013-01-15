package br.edu.cederj.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@SuppressWarnings("serial")
@Entity
@Table(name = "ger_polo")
public class Polo implements Serializable {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "polo_titulo", nullable = true, length = 100)
	@Length(max = 30, min = 3, message = "Deve ter entre 3 e 30 caracteres.")
	private String poloTitulo;

	@Column(name = "polo_sigla", nullable = true, length = 3)
	@Pattern(regexp = "^[A-Z0-9]{3,3}$", message = "Devem ser 3 letras maiúsculas ou algarismos.")
	private String poloSigla;

	@Column(name = "ativo")
	private boolean ativo;

	@OneToMany(mappedBy = "polo", fetch = FetchType.LAZY)
	private List<Vaga> vaga = new ArrayList<Vaga>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPoloTitulo() {
		return poloTitulo;
	}

	public void setPoloTitulo(String poloTitulo) {
		this.poloTitulo = poloTitulo;
	}

	public String getPoloSigla() {
		return poloSigla;
	}

	public void setPoloSigla(String poloSigla) {
		this.poloSigla = poloSigla;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public List<Vaga> getVaga() {
		return vaga;
	}

	public void setVaga(List<Vaga> vaga) {
		this.vaga = vaga;
	}

}
