package br.ufc.qx.agtcc.repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufc.qx.agtcc.model.entities.Curso;
import br.ufc.qx.agtcc.model.entities.Defesa;

public class Defesas {

	private EntityManager em;
	private Defesa defesa = new Defesa();
	private List<Defesa> defesas = new ArrayList<>();

	public Defesas(EntityManager entityManager) {
		this.em = entityManager;
	}

	public void salvar(Defesa defesa) {
		em.persist(defesa);
		em.flush();
	}

	public void atualizar(Defesa defesa) {
		defesa = em.merge(defesa);
		em.persist(defesa);
		em.flush();
	}

	public void excluir(Defesa defesa) {
		defesa = em.merge(defesa);
		em.remove(defesa);
		em.flush();
	}

	public Defesa porId(Long id) {
		this.defesa = em.find(Defesa.class, id);
		return this.defesa;
	}

	public List<Defesa> todos() {
		TypedQuery<Defesa> query = em.createQuery("from Defesa d", Defesa.class);
		this.defesas = query.getResultList();
		return this.defesas;
	}

	public List<Defesa> todosPorCurso(Curso curso) {
		TypedQuery<Defesa> query = em.createQuery("Select d from Defesa d where d.curso = :curso", Defesa.class);
		this.defesas = query.setParameter("curso", curso).getResultList();
		return this.defesas;
	}

	public List<Defesa> porNomeDoLocal(String nomeDolocal, Curso curso) {
		TypedQuery<Defesa> query = em.createQuery("Select d from Defesa d where d.curso = :curso and d.nomeDolocal like :nomeDolocal", Defesa.class);
		this.defesas = query.setParameter("curso", curso).setParameter("nomeDolocal", nomeDolocal).getResultList();
		return this.defesas;
	}

	public List<Defesa> porDataDeDefesa(Date dataDefesa, Curso curso) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String data = df.format(dataDefesa);
		TypedQuery<Defesa> query = em.createQuery("Select d from Defesa d where d.curso = :curso and d.dataDefesa = :dataDefesa", Defesa.class);
		this.defesas = query.setParameter("curso", curso).setParameter("dataDefesa", data).getResultList();
		return this.defesas;
	}

	public List<Defesa> porDataEHora(Date dataDefesa, Date horaDefesa, Curso curso) {
		DateFormat df = new SimpleDateFormat("HH:mm");
		String hora = df.format(horaDefesa);
		df = new SimpleDateFormat("dd/MM/yyyy");
		String data = df.format(dataDefesa);
		TypedQuery<Defesa> query = em.createQuery("Select d from Defesa d where d.curso = :curso and d.dataDefesa = :data and d.horaDefesa = :hora", Defesa.class);
		this.defesas = query.setParameter("curso", curso).setParameter("data", data).setParameter("hora", hora).getResultList();
		return this.defesas;
	}

	public List<Defesa> porDataELocal(Date dataDefesa, String nomeDolocal, Curso curso) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String data = df.format(dataDefesa);
		TypedQuery<Defesa> query = em.createQuery("Select d from Defesa d where d.curso = :curso and d.dataDefesa = :data and d.nomeDolocal like :nomeDolocal", Defesa.class);
		this.defesas = query.setParameter("curso", curso).setParameter("data", data).getResultList();
		return this.defesas;
	}

	public List<Defesa> porDataHoraELocal(Date dataDefesa, Date horaDefesa, String nomeDolocal, Curso curso) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String data = df.format(dataDefesa);
		df = new SimpleDateFormat("HH:mm");
		String hora = df.format(horaDefesa);
		TypedQuery<Defesa> query = em.createQuery("Select d from Defesa d where d.curso = :curso and d.dataDefesa = :data and d.horaDefesa = :hora and d.nomeDolocal like :nomeDolocal", Defesa.class);
		this.defesas = query.setParameter("curso", curso).setParameter("data", data).setParameter("hora", hora).getResultList();
		return this.defesas;
	}

}
