package me;

public class ScoreDao3 {
    
    static void compute(Score3 score) {
        for (int sub : score.subjects) {
            score.sum += sub;
        }
        score.aver = (float)score.sum / score.subjects.length;
    }

}
