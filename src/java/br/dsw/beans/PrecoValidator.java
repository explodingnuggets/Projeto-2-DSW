package br.dsw.beans;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("PrecoValidator")
public class PrecoValidator implements Validator{

	private static final String PRECO_PATTERN = "^[0-9]{0,12}([,][0-9]{2,2})?$";

	private Pattern pattern;
	private Matcher matcher;
	
	public PrecoValidator(){
		  pattern = Pattern.compile(PRECO_PATTERN);
	}
	
	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		
		matcher = pattern.matcher(value.toString());
		if(!matcher.matches()){
			
			FacesMessage msg = 
				new FacesMessage("Preco inválido, digite valores comuns, com ou sem virgula");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}

	}
}
