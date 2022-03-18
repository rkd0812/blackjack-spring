package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
    private List<Card> cards = new ArrayList<>();

    public Dealer() {
    }

    public void drawCard () {
        System.out.println("딜러가 카드를 뽑습니다.");
        Card card = Deck.drawCard();
        if (cards.isEmpty()) {
            System.out.println("딜러가 카드를 받았습니다.");
            System.out.printf("Label : %s | Symbol : %s \n", card.getLabel(), card.getSymbol());
        } else {
            System.out.println("딜러가 카드를 받았습니다.");
        }

        this.cards.add(card);

    }

    public Card drawSendCard() {
        System.out.println("딜러가 카드를 뽑아 플레이어게 줍니다.");
        return Deck.drawCard();
    }

    public int open() {
        return cards.stream()
                .mapToInt(card -> card.getScore())
                .sum();
    }

    public void showCards() {
        System.out.println("딜러 카드");
        for (Card card : cards) {
            System.out.printf("Label : %s | Symbol : %s \n", card.getLabel(), card.getSymbol());
        }
    }
}
