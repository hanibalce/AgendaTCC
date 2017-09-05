package br.ufc.qx.agtcc.model.enums;

public enum Genero {

	MASCULINO("Masculino"),
	FEMININO("Feminino");

	private String descricao;

	private Genero(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

}
