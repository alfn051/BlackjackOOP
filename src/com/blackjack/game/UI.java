package com.blackjack.game;

import com.blackjack.cards.Card;
import com.blackjack.cards.Suit;
import com.blackjack.person.Person;

public class UI {
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
}
