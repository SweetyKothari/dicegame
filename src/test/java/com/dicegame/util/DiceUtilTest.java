package com.dicegame.util;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DiceUtilTest {

    @Test
    public void convertToIntTest(){
        int number=DiceUtil.convertToInt("11");
        assertEquals(number,11);
    }

    @Test
    public void convertToIntTestForNeg(){
        int number=DiceUtil.convertToInt("-11");
        assertEquals(number,-11);
    }

    @Test
    public void isPositiveNumberTestTrue(){
        assertEquals(DiceUtil.isPositiveNumber(-11),false);
    }
    @Test
    public void isPositiveNumberTestFalse(){
        assertEquals(DiceUtil.isPositiveNumber(11),true);
    }
}
