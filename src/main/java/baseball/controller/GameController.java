package baseball.controller;

import baseball.controller.message.Message;
import baseball.controller.validator.Validator;
import baseball.domain.GameResult;
import baseball.service.CheckAnswerService;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameController {

    private CheckAnswerService checkAnswerService;

    public GameController(CheckAnswerService checkAnswerService) {
        this.checkAnswerService = checkAnswerService;
    }

    public void run() {
        print(Message.STARTING_MESSAGE);
        while (true) {
            print(Message.INPUT_NUMBER);
            GameResult gameResult = checkAnswerService.isAnswer(checkFormat(readLine()));
        }
    }

    private void print(Message message) {
        System.out.println(message.getMessage());
    }

    private String checkFormat(String inputNumber) {
        if (Validator.isThreeLetters(inputNumber) && Validator.isComposedOfNumber(inputNumber)) {
            return inputNumber;
        }
        throw new IllegalArgumentException();
    }
}
