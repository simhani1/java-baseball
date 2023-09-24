package baseball.domain;

public class GameResult {

    private int strikeCount;
    private int ballCount;
    private boolean correct;

    public GameResult(int strikeCount, int ballCount, boolean correct) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
        this.correct = correct;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void addStrikeCount(int count) {
        this.strikeCount += count;
    }

    public void addBallCount(int count) {
        this.ballCount += count;
    }

    public GameResult changeCorrection() {
        if (strikeCount == 3) {
            this.correct = true;
        }
        return this;
    }

    public boolean isCorrect() {
        return correct;
    }
}
