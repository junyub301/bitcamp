"use strict"

function generator(interest) { // 파라미터도 로컬 변수이다.
    // 함수 안에 정의된 내장 함수를 "closure"라 부른다.
    return function(money, year) {return money + ((money * interest) * year)};
}

var f1= generator(0.02)
var f2= generator(0.08)

console.log(f1(80000000, 1))
console.log(f2(80000000, 1))