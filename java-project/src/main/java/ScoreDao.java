

public class ScoreDao {

    Score[] scores = new Score[100000];
    int cursor = 0;

    void add(Score score) {

        if (this.cursor == this.scores.length) {
            System.err.println("최대 저장 개수를 초과했습니다.");
            return;
        }
        this.scores[cursor++] = score;
    }

    int size() {
        return this.cursor;
    }

    Score get(int index) {
        if (index < 0 || index >= this.cursor) {
            return null;
        }

        return this.scores[index];
    }
}
