

var obj = new Object();

// 객체 생성 과정
// 1) 빈 객체를 생성한 후 Object()함수를 호출한다.
// 2) Object() 함수는 prototype에 들어있는 값과 함수를 사용할 수 있도록
//    빈 객체를 초기화 시킨다.
//    =>이때 객체에 추가된 값이나 함수 등을 "프로퍼티(property)"라 부른다.
// 3) 객체 주소를 리턴한다.


console.log(obj)
console.log("-------------------------------")
console.log(obj.toString())
console.log("-------------------------------")
console.log(obj.valueOf())