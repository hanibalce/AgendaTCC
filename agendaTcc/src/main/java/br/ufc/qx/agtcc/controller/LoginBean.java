package br.ufc.qx.agtcc.controller;

import java.io.Serializable;

import javax.inject.Named;

import br.ufc.qx.agtcc.model.entities.Curso;
import br.ufc.qx.agtcc.model.entities.Usuario;

@Named
@javax.faces.bean.SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = -3827495717173677303L;

	private Usuario usuario;
	private Curso curso;

	public LoginBean() {
		super();
		this.usuario = new Usuario();
		this.curso = new Curso();
	}

	public String realizarLogin(Usuario usuario) {
		return "home?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
