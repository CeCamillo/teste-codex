package org.example.backend.cnpj;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "cnpj")
public class CNPJController {
//    String stdin = "11.222.333/0001-xx";

    public String removeNonDigits(String stdin) {
        return stdin.replaceAll("[^0-9]", "");
    }

    @PostMapping
    public boolean checkDigit(@RequestBody String cnpj) {
        String verificacao1 = "543298765432";
        String verificacao2 = "6543298765432";
        String filteredStdin = removeNonDigits(cnpj);
        String digitsToVerify = filteredStdin.substring(0, filteredStdin.length() - 1);
        digitsToVerify = digitsToVerify.substring(0, filteredStdin.length() - 2);
        Integer digit1 = 0;

        for (int i = 0; i < digitsToVerify.length(); i++) {
            digit1 += Integer.parseInt(String.valueOf(digitsToVerify.charAt(i))) * Integer.parseInt(String.valueOf(verificacao1.charAt(i)));
        }
        if (digit1%11 < 2) {
            digit1 = 0;
        } else {
            digit1 = 11- digit1%11;
        }
        cnpj = cnpj + digit1;
        digitsToVerify += digit1;

        Integer digit2 = 0;
        for (int i = 0; i < digitsToVerify.length(); i++) {
            digit2 += Integer.parseInt(String.valueOf(digitsToVerify.charAt(i))) * Integer.parseInt(String.valueOf(verificacao2.charAt(i)));
        }
        if (digit2%11 < 2) {
            digit2 = 0;
        } else {
            digit2 = 11- digit2%11;
        }

        cnpj = cnpj + digit2;
        System.out.println(cnpj);

        System.out.println(Integer.toString(digit1) + Integer.toString(digit2));
        System.out.println(cnpj.substring(filteredStdin.length()-2));

        if ((Integer.toString(digit1) + Integer.toString(digit2)).equals(filteredStdin.substring(filteredStdin.length() - 2))) {
            return true;
        } else {
            return false;
        }
    }
}
