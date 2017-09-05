package br.ufc.qx.agtcc.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufc.qx.agtcc.model.entities.Atividade;
import br.ufc.qx.agtcc.model.entities.Curso;
import br.ufc.qx.agtcc.model.enums.TipoAtividade;

public class Atividades implements Serializable {

	private static final long serialVersionUID = 1L;
	private EntityManager em;
	
	@Inject
	public Atividades(EntityManager em) {
		super();
		this.em = em;
	}

	public void salvar(Atividade atividade) {
		em.persist(atividade);
		em.flush();
	}

	public void atualizar(Atividade atividade) {
		atividade = em.merge(atividade);
		em.persist(atividade);
		em.flush();
	}

	public void excluir(Atividade atividade) {
		atividade = em.merge(atividade);
		em.remove(atividade);
		em.flush();
	}

	public Atividade porId(Long id) {		
		return em.find(Atividade.class, id);
	}

	public List<Atividade> todos() {
		TypedQuery<Atividade> query = em.createQuery("from Atividade a", Atividade.class);	
		return query.getResultList();

	}

	public List<Atividade> porTipoAtividade(TipoAtividade tipoAtividade) {
		TypedQuery<Atividade> query = em.createQuery("Select a from Atividade a where a.tipoAtividade = :tipoAtividade", Atividade.class);	
		return query.setParameter("tipoAtividade", tipoAtividade).getResultList();
	}

	public Atividade porIdMoodle(Long idMoodle, Curso curso) {
		TypedQuery<Atividade> query = em.createQuery("Select a from Atividade a where a.curso = :curso and a.idMoodle = :idMoodle", Atividade.class);		
		return query.setParameter("curso", curso).setParameter("idMoodle", idMoodle).getSingleResult();
	}

	public List<Atividade> todosPorCurso(Curso curso) {
		TypedQuery<Atividade> query = em.createQuery("Select a from Atividade a where a.curso = :curso", Atividade.class);
		return query.setParameter("curso", curso).getResultList();		
	}
}
