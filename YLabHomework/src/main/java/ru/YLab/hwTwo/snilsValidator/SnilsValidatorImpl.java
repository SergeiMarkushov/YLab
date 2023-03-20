package ru.YLab.hwTwo.snilsValidator;

import static java.lang.Integer.parseInt;

public class SnilsValidatorImpl implements SnilsValidator {
    @Override
    public boolean validate(String snils) {
        int sum = 0;
        int checkDigit = 0;
        boolean isOnlyDigits = true;

        if (snils == null) {
            return false;
        } else if (snils.isEmpty()) {
            return false;
        } else if (snils.length() != 11) {
            return false;
        }

        for(int i = 0; i < snils.length() && isOnlyDigits; i++) {
            if(!Character.isDigit(snils.charAt(i))) {
                isOnlyDigits = false;
            }
        }

        if (!isOnlyDigits) {
            return false;
        }



        for (int i = 0; i < 9; i++) {
            sum += Character.digit(snils.charAt(i), 10) * (9 - i);
        }
        if (sum < 100) {
            checkDigit = sum;
        } else if (sum > 101) {
            checkDigit = sum % 101;
        }
        return checkDigit == parseInt(snils.substring(9));
    }
}
