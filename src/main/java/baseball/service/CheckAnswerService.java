package baseball.service;

import baseball.domain.GameResult;

public interface CheckAnswerService {
    GameResult isAnswer(String inputNumber);
}
