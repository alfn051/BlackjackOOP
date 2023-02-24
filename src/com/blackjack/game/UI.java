package com.blackjack.game;

import com.blackjack.card.Card;
import com.blackjack.card.Suit;
import com.blackjack.person.Dealer;
import com.blackjack.person.Person;
import com.blackjack.person.Player;

import java.util.Scanner;

public class UI {
    static Scanner sc = new Scanner(System.in);
    public static void openCard(Person person, int score){
        String personName;
        if(person instanceof Player) {
            personName = "플레이어";
        }else {
            personName = "딜러";
        }
        System.out.printf("%s의 카드는 : ", personName);
        person.getReceivedCards().forEach(card -> UI.personCardOutput(card));
        System.out.printf("입니다.   점수 : %d 점\n", score);
    }
    public static void openCard(Person person, boolean dealerBeginning){
        System.out.printf("딜러의 카드는 : ");
        UI.personCardOutput(person.getReceivedCards().get(0));
        System.out.printf("?   입니다.\n");
    }
    public static void openBothCard(Player player, Dealer dealer){
        UI.openCard(dealer, Rule.getPersonScore(dealer));
        UI.openCard(player, Rule.getPersonScore(player));
    }
    public static void openBothCard(Player player, Dealer dealer, boolean dealerBeginning){
        UI.openCard(dealer, dealerBeginning);
        UI.openCard(player, Rule.getPersonScore(player));
    }
    public static void personCardOutput(Card card){
        System.out.printf("%s   ", UI.cardViewer(card));
    }

    public static String cardViewer(Card card){
        if(card.getSuit()== Suit.SPADE){
            return "♠"+card.getDenomination();
        }if(card.getSuit()==Suit.HEART){
            return "♥"+card.getDenomination();
        }if(card.getSuit()==Suit.DIAMOND){
            return "♦"+card.getDenomination();
        }else{
            return "♣"+card.getDenomination();
        }
    }

    public static boolean hitSelector(){
        String select;
        while (true){
            System.out.print("카드를 한장 더 받겠습니까?(Hit or Stand?) y / n : ");
            select = sc.nextLine();
            if(select.equals("y")){
                return true;
            } else if (select.equals("n")) {
                return false;
            }else {
                System.out.println("올바른 값을 입력하세요");
            }
        }
    }

    public static int betInputs(boolean overBet){
        if(overBet){
            System.out.println("베팅 금액이 잔액보다 많습니다.");
        }
        int betting;
        while(true){
            System.out.print("베팅할 금액을 정해주십시오(최소 100 ~ 최대 5000 : ");
            betting = Integer.parseInt(sc.nextLine());
            if(betting >= 100 && betting <= 5000){
                return betting;
            }else {
                System.out.println("올바른 금액을 입력하세요");
            }
        }
    }

    public static int setPlayersSeedMoney(){
        int seedMoney;
        while(true){
            System.out.print("게임 시작 시 플레이어가 가지고 있을 돈의 액수를 입력해 주시오(최소 5000 ~ 최대 500000) : ");
            seedMoney = Integer.parseInt(sc.nextLine());
            if(seedMoney >= 5000 && seedMoney <= 500000){
                return seedMoney;
            }else {
                System.out.println("올바른 금액을 입력하세요");
            }
        }
    }
    public static void sessionStartMessage(){
        System.out.println("***게임을 시작합니다***");
    }
    public static void bustMessage(Person person){
        if(person instanceof Player) {
            System.out.println("플레이어 버스트!(21점 초과)");
        }else {
            System.out.println("딜러 버스트!(21점 초과)");
        }
    }
    public static void blackJackMessage(Person person){
        if(person instanceof Player) {
            System.out.println("플레이어 블랙잭!");
        }else {
            System.out.println("딜러 블랙잭!");
        }
    }
    public static void resultMessage(Person person){
        if(person instanceof Player) {
            System.out.println("플레이어의 승리입니다!");
        }else if(person instanceof Dealer){
            System.out.println("플레이어의 패배입니다, 딜러 승리!");
        }else {
            System.out.println("무승부 입니다");
        }
    }
}
