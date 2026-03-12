package com.l98293.phone;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

	private Region region;

	@Override
	public void initialize(Phone constraintAnnotation) {
		this.region = constraintAnnotation.region();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || value.trim().isEmpty()) {
			return true;
		}

		PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
		try {

			PhoneNumber phonenumber = phoneNumberUtil.parse(value, region.getCode());
			return phoneNumberUtil.isValidNumber(phonenumber);
		} catch (NumberParseException e) {
			throw new RuntimeException(e);
		}
	}
}
