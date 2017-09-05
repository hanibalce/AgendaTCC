package br.ufc.qx.agtcc.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufc.qx.agtcc.model.entities.Instituicao;
import br.ufc.qx.agtcc.model.enums.TipoInstituicao;
import br.ufc.qx.agtcc.repository.Instituicoes;

public class Instituicoes {

	private EntityManager em;
	private Instituicao instituicao = new Instituicao();
	private List<Instituicao> instituicoes = new ArrayList<>();

	public Instituicoes(EntityManager em) {
		super();
		this.em = em;
	}

	public void salvar(Instituicao instituicao) {
		em.persist(instituicao);
		em.flush();
	}

	public void atualizar(Instituicao instituicao) {
		instituicao = em.merge(instituicao);
		em.persist(instituicao);
		em.flush();
	}

	public void excluir(Instituicao instituicao) {
		instituicao = em.merge(instituicao);
		em.remove(instituicao);
		em.flush();
	}

	public Instituicao porId(Long id) {
		this.instituicao = em.find(Instituicao.class, id);
		return this.instituicao;
	}

	public List<Instituicao> todos() {
		this.instituicoes = em.createQuery("from Instituicao i", Instituicao.class).getResultList();
		return this.instituicoes;
	}

	public List<Instituicao> buscarPorTipoInstituicao(TipoInstituicao tipoInstituicao) {
		TypedQuery<Instituicao> query = em.createQuery("Select i from Instituicao i where i.tipoInstituicao = :tipoInstituicao", Instituicao.class);
		this.instituicoes = query.setParameter("tipoInstituicao", tipoInstituicao).getResultList();
		return this.instituicoes;
	}

}
