package br.ufc.qx.agtcc.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufc.qx.agtcc.model.entities.Documento;
import br.ufc.qx.agtcc.model.enums.TipoDocumento;

public class Documentos {

	private EntityManager em;
	private Documento documento = new Documento();
	private List<Documento> documentos = new ArrayList<Documento>();

	public Documentos(EntityManager entityManager) {
		this.em = entityManager;
	}

	
	public void salvar(Documento documento) {
		em.persist(documento);
		em.flush();
	}

	
	public void atualizar(Documento documento) {
		documento = em.merge(documento);
		em.persist(documento);
		em.flush();
	}

	
	public void excluir(Documento documento) {
		documento = em.merge(documento);
		em.remove(documento);
		em.flush();

	}

	
	public Documento porId(Long id) {
		this.documento = em.find(Documento.class, id);
		return this.documento;
	}

	
	public List<Documento> todos() {
		TypedQuery<Documento> query = em.createQuery("from Documento d", Documento.class);
		this.documentos = query.getResultList();
		return this.documentos;
	}

	
	public List<Documento> porTipoDocumento(TipoDocumento tipoDocumento) {
		TypedQuery<Documento> query = em
				.createQuery("Select d from Documento d where d.tipoDeDocumento = :tipoDocumento", Documento.class);
		this.documentos = query.setParameter("tipoDocumento", tipoDocumento).getResultList();
		return this.documentos;
	}
}
