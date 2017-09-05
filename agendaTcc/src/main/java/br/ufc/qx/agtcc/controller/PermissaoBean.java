package br.ufc.qx.agtcc.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.ufc.qx.agtcc.model.entities.Permissao;
import br.ufc.qx.agtcc.service.PermissaoService;

@Named(value = "permissaoBean")
@RequestScoped
public class PermissaoBean implements Serializable {

	private static final long serialVersionUID = -7432720880169667152L;

	@Inject
	private PermissaoService permissaoService;

	private Permissao permissao;

	private List<Permissao> permissaoLista;

	public PermissaoBean() {
		super();
		this.permissao = this.getPermissao();
	}

	public String salvar(Permissao permissao) {
		try {
			permissao.getValor().trim();
			permissaoService.salvar(permissao);
			return "consultaPermissoes?faces-redirect=true";
		} catch (Exception e) {
			this.addMessage(FacesMessage.SEVERITY_ERROR, "frm:valor", e.getMessage(), null);
			return null;
		}
	}

	public Permissao getPermissao() {
		if (this.permissao == null) {
			return new Permissao();
		}
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

	public List<Permissao> getPermissaoLista() {
		if (this.permissaoLista == null) {
			this.permissaoLista = permissaoService.listarPermissoesPorOrdemIdInversa();
		}
		return this.permissaoLista;
	}

	public void setPermissaoLista(List<Permissao> permissaoLista) {
		this.permissaoLista = permissaoLista;
	}

	public String excluir(Permissao permissao) {
		try {
			permissaoService.excluir(permissao);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "consultaPermissoes?faces-redirect=true";
	}

	public void addMessage(Severity severityInfo, String clientId, String summary, String detail) {
		FacesMessage message = new FacesMessage(severityInfo, summary, detail);
		FacesContext.getCurrentInstance().addMessage(clientId, message);
	}

	public void resetValor(Permissao permissao) {
		permissao.setValor("");
	}

	public String alterarPermissao(Permissao permissao) {
		this.permissao = permissao;
		return "cadastroPermissoes";
	}

}
