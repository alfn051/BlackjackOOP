package com.blackjack.person;

import com.blackjack.cards.Card;
import com.blackjack.cards.CardDeck;
import com.blackjack.game.Rule;

import java.util.ArrayList;

public class Dealer extends Person{

    private int countCard = 0;

    @Override
    public boolean selectHitOrStand() {
        return Rule.getPersonScore(this) <= 16;
    }
    @Override
    public void removeAllCards(){   //한 세션이 끝나고 다음세션을 시작할 때 가지고있는 카드와 카운트를 초기화
        receivedCards = new ArrayList<>();
        countCard = 0;
    }
}
