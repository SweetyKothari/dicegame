package com.dicegame.util;
import org.junit.Rule;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static junit.framework.TestCase.assertEquals;

public class DiceGameRunnerTest {

    @Test
    public void testInputInstance(){
        DiceGameRunner diceGameRunner = new DiceGameRunner(2,20);
        assertEquals(diceGameRunner.getPlayerMap(), null);
        assertEquals(diceGameRunner.getPlayerMap(), null);
    }

    @Test
    public void testInitMethod(){
        DiceGameRunner diceGameRunner = new DiceGameRunner(2,20);
        diceGameRunner.initPlayers();
        assertEquals(diceGameRunner.getPlayerMap().size(), 2);
    }

    @Test
    public void playGameTest()
    {
        String input = "r";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        DiceGameRunner diceGameRunner = new DiceGameRunner(2,20);
        diceGameRunner.playGame();
        assertEquals(diceGameRunner.getRankMap().size(),2);
    }
}
