package br.ufc.qx.agtcc.service;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

import br.ufc.qx.agtcc.exceptions.SaadCampoDuplicadoException;
import br.ufc.qx.agtcc.exceptions.SaadCampoEmUsoException;
import br.ufc.qx.agtcc.model.entities.Permissao;
import br.ufc.qx.agtcc.repository.Permissoes;

public class PermissaoService implements Serializable {

	private static final long serialVersionUID = -5330742957706100768L;

	private final Permissoes permissoes;

	@Inject
	public PermissaoService(Permissoes permissoes) {
		super();
		this.permissoes = permissoes;
	}

	public void salvar(Permissao permissao) throws SaadCampoDuplicadoException {
		try {
			if (permissao.getId() != null) {
				this.permissoes.atualizar(permissao);
			} else {
				this.permissoes.salvar(permissao);
			}
		} catch (PersistenceException e) {
			throw new SaadCampoDuplicadoException(permissao.getValor());
		}

	}

	public List<Permissao> listarPermissoes() {
		return this.permissoes.todos();
	}

	public List<Permissao> listarPermissoesPorOrdemAlfabetica() {
		return this.permissoes.todosPorOrdemAlfabetica();
	}

	public List<Permissao> listarPermissoesPorOrdemIdInversa() {
		List<Permissao> list = this.permissoes.todos();
		Collections.reverse(list);
		return list;
	}

	public Permissao buscarPorId(long id) {
		return this.permissoes.porId(id);
	}

	public List<Permissao> buscarPorValor(String valor) {
		List<Permissao> list = this.permissoes.porValor(valor);
		return list;
	}

	public void excluir(Permissao permissao) throws Exception {
		try {
			this.permissoes.excluir(permissao);
		} catch (PersistenceException e) {
			throw new SaadCampoEmUsoException(permissao.getValor());
		}
	}

	public void excluir(String valor) throws Exception {
		try {
			this.permissoes.excluirPorValor(valor);
		} catch (PersistenceException e) {
			throw new SaadCampoEmUsoException(valor);
		}
	}
}
