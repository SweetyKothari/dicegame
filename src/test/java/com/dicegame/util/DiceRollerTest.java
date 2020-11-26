package com.dicegame.util;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class DiceRollerTest {

    @Test
    public void rollTest(){
        boolean val=DiceRoller.roll() <=6;
        assertEquals(val ,true);
    }

    @Test
    public void rollTestForLower(){
        boolean val=DiceRoller.roll()>=6;
        assertEquals(val ,false);
    }
}
