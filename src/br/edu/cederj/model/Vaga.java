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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
@Table(name = "stu_vaga", uniqueConstraints = @UniqueConstraint(columnNames = {
		"ger_polo_id", "ger_disciplina_id" }))
public class Vaga implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)	
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ger_polo_id", nullable = false)
	private Polo polo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ger_disciplina_id", nullable = false)
	private Disciplina disciplina;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ger_concurso_id", nullable = false)
	private Concurso concurso;

	@Column(name = "qtd_vagas", nullable = false, length = 3)
	private Integer qtdVagas;

	@OneToMany(mappedBy = "vaga", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Inscricao> inscricao = new ArrayList<Inscricao>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Polo getPolo() {
		return polo;
	}

	public void setPolo(Polo polo) {
		this.polo = polo;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Concurso getConcurso() {
		return concurso;
	}

	public void setConcurso(Concurso concurso) {
		this.concurso = concurso;
	}

	public Integer getQtdVagas() {
		return qtdVagas;
	}

	public void setQtdVagas(Integer qtdVagas) {
		this.qtdVagas = qtdVagas;
	}

	public List<Inscricao> getInscricao() {
		return inscricao;
	}

	public void setInscricao(List<Inscricao> inscricao) {
		this.inscricao = inscricao;
	}

}