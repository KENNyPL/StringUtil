package pl.jcygan.util;

public class AsciiToNegativeIntegerCalculator extends AsciiToIntegerCalculator {
    public boolean isOutOfIntegerRange(int result, int nextSignValue) {
        if (-nextSignValue < getMaxValue() - result) {
            return true;
        }
        return false;
    }

    public int getMaxValue() {
        return MAX_NEGATIVE_VALUE;
    }

    @Override
    public int calculateValueByBaseAndValidate(int signAsciiCode, int convertBase, int result) {
        return  -super.calculateValueByBaseAndValidate(signAsciiCode, convertBase, result);
    }
}
