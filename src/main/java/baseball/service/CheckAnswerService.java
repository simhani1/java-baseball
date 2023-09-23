package baseball.service;

import baseball.domain.Computer;
import baseball.domain.GameResult;

import java.util.List;

public interface CheckAnswerService {
    GameResult checkAnswer(Computer computer, List<Integer> inputNumber);
}
