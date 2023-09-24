package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {

    private GameResult gameResult;

    @BeforeEach
    void init() {
        this.gameResult = new GameResult(0, 0, false);
    }

    @DisplayName("스트라이크 횟수를 추가한 만큼 스트라이크가 증가한다.")
    @Test
    void addStrike() {
        // given
        int strikeCount = 1;

        // when
        gameResult.addStrikeCount(strikeCount);

        // then
        assertThat(gameResult.getStrikeCount()).isEqualTo(strikeCount);
    }

    @DisplayName("볼 횟수를 추가한 만큼 볼이 증가한다.")
    @Test
    void addBall() {
        // given
        int ballCount = 1;

        // when
        gameResult.addBallCount(ballCount);

        // then
        assertThat(gameResult.getBallCount()).isEqualTo(ballCount);
    }

    @DisplayName("3스트라이크인 경우 정답으로 상태를 변경한다.")
    @Test
    void changeCorrection() {
        // given
        int strikeCount = 3;

        // when
        gameResult.addStrikeCount(strikeCount);
        gameResult.changeCorrection();

        // then
        assertThat(gameResult.isCorrect()).isTrue();
    }
}