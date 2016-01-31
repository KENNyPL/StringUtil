package pl.jcygan.util;

class AsciiToPositiveIntegerCalculator extends AsciiToIntegerCalculator {
    public boolean isOutOfIntegerRange(int current, int nextSignValue) {
        if (nextSignValue > getMaxValue() - current) {
            return true;
        }
        return false;
    }

    public int getMaxValue() {
        return MAX_POSITIVE_VALUE;
    }

}
