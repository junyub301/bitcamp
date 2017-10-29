package me;

public class ScoreDao4 {
    
    static void compute(Score4 score) {
        for (int sub : score.subjects) {
            score.sum += sub;
        }
        score.aver = (float)score.sum / score.subjects.length;
    }

}
