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
    private void reset(){
        player.removeAllCards();
        dealer.removeAllCards();
    }
    private void playerWin(){   //승
        UI.resultMessage(player);
        reset();
    }
    private void playerLose(){  //패
        UI.resultMessage(dealer);
        reset();
    }
    private void push(){    //무승부
        UI.resultMessage(null);
        reset();
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
            UI.openBothCard(player, dealer);
            if(rule.isBlackJack(dealer)){
                push();
            }else{
                playerWin();
            }
            return;
        }
        while (true){
            if(!hitOrStand(player)){    //스탠드
                boolean isHit = false;
                do{
                    UI.openBothCard(player, dealer);
                    isHit = hitOrStand(dealer);
                }while (isHit);
                if(rule.isBust(dealer)){
                    UI.bustMessage(dealer);
                    playerWin();
                }else {
                    Person judgeResult = rule.judge(player, dealer);
                    if(judgeResult instanceof Player){
                        playerWin();
                    } else if (judgeResult instanceof Dealer) {
                        playerLose();
                    }else {
                        push();
                    }
                }return;
            }
            UI.openBothCard(player, dealer, true);    //히트
            if(rule.isBust(player)){
                UI.bustMessage(player);
                playerLose();
                return;
            }
        }
    }

}
