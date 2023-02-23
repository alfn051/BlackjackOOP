package com.blackjack.game;

import com.blackjack.cards.Card;
import com.blackjack.person.Person;

public class Rule {

    public static int getPersonScore(Person person){
        int score = 0;
        /*score = person.getReceivedCards()
                .stream().mapToInt(card -> convertDenominationToNum(card.getDenomination()))
                .sum(); 정무가 알려준 람다쓰는 코드, 잘 모르겠어서 그냥 반복문으로*/
        //person.getReceivedCards().forEach(card -> score.addAndGet(convertDenominationToNum(card.getDenomination()))); 직접 써본건데 아토믹인티저 써야되서 그냥 반복문으로
        for(Card card : person.getReceivedCards()){
            score += convertDenominationToNum(card.getDenomination());
        }
        return score;
    }
    private static int convertDenominationToNum(String denomination){
        if(denomination.equals("A")){
            return 1;
        } else if(denomination.equals("J") || denomination.equals("Q") || denomination.equals("K")) {
            return 11;
        }else {
            return Integer.parseInt(denomination);
        }
    }
}
