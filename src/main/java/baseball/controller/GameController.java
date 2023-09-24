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

    private void print(GameResult gameResult) {
        System.out.println(makeResultMessage(gameResult));
    }

    private String makeResultMessage(GameResult gameResult) {
        StringBuilder sb = new StringBuilder();
        containBall(sb, gameResult);
        containStrike(sb, gameResult);
        containNothing(sb, gameResult);
        return sb.toString();
    }

    private void containBall(StringBuilder sb, GameResult gameResult) {
        if (gameResult.getBallCount() >= 1) {
            sb.append(gameResult.getBallCount()).append(BALL_MESSAGE.getMessage());
        }
    }

    private void containStrike(StringBuilder sb, GameResult gameResult) {
        if (gameResult.getStrikeCount() >= 1) {
            sb.append(gameResult.getStrikeCount()).append(STRIKE_MESSAGE.getMessage());
        }
    }

    private void containNothing(StringBuilder sb, GameResult gameResult) {
        if (gameResult.getBallCount() == 0 && gameResult.getStrikeCount() == 0) {
            sb.append(NOTHING_MESSAGE.getMessage());
        }
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
