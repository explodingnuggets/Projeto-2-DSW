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
public class PrecoValidator implements Validator {

    public PrecoValidator() {
    }

    @Override
    public void validate(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {
        if (!(value instanceof Double)) {
            FacesMessage msg
                    = new FacesMessage("Preco inválido, digite apenas numeros");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        if (((double) value) < 0) {
            FacesMessage msg
                    = new FacesMessage("Preco inválido, digite valores positivos");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

    }
}
