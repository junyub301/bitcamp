

// 빈 객체를 초기화시키는 정보를 넘겨준다.
var obj = Object.create(Object.prototype);

// Object 객체에 들어있는 기본 정보를 객체를 생성할 때 넘겨주면,
// 최소한 다음의 함수들이 들어있다.
console.log(obj)
console.log("-------------------------------")
console.log(obj.toString())
console.log("-------------------------------")
console.log(obj.valueOf())