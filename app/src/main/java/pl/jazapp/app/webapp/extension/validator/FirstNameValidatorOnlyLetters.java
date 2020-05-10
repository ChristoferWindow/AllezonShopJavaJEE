package pl.jazapp.app.webapp.extension.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.PropertyResourceBundle;

@FacesValidator("firstnameValidator")
public class FirstNameValidatorOnlyLetters implements Validator<String> {

    private static final String ONLY_LETTERS_MESSAGE_ID = "pl.jazapp.app.webapp.extension.validator.UserFirstName.ONLY_LETTERS";

    @Override
    public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException {
        if(!value.matches("^[A-Z][a-z\\u00e0-\\u017e]+$")){
            var msg = getMsg(context);
            var NumbersAndLetters = msg.getString(ONLY_LETTERS_MESSAGE_ID);
            throw new ValidatorException(new FacesMessage(NumbersAndLetters));
        }
    }

    public PropertyResourceBundle getMsg(FacesContext context){
        return context.getApplication().evaluateExpressionGet(
                context, "#{msg}", PropertyResourceBundle.class
        );
    }
}