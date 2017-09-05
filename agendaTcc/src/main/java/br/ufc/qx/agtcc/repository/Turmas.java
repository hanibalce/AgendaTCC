/**
 * 
 */
package br.ufc.qx.agtcc.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufc.qx.agtcc.model.entities.Curso;
import br.ufc.qx.agtcc.model.entities.Professor;
import br.ufc.qx.agtcc.model.entities.Turma;

public class Turmas {

	private final EntityManager em;
	private List<Turma> turmas = new ArrayList<>();
	private Turma turma = new Turma();

	public Turmas(EntityManager em) {
		super();
		this.em = em;
	}

	public List<Turma> todosPorCurso(Curso curso) {
		TypedQuery<Turma> query = em.createQuery("SELECT t FROM Turma t WHERE t.curso = :curso", Turma.class);
		this.turmas = query.setParameter("curso", curso).getResultList();
		return this.turmas;
	}

	public Turma porId(Long id) {
		this.turma = em.find(Turma.class, id);
		return this.turma;
	}

	public Turma porIdMoodle(Long idMoodle, Curso curso) {
		TypedQuery<Turma> query = em.createQuery("SELECT t FROM Turma t WHERE t.curso = :curso and t.idMoodle = :idMoodle", Turma.class);
		this.turma = query.setParameter("curso", curso).setParameter("idMoodle", idMoodle).getSingleResult();
		return this.turma;
	}

	public List<Turma> porTutor(Professor tutor, Curso curso) {
		TypedQuery<Turma> query = em.createQuery("SELECT t FROM Turma t WHERE t.tutor = :tutor and t.curso = :curso", Turma.class);
		this.turmas = query.setParameter("tutor", tutor).setParameter("curso", curso).getResultList();
		return this.turmas;
	}

	public void excluir(Turma turma) {
		turma = em.merge(turma);
		em.remove(turma);
		em.flush();
	}

	public void atualizar(Turma turma) {
		turma = em.merge(turma);
		em.persist(turma);
		em.flush();
	}

	public void salvar(Turma turma) {
		em.persist(turma);
		em.flush();
	}
}
