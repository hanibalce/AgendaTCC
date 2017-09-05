package br.ufc.qx.agtcc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import br.ufc.qx.agtcc.model.entities.Perfil;
import br.ufc.qx.agtcc.model.entities.Permissao;
import br.ufc.qx.agtcc.service.PerfilService;
import br.ufc.qx.agtcc.service.PermissaoService;

@Named(value = "perfilBean")
@RequestScoped
public class PerfilBean implements Serializable {

	@Inject
	private PerfilService perfilService;

	@Inject
	private PermissaoService permissaoService;

	private static final long serialVersionUID = -7432720880169667152L;
	private Perfil perfil;
	private List<Perfil> perfilLista;
	private DualListModel<Permissao> permissoes;

	public PerfilBean() {
		super();
		this.perfil = new Perfil();
		this.perfil.setPermissoes(new ArrayList<Permissao>());
	}

	@PostConstruct
	public void init() {
		// Permissões
        List<Permissao> permissoesSource = permissaoService.listarPermissoes();
        List<Permissao> permissoesTarget = new ArrayList<Permissao>();
         
        permissoes = new DualListModel<Permissao>(permissoesSource, permissoesTarget);
	}

	public String salvar(Perfil perfil) {
		try {			
			perfilService.salvar(perfil,  permissoes.getTarget());
			return "consultaPerfis?faces-redirect=true";
		} catch (Exception e) {
			this.addMessage(FacesMessage.SEVERITY_ERROR, "frm:valor", e.getMessage(), null);
			return null;
		}
	}

	public String excluir(Perfil perfil) {
		try {
			perfilService.excluir(perfil);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "consultaPerfis?faces-redirect=true";
	}

	public String alterar(Perfil perfil) {
		this.perfil = perfil;
		return "cadastroPerfis";
	}

	public void addMessage(Severity severityInfo, String clientId, String summary, String detail) {
		FacesMessage message = new FacesMessage(severityInfo, summary, detail);
		FacesContext.getCurrentInstance().addMessage(clientId, message);
	}

	public void reset() {
		this.perfil.setNome("");
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public List<Perfil> getPerfilLista() {
		if (this.perfilLista == null) {
			this.perfilLista = perfilService.listarPerfisPorOrdemIdInversa();
		}
		return this.perfilLista;
	}

	public void setPerfilLista(List<Perfil> perfilLista) {
		this.perfilLista = perfilLista;
	}

	public DualListModel<Permissao> getPermissoes() {
		return this.permissoes;
	}

	public void setPermissoes(DualListModel<Permissao> permissaoLista) {
		this.permissoes = permissaoLista;
	}
	
	public void onTransfer(TransferEvent event) {
        StringBuilder builder = new StringBuilder();
        for(Object item : event.getItems()) {
            builder.append(((Permissao) item).getValor()).append("<br />");
        }
    } 

	public void setPerfilService(PerfilService perfilService) {
		this.perfilService = perfilService;
	}

	public void setPermissaoService(PermissaoService permissaoService) {
		this.permissaoService = permissaoService;
	}

}
