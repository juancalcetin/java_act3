package com.company;


public class PlayingCard {

    public enum Suit {
        Corazones, Diamantes, Treboles, Picas
    };

    public enum Rank {
        A, Dos, Tres, Cuatro, Cinco, Seis, Siete, Ocho, Nueve, Diez, J, Q, K
    };

    private Suit suit;

    private Rank rank;


    public PlayingCard(Rank rank, Suit suit) {
        if (rank == null) {
            throw new IllegalArgumentException("Card rank is empty!");
        }
        if (suit == null) {
            throw new IllegalArgumentException("Card suit is empty!");
        }

        this.rank = rank;
        this.suit = suit;
    }


    public Rank getRank() {
        return rank;
    }


    public Suit getSuit() {
        return suit;
    }


    @Override
    public String toString() {
        return new StringBuilder().append(rank).append(" de ").append(suit).toString();
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((rank == null) ? 0 : rank.hashCode());
        result = prime * result + ((suit == null) ? 0 : suit.hashCode());
        return result;
    }


}