# SpringMVC_Practice

SpringBoot 기반으로 연습해보는 회원가입 Project입니다.
> 기능보단 MVC의 설계, Annotation을 쓰면 왜 편리하고 그것을 쓰기 전까지 직접 만들어보는 '공부용' 입니다.
> 인프런의 김영한 님의 강의인 '스프링 MVC 1편'을 보고 정리한 내용입니다.
> https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-mvc-1/dashboard

*Description*

> HTTP API Parsing, Servlet, JSP, Thymeleaf, MVC Pattern 등을 연습해봅니다.

*Environment*

> IntelLiJ
> 
> Java 11
> 
> Gradle

*Period*

> Start : ***2021/12/02~***
> 
> End : ***~ing***

***2021/12/02***
> Servlet과 JSP 학습 -> JSP에서 스파게티 코드로 인해 MVC 패턴의 필요성을 느꼈다. 따라서 Controller에서 Model에 값을 실어서 View를 해주는 JSP를 만들어야 된다.
>
***2021/12/03***
> MVC를 통해서 각 역할을 부여, 할당 받은 역할만 수행하도록 만들었다. 하지만 forward, viewPath, Dispatcher 등 중복 코드들이 많다. 이러한 부분들을 공통 처리하여 Class로 Module화 시킨다해도 호출을 해야하는건 똑같다. 따라서 Controller 앞에 Filter역할을 하는 Front Controller의 역할이 필요하다. prefix, suffix를 Front Controller를 통해 공통 처리를 해야 한다.
> 
![image](https://user-images.githubusercontent.com/69206748/144590143-36c9faae-bfc3-4688-a315-77f78d77ed5a.png)
>
> * Controller V1 (Version1) -Front Controller 처음 도입-
>
> ![image](https://user-images.githubusercontent.com/69206748/144594981-ee47c4ee-fb6d-48fd-b53d-9d177e4bda6d.png)
>
>
> * Controller V2 (Version2) -각 Controller에 있던 View를 따로 분리해서 MyView 클래스에 설정-
>
> ![image](https://user-images.githubusercontent.com/69206748/144595087-4267fdd6-a1be-4600-b68d-230309eab06c.png)
>
>
> * Controller V3 (Version3) -ModelView객체를 따로 만들어서 viewResolver를 통해 논리 이름을 물리 이름으로 바꿔주는 형식을 채용.
> 
> ![image](https://user-images.githubusercontent.com/69206748/144620818-052e13a0-3149-4aa0-afde-46b87c513450.png)
>
***2021/12/04***
> * Controller V4 (Version4) -기존 ModelView객체를 만들어서 반환했던 것이 불편했다. 좋은 프레임워크는 아키텍처도 중요하지만, 그와 더불어 실제 개발하는 개발자가 단순하고 편리하게 사용할 수 있어야 한다. 소위 실용성이 있어야 한다. 따라서 ModelView를 반환하지 않고, ViewName 즉, 논리 이름만 반환한다.-
> 
> ![image](https://user-images.githubusercontent.com/69206748/144702739-577e7703-5f1d-4033-b3ea-09d3cab601e7.png)
>
>
> * Controller V5 (Version5) -Controller Version을 진화시키면서 풀지 못한 숙제가 있었다. 현재 구현되어있는 것이 V3인데 V4로 바꾸고 싶다면 어떻게 해야할까? 현재 구현되어 있는 코드를 사용한다면 ControllerV3, ControllerV4같이 구체적인 Controller를 Mapping해주었기 때문에 유연성이 매우 떨어진다. 따라서 "Adapter Pattern"을 채용하기로 했다. View단은 그대로 가져가되, Controller부분을 좀 더 유연하게 하기 위해 HandlerAdapter를 만들 것이고 그것을 가져오기 위해 Object형식의 HandlerMappingMap을 구현할 것이다. 비유를 하자면, 110V와 220V의 Handler가 있는데 110V를 220V로 바꿔야 한다고 하자. 그렇다면 110V를 가져와서 HandlerAdapter를 통해 220V로 변경해서 주겠다는 소리다. HandlerAdapter는 MyHandlerAdapter Interface를 구현한 각 구현 Handler이다. 따라서 유연한 변경이 가능하다.-
>
> ![image](https://user-images.githubusercontent.com/69206748/144705864-d319d58e-258e-4508-b8b1-62c1c95b3d38.png)
>
***2021/12/05***
> * 실제 Spring MVC 구조 -우리가 구현했던 Controller V5는 사실 Spring MVC의 구조와 매우 흡사한 구조이다. 다음과 같은 그림을 보면 이해할 수 있을 것이다.-
>
> ![image](https://user-images.githubusercontent.com/69206748/144743951-a9aa0e40-e115-4598-9d6f-885a1cb4b262.png)
>
> * 동작 순서
> 1. 핸들러 조회 : 핸들러 매핑을 통해 요청 URL에 매핑된 핸들러(컨트롤러)를 조회한다.
> 2. 핸들러 어댑터 조회 : 핸들러를 실행할 수 있는 핸들러 어댑터를 조회한다.
> 3. 핸들러 어댑터 실행
> 4. 핸들러 실행 : 핸들러 어댑터가 실제 핸들러를 실행한다.
> 5. ModelAndView 반환 : 핸들러 어댑터는 핸들러가 반환하는 정보를 ModelAndView로 변환해서 반환한다.
> 6. viewResolver 호출 : 뷰 리졸버를 찾고 실행한다.(JSP의 경우 InternalResourceViewResolver가 자동 등록되고 사용된다.)
> 7. View 반환 : 뷰 리졸버는 뷰의 논리 이름을 물리 이름으로 바꾸고, 렌더링 역할을 담당하는 뷰 객체를 반환한다.(JSP의 경우 InternalResourceView(JstlView)를 반환하는데, 내부에 forward() 로직이 있다.
> 8. 뷰 렌더링
>
***2021/12/06***
> 개인적인 일로 휴식
***2021/12/07***
> 개인적인 일로 휴식
