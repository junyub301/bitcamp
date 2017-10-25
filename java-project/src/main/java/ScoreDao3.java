
public class ScoreDao3 {
    
    static void compute(Score score) {
        for (int sub : score.subjects) {
            score.sum += sub;
        }
        score.aver = (float)score.sum / score.subjects.length;
    }

}
