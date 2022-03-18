package blackjack;

import blackjack.enums.Label;
import blackjack.enums.Symbol;

public class Card {
    private final Label label;
    private final Symbol symbol;

    public Card(Label label, Symbol symbol) {
        this.label = label;
        this.symbol = symbol;
    }

    public int getScore() {
        return label.getScore();
    }

    public Label getLabel() {
        return label;
    }

    public Symbol getSymbol() {
        return symbol;
    }
}
