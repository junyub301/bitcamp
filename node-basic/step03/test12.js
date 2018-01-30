// 객체 - prototype

// 생성자로 초기화된 객체들이 저장하는 저장소

// prototype 사용전
function Calculator() {
    // 모든 생성자 역할을 하는 함수는 상위 prototype이 Object()이다.
    // 모든 생성자의 최상위 생성자는 Object이다.
    // 이 생성자가 호출되기전에 먼저 Object()가 호출 된다.
    
    this.result = 0;
    this.plus = function(value) {
        // this를 생략하면 인스턴스변수가 아닌 로컬변수가 되기 때문에 
        // this를 생략해서는 안된다.
        this.result += value;
    }
    this.minus = function(value) { 
        this.result -= value;
    }
}

// 객체 생성 과정
// 1) 빈 객체 생성
// 2) Object() 함수가 호출되어 기본 프로퍼티가 추가된다.
// 3) Calculator() 함수가 호출되어 기타 프로퍼티가 추가된다.
var c1 = new Calculator();

c1.plus(10);
c1.plus(20);
c1.minus(7);
console.log(c1.result);










