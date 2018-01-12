"use strict"


function play(a, b, fn) {
    fn(a, b);
}


// 함수를 전달할 때 단 한번만 사용할 함수라면
// 익명함수를 정의하여 그 주소를 전달하라!
play(10, 20, function plus(a, b) {console.log(a, '+', b, '=', a + b)})
play(200, 150, function minus(a, b) {console.log(a, '-', b, '=', a - b)})

try{
    
 plus(15,25) // 함수를 호출할 때 아규먼트 자리에서 정의한 함수는
             // 따로 사용할 수 없다.
} catch (err) {
    console.log(err)
}

play(10, 20, function(a, b) {
    console.log(a, '+', b, '=', a + b)
});

play(200, 150, function(a, b) {
    console.log(a, '-', b, '=', a - b)
});