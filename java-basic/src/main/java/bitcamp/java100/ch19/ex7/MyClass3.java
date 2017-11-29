package bitcamp.java100.ch19.ex7;


// 프로퍼티 이름이 "value"일 경우 값을 설정할 때 이름을 생략할 수 있다.
// 다른 이름의 프로퍼티는 안된다. 반드시 value일때만 생략이 가능하다.
// 단 다른 프로퍼티의 값도 함께 지정할 때는 이름을 생략할 수 없다.
//@MyAnnotation1("오호라! ㅋㅋ", value3=300) -> 오류 

@MyAnnotation1(value = "오호라ㅋㅋ!", value3 = 300)
public class MyClass3 {

}
