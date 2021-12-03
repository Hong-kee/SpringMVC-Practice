# SpringMVC_Practice

SpringBoot 기반으로 연습해보는 Project입니다.

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