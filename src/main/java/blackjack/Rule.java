package blackjack;

import blackjack.enums.PlayerResult;

public class Rule {
    private int baseScore;
    private Player player;
    private Dealer dealer;

    public Rule(int baseScore, Player player, Dealer dealer) {
        this.baseScore = baseScore;
        this.player = player;
        this.dealer = dealer;
    }

    public boolean isBurst(Player player) {
        return player.open() > this.baseScore;
    }

    public void showResult() {
        if (PlayerResult.WIN == evaluate()) {
            System.out.println("플레이어 승리 ~ !!!");
        } else if (PlayerResult.LOSE == evaluate()) {
            System.out.println("딜러의 승리 ~ !!!");
        } else {
            System.out.println("비겼습니다.");
        }
    }

    public PlayerResult evaluate() {
        System.out.println("|--> 결과를 집계합니다. ");
        int playerScore = player.open();
        player.showCards();
        int dealerScore = dealer.open();
        dealer.showCards();

        if (playerScore == this.baseScore) return PlayerResult.WIN;
        if (playerScore == dealerScore) return PlayerResult.DRAW;

        if (this.baseScore - playerScore < this.baseScore - dealerScore) {
            return PlayerResult.WIN;
        } else {
            return PlayerResult.LOSE;
        }
    }
}
