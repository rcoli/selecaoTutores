package br.edu.cederj.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("serial")
@Entity
@Table(name = "stu_inscricao")
public class Inscricao implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	private Long numeroInscricao;

	@Column(nullable = false, length = 65535)
	@NotNull(message="Campo Obrigatório")
	private String motivoInscricao;
	
	@NotNull(message="Campo Obrigatório")
	private String termoCompromisso;
	
	@NotNull(message="Campo Obrigatório")
	private String pgtoTipo;

	@NotNull(message="Campo Obrigatório")
	private String pgtoComprovante;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@NotNull(message="Campo Obrigatório")
	private Date pgtoData;

	@Column(name = "outras_informacoes", nullable = false, length = 500)
	@NotNull(message="Campo Obrigatório")
	private String outrasInformacoes;
	
	@PrimaryKeyJoinColumn
	@OneToOne(mappedBy = "inscricao", fetch = FetchType.EAGER, cascade = CascadeType.ALL)	
	private Candidato candidato;

	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "vaga_id", insertable = true, updatable = true, nullable = false)	
	private Vaga vaga;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumeroInscricao() {
		return numeroInscricao;
	}

	public void setNumeroInscricao(Long numeroInscricao) {
		this.numeroInscricao = numeroInscricao;
	}

	public String getMotivoInscricao() {
		return motivoInscricao;
	}

	public void setMotivoInscricao(String motivoInscricao) {
		this.motivoInscricao = motivoInscricao;
	}

	public String getTermoCompromisso() {
		return termoCompromisso;
	}

	public void setTermoCompromisso(String termoCompromisso) {
		this.termoCompromisso = termoCompromisso;
	}

	public String getPgtoTipo() {
		return pgtoTipo;
	}

	public void setPgtoTipo(String pgtoTipo) {
		this.pgtoTipo = pgtoTipo;
	}

	public String getPgtoComprovante() {
		return pgtoComprovante;
	}

	public void setPgtoComprovante(String pgtoComprovante) {
		this.pgtoComprovante = pgtoComprovante;
	}

	public Date getPgtoData() {
		return pgtoData;
	}

	public void setPgtoData(Date pgtoData) {
		this.pgtoData = pgtoData;
	}

	public String getOutrasInformacoes() {
		return outrasInformacoes;
	}

	public void setOutrasInformacoes(String outrasInformacoes) {
		this.outrasInformacoes = outrasInformacoes;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;	
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}	
}