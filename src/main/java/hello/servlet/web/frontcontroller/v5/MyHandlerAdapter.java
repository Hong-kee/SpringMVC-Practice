package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {

    //Handler는 Controller를 말한다.
    //Adapter가 해당 Controller를 처리할 수 있는지 판단하는 Method
    boolean supports(Object handler);

    //Adapter는 실제 Controller를 호출하고, 결과로 ModelView 반환
    //실제 컨트롤러가 ModelView를 반환 못하면 예외 터뜨리기
    //이전에는 FrontController가 실제 Controller를 호출했지만 이제는 이 Adapter를 통해서 실제 Controller가 호출
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
}
