package br.ufc.qx.agtcc.validation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("nomeValido")
public class NomesSaadVlidator implements Validator {

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String valor = (String) value;
		valor = valor.trim();

		if (validarNomenclatura(valor)) {
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "O valor não pode conter espaços em branco.", "O valor não pode conter espaços em branco.");
			throw new ValidatorException(mensagem);
		}
	}

	private boolean validarNomenclatura(String valor) {
		CharSequence cs1 = " ";
		return valor.contains(cs1);
	}
}
