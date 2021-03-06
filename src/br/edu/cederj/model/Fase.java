package br.edu.cederj.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * StuFase generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "stu_fase")
public class Fase implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	//@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date inicio;

	@Temporal(TemporalType.TIMESTAMP)
	//@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date fim;
	
	@Column(nullable=false, length=10)
	private String sigla;
	
	@Column(nullable = false, length = 255)
	private String nome;
	
	private Boolean visivelPublico;

	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "concurso_id", insertable = true, updatable = true, nullable = false)
	private Concurso concurso;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getVisivelPublico() {
		return visivelPublico;
	}

	public void setVisivelPublico(Boolean visivelPublico) {
		this.visivelPublico = visivelPublico;
	}

	public Concurso getConcurso() {
		return concurso;
	}

	public void setConcurso(Concurso concurso) {
		this.concurso = concurso;
	}

}
