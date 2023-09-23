package baseball.controller;

import baseball.controller.message.Message;
import baseball.controller.validator.Validator;
import baseball.domain.Computer;
import baseball.domain.GameResult;
import baseball.service.CheckAnswerService;

import java.util.List;
import java.util.stream.Collectors;

import static baseball.controller.message.Message.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameController {

    private CheckAnswerService checkAnswerService;
    private static final int RETRY_COMMAND = 1;

    public GameController(CheckAnswerService checkAnswerService) {
        this.checkAnswerService = checkAnswerService;
    }

    public void run() {
        print(STARTING_MESSAGE);
        do {
            Computer computer = new Computer();
            GameResult gameResult;
            do {
                print(INPUT_NUMBER);
                gameResult = checkAnswerService.checkAnswer(computer.getNumber(), toList(checkNumberFormat(readLine())));
                print(gameResult);
            } while (!gameResult.isCorrect());
            print(ANSWER_MESSAGE);
        } while (retryGame());
    }

    private List<Integer> toList(String inputNumber) {
        return inputNumber.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }

    private String checkNumberFormat(String inputNumber) {
        if (Validator.checkNumberFormat(inputNumber)) {
            return inputNumber;
        }
        throw new IllegalArgumentException();
    }

    private void print(Message message) {
        System.out.println(message.getMessage());
    }

    // TODO: 상수 처리
    private void print(GameResult gameResult) {
        String message = "";
        if (gameResult.getBallCount() >= 1) {
            message += (gameResult.getBallCount() + "볼 ");
        }
        if (gameResult.getStrikeCount() >= 1) {
            message += (gameResult.getStrikeCount() + "스트라이크");
        }
        if (gameResult.getBallCount() == 0 && gameResult.getStrikeCount() == 0) {
            message += "낫싱";
        }
        System.out.println(message);
    }

    private boolean retryGame() {
        print(RETRY_MESSAGE);
        return toInt(checkCommandFormat(readLine())) == RETRY_COMMAND;
    }

    private String checkCommandFormat(String command) {
        if (Validator.checkCommandFormat(command)) {
            return command;
        }
        throw new IllegalArgumentException();
    }

    private int toInt(String command) {
        return Integer.parseInt(command);
    }
}
