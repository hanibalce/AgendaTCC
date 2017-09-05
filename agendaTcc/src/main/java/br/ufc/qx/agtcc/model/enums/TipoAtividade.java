package br.ufc.qx.agtcc.model.enums;

public enum TipoAtividade {
	FORUM("Fórum"), 
	TAREFA("Tarefa"),
	TRABALHO("Trabalho"),
	EXERCICIO("Exercício"), 
	AVALIACAO_PRESENCIAL("Avaliação Presencial"),
	AVALIACAO_VIRTUAL("Avaliação Virtual"), 
	ATIVIDADE_PRESENCIAL("Atividade Presencial"), 
	ATIVIDADE_VIRTUAL("Atividade Virtual"), 
	QUESTIONARIO("Questionário"),
	QUESTIONÁRIO_PREDEFINIDO("Questionário Predefinido"),
	GLOSSARIO("Glossário"),
	WORKSHOP("Workshop"),
	LICAO("Lição"),
	CHAT("Chat"),
	INQUERITO("Inquérito");
	
	private String descricao;

	public String getDescricao() {
		return this.descricao;
	}

	private TipoAtividade(String descricao) {
		this.descricao = descricao;
	}

}
