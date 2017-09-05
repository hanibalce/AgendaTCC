package br.ufc.qx.agtcc.model.enums;

public enum TipoDocumento {
	TCC_INSCRICAO_PPT("Inscrição","ppt"),
	TCC_INSCRICAO_PPTX("Inscrição","pptx"), 
	TCC_INSCRICAO_DOC("Inscrição","doc"), 
	TCC_INSCRICAO_DOCX("Inscrição","docx"),
	TCC_INSCRICAO_PDF("Inscrição","pdf"), 
	TCC_INSCRICAO_TXT("Inscrição","txt"),
	TCC_ARQUIVO_FINAL_PPT("Arquivo Final","ppt"), 
	TCC_ARQUIVO_FINAL_PPTX("Arquivo Final","pptx"),
	TCC_ARQUIVO_FINAL_DOCX("Arquivo Final","docx"), 
	TCC_ARQUIVO_FINAL_DOC("Arquivo Final","doc"),
	TCC_ARQUIVO_FINAL_PDF("Arquivo Final","pdf"), 
	TCC_ARQUIVO_FINAL_TXT("Arquivo Final","txt");

	private String descricao;

	private String extensao;

	public String getDescricao() {
		return this.descricao;
	}

	public String getExtensao() {
		return extensao;
	}

	private TipoDocumento(String descricao, String extensao) {
		this.descricao = descricao;
		this.extensao = extensao;
	}

}
