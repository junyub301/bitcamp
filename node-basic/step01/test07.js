

"use strict"

var v1 = 100;
 {
     var v2 = 200; // 이 변수도 모듈 변수(이 파일에 소속된 변수)이다
 }
 
 console.log(v1)
 console.log(v2)
 

function test() {
     var a = 100;
     
     {
         var b = 200; // 함수의 로컬 변수이다. 블록은 무시된다.
         
     }
     console.log(v1)
     console.log(v2)
     
     console.log(a)
     console.log(b)
 }
 
 
console.log("-------------------------------------")

test()