package baseball.service.impl;

import baseball.domain.GameResult;
import baseball.service.CheckAnswerService;

import java.util.List;

public class CheckAnswerServiceImpl implements CheckAnswerService {

    @Override
    public GameResult checkAnswer(List<Integer> computer, List<Integer> inputNumber) {
        GameResult gameResult = new GameResult(0, 0, false);
        for (int i = 0; i < computer.size(); i++) {
            gameResult.addStrikeCount(countStrike(computer.get(i), i, inputNumber));
            gameResult.addBallCount(countBall(computer.get(i), i, inputNumber));
        }
        gameResult.changeCorrection();
        return gameResult;
    }

    private int countBall(int std, int idx, List<Integer> inputNumber) {
        int ballCount = 0;
        for (int i = 0; i < inputNumber.size(); i++) {
            if (idx != i && std == inputNumber.get(i)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private int countStrike(int std, int idx, List<Integer> inputNumber) {
        int strikeCount = 0;
        for (int i = 0; i < inputNumber.size(); i++) {
            if (idx == i && std == inputNumber.get(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }
}
