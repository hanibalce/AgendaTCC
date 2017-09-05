package br.ufc.qx.agtcc.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Defesa implements Serializable {

	private static final long serialVersionUID = 6830496526979623445L;

	@Id
	@GeneratedValue
	private Long id;

	private String nomeDolocal;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Endereco endereco;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_defesa")
	private Date dataDefesa;

	@Temporal(TemporalType.TIME)
	@Column(name = "hora_defesa")
	private Date horaDefesa;

	@OneToOne
	private Matricula matricula;

	@OneToOne
	private Curso curso;

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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Date getDataDefesa() {
		return dataDefesa;
	}

	public void setDataDefesa(Date data) {
		this.dataDefesa = data;
	}

	public Date getHoraDefesa() {
		return horaDefesa;
	}

	public void setHoraDefesa(Date hora) {
		this.horaDefesa = hora;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((dataDefesa == null) ? 0 : dataDefesa.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((horaDefesa == null) ? 0 : horaDefesa.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
		Defesa other = (Defesa) obj;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (dataDefesa == null) {
			if (other.dataDefesa != null)
				return false;
		} else if (!dataDefesa.equals(other.dataDefesa))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (horaDefesa == null) {
			if (other.horaDefesa != null)
				return false;
		} else if (!horaDefesa.equals(other.horaDefesa))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (nomeDolocal == null) {
			if (other.nomeDolocal != null)
				return false;
		} else if (!nomeDolocal.equals(other.nomeDolocal))
			return false;
		return true;
	}

}
