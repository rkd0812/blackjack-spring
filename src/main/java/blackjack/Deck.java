package blackjack;

import blackjack.enums.Label;
import blackjack.enums.Symbol;

import java.util.*;

public class Deck {

    private final Set<Card> cardSet = new HashSet<>();
    public static Stack<Card> cardDeck = new Stack<>();

    public Deck() {
        for (Symbol symbol : Symbol.values()) {
            for (Label label : Label.values()) {
                this.cardSet.add(new Card(label, symbol));
            }
        }
        this.shuffle();
    }

    public void shuffle() {
        List<Card> tempList = new ArrayList<>(cardSet);
        Collections.shuffle(tempList);

        for (Card card : tempList) {
            cardDeck.push(card);
        }
    }

    public static Card drawCard() {
        return cardDeck.pop();
    }
}
