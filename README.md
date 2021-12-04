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

> Start : 2021/12/02 ~
> 
> End : ~ing

2021/12/02
> Servlet과 JSP 학습 -> JSP에서 스파게티 코드로 인해 MVC 패턴의 필요성을 느꼈다. 따라서 Controller에서 Model에 값을 실어서 View를 해주는 JSP를 만들어야 된다.
>
2021/12/03
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
2021/12/03
> * Controller V4 (Version4) -기존 ModelView객체를 만들어서 반환했던 것이 불편했다. 좋은 프레임워크는 아키텍처도 중요하지만, 그와 더불어 실제 개발하는 개발자가 단순하고 편리하게 사용할 수 있어야 한다. 소위 실용성이 있어야 한다. 따라서 ModelView를 반환하지 않고, ViewName 즉, 논리 이름만 반환한다.-
> 
> ![image](https://user-images.githubusercontent.com/69206748/144702739-577e7703-5f1d-4033-b3ea-09d3cab601e7.png)
>
>
