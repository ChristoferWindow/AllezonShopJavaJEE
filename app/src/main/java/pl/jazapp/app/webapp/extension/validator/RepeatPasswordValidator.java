package pl.jazapp.app.webapp.extension.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.PropertyResourceBundle;

@FacesValidator("repeatPasswordValidator")
public class RepeatPasswordValidator implements Validator<String> {

    private static final String REPEAT_PASSWORD_NOT_MATCH_MESSAGE_ID = "pl.jazapp.app.webapp.extension.validator.PasswordValidator.REPEAT_PASSWORD_NO_MATCH";

    @Override
    public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException {
        // Retrieve the value passed to this method
        String confirmPassword = (String) value;

        // Retrieve the temporary value from the password field
        UIInput passwordInput = (UIInput) component.findComponent("password");
        String password = (String) passwordInput.getLocalValue();

        if (password == null || confirmPassword == null || !password.equals(confirmPassword)) {
            var msg = getMsg(context);
            var NumbersAndLetters = msg.getString(REPEAT_PASSWORD_NOT_MATCH_MESSAGE_ID);
            throw new ValidatorException(new FacesMessage(NumbersAndLetters));
        }
    }

    public PropertyResourceBundle getMsg(FacesContext context){
        return context.getApplication().evaluateExpressionGet(
                context, "#{msg}", PropertyResourceBundle.class
        );
    }
}
