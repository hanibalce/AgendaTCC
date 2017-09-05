package br.ufc.qx.agtcc.model.enums;

public enum StatusAluno {

	CURSANDO("Cursando"), APROVADO("Aprovado"), REPORVADO("Reprovado"), ABANDONOU("Abandonou");

	private String descricao;

	public String getDescricao() {
		return this.descricao;
	}

	private StatusAluno(String descricao) {
		this.descricao = descricao;
	}

}
