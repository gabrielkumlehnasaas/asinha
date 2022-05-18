
package com.asinha.utils

import java.lang.String
import java.net.URL.*

class ValidationUtils {

    // String patternNumbers = "[0-9]"
    // def patternNotNumbers = "[^0-9]"

    public static String digitsOnlyCleaner(String dirty) {
        String clean = dirty.replaceAll("[^0-9]", '')
        return clean
    }

    public static Boolean addressNumberValidate(String addressNumber) {
        if(!(addressNumber.contains("[0-9]"))) {
            return false
        }
        return true
    }

    public static Boolean phoneValidate(String phone) {
        String cleanPhone = digitsOnlyCleaner(phone)
        if(cleanPhone.length() != 10 || cleanPhone.lenght() != 11) {
            return false
        }
        return true
    }

    public static Boolean cpfCnpjValidate(String cpfCnpj) {
        String cleanCpfCnpj = digitsOnlyCleaner(cpfCnpj)
        if(cleanCpfCnpj.length() !=  11 || cleanCpfCnpj.length() !=  14) {
            return false
        }
        return true
    }

    public static Boolean postalCodeValidate(String postalCode) {
        String cleanPostalCode = digitsOnlyCleaner(postalCode)
        if(cleanPostalCode.length() == 8) {
            def get = new URL("https://viacep.com.br/ws/" + cleanPostalCode + "/json/").openConnection()
            def getResponseCode = get.getResponseCode()
                if (getResponseCode.equals(200)) {
                return true
            }
            return false
        }
        return false
    }
}
