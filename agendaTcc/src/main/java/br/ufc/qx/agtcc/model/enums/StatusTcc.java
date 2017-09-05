package br.ufc.qx.agtcc.model.enums;

public enum StatusTcc {

	NAO_INSCRITO("Não Inscrito"), 
	INSCRITO("Inscrito"), 
	EM_ANALISE("Em Análise"), 
	DEFESA_AGENDADA("Defesa Agendada"), 
	DEFESA_LIBERADA("Defesa Liberada"), 
	DEFENDIDO("Defendido"), 
	FINALIZADO("Finalizado");
	
	private String descricao;

	public String getDescricao() {
		return this.descricao;
	}

	private StatusTcc(String descricao) {
		this.descricao = descricao;
	}
}
