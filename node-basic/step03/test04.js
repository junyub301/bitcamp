

var obj = new Object();

obj['name'] = "홍길동"; 
obj["age"] = 20;
obj["home tell"] = "1111-1111";
obj['office tel'] = '2222-2222';
obj['plus'] = function(a, b) {
    console.log(a + b)
}
obj['working'] = true;

console.log(obj['name'])
console.log(obj['age'])
console.log(obj['home tell'])
console.log(obj['office tel'])
console.log(obj['working'])
obj['plus'](10,20)