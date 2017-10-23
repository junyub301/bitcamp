package bitcamp.java100.ch06.ex2;

public class ScoreDao {

    static Score[] scores = new Score[100000];
    static int cursor = 0;

    static void add(Score score) {

        if (cursor == scores.length) {
            System.err.println("최대 저장 개수를 초과했습니다.");
            return;
        }
        scores[cursor++] = score;
    }

    static int size() {
        return cursor;
    }

    static Score get(int index) {
        if (index < 0 || index >= cursor) {
            return null;
        }

        return scores[index];
    }
}
