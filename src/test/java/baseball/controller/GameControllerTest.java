package baseball.controller;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

class GameControllerTest extends NsTest {

    @Test
    void 숫자가_아닌_다른_문자를_입력하는_경우_예외를_던진다() {
        // given
        String inputNumber = "가나다";

        // then
        assertSimpleTest(
                () -> Assertions.assertThatThrownBy(
                        () -> runException(inputNumber)).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력한_문자열의_길이가_4이상이면_예외를_던진다() {
        // given
        String inputNumber = "1234";

        // then
        assertSimpleTest(
                () -> Assertions.assertThatThrownBy(
                        () -> runException(inputNumber)).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}