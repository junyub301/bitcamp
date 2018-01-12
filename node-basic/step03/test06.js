

var obj = new Object();

obj.name = "홍길동"; 
obj.age = 20;
obj.plus = function(a, b) {
    console.log(a + b)
}
obj.working = false;

if (obj.hasOwnProperty('age')) {
    console.log('age 있다!')
}

if (obj.age) { // 객체에 age 값이 있으면 true이다.
    console.log('age 있다!')
}

if (obj.hasOwnProperty('tel')) {
    console.log('tel 있다!')
}

if (obj.tel) { 
    console.log('tel 있다!')
}
// 다음과 같이 조건문에 객체의 프로퍼티를 지정하여 존재 여부를 검사할 수 있다.
// 만약 해당 변수의 값이 false라면 
// 존재하지 않는 걸로 오해할 수 있기 때문에 
// 일반 변수에 대해서는 다음방식을 사용하지 않는다.

if (obj.hasOwnProperty('age')) {
    console.log('age 있다!')
}

if (obj.working) { // 객체에 age 값이 있으면 true이다.
    console.log('working 있다!')
}


// 주로 이 방법은 함수의 존재 여부를 검사할 때 사용한다.
if (obj.plus) {
    obj.plus(10,20)
}
if (obj.minus) {
    obj.minus(10,20)
}