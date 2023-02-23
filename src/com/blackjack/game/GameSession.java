package com.blackjack.game;

import com.blackjack.card.CardDeck;
import com.blackjack.person.Dealer;
import com.blackjack.person.Person;
import com.blackjack.person.Player;

public class GameSession {
    Player player;
    Dealer dealer;
    Rule rule = new Rule();

    CardDeck deck = new CardDeck();

    int betMoney;
    public GameSession(Player player, Dealer dealer){
        this.player = player;
        this.dealer = dealer;
    }
    private boolean hitOrStand(Person person){
        if(person.selectHitOrStand()){
            person.receiveCard(deck.drawCard());
            return true;
        }
        return false;
    }
    private void playerWin(){

    }
    private void playerLose(){

    }
    private void push(){

    }
    public void run(){
        UI.sessionStartMessage();
        betMoney = player.betMoney();
        player.receiveCard(deck.drawCard());
        player.receiveCard(deck.drawCard());
        dealer.receiveCard(deck.drawCard());
        dealer.receiveCard(deck.drawCard());
        UI.openCard(dealer, true);
        UI.openCard(player, rule.getPersonScore(player));
        if(rule.isBlackJack(player)){
            UI.openCard(dealer, rule.getPersonScore(dealer));
            if(rule.isBlackJack(dealer)){
                push();
            }else{
                playerWin();
            }
            return;
        }
        while (true){
            if(hitOrStand(player)){

            }
        }
    }

}
