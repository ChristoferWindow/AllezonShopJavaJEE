package pl.jazapp.app.webapp.extension.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.PropertyResourceBundle;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator<String> {

    private static final String LETTERS_AND_NUMBERS_MESSAGE_ID = "pl.jazapp.app.webapp.extension.validator.EmailValidator.INVALID_FORMAT";

    @Override
    public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException {
        if(!value.matches("^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")){
            var msg = getMsg(context);
            var NumbersAndLetters = msg.getString(LETTERS_AND_NUMBERS_MESSAGE_ID);
            throw new ValidatorException(new FacesMessage(NumbersAndLetters));
        }
    }

    public PropertyResourceBundle getMsg(FacesContext context){
        return context.getApplication().evaluateExpressionGet(
                context, "#{msg}", PropertyResourceBundle.class
        );
    }
}