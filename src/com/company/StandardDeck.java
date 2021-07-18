package com.company;

import java.util.*;

public class StandardDeck {

    private static final Random rand = new Random();

    private Set<PlayingCard> deck = new LinkedHashSet<>();

    public StandardDeck() {
        for (PlayingCard.Suit suit : PlayingCard.Suit.values()) {
            for (PlayingCard.Rank rank : PlayingCard.Rank.values()) {
                deck.add(new PlayingCard(rank, suit));
            }
        }
    }

    public void shuffle() {
        System.out.println("Se mezclo el Deck");
        List<PlayingCard> cardsInDeck = new LinkedList<>(deck);
        int totalDeckLength = cardsInDeck.size();
        Set<PlayingCard> newDeck = new LinkedHashSet<>();
        for (int i = 0; i < totalDeckLength; i++) {
            PlayingCard randomlySelectedCard = cardsInDeck.get(rand.nextInt(cardsInDeck.size()));
            cardsInDeck.remove(randomlySelectedCard);
            newDeck.add(randomlySelectedCard);
        }

        deck = newDeck;
    }

    public PlayingCard deal_one_card() {
        if (deck.size() > 0) {
            List<PlayingCard> cardsInDeck = new LinkedList<>(deck);
            PlayingCard selectedCard = cardsInDeck.get(0);
            System.out.println("La primera carta del deck es: "+selectedCard);
            cardsInDeck.remove(0);
            deck = new LinkedHashSet<>(cardsInDeck);
            System.out.println("Quedan "+deck.size()+" cartas");
            return null;
        }

        return null;
    }
    public PlayingCard carta_al_azar() {
        System.out.println("Obteniendo una carta al azar");
        if (deck.size() > 0) {
            List<PlayingCard> cardsInDeck = new LinkedList<>(deck);
            Random random_method = new Random();
            int random_index = random_method.nextInt(deck.size());
            PlayingCard selectedCard = cardsInDeck.get(random_index);
            System.out.println("Carta al azar es: " + cardsInDeck.get(random_index));
            cardsInDeck.remove(random_index);
            deck = new LinkedHashSet<>(cardsInDeck);
            System.out.println("Quedan " + deck.size() + " cartas");
            return null;
        }
        return null;
    }
    public PlayingCard mano() {
        System.out.println("Entregando 5 cartas");
        List<PlayingCard> cardsInDeck = new LinkedList<>(deck);
        if(deck.size() >=5) {
            for(int i= 0; i<5;i++){
                PlayingCard selectedCard = cardsInDeck.get(0);
                System.out.println("Obtuvo la carta: "+selectedCard);
                cardsInDeck.remove(0);
                deck = new LinkedHashSet<>(cardsInDeck);
                System.out.println("Quedan " + deck.size() + " cartas");


            }
            return null;

        } return null;

    }

    public Set<PlayingCard> getDeck() {
        System.out.println("Las cartas en el deck son: ");
        return deck;
    }
}