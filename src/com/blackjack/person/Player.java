package com.blackjack.person;

import com.blackjack.game.UI;

public class Player extends Person{
    private int money = 0;
    @Override
    public boolean selectHitOrStand() {
        return UI.hitSelector();
    }

    public int betMoney(){
//        int betting;
//        while(true){
//            System.out.println("베팅할 금액을 정해주십시오(최소 100 ~ 최대 5000");
//            betting = Integer.parseInt(sc.nextLine());
//            if(betting >= 100 && betting <= 5000){
//                if(betting <= money){
//                    money -= betting;
//                    return betting;
//                }else{
//                    System.out.println("베팅금액이 잔액보다 많습니다.");
//                }
//            }else {
//                System.out.println("올바른 금액을 입력하세요");
//            }
//        }
//        int betting;
//        boolean overBet = false;    //배팅한 금액이 플레이어의 남은 돈보다 많을 시 true -> UI에서 메시지 출력
//        do{
//            betting = UI.betInputs(overBet);
//            overBet = true;
//        }while (betting > money);
//        money -= betting;
//        return betting;
        int betting;
        while (true){
            betting = UI.betInputs(false);
            if(betting <= money){
                money -= betting;
                return betting;
            }else{
                betting = UI.betInputs(true);
            }
        }
    }

    public void receiveMoney(int money){
        this.money += money;
    }
    public int getMoney(){
        return money;
    }
}
