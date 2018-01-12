"use strict"

function f1() {
    console.log("f1().....")
}
// 익명 함수
var f2 = function() {
    console.log("f2().....")
}

// 애로우 함수 = 람다 함수
var f3 = () => {
    console.log("f3().....")
}

f1()
f2()
f3()

console.log("---------------------------")


function play(a, b, fn) {
    fn(a, b);
}


play(10, 20, function(a, b) {
    console.log(a, '+', b, '=', a + b)
});

play(200, 150, function(a, b) {
    console.log(a, '-', b, '=', a - b)
});