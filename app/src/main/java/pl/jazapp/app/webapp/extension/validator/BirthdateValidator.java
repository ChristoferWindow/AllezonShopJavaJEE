package pl.jazapp.app.webapp.extension.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.PropertyResourceBundle;

@FacesValidator("birthdateValidator")
public class BirthdateValidator implements Validator<String> {

    private static final String INVALID_FORMAT_EMAIL_MESSAGE_ID = "pl.jazapp.app.webapp.extension.validator.BirthDateValidator.INVALID_FORMAT";

    @Override
    public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException {

        if (!value.matches("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$")) {
            var msg = getMsg(context);
            var NumbersAndLetters = msg.getString(INVALID_FORMAT_EMAIL_MESSAGE_ID);
            throw new ValidatorException(new FacesMessage(NumbersAndLetters));
        }

    }

    public PropertyResourceBundle getMsg(FacesContext context){
        return context.getApplication().evaluateExpressionGet(
                context, "#{msg}", PropertyResourceBundle.class
        );
    }
}
