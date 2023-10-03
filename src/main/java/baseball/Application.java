package baseball;

import baseball.controller.GameController;
import baseball.service.impl.CheckAnswerServiceImpl;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController(new CheckAnswerServiceImpl());
        gameController.run();
    }
}
