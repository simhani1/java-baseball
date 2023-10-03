package baseball.service;

import baseball.domain.GameResult;

import java.util.List;

public interface CheckAnswerService {
    GameResult checkAnswer(List<Integer> computer, List<Integer> inputNumber);
}
