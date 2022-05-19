package com.asinha.utils

import com.asinha.enums.PaymentMethod
import com.asinha.utils.CustomDateUtils

import groovy.json.JsonSlurper
import java.lang.String
import java.math.BigDecimal
import java.net.URL.*
import org.apache.commons.validator.routines.EmailValidator

class ValidationUtils {

    public static String digitsOnlyCleaner(String dirty) {
        String clean = dirty.replaceAll("[^0-9]", '')
        return clean
    }

    public static Boolean validateNotNull(String parameter) {
        if (parameter != null) {
            return true
        }
        return false
    }

    public static Boolean validateAddressNumber(String addressNumber) {
        String cleanAddressNumber = digitsOnlyCleaner(addressNumber)
        if (cleanAddressNumber.length() == addressNumber.length() && addressNumber != null) {
            return true
        }
        return false
    }

    public static Boolean validatePhone(String phone) {
        String cleanPhone = digitsOnlyCleaner(phone)
        if (cleanPhone != null && cleanPhone.length() == 10 || cleanPhone.length() == 11) {
            return true
        }
        return false
    }

    public static Boolean validateCpfCnpj(String cpfCnpj) {
        String cleanCpfCnpj = digitsOnlyCleaner(cpfCnpj)
        if (cleanCpfCnpj != null && cleanCpfCnpj.length() ==  11 || cleanCpfCnpj.length() ==  14) {
            return true
        }
        return false
    }

    public static Boolean validatePostalCode(String postalCode) {
        String cleanPostalCode = digitsOnlyCleaner(postalCode)
        if (cleanPostalCode != null && cleanPostalCode.length() == 8) {
            def get = new URL("https://viacep.com.br/ws/" + cleanPostalCode + "/json/").openConnection()
            def sluper = new JsonSlurper()
            def getResponse = sluper.parseText(get.content.text)
            if (getResponse.erro) {
                return false
            }
            return true
        }
        return false
    }

    public static Boolean validateEmail(String email) {
        EmailValidator emailValidator = EmailValidator.getInstance()
        if (emailValidator.isValid(email)) {
            return true
        }
        return false
    }

    public static Boolean validateValue(String value) {
        BigDecimal parsedValue = BigDecimal(value)
        if (parsedValue < 5.00) {
            return false
        }
    return true
    }

    public static Boolean validateMethod(String method) {
        if (PaymentMethod.values().contains(PaymentMethod.valueOf(method))) {
            return true
        }
        return false
    }

    public static Boolean validateDueDate(String dueDate) {
        Date yesterday = CustomDateUtils.getYesterday()
    }
}
