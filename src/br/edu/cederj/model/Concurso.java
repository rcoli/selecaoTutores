package br.edu.cederj.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@SuppressWarnings("serial")
@Entity
@Table(name = "stu_concurso")
public class Concurso implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(nullable = false, length = 4)
	@NotNull(message = "Não pode ser vazio")
	@NumberFormat(style = Style.NUMBER)
	@Min(2012)
	@Max(2050)
	private Integer ano;

	@Column(name = "nome", nullable = false, length = 200)
	@Length(max = 30, min = 3, message = "Deve ter entre 3 e 30 caracteres.")
	private String nome;

	@OneToMany(mappedBy = "concurso", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Fase> fase = new ArrayList<Fase>();

	/*@OneToMany(mappedBy = "concurso", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Inscricao> inscricao = new ArrayList<Inscricao>();*/

	@OneToMany(mappedBy = "concurso", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Vaga> vaga = new ArrayList<Vaga>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Fase> getFase() {
		return fase;
	}

	public void setFase(List<Fase> fase) {
		this.fase = fase;
	}
/*
	public List<Inscricao> getInscricao() {
		return inscricao;
	}

	public void setInscricao(List<Inscricao> inscricao) {
		this.inscricao = inscricao;
	}*/

	public List<Vaga> getVaga() {
		return vaga;
	}

	public void setVaga(List<Vaga> vaga) {
		this.vaga = vaga;
	}

}
