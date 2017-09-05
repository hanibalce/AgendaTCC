package br.ufc.qx.agtcc.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufc.qx.agtcc.model.entities.Endereco;

public class Enderecos {

	private final EntityManager em;
	private List<Endereco> enderecos = new ArrayList<>();
	private Endereco endereco = new Endereco();

	public Enderecos(EntityManager em) {
		this.em = em;
	}

	public List<Endereco> todos() {
		TypedQuery<Endereco> query = em.createQuery("from Endereco e", Endereco.class);
		this.enderecos = query.getResultList();
		return enderecos;
	}

	public Endereco porId(Long id) {
		this.endereco = em.find(Endereco.class, id);
		return endereco;
	}

	public List<Endereco> porUf(String uf) {
		TypedQuery<Endereco> query = em.createQuery("SELECT e FROM Endereco e WHERE e.uf = :uf", Endereco.class);
		this.enderecos = query.setParameter("uf", uf).getResultList();
		return this.enderecos;
	}

	public List<Endereco> porMunicipio(String municipio) {
		TypedQuery<Endereco> query = em.createQuery("SELECT e FROM Endereco e WHERE e.municipio = :municipio", Endereco.class);
		this.enderecos = query.setParameter("municipio", municipio).getResultList();
		return this.enderecos;
	}

	public List<Endereco> porUfEMunicipio(String uf, String municipio) {
		TypedQuery<Endereco> query = em.createQuery("SELECT e FROM Endereco e WHERE  e.uf = :uf and e.municipio = :municipio", Endereco.class);
		this.enderecos = query.setParameter("uf", uf).setParameter("municipio", municipio).getResultList();
		return this.enderecos;
	}

	public void salvar(Endereco endereco) {
		this.endereco = endereco;
		em.persist(endereco);
		em.flush();
	}

	public void atualizar(Endereco endereco) {
		endereco = em.merge(endereco);
		em.persist(this.endereco);
		em.flush();
	}

	public void excluir(Endereco endereco) {
		this.endereco = endereco;
		endereco = em.merge(endereco);
		em.remove(endereco);
		em.flush();
	}

}
