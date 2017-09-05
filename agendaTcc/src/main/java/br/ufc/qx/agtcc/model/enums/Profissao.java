package br.ufc.qx.agtcc.model.enums;

public enum Profissao {
	MEDICO("Médico(a)"), 
	ENFEREMEIRO("Enfermeiro(a)"), 
	ODONTOLOGISTA("Odontologista"), 
	FARMACEUTICO("farmacêutico(a)"), 
	BIOMEDICO("Biomédico(a)"), 
	NUTRICIONISTA("Nutricionista"), 
	PSICOLOGO("Psicólogo(a)"), 
	FISIOTERAPEUTA("Fisioterapeuta"), 
	TERAPEUTA_OCUPACIONAL("Terapeuta Ocupacional"), 
	QUIROPRAXISTA("Quiropraxista"), 
	PROFESSOR("Professor"), 
	ANALISTA_DE_SISTEMAS("Analista de Sistemas"), 
	EDUCADOR_FÍSICO("Educador Físico"),
	BIBLIOTECARIO("Bibliotecário(a)"),
	OUTRO("Outro");	

	private String descricao;

	private Profissao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

}
