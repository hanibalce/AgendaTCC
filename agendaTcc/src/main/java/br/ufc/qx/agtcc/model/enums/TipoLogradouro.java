package br.ufc.qx.agtcc.model.enums;

public enum TipoLogradouro {

	RUA("Rua", "R."), 
	AVENIDA("Avenida", "Av."), 
	RODOVIA("Rodovia", "Rod."), 
	VIA("Via", "Via"), 
	BECO("Beco","Bc."), 
	ESTRADA("Estrada", "Estr."), 
	TRAVESSA("Travessa", "Trav."), 
	PRACA("Praça", "Pça."), 
	VILA("Vila", "Vl."), 
	AEROPORTO("AEROPORTO", "Aer."), 
	ALAMEDA("Alameda", "Al."), 
	BOULEVARD("Boulevard","Blv."), 
	CAMINHO("Caminho", "Cam."), 
	CAIS("Cais", "Cais."), 
	CAMPO("Campo","Cpo."), 
	ESCADA("Escada", "Escd."), 
	FAVELA("Favela", "Fav."), 
	FAZENDA("Fazenda","Faz."), 
	GALERIA("Galeria", "Gl."), 
	LADEIRA("Ladeira","Ld."), 
	LARGO("Largo", "Lgo."), 
	LOTEAMENTO("Loteamento","Ltm."), 
	PARQUE("Parque", "Prq."), 
	PRAIA("Praia","Pr."), 
	SUPER_QUADRA("Super Quadra", "Sqd.");

	private String descricao;

	private String abreviatura;

	private TipoLogradouro(String descricao, String abreviatura) {
		this.descricao = descricao;
		this.abreviatura = abreviatura;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

}
