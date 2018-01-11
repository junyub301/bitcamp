"use strict"

// 변수 선언의 호이스팅과 원리가 같다.
// plus 변수의 선언부만 호이스팅 되고,
// 나머지 익명 함수를 정의하여 plus 변수에 저장되는 부문은
// 그대로 그 위치에 있는다.
//console.log(plus(20, 30)) -> 실행 오류!

var plus = function(a, b) {
    return a + b
};

console.log(plus(20, 30))