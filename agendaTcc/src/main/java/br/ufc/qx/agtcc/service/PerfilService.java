package br.ufc.qx.agtcc.service;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import br.ufc.qx.agtcc.exceptions.SaadCampoDuplicadoException;
import br.ufc.qx.agtcc.exceptions.SaadCampoEmUsoException;
import br.ufc.qx.agtcc.model.entities.Perfil;
import br.ufc.qx.agtcc.model.entities.Permissao;
import br.ufc.qx.agtcc.repository.Perfis;

public class PerfilService implements Serializable {

	private static final long serialVersionUID = -1124161878719777499L;

	private Perfis perfis;

	@Inject
	public PerfilService(Perfis perfis) {
		super();
		this.perfis = perfis;
	}

	public void salvar(Perfil perfil, List<Permissao> list) throws SaadCampoDuplicadoException {
		try {
			list.removeAll(Collections.singleton(null));
			perfil.setPermissoes(list);
			if (perfil.getId() != null) {
				this.perfis.atualizar(perfil);
			} else {
				this.perfis.salvar(perfil);
			}
		} catch (Exception e) {
			throw new SaadCampoDuplicadoException(perfil.getNome());
		}
	}

	public List<Perfil> listarPerfisPorOrdemIdInversa() {
		List<Perfil> lista = this.listarPerfis();
		Collections.reverse(lista);
		return lista;
	}

	public void excluir(Perfil perfil) throws SaadCampoEmUsoException {
		try {
			this.perfis.excluir(perfil);
		} catch (Exception e) {
			throw new SaadCampoEmUsoException(perfil.getNome());
		}
	}

	public List<Perfil> listarPerfis() {
		return this.perfis.todos();
	}

	public List<Perfil> listarPerfisPorOrdemAlfabetica() {
		return this.perfis.todosPorOrdemAlfabetica();
	}

	public List<Perfil> buscarPorNome(String nome) {
		return this.perfis.buscarPorNome(nome);
	}
}
