"use strict"


function play(a, b, fn) {
    fn(a, b);
}

function plus(a, b) {
    // log는 ,로 나열하면 그대로 한줄로 출력한다.
    console.log(a, '+', b, '=', a + b)
}

function minus(a, b) {
    console.log(a, '-', b, '=', a - b)
}

// 함수를 호출할 때 아규먼트로 함수를 넘겨준다.
play(10, 20, plus)
play(200, 150, minus)