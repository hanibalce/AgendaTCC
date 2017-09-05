package br.ufc.qx.agtcc.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class LocalDeDefesa implements Serializable {

	private static final long serialVersionUID = -2457625880499798545L;

	@Id
	@GeneratedValue
	private Long id;

	private String nomeDolocal;

	@OneToOne
	private Curso curso;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Endereco endereco;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "local_id")
	private List<DataDeDefesa> datasDeDefesa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDolocal() {
		return nomeDolocal;
	}

	public void setNomeDolocal(String nomeDolocal) {
		this.nomeDolocal = nomeDolocal;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<DataDeDefesa> getDatasDeDefesa() {
		return datasDeDefesa;
	}

	public void setDatasDeDefesa(List<DataDeDefesa> datasDeDefesa) {
		this.datasDeDefesa = datasDeDefesa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((datasDeDefesa == null) ? 0 : datasDeDefesa.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomeDolocal == null) ? 0 : nomeDolocal.hashCode());
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
		LocalDeDefesa other = (LocalDeDefesa) obj;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (datasDeDefesa == null) {
			if (other.datasDeDefesa != null)
				return false;
		} else if (!datasDeDefesa.equals(other.datasDeDefesa))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomeDolocal == null) {
			if (other.nomeDolocal != null)
				return false;
		} else if (!nomeDolocal.equals(other.nomeDolocal))
			return false;
		return true;
	}

}
