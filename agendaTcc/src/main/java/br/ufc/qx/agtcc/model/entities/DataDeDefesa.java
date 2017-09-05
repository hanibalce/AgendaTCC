package br.ufc.qx.agtcc.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class DataDeDefesa implements Serializable {

	private static final long serialVersionUID = 8567128213375559853L;

	@Id
	@GeneratedValue
	private Long id;

	@OneToMany
	private List<Professor> orientadores;

	@OneToMany
	private List<Turma> turmas;

	@OneToMany
	private List<Matricula> matriculas;

	@ManyToOne(cascade = CascadeType.ALL)
	private LocalDeDefesa localDeDefesa;

	@Temporal(TemporalType.TIME)
	@Column(name = "hora_sugerida")
	private Date horaSugerida;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_sugerida")
	private Date dataSugerida;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Professor> getOrientadores() {
		return orientadores;
	}

	public void setOrientadores(List<Professor> orientadores) {
		this.orientadores = orientadores;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public LocalDeDefesa getLocalDeDefesa() {
		return localDeDefesa;
	}

	public void setLocalDeDefesa(LocalDeDefesa localDeDefesa) {
		this.localDeDefesa = localDeDefesa;
	}

	public Date getHoraSugerida() {
		return horaSugerida;
	}

	public void setHoraSugerida(Date horaSugerida) {
		this.horaSugerida = horaSugerida;
	}

	public Date getDataSugerida() {
		return dataSugerida;
	}

	public void setDataSugerida(Date dataSugerida) {
		this.dataSugerida = dataSugerida;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataSugerida == null) ? 0 : dataSugerida.hashCode());
		result = prime * result + ((horaSugerida == null) ? 0 : horaSugerida.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((localDeDefesa == null) ? 0 : localDeDefesa.hashCode());
		result = prime * result + ((matriculas == null) ? 0 : matriculas.hashCode());
		result = prime * result + ((orientadores == null) ? 0 : orientadores.hashCode());
		result = prime * result + ((turmas == null) ? 0 : turmas.hashCode());
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
		DataDeDefesa other = (DataDeDefesa) obj;
		if (dataSugerida == null) {
			if (other.dataSugerida != null)
				return false;
		} else if (!dataSugerida.equals(other.dataSugerida))
			return false;
		if (horaSugerida == null) {
			if (other.horaSugerida != null)
				return false;
		} else if (!horaSugerida.equals(other.horaSugerida))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (localDeDefesa == null) {
			if (other.localDeDefesa != null)
				return false;
		} else if (!localDeDefesa.equals(other.localDeDefesa))
			return false;
		if (matriculas == null) {
			if (other.matriculas != null)
				return false;
		} else if (!matriculas.equals(other.matriculas))
			return false;
		if (orientadores == null) {
			if (other.orientadores != null)
				return false;
		} else if (!orientadores.equals(other.orientadores))
			return false;
		if (turmas == null) {
			if (other.turmas != null)
				return false;
		} else if (!turmas.equals(other.turmas))
			return false;
		return true;
	}

}
