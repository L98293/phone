package com.l98293.phone

import com.google.i18n.phonenumbers.PhoneNumberUtil
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class PhoneValidator: ConstraintValidator<Phone, String> {

    private lateinit var region: Region
    private lateinit var format: Format

    override fun initialize(constraintAnnotation: Phone) {

        region = constraintAnnotation.region
        format = constraintAnnotation.format
    }

    override fun isValid(
        value: String?,
        context: ConstraintValidatorContext?
    ) = value.isNullOrEmpty() || runCatching {

        val phoneNumberUtil = PhoneNumberUtil.getInstance()
        val phoneNumber = phoneNumberUtil.parseAndKeepRawInput(
            value,
            region.code
        )

        phoneNumberUtil.isValidNumberForRegion(
            phoneNumber,
            region.code
        ) && format.matches(phoneNumber.countryCodeSource)
    }.getOrDefault(false)
}