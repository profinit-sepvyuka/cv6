package cz.profinit.sep.civka6.validators;

import java.time.LocalDate;

import com.vaadin.data.ValidationResult;
import com.vaadin.data.ValueContext;
import com.vaadin.data.validator.AbstractValidator;

import cz.profinit.sep.civka6.Utils;

public class NotWeekendValidator extends AbstractValidator<LocalDate> {

	public NotWeekendValidator(String errorMessage) {
		super(errorMessage);
	}

	@Override
	public ValidationResult apply(LocalDate value, ValueContext context) {
		if (Utils.isWeekend(value)) {
			return ValidationResult.error("Je to vikend");
		}
		
		return ValidationResult.ok();
	}

}
