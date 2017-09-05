package br.ufc.qx.agtcc.model.entities;

import javax.persistence.*;

import br.ufc.qx.agtcc.model.enums.TipoAtividade;

import java.io.Serializable;

@Entity
public class Atividade implements Serializable {

	private static final long serialVersionUID = -3227024270243474008L;

	@Id
	@GeneratedValue
	private Long id;

	private Long idMoodle;

	private String nome;

	private Double peso;

	@Column(name = "tipo_atividade")
	@Enumerated(EnumType.STRING)
	private TipoAtividade tipoDeAtividade;

	@ManyToOne
	private Curso curso;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdMoodle() {
		return idMoodle;
	}

	public void setIdMoodle(Long idMoodle) {
		this.idMoodle = idMoodle;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public TipoAtividade getTipoDeAtividade() {
		return tipoDeAtividade;
	}

	public void setTipoDeAtividade(TipoAtividade tipoDeAtividade) {
		this.tipoDeAtividade = tipoDeAtividade;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idMoodle == null) ? 0 : idMoodle.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((peso == null) ? 0 : peso.hashCode());
		result = prime * result + ((tipoDeAtividade == null) ? 0 : tipoDeAtividade.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atividade other = (Atividade) obj;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idMoodle == null) {
			if (other.idMoodle != null)
				return false;
		} else if (!idMoodle.equals(other.idMoodle))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (peso == null) {
			if (other.peso != null)
				return false;
		} else if (!peso.equals(other.peso))
			return false;
		if (tipoDeAtividade != other.tipoDeAtividade)
			return false;
		return true;
	}

}
