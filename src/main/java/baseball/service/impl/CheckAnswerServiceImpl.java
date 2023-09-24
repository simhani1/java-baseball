package baseball.service.impl;

import baseball.domain.GameResult;
import baseball.service.CheckAnswerService;

import java.util.List;

public class CheckAnswerServiceImpl implements CheckAnswerService {

    @Override
    public GameResult checkAnswer(List<Integer> computer, List<Integer> inputNumber) {
        GameResult gameResult = createGameResult();
        grading(computer, inputNumber, gameResult);
        return gameResult.changeCorrection();
    }

    private GameResult createGameResult() {
        return new GameResult(0, 0, false);
    }

    private void grading(List<Integer> computer, List<Integer> inputNumber, GameResult gameResult) {
        for (int i = 0; i < computer.size(); i++) {
            gameResult.addStrikeCount(countStrike(i, computer, inputNumber));
            gameResult.addBallCount(countBall(i, computer, inputNumber));
        }
    }

    private int countStrike(int idx, List<Integer> copmputer, List<Integer> inputNumber) {
        int strikeCount = 0;
        for (int i = 0; i < inputNumber.size(); i++) {
            if (isSamePosition(idx, i) && isSameNumber(copmputer.get(idx), inputNumber.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int countBall(int idx, List<Integer> computer, List<Integer> inputNumber) {
        int ballCount = 0;
        for (int i = 0; i < inputNumber.size(); i++) {
            if (!isSamePosition(idx, i) && isSameNumber(computer.get(idx), inputNumber.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private boolean isSamePosition(int idx, int i) {
        return idx == i;
    }

    private boolean isSameNumber(Integer computerNumber, Integer inputNumber) {
        return computerNumber.equals(inputNumber);
    }
}
