package br.ufc.qx.agtcc.model.enums;

public enum TipoInstituicao {

	UNIVERSIDADE("Universidade"), 
	FACULDADE("Faculdade"), 
	INSTITUTO("Instituto"), 
	ESCOLA("Escola"), 
	COLEGIO("Colégio"), 
	CURSINHO("Cursinho"), 
	NUCLEO("Núcleo");

	private String descricao;

	public String getDescricao() {
		return this.descricao;
	}

	private TipoInstituicao(String descricao) {
		this.descricao = descricao;
	}
}
