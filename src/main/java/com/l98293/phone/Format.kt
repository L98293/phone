package com.l98293.phone

import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource

enum class Format {

    PLUS,
    IDD,
    WITHOUT_PLUS,
    LOCAL,
    ANY;

    fun matches(countryCodeSource: CountryCodeSource) = when(this) {

        PLUS -> countryCodeSource == CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN
        IDD -> countryCodeSource == CountryCodeSource.FROM_NUMBER_WITH_IDD
        WITHOUT_PLUS -> countryCodeSource == CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN
        LOCAL -> countryCodeSource == CountryCodeSource.FROM_DEFAULT_COUNTRY
        ANY -> true
    }
}