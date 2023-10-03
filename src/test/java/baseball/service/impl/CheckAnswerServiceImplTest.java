package baseball.service.impl;

import baseball.domain.GameResult;
import baseball.service.CheckAnswerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CheckAnswerServiceImplTest {

    private CheckAnswerService checkAnswerService;

    @BeforeEach
    void init() {
        this.checkAnswerService = new CheckAnswerServiceImpl();
    }

    @DisplayName("컴퓨터: 123, 사용자: 234, 결과: 2볼")
    @Test
    void twoBall() {
        // given
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> inputNumber = List.of(2, 3, 4);

        // when
        GameResult gameResult = checkAnswerService.checkAnswer(computer, inputNumber);

        // then
        assertThat(gameResult)
                .extracting(GameResult::getStrikeCount, GameResult::getBallCount, GameResult::isCorrect)
                .contains(0, 2, false);
    }

    @DisplayName("컴퓨터: 123, 사용자: 124, 결과: 2스트라이크")
    @Test
    void twoStrike() {
        // given
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> inputNumber = List.of(1, 2, 4);

        // when
        GameResult gameResult = checkAnswerService.checkAnswer(computer, inputNumber);

        // then
        assertThat(gameResult)
                .extracting(GameResult::getStrikeCount, GameResult::getBallCount, GameResult::isCorrect)
                .contains(2, 0, false);
    }

    @DisplayName("컴퓨터: 123, 사용자: 456, 결과: 낫싱")
    @Test
    void notThing() {
        // given
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> inputNumber = List.of(4, 5, 6);

        // when
        GameResult gameResult = checkAnswerService.checkAnswer(computer, inputNumber);

        // then
        assertThat(gameResult)
                .extracting(GameResult::getStrikeCount, GameResult::getBallCount, GameResult::isCorrect)
                .contains(0, 0, false);
    }

    @DisplayName("컴퓨터: 123, 사용자: 231, 결과: 3볼")
    @Test
    void threeBall() {
        // given
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> inputNumber = List.of(2, 3, 1);

        // when
        GameResult gameResult = checkAnswerService.checkAnswer(computer, inputNumber);

        // then
        assertThat(gameResult)
                .extracting(GameResult::getStrikeCount, GameResult::getBallCount, GameResult::isCorrect)
                .contains(0, 3, false);
    }

    @DisplayName("컴퓨터: 123, 사용자: 135, 결과: 1볼 1스트라이크")
    @Test
    void oneBallOneStrike() {
        // given
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> inputNumber = List.of(1, 3, 5);

        // when
        GameResult gameResult = checkAnswerService.checkAnswer(computer, inputNumber);

        // then
        assertThat(gameResult)
                .extracting(GameResult::getStrikeCount, GameResult::getBallCount, GameResult::isCorrect)
                .contains(1, 1, false);
    }

    @DisplayName("컴퓨터: 123, 사용자: 123, 결과: 3스트라이크")
    @Test
    void threeStrike() {
        // given
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> inputNumber = List.of(1, 2, 3);

        // when
        GameResult gameResult = checkAnswerService.checkAnswer(computer, inputNumber);

        // then
        assertThat(gameResult)
                .extracting(GameResult::getStrikeCount, GameResult::getBallCount, GameResult::isCorrect)
                .contains(3, 0, true);
    }
}