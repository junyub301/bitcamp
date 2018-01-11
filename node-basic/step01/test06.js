

"use strict"

var name = "홍길동" // OK


    
function test() {
    var name2;
    
    name = "임꺽정"; // 모듈 번수에 저장한다.
    name2 = "유관순"; // 로컬 변수에 저장한다.
    
}

test()

console.log(name)
console.log(name2) // 로컬 변수는 함수 호출이 끝나면 제거된다.