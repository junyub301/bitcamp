package bitcamp.java100.ch02;
public class Test11_10 {

    public static void main(String[] args) {

        // 고정 소수점의 값 크기
        // IEEE-754 규칙에 따라 부동소수점을 2진수로 바꾸기 때문에 정확히 음수     어디에서 양수 어디까지, 소수점 이상/이하 몇자리라고 말할 수 없다.
        // -> 즉, 소수점을 뺀 나머지 숫자의 개수를 몇 개 까지 정확하게 저장할         수 있는지 말하는 것이다. 
        
        // 1) 32비트 단정도 메모리 -> 유효자리 : 7자리
        //   -> 즉, 소수점을 제외한 7자리 수를 정상적으로 저장 할 수 있다.
        // 7자리의 수는 거의 다 정상으로 저장될 가능성이 높고 그이상의 자릿수가    되면 정확한 값이 저장 안될 가능성이 높다.
        System.out.println(9876567f);
        System.out.println(98765678f);
        System.out.println(9876.567f);
        System.out.println(9876.5678f);

        // 2) 64비트 배정도 메모리 -> 유효자리 : 15자리
        //   -> 소수점을 제외한 15자리 수를 정상적으로 저장 할 수 있다.
        //   -> 단정도보다 두배 정도 더 정밀한 값을 저장할 수 있다.
        System.out.println(98765678);
        System.out.println(9876.5678);


    }

}



  /*
  REPL
  Read
  Evaluate
  Print
  Loop */