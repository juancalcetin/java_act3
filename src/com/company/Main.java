package com.company;


public class Main {
    public static void main(String[] args){
        StandardDeck t = new StandardDeck();
        System.out.println(t.getDeck());
        t.shuffle();
        System.out.println(t.getDeck());
        t.deal_one_card();
        t.carta_al_azar();
        t.mano();


    }
}
