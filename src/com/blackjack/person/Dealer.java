package com.blackjack.person;

import com.blackjack.game.Rule;

import java.util.ArrayList;

public class Dealer extends Person{

    @Override
    public boolean selectHitOrStand() {
        return Rule.getPersonScore(this) <= 16;
    }
}
