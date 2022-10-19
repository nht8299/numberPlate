package data.validator;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import ch.ivyteam.ivy.cm.IContentManagementSystem;
import ch.ivyteam.ivy.environment.Ivy;

@FacesValidator("customBirthDayValidator")
public class BirthDayValidator implements Validator{

	@SuppressWarnings("deprecation")
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object obj) throws ValidatorException {
		// TODO Auto-generated method stub
		Date birthday = (Date) obj;
		Date now = new Date(System.currentTimeMillis());
		
		if (birthday.equals(null)){
			IContentManagementSystem cms = Ivy.cms();
			FacesMessage msg = new FacesMessage(
					cms.co("/validation/birthdayValidationDetail")
					);
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}else if ( now.getYear() - birthday.getYear() < 18) {
			IContentManagementSystem cms = Ivy.cms();
			FacesMessage msg = new FacesMessage(
					cms.co("/validation/birthdayValidationDetail"),
					cms.co("/validation/birthdayValidationSummarry")
					);
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}
}
