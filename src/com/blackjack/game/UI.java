package com.blackjack.game;

import com.blackjack.cards.Card;
import com.blackjack.cards.Suit;
import com.blackjack.person.Person;

import java.util.Scanner;

public class UI {
    static Scanner sc = new Scanner(System.in);
    public static void openCardMessage(Person person, Card card){
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
            System.out.println("베팅할 금액을 정해주십시오(최소 100 ~ 최대 5000");
            betting = Integer.parseInt(sc.nextLine());
            if(betting >= 100 && betting <= 5000){
                return betting;
            }else {
                System.out.println("올바른 금액을 입력하세요");
            }
        }
    }
}
