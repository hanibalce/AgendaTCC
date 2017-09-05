package br.ufc.qx.agtcc.validation;

import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

public class DiaUtilValidator {

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		Date data = (Date) value;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);

		int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);

		if (diaSemana < Calendar.SUNDAY) {
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data inválida.", "A data informada não é um dia útil.");
			throw new ValidatorException(mensagem);
		}
	}
}
