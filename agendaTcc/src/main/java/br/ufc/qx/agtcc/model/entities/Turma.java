package br.ufc.qx.agtcc.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Turma implements Serializable {

	private static final long serialVersionUID = -9135522995779736612L;

	@Id
	@GeneratedValue
	private Long id;

	private Long idMoodle;

	private String nome;

	@OneToMany(fetch = FetchType.LAZY)
	@Fetch(FetchMode.SELECT)
	private List<Matricula> matriculas;

	@ManyToOne(optional = false)
	@JoinColumn(name = "tutor_id", referencedColumnName = "id")
	private Professor tutor;

	@OneToOne
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

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public Professor getTutor() {
		return tutor;
	}

	public void setTutor(Professor tutor) {
		this.tutor = tutor;
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
		result = prime * result + ((matriculas == null) ? 0 : matriculas.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tutor == null) ? 0 : tutor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Turma other = (Turma) obj;
		if (curso == null) {
			if (other.curso != null) {
				return false;
			}
		} else if (!curso.equals(other.curso)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (idMoodle == null) {
			if (other.idMoodle != null) {
				return false;
			}
		} else if (!idMoodle.equals(other.idMoodle)) {
			return false;
		}
		if (matriculas == null) {
			if (other.matriculas != null) {
				return false;
			}
		} else if (!matriculas.equals(other.matriculas)) {
			return false;
		}
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		if (tutor == null) {
			if (other.tutor != null) {
				return false;
			}
		} else if (!tutor.equals(other.tutor)) {
			return false;
		}
		return true;
	}

}
