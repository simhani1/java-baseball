package baseball.controller.message;

public enum Message {

    STARTING_MESSAGE("숫자 야구 게임을 시작합니다."),
    INPUT_NUMBER("숫자를 입력해주세요 : "),
    ANSWER_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RETRY_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    STRIKE_MESSAGE("스트라이크"),
    BALL_MESSAGE("볼 "),
    NOTHING_MESSAGE("낫싱")
    ;

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
