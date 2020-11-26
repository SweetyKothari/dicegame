package com.dicegame.util;

public class DiceUtil {

    public static int convertToInt(String input) {
        int n =0;
        try {
            n = Integer.parseInt(input);
        }
        catch (NumberFormatException e){
            System.out.print("Exception in parsing number");
            System.exit(0);
        }
        return n;
    }

    public static boolean isPositiveNumber(int n){
       return n >0 ?true  :false;
    }
}
