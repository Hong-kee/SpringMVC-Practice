package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1. 파라미터 전송 기능
 * 2. http://localhost:8080/request-param?username=hello&age=20
 */

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("[Read All Parameters] -- Start");

        request.getParameterNames().asIterator().
                forEachRemaining(paramName -> System.out.println(paramName + "=" + request.getParameter(paramName)));


        System.out.println("[Read All Parameters] -- End");
        System.out.println();

        System.out.println("[Read Each Parameter] -- Start");

        String username = request.getParameter("username");
        String age = request.getParameter("age");

        System.out.println("username = " + username);
        System.out.println("age = " + age);

        System.out.println("[Read Each Parameter] -- End");
        System.out.println();

        System.out.println("[Read Same Name Parameter] -- Start");

        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("name = " + name);
        }
        response.getWriter().write("OK");

        System.out.println("[Read Same Name Parameter] -- End");
        System.out.println();
    }
}
