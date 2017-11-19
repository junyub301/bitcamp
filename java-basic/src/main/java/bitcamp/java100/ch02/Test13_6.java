package bitcamp.java100.ch02;
public class Test13_6 {
      
    public static void main(String[] args){

        int[] arr1;

        // 인스턴스(instancs) or 객체(object) : new 명령으로 준비된 메모리
        arr1 = new int[3];

        //새 배열 메모리를 만들어 arr1에 그 주소를 저장하면, 기존 배열의 주소는  잃어 버린다. 그러면 기존 배열 메모리는 사용할 수 업슨ㄴ 상태가 되는데,  이렇게 메모리만 차지하고 사용할 수 없는 인스턴스를 "가비지(garbage)"라  부른다.
        arr1 = new int[5];

        // Garbage : 주소를 잃어버려 사용할 수 없는 상태의 인스턴스(객체)                    ->"Dangling Object"
        // Garbage Collector 
        //  - 가비지 메모리를 다시 사용할 수 있게 제거하는 프로그래밍
        

    }

}