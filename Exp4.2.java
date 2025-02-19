Experiment 4.2: Card Collection System

import java.util.*;
class Card {
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }
    public String getRank() {
        return rank;
    }
    public String getSuit() {
        return suit;
    }
    public String toString() {
        return rank + " of " + suit;
    }
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card card = (Card) obj;
        return rank.equals(card.rank) && suit.equals(card.suit);
    }
    public int hashCode() {
        return Objects.hash(rank, suit);
    }
}
public class CardCollectionSystem {
    private Map<String, Set<Card>> cardMap;

    public CardCollectionSystem() {
        cardMap = new HashMap<>();
    }
    public void addCard(String rank, String suit) {
        Card card = new Card(rank, suit);
        cardMap.putIfAbsent(suit, new HashSet<>());
        if (cardMap.get(suit).add(card)) {
            System.out.println("Card added: " + card);
        } else {
            System.out.println("Error: Card \"" + card + "\" already exists.");
        }
    }
    public void findCardsBySuit(String suit) {
        Set<Card> cards = cardMap.get(suit);
        if (cards == null || cards.isEmpty()) {
            System.out.println("No cards found for " + suit + ".");
        } else {
            for (Card card : cards) {
                System.out.println(card);
            }
        }
    }
    public void displayAllCards() {
        if (cardMap.isEmpty()) {
            System.out.println("No cards found.");
            return;
        }
        for (Set<Card> cards : cardMap.values()) {
            for (Card card : cards) {
                System.out.println(card);
            }
        }
    }
    public void removeCard(String rank, String suit) {
        Card card = new Card(rank, suit);
        Set<Card> cards = cardMap.get(suit);
        if (cards != null && cards.remove(card)) {
            System.out.println("Card removed: " + card);
            if (cards.isEmpty()) {
                cardMap.remove(suit);
            }
        } else {
            System.out.println("Card not found: " + card);
        }
    }
    public static void main(String[] args) {
        CardCollectionSystem system = new CardCollectionSystem();

        system.displayAllCards();

        system.addCard("Ace", "Spades");
        system.addCard("King", "Hearts");
        system.addCard("10", "Diamonds");
        system.addCard("5", "Clubs");

        system.findCardsBySuit("Hearts");

        system.findCardsBySuit("Diamonds");

        system.displayAllCards();

        system.addCard("King", "Hearts");

        system.removeCard("10", "Diamonds");
        system.displayAllCards();
    }
}

Test Cases

Test Case 1: No Cards Initially
Input:
Display All Cards
Expected Output:
No cards found.

Test Case 2: Adding Cards
Input:
Add Card: Ace of Spades
Add Card: King of Hearts
Add Card: 10 of Diamonds
Add Card: 5 of Clubs
Expected Output:
Card added: Ace of Spades
Card added: King of Hearts
Card added: 10 of Diamonds
Card added: 5 of Clubs

Test Case 3: Finding Cards by Suit
Input:
Find All Cards of Suit: Hearts
Expected Output:
King of Hearts

Test Case 4: Searching Suit with No Cards
Input:
Find All Cards of Suit: Diamonds
(If no Diamonds were added)
Expected Output:
No cards found for Diamonds.

Test Case 5: Displaying All Cards
Input:
Display All Cards
Expected Output:
Ace of Spades
King of Hearts
10 of Diamonds
5 of Clubs

Test Case 6: Preventing Duplicate Cards
Input:
Add Card: King of Hearts
Expected Output:
Error: Card "King of Hearts" already exists.

Test Case 7: Removing a Card
Input:
Remove Card: 10 of Diamonds
Expected Output:
Card removed: 10 of Diamonds
