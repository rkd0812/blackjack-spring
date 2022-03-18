package blackjack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {
    public static void main(String[] args)  {
        ApplicationContext context = new GenericXmlApplicationContext("classpath:spring/context-common.xml");
        Game game = context.getBean(Game.class);
        game.start();
    }
}
