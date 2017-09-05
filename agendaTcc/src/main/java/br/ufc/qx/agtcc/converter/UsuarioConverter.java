package br.ufc.qx.agtcc.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.ufc.qx.agtcc.model.entities.Usuario;
import br.ufc.qx.agtcc.repository.Usuarios;

@FacesConverter(forClass=Usuario.class)
public class UsuarioConverter implements Converter {

	@Inject
	private Usuarios usuarios;
	
	public UsuarioConverter(Usuarios usuarios) {
		this.usuarios = usuarios;
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Usuario retorno = null;

		if (value != null) {
			retorno = this.usuarios.porId(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Usuario) value).getId().toString();
		}
		return "";
	}

}