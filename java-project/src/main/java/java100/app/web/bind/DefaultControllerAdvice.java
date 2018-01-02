package java100.app.web.bind;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

//방법2 : @ControllerAdvice 클래스에 둔다.
// @ControllerAdvice?
//  => 페이지 컨트롤러를 실행하는 데 추가적인 도움을 제공하는 클래스에 붙인다.
//  => 이 애노테이션이 붙은 클래스는 페이지 컨트롤러의 요청 핸들러를 호출하기 전에 
//     이 클래스에 포함된 메서드를 적절하게 호출하여 작업을 수행한 후
//     요청 핸들러를 호출한다.

// 충고의 대상을 지정할 수 있다.
//  - annotations : 특정 애노테이션들이 붙은 페이지 컨트롤러.
//  - basePackages : 특정 패키지나 그 하위 패키지에 소속된 페이지 컨트롤러들.
//  - value : basePakages와 같다.
//  - assignableTypes : 특정 타입의 페이지 컨트롤러들

@ControllerAdvice // 모든 페이지 컨트롤러에 충고한다.
public class DefaultControllerAdvice {

    // @InitBinder를 이 클래스에 두면 특정 컨트롤러가 아닌
    // 충고하기를 원하는 모든 컨트롤러에 적용할 수 있어 편리하다.
    // 즉 문자열을 날짜 타입으로 바꾸기를 원하는 컨트롤러 마다
    // 이 메서드를 추가할 필요가 없다.
    
    @InitBinder // 요청 핸들러가 호출되기 전에 먼저 실행된다.
    protected void initBinder(WebDataBinder binder) {
        System.out.println("DefaultControllerAdvice.initBinder()");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

}
