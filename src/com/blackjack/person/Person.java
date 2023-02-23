package com.blackjack.person;

import java.util.ArrayList;
import java.util.List;
import com.blackjack.cards.*;
import com.blackjack.cards.Suit;

public abstract class Person {
    public Person(){

    }
    protected List<Card> receivedCards = new ArrayList<>();

    public void receiveCard(Card card){ //CardDeck 으로부터 카드를 한장 받아온다.
        receivedCards.add(card);
    }
    public void openCard(){
        receivedCards.forEach(card -> System.out.printf("%s   ", cardViewer(card)));
        System.out.println("");
    }
    private String cardViewer(Card card){
        if(card.getSuit()==Suit.SPADE){
            return "♠"+card.getDenomination();
        }if(card.getSuit()==Suit.HEART){
            return "♥"+card.getDenomination();
        }if(card.getSuit()==Suit.DIAMOND){
            return "♦"+card.getDenomination();
        }else{
            return "♣"+card.getDenomination();
        }
    }
    public List<Card> getReceivedCards(){
        return receivedCards;
    }
    public abstract boolean selectHitOrStand();   //히트(카드한장더받기)할지 스탠드(안받기)할지 정하는 메서드, 딜러랑 플레이어의 방식이 다름
    public void removeAllCards(){   //한 세션이 끝나고 다음세션을 시작할 때 가지고있는 카드와 카운트를 초기화
        receivedCards = new ArrayList<>();
    }

}
