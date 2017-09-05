package br.ufc.qx.agtcc.model.enums;

public enum Operadora {

	TIM("Tim", 41),
	OI("Oi", 31),
	VIVO("Vivo", 15), 
	GVT("GVT VIVO", 25), 
	CLARO("Claro", 21), 
	NET("Net", 21), 
	EMBRATEL("Embratel", 21),	
	NEXTEL1("Nextel", 77),
	NEXTEL2("Nextel", 99),
	INTELIG("Intelig", 23),
	GOIAS_TELECOM("GOIÁS TELECOM", 22),
	SERCOMTEL("Sercomtel",43) ;

	private String descricao;
	private int codigo;

	private Operadora(String descricao, int codigo) {
		this.descricao = descricao;
		this.codigo = codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public int getCodigo() {
		return this.codigo;
	}
}
