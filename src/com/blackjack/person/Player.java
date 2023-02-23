package com.blackjack.person;

import com.blackjack.cards.Card;
import com.blackjack.cards.CardDeck;

import java.util.Scanner;

public class Player extends Person{
    private int money = 0;
    Scanner sc = new Scanner(System.in);
    @Override
    public boolean selectHitOrStand() {
        String select;
        while (true){
            System.out.print("카드를 한장 더 받겠습니까?(Hit or Stand?) y / n : ");
            select = sc.nextLine();
            if(select.equals("y")){
                return true;
            } else if (select.equals("n")) {
                return false;
            }else {
                System.out.println("올바른 값을 입력하세요");
            }
        }

    }

    public int betMoney(){
        int betting;
        while(true){
            System.out.println("베팅할 금액을 정해주십시오(최소 100 ~ 최대 5000");
            betting = Integer.parseInt(sc.nextLine());
            if(betting >= 100 && betting <= 5000){
                if(betting <= money){
                    money -= betting;
                    return betting;
                }else{
                    System.out.println("베팅금액이 잔액보다 많습니다.");
                }
            }else {
                System.out.println("올바른 금액을 입력하세요");
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
