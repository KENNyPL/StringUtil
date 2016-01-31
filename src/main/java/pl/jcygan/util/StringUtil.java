package pl.jcygan.util;

public class StringUtil {
    public static final String EXCEPTION_MESSAGE = "unexpected sign: ";

    public static Integer toInteger(String string) {
        char[] stringCharsArray = string.toCharArray();
        int result = 0;
        int convertBase = 1;
        boolean resultSingIsNegative = isNegative(string);
        int loopEndIndex = getLastSignIndexToConvert(resultSingIsNegative);
        AsciiToIntegerCalculator calculator = resultSingIsNegative?new AsciiToNegativeIntegerCalculator(): new AsciiToPositiveIntegerCalculator();

        for (int i = stringCharsArray.length - 1; i >= loopEndIndex; i--) {
            int signAsciiCode = stringCharsArray[i];

            if (signAsciiCode < AsciiToIntegerCalculator.FIRST_NUMBER_ASCII_CODE || signAsciiCode > AsciiToIntegerCalculator.LAST_NUMBER_ASCII_CODE) {
                throw new NumberFormatException(EXCEPTION_MESSAGE + (char) signAsciiCode);
            } else {
                result += calculator.calculateValueByBaseAndValidate(signAsciiCode, convertBase, result);
                convertBase *= AsciiToIntegerCalculator.RADIX;
            }
        }
        return result;
    }

    private static int getLastSignIndexToConvert(boolean resultSingIsNegative) {
        if (resultSingIsNegative) {
            return 1;
        } else {
            return 0;
        }
    }

    private static boolean isNegative(String string) {
        if (string.charAt(0) == AsciiToIntegerCalculator.MINUS_SIGN_ASCII_CODE) {
            return true;
        }

        return false;
    }
}
