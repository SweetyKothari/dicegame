package com.dicegame;

import com.dicegame.helper.DiceGameRunner;
import com.dicegame.util.DiceUtil;

/**
 * This is an Entry point for game
 */
public class DiceMain {

    public static void main(String[] args) {

        System.out.println("Welcome to Dice Game");
        System.out.println(" --- -- ");
        System.out.println("| .  . |");
        System.out.println("| .  . |");
        System.out.println(" --- -- ");

        if(args.length < 2){
            System.out.print("Correct Usage java -jar <jarFileName> <noOfplayer> <totalScore>");
            System.exit(0);
        }
        int n = DiceUtil.convertToInt(args[0]);
        if(!DiceUtil.isPositiveNumber(n)){
            System.out.print("Number should be +ve");
            System.exit(0);
        }
        int points=DiceUtil.convertToInt(args[1]);
        if(!DiceUtil.isPositiveNumber(points)){
            System.out.print("Number should be +ve");
            System.exit(0);
        }
        DiceGameRunner diceGameRunner =new DiceGameRunner(n,points);
        diceGameRunner.playGame();

    }


}
