package baseball.controller;

import baseball.service.CheckAnswerService;

public class GameController {

    private CheckAnswerService checkAnswerService;

    public GameController(CheckAnswerService checkService) {
        this.checkAnswerService = checkService;
    }
}
