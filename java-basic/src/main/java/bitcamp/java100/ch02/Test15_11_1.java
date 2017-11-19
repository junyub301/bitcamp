package bitcamp.java100.ch02;
public class Test15_11_1 {
      
    public static void main(String[] args){
        
        // 파일의 정보를 저장
        // 디렉토리여부, 소유주/그룹/기타 사용자의 읽기, 쓰기, 권한 정보
        
        // class를 이용
        class Privilege {
            boolean isDirectroy;
            boolean ownerRead;
            boolean ownerWrite;
            boolean ownerExe;
            boolean groupRead;
            boolean groupWrite;
            boolean groupExe;
            boolean otherRead;
            boolean otherWrite;
            boolean otherExe;
        }
        
        Privilege p1 = new Privilege();
        p1.isDirectroy = false;
        p1.ownerRead = true;
        p1.ownerWrite = true;
        p1.ownerExe = true;
        p1.groupRead = true;
        p1.groupWrite = false;
        p1.groupExe = true;
        p1.otherRead = true;
        p1.otherWrite = false;
        p1.otherExe = true;
        
        System.out.print(p1.isDirectroy ? "d" : "-");
        System.out.print(p1.ownerRead ? "r" : "-");
        System.out.print(p1.ownerWrite ? "w" : "-");
        System.out.print(p1.ownerExe ? "x" : "-");
        System.out.print(p1.groupRead ? "r" : "-");
        System.out.print(p1.groupWrite ? "w" : "-");
        System.out.print(p1.groupExe ? "x" : "-");
        System.out.print(p1.otherRead ? "r" : "-");
        System.out.print(p1.otherWrite ? "w" : "-");
        System.out.print(p1.otherExe ? "x" : "-");
        System.out.println("");
    }

}

/* 
 * 식(Expression) => 결과를 리턴하는 명령어.
 * 문장(Statement) => 결과를 반드시 리턴하지는 않는다. 세미콜론으로 끝나야 한다.
 * 블록(Block) => 한개 이상의 문장이나 하위 블로들로 구성된 것.
 * 메서드(Method) => 다시 사용할 수 있는 블록.
 * 클래스(Class) = > 여러 개의 변수 선언과 메서들로 구성된 블록.
 */ 
