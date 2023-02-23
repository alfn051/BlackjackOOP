package com.blackjack.game;

import com.blackjack.person.Dealer;
import com.blackjack.person.Person;
import com.blackjack.person.Player;

public class GameSession {
    Player player;
    Dealer dealer;
    Rule rule = new Rule();
    int playerScore = 0;
    int dealerScore = 0;
    int betMoney;
    public GameSession(Player player, Dealer dealer){
        this.player = player;
        this.dealer = dealer;
    }
    public void openCard(Person person){
        person.getReceivedCards().forEach(card -> UI.openCardMessage(person, card));
    }
    public void run(){

    }

}
