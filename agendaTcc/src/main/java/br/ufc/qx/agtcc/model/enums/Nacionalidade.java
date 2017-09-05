package br.ufc.qx.agtcc.model.enums;

public enum Nacionalidade {

	BRASILEIRO("Brasileiro"), 
	BRASILEIRA("Brasileira"),
	CUBANO("Cubano"),
	CUBANA("Cubana"),
	ARGENTINO("Argentino"), 
	ARGENTINA("Argentina"), 
	VENEZUELANO("Venezuelano"), 
	VENEZUELANA("Venezuelana"),
	CHILENO("Chileno"), 
	CHILENA("Chilena"),
	COLOMBIANO("Colombiano"), 
	COLOMBIANA("Colombiana"), 
	MEXICANO("Mexicano"), 
	MEXICANA("Mexicana"),
	NORTE_AMERICANO("Norte Americano"),
	NORTE_AMERICANA("Norte Americana");
	
	private String descricao;

	private Nacionalidade(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

}
