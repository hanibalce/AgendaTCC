package br.ufc.qx.agtcc.exceptions;

public class SaadCampoEmUsoException extends Exception {

	private static final long serialVersionUID = 2289066501332342915L;

	public SaadCampoEmUsoException(String msg) {
		super("O campo \"" + msg + "\" está sendo utilizado.");
	}

}
