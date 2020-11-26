package com.dicegame.helper;

import com.dicegame.model.Player;
import com.dicegame.util.DiceConstant;
import com.dicegame.util.DiceRoller;

import java.util.*;

public class DiceGameRunner {
    //This will keep track of all players
    private  Map<String, Player> playerMap= null;

    //This will keep track of all players who had accumulated points alongwith 10
    private static Map<String, Player> rankMap= null;
    private int score=0;
    private int initial=0;
    private int noOfPlayers=0;

    public DiceGameRunner(int player , int score){
        this.score=score;
        this.noOfPlayers=player;
    }

    /**
     * This is to initialise rank & player board
     */
    public  void initPlayers(){
        initial=0;
        playerMap= new LinkedHashMap<String, Player>();
        rankMap= new LinkedHashMap<String, Player>();
        for(int i=1;i<=noOfPlayers;i++) {
            playerMap.put(DiceConstant.PLAYER + i, new Player(DiceConstant.PLAYER + i));
        }

    }

    /**
     * This is one round for each player
     */
    public void startRound(){
        if(playerMap ==null){
            return ;
        }
        Iterator<String> it = playerMap.keySet().iterator();
        while (it.hasNext()) {
            String currentPlayerName=it.next();
            Player currentPlayer= playerMap.get(currentPlayerName);
            System.out.println(currentPlayerName+ " its your turn (press ‘r’ to roll the dice)");
            readInputValueToRollDice();
            int number = DiceRoller.roll();
            System.out.println("Your Current Score "+number);
            if(currentPlayer.isSkipNext()){
                System.out.println("Since you have two 1's previous ,you need to skip this one as penalty");
                currentPlayer.setSkipNext(false);
                continue;
            }
            currentPlayer.setSkipNext(number == DiceConstant.PENALTY_VAL && number == currentPlayer.getPreviousScore());
            currentPlayer.setPreviousScore(number);
            if(number == DiceConstant.POINT){
                number += DiceRoller.roll() ;
                System.out.println("Wow,you go one more chance");
                System.out.println("Your Current Score "+number);
            }
            currentPlayer.setTotalScore(currentPlayer.getTotalScore()+number);
            if(currentPlayer.getTotalScore() >= score){
                //move to ranker
                int currentPlayerRank=rankMap.size()+1;
                currentPlayer.setRank(currentPlayerRank);
                System.out.println("Congratulations,You have achieved desired points & your rank is "+currentPlayerRank);
                rankMap.put(currentPlayerName,currentPlayer);
                it.remove();
            }

            printRankBoard();

        }
    }

    /**
     * This is to read user input to roll the dice
     */
    private void readInputValueToRollDice() {
        if(initial!=0 && initial < DiceConstant.CHANCE){
            System.exit(0);
        }else {
            Scanner input = new Scanner(System.in);
            if (input.hasNext()) {
                String inStr = input.next();
                if (inStr.length() > 1 || !inStr.toLowerCase().equals("r")) {
                    System.out.print("Please enter r ");
                    initial++;
                    readInputValueToRollDice();
                }
            }
        }
    }


    /**
     * This method prints current score board
     */
    public void printCurrentScore(){
        for(Player player:playerMap.values()){
            String rank=player.getRank() !=0 ? Integer.toString(player.getRank()) :"-";
            System.out.println(player.getName() +"\t "+player.getTotalScore() +"         \t "+rank);
        }
    }

    /**
     * This method prints rank table
     */
    public  void printRankBoard(){
        System.out.println("------------------");
        System.out.println("Player Name\t Total Score \t Rank");
        for(String name:rankMap.keySet()){
            Player player=rankMap.get(name);
            System.out.println(name +"\t "+player.getTotalScore() +"         \t "+player.getRank());
        }
        printCurrentScore();
        System.out.println("------------------");

    }

    /**
     * This is to check how many rounds are required for game
     */
    public void  playGame(){
        initPlayers();
        int index=0;
        while(rankMap.size() != (noOfPlayers)) {
            System.out.println("------------------");
            index++;
            startRound();
        }
    }

    public  Map<String, Player> getPlayerMap() {
        return playerMap!= null ?Collections.unmodifiableMap(playerMap):playerMap;
    }


    public  Map<String, Player> getRankMap() {
        return rankMap!=null ?Collections.unmodifiableMap(rankMap):rankMap;
    }

}
