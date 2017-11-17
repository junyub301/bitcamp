package bitcamp.java100;

public class Test15_11_2 {
      
    public static void main(String[] args){
        
        // 파일의 정보를 저장
        // 디렉토리여부, 소유주/그룹/기타 사용자의 읽기, 쓰기, 권한 정보
        
        // 배열 이용
        
        boolean[] arr = new boolean[10];
            arr[0] = false;
            arr[1] = true;
            arr[2] = true;
            arr[3] = true;
            arr[4] = true;
            arr[5] = false;
            arr[6] = true;
            arr[7] = true;
            arr[8] = false;
            arr[9] = true;
                
        System.out.print(arr[0] ? "d" : "-");
        System.out.print(arr[1] ? "r" : "-");
        System.out.print(arr[2]? "w" : "-");
        System.out.print(arr[3] ? "x" : "-");
        System.out.print(arr[4] ? "r" : "-");
        System.out.print(arr[5] ? "w" : "-");
        System.out.print(arr[6] ? "x" : "-");
        System.out.print(arr[7] ? "r" : "-");
        System.out.print(arr[8] ? "w" : "-");
        System.out.print(arr[9] ? "x" : "-");
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
