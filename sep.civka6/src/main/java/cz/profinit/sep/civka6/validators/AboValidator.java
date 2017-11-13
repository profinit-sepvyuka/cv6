package cz.profinit.sep.civka6.validators;

import com.vaadin.data.ValidationResult;
import com.vaadin.data.ValueContext;
import com.vaadin.data.validator.AbstractValidator;

import cz.profinit.sep.civka6.Utils;

public class AboValidator extends AbstractValidator<String> {

	public AboValidator(String errorMessage) {
		super(errorMessage);
	}

	@Override
	public ValidationResult apply(String value, ValueContext context) {
		if (Utils.isValidABO(value)) {
			return ValidationResult.ok();
		}
		
		return ValidationResult.error("Nespravny format abo");
	}

}
