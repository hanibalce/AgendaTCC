package br.ufc.qx.agtcc.service;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import br.ufc.qx.agtcc.model.entities.BDMoodle;
import br.ufc.qx.agtcc.repository.BDMoodles;

public class BdMoodleService implements Serializable{


	private BDMoodles bdMoodles;
	
	private static final long serialVersionUID = 1L;

	@Inject	
	public BdMoodleService(BDMoodles bdMoodles) {
		super();
		this.bdMoodles = bdMoodles;
	}

	public BDMoodles getBdMoodles() {
		return bdMoodles;
	}

	public void setBdMoodles(BDMoodles bdMoodles) {
		this.bdMoodles = bdMoodles;
	}

	public void salvar(BDMoodle bdmoodle) throws Exception {
		try {
			if (bdmoodle.getId() != null) {
				this.bdMoodles.atualizar(bdmoodle);
			} else {
				this.bdMoodles.salvar(bdmoodle);
			}
		} catch (Exception e) {
			throw new Exception("Erro ao salvar o banco de dados do Moodle.");
		}
		
	}

	public void excluir(BDMoodle bdmoodle) throws Exception {
		try {
			this.bdMoodles.excluir(bdmoodle);
		} catch (Exception e) {
			throw new Exception("O Banco de Dados que você está tentando excluir está em uso.");
		}
		
	}
	
	public List<BDMoodle> listarBdMoodles() {
		return this.bdMoodles.todos();
	}
	
	public List<BDMoodle> listarPermissoesPorOrdemAlfabetica() {
		return this.bdMoodles.todosPorOrdemAlfabetica();
	}

	public List<BDMoodle> listarPermissoesPorOrdemIdInversa() {
		List<BDMoodle> list = this.bdMoodles.todos();
		Collections.reverse(list);
		return list;
	}
}
