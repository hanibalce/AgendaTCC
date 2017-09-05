package br.ufc.qx.agtcc.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.ufc.qx.agtcc.model.entities.Perfil;

public class Perfis implements Serializable {

	private static final long serialVersionUID = 4675812267812212940L;

	private final EntityManager em;

	private Perfil perfil = new Perfil();

	private List<Perfil> perfis = new ArrayList<>();

	@Inject
	public Perfis(EntityManager entityManager) {
		this.em = entityManager;
	}

	public List<Perfil> todos() {
		TypedQuery<Perfil> query = em.createQuery("from Perfil p order by p.id", Perfil.class);
		this.perfis = query.getResultList();
		return this.perfis;
	}

	public Perfil porId(Long id) {
		this.perfil = em.find(Perfil.class, id);
		return this.perfil;
	}

	public Perfil porNome(String nome) {
		TypedQuery<Perfil> query = em.createQuery("from Perfil p Where p.nome =:nome", Perfil.class);
		this.perfil = query.setParameter("nome", nome).getSingleResult();
		return this.perfil;
	}

	@Transactional
	public void salvar(Perfil perfil) {
		this.perfil = perfil;
		em.persist(perfil);
		em.flush();
	}

	@Transactional
	public void atualizar(Perfil perfil) {
		this.perfil = perfil;
		perfil = em.merge(perfil);
		em.persist(perfil);
		em.flush();
	}

	@Transactional
	public void excluir(Perfil perfil) {
		this.perfil = perfil;
		perfil = em.merge(perfil);
		em.remove(perfil);
		em.flush();
	}

	public List<Perfil> todosPorOrdemAlfabetica() {
		TypedQuery<Perfil> query = em.createQuery("from Perfil p order by p.nome", Perfil.class);
		this.perfis = query.getResultList();
		return this.perfis;
	}

	public List<Perfil> buscarPorNome(String nome) {
		TypedQuery<Perfil> query = em.createQuery("from Perfil p where p.nome =:nome order by p.nome", Perfil.class);
		this.perfis = query.setParameter("nome", nome).getResultList();
		return this.perfis;
	}
}
