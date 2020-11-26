package com.dicegame.util;

import java.util.Random;

public class DiceRoller {

   public  static Random rn= new Random();
    private static final int POINT =6;

    public static int roll(){
       return rn.nextInt(POINT) + 1;

    }
}
