package br.ufc.qx.agtcc.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.ufc.qx.agtcc.model.entities.BDMoodle;
import br.ufc.qx.agtcc.service.BdMoodleService;

@Named(value = "bdMoodleBean")
@RequestScoped
public class BdMoodleBean implements Serializable {

	private static final long serialVersionUID = -7763532508396439219L;

	private BDMoodle bdMoodle;

	private List<BDMoodle> bdMoodleList;

	private BdMoodleService bdMoodleService;

	@Inject
	public BdMoodleBean(BDMoodle bdMoodle, BdMoodleService bdMoodleService) {
		super();
		this.bdMoodle = bdMoodle;
		this.bdMoodleService = bdMoodleService;
	}

	public BDMoodle getBdMoodle() {
		return bdMoodle;
	}

	public void setBdMoodle(BDMoodle bdMoodle) {
		this.bdMoodle = bdMoodle;
	}

	public BdMoodleService getBdMoodleService() {
		return bdMoodleService;
	}

	public void setBdMoodleService(BdMoodleService bdMoodleService) {
		this.bdMoodleService = bdMoodleService;
	}

	public String salvar(BDMoodle bdmoodle) {
		try {
			this.bdMoodleService.salvar(bdmoodle);
		} catch (Exception e) {
			this.addMessage(FacesMessage.SEVERITY_ERROR, "frm:valor", e.getMessage(), null);
			return null;
		}
		return "consultaBdMoodle?faces-redirect=true";

	}

	private void addMessage(Severity severityInfo, String clientId, String summary, String detail) {
		FacesMessage message = new FacesMessage(severityInfo, summary, detail);
		FacesContext.getCurrentInstance().addMessage(clientId, message);
	}

	public String excluir(BDMoodle bdmoodle) {
		try {
			this.bdMoodleService.excluir(bdmoodle);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "consultaBdMoodle?faces-redirect=true";
	}

	public List<BDMoodle> getBdMoodleList() {
		if (this.bdMoodleList == null) {
			this.bdMoodleList = this.bdMoodleService.listarPermissoesPorOrdemAlfabetica();
		}
		return bdMoodleList;
	}

	public void setBdMoodleList(List<BDMoodle> bdMoodleList) {
		this.bdMoodleList = bdMoodleList;
	}

	public String alterar(BDMoodle bd) {
		this.bdMoodle = bd;
		return "cadastroBdMoodle";
	}

	public void reset() {
		this.bdMoodle.setNomeBD("");
		this.bdMoodle.setPorta(0);
		this.bdMoodle.setSenha("");
		this.bdMoodle.setUrl("");
		this.bdMoodle.setUsuario("");
	}
}
