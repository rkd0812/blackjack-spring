package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Card> cards;

    public Player() {
        cards = new ArrayList<>();
    }

    public void receivedCard(Card card) {
        this.cards.add(card);
        System.out.println("플레이어가 카드를 받았습니다.");
        System.out.printf("Label : %s | Symbol : %s \n", card.getLabel(), card.getSymbol());
    }

    public int open() {
        return cards.stream()
                .mapToInt(card -> card.getScore())
                .sum();
    }

    public void showCards() {
        System.out.println("플레이어 카드");
        for (Card card : cards) {
            System.out.printf("Label : %s | Symbol : %s \n", card.getLabel(), card.getSymbol());
        }
    }
}
