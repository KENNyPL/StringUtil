package pl.jcygan.util;

abstract class AsciiToIntegerCalculator {
    public static final int FIRST_NUMBER_ASCII_CODE = 48;
    public static final int LAST_NUMBER_ASCII_CODE = 57;
    public static final int MINUS_SIGN_ASCII_CODE = 45;
    public static final int MAX_NEGATIVE_VALUE = -2147483648;
    public static final int MAX_POSITIVE_VALUE = 2147483647;
    public static final int RADIX = 10;

    String OUT_OF_RANGE_EXCEPTION_MESSAGE = "Out of range for Integer ";

    abstract boolean isOutOfIntegerRange(int current, int nextSignValue);
    abstract int getMaxValue();

    public int calculateValueByBaseAndValidate(int signAsciiCode, int convertBase, int result) {
        int nextSignValue = (signAsciiCode - FIRST_NUMBER_ASCII_CODE) * convertBase;
        if(isOutOfIntegerRange(result, nextSignValue)){
            throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION_MESSAGE);
        }else{
            return nextSignValue;
        }
    }
}
