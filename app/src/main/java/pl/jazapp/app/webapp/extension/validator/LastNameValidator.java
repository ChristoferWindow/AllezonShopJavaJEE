package pl.jazapp.app.webapp.extension.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.PropertyResourceBundle;

@FacesValidator("lastnameValidator")
public class LastNameValidator implements Validator<String> {

    private static final String LETTERS_AND_SEPARATOR_CHAR_MESSAGE_ID = "pl.jazapp.app.webapp.extension.validator.UserLasName.LETTERS_AND_SEPARATOR_CHAR";

    @Override
    public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException {
        if(!value.matches("^[A-Za-zà-ž (\\-)?]*$")){
            var msg = getMsg(context);
            var NumbersAndLetters = msg.getString(LETTERS_AND_SEPARATOR_CHAR_MESSAGE_ID);
            throw new ValidatorException(new FacesMessage(NumbersAndLetters));
        }
    }

    public PropertyResourceBundle getMsg(FacesContext context){
        return context.getApplication().evaluateExpressionGet(
                context, "#{msg}", PropertyResourceBundle.class
        );
    }
}