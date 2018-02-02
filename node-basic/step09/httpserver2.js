
const http = require('http'); 

const server = http.createServer(function(req, resp) {
    resp.writeHead(
            '200', // 응답 상태 코드
            { // 응답 헤더
                'Content-Type':'text/html;charset=UTF-8',
                'Access-Control-Allow-Origin': '*'
            });
    
    // 클라이언트에게 HTML 조각을 전달한다.
    resp.write('<p style="background-color: gray; color: white;">');
    resp.write('자바100기</p>')
    resp.end(); 

});
// 3) 서버 실행
// listen(포트번호,[IP 주소],[서버가 실행되었을 때 호출될 함수])
server.listen(8888, function() {
    console.log("서버 실행 중 ...")
});