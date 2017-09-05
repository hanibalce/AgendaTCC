package br.ufc.qx.agtcc.exceptions;

public class SaadCampoDuplicadoException extends Exception {

	private static final long serialVersionUID = -1049532623039801873L;

	public SaadCampoDuplicadoException(String msg) {
		super("O campo \"" + msg + "\" está duplicado.");
	}

}
