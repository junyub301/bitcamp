package ver32;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import java100.app.domain.Score;
import java100.app.util.Prompts;

public class ScoreController extends GenericController<Score> {

    public void save() {
        try(FileWriter out = new FileWriter("./data/score.csv");) {
            for (Score score : this.list) {
                out.write(String.format("%s,%d,%d,%d,%d,%f\n", score.getName(), score.getKor(),
                        score.getEng(), score.getMath(), score.getSum(), score.getAver()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ScoreController obj = new ScoreController();
        obj.load();
    }

    public void load() {
        try (FileReader in = new FileReader("./data/score.csv");){
            StringBuffer buf = new StringBuffer();
            int ch;
            while((ch = in.read()) != -1) {
                // 윈도우는 엔터가(0d 0a) 이지만 리눅스는 엔터가 (0a)만 있기때문에
                // 0d일경우는 그냥 넘어가고 0a를 만나면 전까지 다 저장
                if (ch == 0x0d) // CR(Carrage Return)
                    continue;
                if (ch != 0x0a) {
                    buf.append((char)ch);
                } else {
                    
                    System.out.println(buf.toString());
                    buf.setLength(0);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute() {
        loop:
            while(true) {
                System.out.print("성적관리> ");
                String input = keyScan.nextLine();

                switch (input) {
                case "add": this.doAdd(); break;
                case "list": this.doList(); break;
                case "view": this.doView(); break;
                case "delete": this.doDelete(); break;
                case "update": this.doUpdate(); break;
                case "main":; break loop;
                default:
                    System.out.println("해당 명령이 없습니다.");
                }

                System.out.println();
            } // while        
    }

    private void doUpdate() {
        System.out.println("[성적 정보 변경]");
        String name = Prompts.inputString("이름? ");

        Score score = findByName(name);

        if (score == null) {
            System.out.printf("'%s'의 성적 정보가 없습니다.\n", name);
        } else {
            int kor = score.getKor();
            try {
                kor = Prompts.inputInt("국어?(%d)" , score.getKor());
            } catch (Exception e) {}

            int eng = score.getEng();
            try {
                eng = Prompts.inputInt("영어?(%d)" , score.getEng());
            } catch (Exception e) {}

            int math = score.getMath();
            try {
                math = Prompts.inputInt("수학?(%d)" , score.getEng());
            } catch (Exception e) {}

            if (Prompts.confirm2("변경하시겠습니까?(y/N) ")) {
                score.setKor(kor);
                score.setEng(eng);
                score.setMath(math);
                System.out.println("변경하였습니다.");
            } else {
                System.out.println("변경 취소하였습니다.");
            }
        }        
    }

    private void doDelete() {
        System.out.println("[성적 삭제]");
        String name = Prompts.inputString("이름? ");

        Score score = findByName(name);

        if (score == null) {
            System.out.printf("'%s'의 성적 정보가 없습니다.\n", name);
        } else {
            if (Prompts.confirm2("정말 삭제하겠습니까?(y/N)")) {
                list.remove(score);
                System.out.println("삭제했습니다.");
            }
            else System.out.println("삭제 취소했습니다.");
        }
    }

    private void doView() {
        System.out.println("[성적 정보]");
        String name = Prompts.inputString("이름? ");
        Score score = findByName(name);

        if (score == null) {
            System.out.printf("'%s'의 성적 정보가 없습니다.\n", name);
            return;
        }

        System.out.printf("%-4s, %4d, %4d, %4d, %4d, %6.1f\n",  
                score.getName(), 
                score.getKor(), 
                score.getEng(), 
                score.getMath(), 
                score.getSum(), 
                score.getAver());
    }

    private void doList() {

        System.out.println("[성적 목록]");
        Iterator<Score> iterator = list.iterator();
        while (iterator.hasNext()) {
            Score score = iterator.next();
            System.out.printf("%-4s, %4d, %6.1f\n",  
                    score.getName(), 
                    score.getSum(), 
                    score.getAver());
        }

    }

    private void doAdd() {

        System.out.println("[성적 등록]");

        Score score = new Score();

        score.setName(Prompts.inputString("이름? "));
        score.setKor(Prompts.inputInt("국어? "));
        score.setEng(Prompts.inputInt("영어? "));
        score.setMath(Prompts.inputInt("수학? "));

        list.add(score);

    }

    private Score findByName(String name) {
        Iterator<Score> iterator = list.iterator();
        while (iterator.hasNext()) {
            Score score = iterator.next();
            if(score.getName().equals(name)) {
                return score;
            }
        }// while
        return null;
    }


}
