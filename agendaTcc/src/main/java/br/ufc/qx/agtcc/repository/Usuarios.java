package br.ufc.qx.agtcc.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufc.qx.agtcc.model.entities.Usuario;

public class Usuarios implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private EntityManager em;
	
	private List<Usuario> usuarios = new ArrayList<>();
	
	private Usuario usuario = new Usuario();

	@Inject
	public Usuarios(EntityManager em) {
		this.em = em;
	}

	public List<Usuario> todos() {
		TypedQuery<Usuario> query = em.createQuery("from Usuario u order by u.id", Usuario.class);
		this.usuarios = query.getResultList();
		return usuarios;
	}

	public Usuario porId(Long id) {
		this.usuario = em.find(Usuario.class, id);
		return usuario;
	}

	public Usuario porLogin(String login) {
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login", Usuario.class);
		this.usuario = query.setParameter("login", login).getSingleResult();
		return this.usuario;
	}

	public Usuario porEmail(String email) {
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class);
		this.usuario = query.setParameter("email", email).getSingleResult();
		return this.usuario;
	}

	public Usuario porCpf(String string) {
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.cpf = :cpf", Usuario.class);
		this.usuario = query.setParameter("cpf", string).getSingleResult();
		return this.usuario;
	}

	public void salvar(Usuario usuario) {
		this.usuario = usuario;
		em.persist(usuario);
		em.flush();
	}

	public void atualizar(Usuario usuario) {
		usuario = em.merge(usuario);
		em.persist(this.usuario);
		em.flush();
	}

	public void excluir(Usuario usuario) {
		this.usuario = usuario;
		usuario = em.merge(usuario);
		em.remove(usuario);
		em.flush();
	}
}
