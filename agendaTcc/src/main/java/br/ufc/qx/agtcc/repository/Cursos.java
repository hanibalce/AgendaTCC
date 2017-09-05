package br.ufc.qx.agtcc.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.ufc.qx.agtcc.model.entities.Curso;

public class Cursos {

	private EntityManager em;
	private Curso curso = new Curso();
	private List<Curso> cursos = new ArrayList<Curso>();

	public Cursos(EntityManager entityManager) {
		this.em = entityManager;
	}

	public void salvar(Curso curso) {
		em.persist(curso);
		em.flush();
	}

	public void atualizar(Curso curso) {
		curso = em.merge(curso);
		em.persist(curso);
		em.flush();
	}

	public void excluir(Curso curso) {
		curso = em.merge(curso);
		em.remove(curso);
		em.flush();
	}

	public Curso porId(Long id) {
		this.curso = em.find(Curso.class, id);
		return this.curso;
	}

	public List<Curso> todos() {
		this.cursos = em.createQuery("from Curso c", Curso.class).getResultList();
		return this.cursos;
	}
}
