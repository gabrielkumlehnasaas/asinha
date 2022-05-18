
package com.asinha.utils

class ValidationUtils {

    String patternNumbers = "[0-9]"
    String patternNotNumbers = "[^0-9]"

    public Boolean addressNumberValidate(String addressNumber) {
        if(!(params.addressNumber.contains(patternNumbers)) {
            return false
        }
        return true
    }

    public Boolean phoneValidate(String phone) {
        String cleanPhone = phone.replaceAll(patternNotNumbers, '')
        if(cleanPhone.lenght() != 10 || cleanPhone.lenght() != 11) {
            return false
        }
        return true
    }

    public Boolean cpfCnpjValidate(String cpfCnpj) {
        String cleanCpfCnpj = cpfCnpj.replaceAll(patternNotNumbers, '')
        if(cleanCpfCnpj.length() !=  11 || cleanCpfCnpj.length() !=  14) {
            return false
        }
        return true
    }

    public Boolean postalCodeValidate(String postalCode) {
        String cleanPostalCode = postalCode.replaceAll(patternNotNumbers, '')
        if(cleanPostalCode.length() == 8) {
            def get = new URL("viacep.com.br/ws/" + cleanCpfCnpj + "/json/")
            def getResponseCode = get.getResponseCode()
            

        }
        return false
    }
}