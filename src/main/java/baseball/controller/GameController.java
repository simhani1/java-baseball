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
            if (gameResult.isCorrect()) {
                if (restart()) {
                    continue;
                }
                break;
            }
        }
    }

    private boolean restart() {
        print(Message.RETRY_MESSAGE);
        return command();
    }

    private boolean command() {
        return toInt(checkFormat(readLine())) == 1;
    }

    private int toInt(String command) {
        return Integer.parseInt(command);
    }

    private void print(Message message) {
        System.out.println(message.getMessage());
    }

    private String checkFormat(String inputNumber) {
        if (inputNumber.length() >= 4 || inputNumber.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (Validator.checkFormat(inputNumber)) {
            return inputNumber;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
