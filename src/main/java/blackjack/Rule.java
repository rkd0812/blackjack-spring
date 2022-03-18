package blackjack;

import blackjack.enums.PlayerResult;

import java.util.Scanner;

public class Rule {
    private final int baseScore;
    private final Player player;
    private final Dealer dealer;

    public Rule(int baseScore, Player player, Dealer dealer) {
        this.baseScore = baseScore;
        this.player = player;
        this.dealer = dealer;
    }

    public void startPhase() {
        dealer.drawCard();
        player.receivedCard(dealer.drawSendCard());
        dealer.drawCard();
        player.receivedCard(dealer.drawSendCard());
        burstCheck();
        player.showCards();
    }

    public void selectPhase() {
        String command = "";
        while (!"S".equals(command)) {
            System.out.println("카드를 받으려면 H 이대로 멈추려면 S 를 입력하세요.");
            Scanner scanner = new Scanner(System.in);
            command = scanner.next();
            if ("H".equals(command)) {
                player.receivedCard(dealer.drawSendCard());
                player.showCards();
                burstCheck();
            }
        }
    }

    private void burstCheck() {
        if (isBurst(player)) {
            System.out.println("Player Burst 입니다.");
            System.out.println("게임을 종료합니다.");
            System.exit(0);
        }
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
