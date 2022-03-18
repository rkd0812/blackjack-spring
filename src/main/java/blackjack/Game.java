package blackjack;

import java.util.Scanner;

public class Game {
    private Dealer dealer;
    private Player player;

    public Game(Dealer dealer, Player player) {
        this.dealer = dealer;
        this.player = player;
    }

    public void start() {
        Rule rule = new Rule(21, player, dealer);

        System.out.println("Black Jack 게임을 시작합니다.");
        dealer.drawCard();
        player.receivedCard(dealer.drawSendCard());
        dealer.drawCard();
        player.receivedCard(dealer.drawSendCard());

        player.showCards();
        burstCheck(rule, player);

        String command = "";
        while (!"S".equals(command)) {
            System.out.println("카드를 받으려면 H 이대로 멈추려면 S 를 입력하세요.");
            Scanner scanner = new Scanner(System.in);
            command = scanner.next();
            if ("H".equals(command)) {
                player.receivedCard(dealer.drawSendCard());
                player.showCards();
                burstCheck(rule, player);
            }
        }
        rule.showResult();
    }

    private void burstCheck(Rule rule, Player player) {
        if (rule.isBurst(player)) {
            System.out.println("Player Burst 입니다.");
            System.out.println("게임을 종료합니다.");
            System.exit(0);
        }
    }
}
