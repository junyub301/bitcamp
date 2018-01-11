"use strict"

// 밑에 함수 정의코드가 먼저 실행된 후 다음 문장이 실행된다.
// 따라서 f1() 함수를 호출할 수 있다.
result = f1(10, 20)
console.log(result)


// 변수 선언도 함수 호이스팅 처럼 위로 끌어올려져 먼저 실행된다.
var result;

function f1(a, b) {
    return a + b
}