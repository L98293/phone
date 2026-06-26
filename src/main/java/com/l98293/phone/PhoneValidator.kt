package com.l98293.phone

import com.google.i18n.phonenumbers.PhoneNumberUtil
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class PhoneValidator: ConstraintValidator<Phone, String> {

    private lateinit var region: Region

    override fun initialize(constraintAnnotation: Phone) {

        region = constraintAnnotation.region
    }

    override fun isValid(
        value: String?,
        context: ConstraintValidatorContext?
    ): Boolean {

        if (value.isNullOrEmpty()) { return true }

        val phoneNumberUtil = PhoneNumberUtil.getInstance()

        return runCatching {

            phoneNumberUtil.isValidNumber(
                phoneNumberUtil.parse(
                    value,
                    region.code
                )
            )
        }.getOrDefault(false)
    }


}