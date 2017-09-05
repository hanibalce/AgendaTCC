package br.ufc.qx.agtcc.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufc.qx.agtcc.model.entities.Telefone;
import br.ufc.qx.agtcc.model.enums.Operadora;

public class Telefones {

	private EntityManager em;
	private Telefone telefone = new Telefone();
	private List<Telefone> telefones = new ArrayList<>();

	public Telefones(EntityManager entityManager) {
		this.em = entityManager;
	}

	public void salvar(Telefone telefone) {
		em.persist(telefone);
		em.flush();
	}

	public void atualizar(Telefone telefone) {
		telefone = em.merge(telefone);
		em.persist(telefone);
		em.flush();
	}

	public void excluir(Telefone telefone) {
		telefone = em.merge(telefone);
		em.remove(telefone);
		em.flush();
	}

	public Telefone porId(Long id) {
		this.telefone = em.find(Telefone.class, id);
		return this.telefone;
	}

	public List<Telefone> todos() {
		this.telefones = em.createQuery("from Telefone t", Telefone.class).getResultList();
		return this.telefones;
	}

	public List<Telefone> porOperadora(Operadora operadora) {
		TypedQuery<Telefone> query = em.createQuery("Select t from telefone t where t.operadora = :operadora", Telefone.class);
		this.telefones = query.setParameter("operadora", operadora).getResultList();
		return this.telefones;
	}

}
