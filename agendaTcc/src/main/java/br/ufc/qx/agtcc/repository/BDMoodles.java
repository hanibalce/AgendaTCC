package br.ufc.qx.agtcc.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.ufc.qx.agtcc.model.entities.BDMoodle;
import br.ufc.qx.agtcc.repository.BDMoodles;

public class BDMoodles implements Serializable {

	private static final long serialVersionUID = 1L;
	private EntityManager em;
	private BDMoodle bd = new BDMoodle();
	private List<BDMoodle> bds = new ArrayList<>();

	@Inject
	public BDMoodles(EntityManager em) {
		super();
		this.em = em;
	}

	public void salvar(BDMoodle bd) {
		em.persist(bd);
		em.flush();
	}

	public void atualizar(BDMoodle bd) {
		bd = em.merge(bd);
		em.persist(bd);
		em.flush();
	}

	public void excluir(BDMoodle bd) {
		bd = em.merge(bd);
		em.remove(bd);
		em.flush();
	}

	public BDMoodle porId(Long id) {
		this.bd = em.find(BDMoodle.class, id);
		return this.bd;
	}

	public List<BDMoodle> todos() {
		this.bds = em.createQuery("from BDMoodle b", BDMoodle.class).getResultList();
		return this.bds;
	}

	public List<BDMoodle> todosPorOrdemAlfabetica() {
		this.bds = em.createQuery("Select b from BDMoodle b order by b.nomeBD", BDMoodle.class).getResultList();
		return this.bds;
	}
}
