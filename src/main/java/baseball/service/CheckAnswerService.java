package baseball.service;

import baseball.domain.Computer;
import baseball.domain.GameResult;

public interface CheckAnswerService {
    GameResult checkAnswer(Computer computer, String inputNumber);
}
