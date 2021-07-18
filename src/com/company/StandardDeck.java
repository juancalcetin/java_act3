package com.company;

import java.util.*;

public class StandardDeck {

    private static final Random rand = new Random();

    private Set<PlayingCard> deck = new LinkedHashSet<>();

    /**
     * Constructs an instance of StandardDeck, populating the internal data
     * structure with 52 instances of the PlayingCard object, one for each
     * combination of Rank and Suit defined
     *
     */
    public StandardDeck() {
        System.out.println("Las cartas en el deck son: ");
        // Populate deck with all 52 available PlayingCards
        for (PlayingCard.Suit suit : PlayingCard.Suit.values()) {
            for (PlayingCard.Rank rank : PlayingCard.Rank.values()) {
                deck.add(new PlayingCard(rank, suit));
            }
        }
    }

    /**
     * Takes the existing ordered set of PlayingCard objects and shuffles the
     * order. The size of the deck remains the same.
     *
     */
    public void shuffle() {
        System.out.println("Se mezclo el Deck");
        List<PlayingCard> cardsInDeck = new LinkedList<>(deck);
        int totalDeckLength = cardsInDeck.size();
        Set<PlayingCard> newDeck = new LinkedHashSet<>();

        // Iterate through the deck, randomly select a card, remove from the old
        // deck and add to the new deck.
        for (int i = 0; i < totalDeckLength; i++) {
            PlayingCard randomlySelectedCard = cardsInDeck.get(rand.nextInt(cardsInDeck.size()));

            cardsInDeck.remove(randomlySelectedCard);
            newDeck.add(randomlySelectedCard);
        }

        deck = newDeck;
    }

    /**
     * Removes one card from the 'top' of the deck and returns it to the client.
     * The size of the deck after the method completes is exactly one less than
     * prior to calling the method. The remaining cards in the deck maintain
     * their original order. When the deck no longer has any cards, the method
     * returns null.
     *
     * @return PlayingCard Selected from the 'top' of the deck
     */
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
    /**
     * Utility method for retrieving the current state of the cards in the deck
     *
     * @return deck A set of the remaining PlayingCard objects in the deck
     */
    public Set<PlayingCard> getDeck() {
        return deck;
    }
}