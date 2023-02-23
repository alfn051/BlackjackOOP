package com.blackjack.game;

import com.blackjack.person.Dealer;
import com.blackjack.person.Player;

public class GameClient {

    Player player = new Player();
    Dealer dealer = new Dealer();

    public void run() {
        while (true) {
            GameSession gameSession = new GameSession(player, dealer);
            gameSession.run();
        }
    }

}
