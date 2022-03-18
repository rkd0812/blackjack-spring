package blackjack;

public class Game {
    private final Rule rule;

    public Game(Rule rule, Player player, Dealer dealer) {
        this.rule = rule;
    }

    public void start() {
        System.out.println("Black Jack 게임을 시작합니다.");
        rule.startPhase();
        rule.selectPhase();
        rule.showResult();
    }

}
