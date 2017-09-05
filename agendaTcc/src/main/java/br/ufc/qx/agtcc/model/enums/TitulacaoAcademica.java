package br.ufc.qx.agtcc.model.enums;

public enum TitulacaoAcademica {

	ESPECIALISTA("Especialista"), 
	MESTRE("Mestre"), 
	DOUTOR("Doutor"), 
	MBA("MBA"), 
	LIVREDOCENTE("Livre-Docente"), 
	POSDOUTOR("Pós-Doutor"), 
	BACHAREL("Bacharel"), 
	LICENCIADO("Licenciado"), 
	TECNOLOGO("Tecnólogo"), 
	PHD("Phd.");

	private String descricao;

	private TitulacaoAcademica(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

}
