package br.ufc.qx.agtcc.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufc.qx.agtcc.model.entities.Aluno;
import br.ufc.qx.agtcc.model.entities.Curso;
import br.ufc.qx.agtcc.model.entities.Matricula;
import br.ufc.qx.agtcc.model.enums.StatusAluno;

public class Matriculas {

	private EntityManager em;
	private Matricula matricula = new Matricula();
	private List<Matricula> matriculas = new ArrayList<Matricula>();

	public Matriculas(EntityManager entityManager) {
		this.em = entityManager;
	}

	
	public Matricula porId(Long id) {
		this.matricula = em.find(Matricula.class, id);
		return this.matricula;
	}

	
	public Matricula porIdMoodle(Long idMoodle, Curso curso) {
		TypedQuery<Matricula> query = em.createQuery(
				"Select m from Matricula m where m.curso = :curso and m.idMoodle = : idMoodle", Matricula.class);
		this.matricula = query.setParameter("curso", curso).setParameter("idMoodle", idMoodle).getSingleResult();
		return this.matricula;
	}

	
	public void salvar(Matricula matricula) {
		em.persist(matricula);
		em.flush();
	}

	
	public void atualizar(Matricula matricula) {
		matricula = em.merge(matricula);
		em.persist(matricula);
		em.flush();
	}

	
	public void excluir(Matricula matricula) {
		matricula = em.merge(matricula);
		em.remove(matricula);
		em.flush();
	}

	
	public List<Matricula> porStatusAluno(StatusAluno statusAluno) {
		TypedQuery<Matricula> query = em.createQuery("Select m from Matricula m where m.statusAluno = :statusAluno",
				Matricula.class);
		this.matriculas = query.setParameter("statusAluno", statusAluno).getResultList();
		return this.matriculas;
	}

	
	public List<Matricula> todos() {
		TypedQuery<Matricula> query = em.createQuery("from Matricula m", Matricula.class);
		this.matriculas = query.getResultList();
		return this.matriculas;
	}

	
	public List<Matricula> todosPorCurso(Curso curso) {
		TypedQuery<Matricula> query = em.createQuery("Select m from Matricula m where m.curso = :curso",
				Matricula.class);
		this.matriculas = query.setParameter("curso", curso).getResultList();
		return this.matriculas;
	}

	
	public List<Matricula> porAluno(Aluno aluno) {
		TypedQuery<Matricula> query = em.createQuery("Select m from Matricula m where m.aluno = :aluno",
				Matricula.class);
		this.matriculas = query.setParameter("aluno", aluno).getResultList();
		return this.matriculas;
	}
}
