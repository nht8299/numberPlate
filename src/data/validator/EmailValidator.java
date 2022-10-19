package data.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import ch.ivyteam.ivy.cm.IContentManagementSystem;
import ch.ivyteam.ivy.environment.Ivy;

@FacesValidator("customEmailValidator")
public class EmailValidator implements Validator{

	private static final String emailPattern = "^[a-zA-Z0-9.!#$%&'*+\\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
	
	private Pattern partten = Pattern.compile(emailPattern);
	
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object value) throws ValidatorException {
		if (null == value) {
			IContentManagementSystem cms = Ivy.cms();
			FacesMessage msg = new FacesMessage(
					cms.co("/validation/emailValidationDetail"),
					cms.co("/validation/emailValidationSummary"));
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
		Matcher matcher = partten.matcher(value.toString());
		if(!matcher.matches()) {
			IContentManagementSystem cms = Ivy.cms();
			FacesMessage msg = new FacesMessage(
					cms.co("/validation/emailValidationDetail"),
					cms.co("/validation/emailValidationSummary"));
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}
	
}
