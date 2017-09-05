package br.ufc.qx.agtcc.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.ufc.qx.agtcc.model.entities.Aluno;
import br.ufc.qx.agtcc.model.entities.Curso;
import br.ufc.qx.agtcc.model.entities.Matricula;
import br.ufc.qx.agtcc.model.entities.Usuario;

public class Alunos implements Serializable {

	private static final long serialVersionUID = 1L;
	private EntityManager em;
	private Aluno aluno = new Aluno();
	private List<Aluno> alunos = new ArrayList<>();

	@Inject
	public Alunos(EntityManager em) {
		super();
		this.em = em;
	}

	public void salvar(Aluno aluno) {
		em.persist(aluno);
		em.flush();
	}

	public void atualizar(Aluno aluno) {
		aluno = em.merge(aluno);
		em.persist(aluno);
		em.flush();
	}

	public void excluir(Aluno aluno) {
		aluno = em.merge(aluno);
		em.remove(aluno);
		em.flush();
	}

	public Aluno porId(Long id) {
		this.aluno = em.find(Aluno.class, id);
		return this.aluno;
	}

	public Aluno porCpf(Integer cpf) {
		Query query = null;
		query = em.createQuery("Select a from Aluno a inner join Usuario u ON (u = a.usuario) where u.cpf = :cpf");
		this.aluno = (Aluno) query.setParameter("cpf", cpf).getSingleResult();
		return this.aluno;
	}

	public Aluno porUsuario(Usuario usuario) {
		TypedQuery<Aluno> query = em.createQuery("Select a from Aluno a where a.usuario = :usuario", Aluno.class);
		this.aluno = query.setParameter("usuario", usuario).getSingleResult();
		return this.aluno;
	}

	public Aluno porMatricula(Matricula matricula) {
		TypedQuery<Aluno> query = em.createQuery("Select a from Aluno a where a.matriculas in :matricula", Aluno.class);
		this.aluno = query.setParameter("matricula", matricula).getSingleResult();
		return this.aluno;
	}

	public List<Aluno> todos() {
		this.alunos = em.createQuery("from Aluno a", Aluno.class).getResultList();
		return this.alunos;
	}

	public List<Aluno> todosPorCurso(Curso curso) {
		TypedQuery<Aluno> query = em.createQuery("Select a from Aluno a Inner Join Matricula m ON (m.aluno.id = a.id) where m.curso = :curso", Aluno.class);
		this.alunos = query.setParameter("curso", curso).getResultList();
		return this.alunos;
	}
}
