package br.ufc.qx.agtcc.model.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.ufc.qx.agtcc.model.enums.StatusAluno;

@Entity
public class Matricula implements Serializable {

	private static final long serialVersionUID = -209772297296140981L;

	@Id
	@GeneratedValue
	private Long id;

	private String matricula;

	@ManyToOne(optional = false)
	@JoinColumn(name = "aluno_id", referencedColumnName = "id")
	private Aluno aluno;

	@ManyToOne(optional = false)
	@JoinColumn(name = "curso_id", referencedColumnName = "id")
	private Curso curso;

	private Long idMoodle;

	@Column(name = "status_curso")
	@Enumerated(EnumType.STRING)
	private StatusAluno statusCurso;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Long getIdMoodle() {
		return idMoodle;
	}

	public void setIdMoodle(Long idMoodle) {
		this.idMoodle = idMoodle;
	}

	public StatusAluno getStatusCurso() {
		return statusCurso;
	}

	public void setStatusCurso(StatusAluno statusCurso) {
		this.statusCurso = statusCurso;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 23 * hash + Objects.hashCode(this.id);
		hash = 23 * hash + Objects.hashCode(this.matricula);
		hash = 23 * hash + Objects.hashCode(this.aluno);
		hash = 23 * hash + Objects.hashCode(this.curso);
		hash = 23 * hash + Objects.hashCode(this.idMoodle);
		hash = 23 * hash + Objects.hashCode(this.statusCurso);
		return hash;
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
		final Matricula other = (Matricula) obj;
		if (!Objects.equals(this.matricula, other.matricula)) {
			return false;
		}
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		if (!Objects.equals(this.aluno, other.aluno)) {
			return false;
		}
		if (!Objects.equals(this.curso, other.curso)) {
			return false;
		}
		if (!Objects.equals(this.idMoodle, other.idMoodle)) {
			return false;
		}
		if (this.statusCurso != other.statusCurso) {
			return false;
		}
		return true;
	}

}
