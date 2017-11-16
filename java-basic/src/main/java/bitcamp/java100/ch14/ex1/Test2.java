package bitcamp.java100.ch14.ex1;

import java.io.File;

public class Test2 {

    public static void main(String[] args) throws Exception {
        File file = new File("ok.txt");
        
        // 파일 생성
        // => 존재하지 않으면, 만들고 true 리턴
        // => 존재면, 만들지 않고고 false 리턴
        System.out.printf("파일생성=%b\n",file.createNewFile());
        
        // 파일 및 디렉토리 제거
        // => 삭제 성공, true 리턴
        // => 삭제 실패, false 리턴
        System.out.printf("파일삭제=%b\n",file.delete());

        File file2 = new File("dir1");
        System.out.printf("디렉토리 생성=%b\n",file2.mkdir());
        // 디렉토리 안에 파일이 있을 경우 삭제하지 않는다.
        System.out.printf("디렉토리 삭제=%b\n",file2.delete());
        
        File file3 = new File("aaa/bbb/ccc/test.txt");
        
        System.out.printf("디렉토리2 생성=%b\n",file3.mkdir());
        // 파일 경로에서 마지막 이름도 디렉토리로 간주해 생성한다. 
        System.out.printf("디렉토리2 생성=%b\n",file3.mkdirs());
        
    }
}
