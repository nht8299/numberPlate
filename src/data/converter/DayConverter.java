package data.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang.StringUtils;

import ch.ivyteam.ivy.environment.Ivy;

@FacesConverter("dayConverter")
public class DayConverter implements Converter {
	
	private static final String DD_MM_YYYY = "dd-MM-yyyy";

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) throws ConverterException {
		if	(StringUtils.isBlank(value)) {
		return null;
	}else {
		Ivy.log().info("Converter String: {0}" ,value);
		SimpleDateFormat dateFormat = new SimpleDateFormat(DD_MM_YYYY);
		try {
			return dateFormat.parseObject(value);
			}catch(ParseException e) {
				Ivy.log().error(e);
				return null;
			}
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) throws ConverterException {
		// TODO Auto-generated method stub
		return null;
	}

}
