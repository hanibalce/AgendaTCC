package br.ufc.qx.agtcc.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.ufc.qx.agtcc.model.entities.Permissao;

public class Permissoes implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager em;

	private Permissao permissao = new Permissao();

	private List<Permissao> permissoes = new ArrayList<>();

	@Inject
	public Permissoes(EntityManager em) {
		super();
		this.em = em;
	}

	public List<Permissao> todos() {
		em.clear();
		TypedQuery<Permissao> query = em.createQuery("from Permissao p order by p.id", Permissao.class);
		this.permissoes = query.getResultList();
		return this.permissoes;
	}

	public Permissao porId(Long id) {
		em.clear();
		this.permissao = em.find(Permissao.class, id);
		return this.permissao;
	}

	public List<Permissao> porValor(String valor) {
		em.clear();
		TypedQuery<Permissao> query = em.createQuery("from Permissao p Where p.valor LIKE :valor order by p.id", Permissao.class);
		this.permissoes = query.setParameter("valor", "%" + valor + "%").getResultList();
		return this.permissoes;
	}

	@Transactional
	public void salvar(Permissao permissao) {
		this.permissao = permissao;
		em.persist(permissao);
		em.flush();
	}

	@Transactional
	public void atualizar(Permissao permissao) {
		this.permissao = permissao;
		permissao = em.merge(permissao);
		em.persist(permissao);
		em.flush();
	}

	@Transactional
	public void excluir(Permissao permissao) {
		this.permissao = permissao;
		permissao = em.merge(permissao);
		em.remove(permissao);
		em.flush();
	}

	public List<Permissao> todosPorOrdemAlfabetica() {
		em.clear();
		TypedQuery<Permissao> query = em.createQuery("from Permissao p order by p.valor", Permissao.class);
		this.permissoes = query.getResultList();
		return this.permissoes;
	}

	public void excluirPorValor(String valor) {
		Query query = em.createQuery("Delete from Permissao p where p.valor = :valor");
		query.setParameter("valor", valor).executeUpdate();
		em.flush();
	}

}
