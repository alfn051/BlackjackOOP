package com.blackjack.game;

import com.blackjack.person.Dealer;
import com.blackjack.person.Player;

public class GameClient {

    Player player = new Player();
    Dealer dealer = new Dealer();

    public void run() {
        boolean going = true;
        while (going) {
            if(player.getMoney()==0 && !player.getCtmd()){
                System.out.println("플레이어가 가진 돈이 없습니다.\n게임을 종료합니다");
                going = false;
            }
            GameSession gameSession = new GameSession(player, dealer);
            gameSession.run();
            UI.moneyMessage(player.getMoney());
            going = UI.keepGoing();
        }
    }

}
