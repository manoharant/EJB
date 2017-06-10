package blogspot.sezera.exampleproject.validator;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class EmailValidator implements Validator{

	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		
		String email = arg2.toString();
		if(email.contains("@")==false){
			//error message
		  ResourceBundle bundle = ResourceBundle.getBundle("messages",arg0.getCurrentInstance().getViewRoot().getLocale());
		  FacesMessage msg = new FacesMessage(bundle.getString("emailNotValid"));
		  throw new ValidatorException(msg);
		}
		
	}
}