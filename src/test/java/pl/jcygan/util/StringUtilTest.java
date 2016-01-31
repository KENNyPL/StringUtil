package pl.jcygan.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionWhenInsertNull() {
        //given
        String stringValue = null;
        Integer expectedIntegerValue = 0;

        //when
        StringUtil.toInteger(stringValue);

        //then
        //should throw exception
    }

    @Test
    public void shouldConvertZeroToInteger() {
        //given
        String stringValue = "0";
        Integer expectedIntegerValue = 0;

        //when
        Integer integerValue = StringUtil.toInteger(stringValue);

        //then
        Assert.assertEquals(expectedIntegerValue, integerValue);
    }

    @Test
    public void sholudConverHundredToInteger(){
        //given
        String stringValue = "100";
        Integer expectedIntegerValue = 100;

        //when
        Integer integerValue = StringUtil.toInteger(stringValue);

        //then
        Assert.assertEquals(expectedIntegerValue, integerValue);
    }

    @Test
    public void sholudConvertHugeNumberToInteger(){
        //given
        String stringValue = "1568714";
        Integer expectedIntegerValue = 1568714;

        //when
        Integer integerValue = StringUtil.toInteger(stringValue);

        //then
        Assert.assertEquals(expectedIntegerValue, integerValue);
    }


    @Test
    public void sholudConvertMinusHundredToInteger(){
        //given
        String stringValue = "-100";
        Integer expectedIntegerValue = -100;

        //when
        Integer integerValue = StringUtil.toInteger(stringValue);

        //then
        Assert.assertEquals(expectedIntegerValue, integerValue);
    }


    @Test
    public void shouldConvertMinusHugeNumberToInteger(){
        //given
        String stringValue = "-231564797";
        Integer expectedIntegerValue = -231564797;

        //when
        Integer integerValue = StringUtil.toInteger(stringValue);

        //then
        Assert.assertEquals(expectedIntegerValue, integerValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionByPositiveOutOfRangeValue(){
        //given
        String stringValue = Long.toString(Integer.MAX_VALUE + 1L);

        //when
        StringUtil.toInteger(stringValue);

        //then
        //should throw exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionnByToLongNegativeString(){
        //given
        String stringValue = "-989865545454678751421";

        //when
        StringUtil.toInteger(stringValue);

        //then
        //should throw exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionByToLongString(){
        //given
        String stringValue = "3214654698798436554";

        //when
        StringUtil.toInteger(stringValue);

        //then
        //should throw exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionByNegativeOutOfRangeValue(){
        //given
        String stringValue = Long.toString(Integer.MIN_VALUE - 1L);

        //when
        StringUtil.toInteger(stringValue);

        //then
        //should throw exception
    }

    @Test
    public void shouldConvertIntegerMaxValue(){
        //given
        String stringValue = Integer.toString(Integer.MAX_VALUE);
        Integer expectedIntegerValue = Integer.MAX_VALUE;

        //when
        Integer integerValue = StringUtil.toInteger(stringValue);

        //then
        Assert.assertEquals(expectedIntegerValue, integerValue);
    }

    @Test
    public void shouldConvertIntegerMinValue(){
        //given
        String stringValue = Integer.toString(Integer.MIN_VALUE);
        Integer expectedIntegerValue = Integer.MIN_VALUE;

        //when
        Integer integerValue = StringUtil.toInteger(stringValue);

        //then
        Assert.assertEquals(expectedIntegerValue, integerValue);
    }

}