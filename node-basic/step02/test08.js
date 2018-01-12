"use strict"

function generator(interest) { // 파라미터도 로컬 변수이다.

    // 클로저에서 바깥 함수의 로컬 변수를 사용한다면,
    // 클로저는 리턴될 때 자신만의 메모리 공간에 
    // 그 바깥 변수를 복제해 둔다.
    return function(money, year) {return money + ((money * interest) * year)};
}

var f1= generator(0.02)
var f2= generator(0.08)


// f1(), f2()를 호출할 때는 f1(), f2()에서 참조하는 바깥 함수의
// interest 변수는 존재하지 않는다.
// 실행되는 방법?
// -> 각 closure가 자신만의 공간에 별도로 복제해둔 변수를 사용하기 때문

console.log(f1(80000000, 1))
console.log(f2(80000000, 1))