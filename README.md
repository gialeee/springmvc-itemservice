# Spring MVC - 기본 기능
* [[인프런] 스프링 MVC 1편 - 섹션7. 스프링 MVC 웹 페이지 만들기](https://www.inflearn.com/course/lecture?courseSlug=%EC%8A%A4%ED%94%84%EB%A7%81-mvc-1&unitId=71207&tab=curriculum)
* 2023.12.15~18 실습 및 정리

### 프로젝트 생성
- Gradle Project
- Java (OpenJDK21)
- Spring Boot: 3.2.0
#### 프로젝트 메타데이터
- Group: hello.springmvc
- Artifact: itemservice
- Name: springmvc-project
- Package name: hello.springmvc.itemservice
- Dependencies
  - Spring Web
  - Thymeleaf
  - Lombok
- Packaging: Jar
> JSP를 사용하지 않아 War가 아닌 Jar 사용   
> Jar 사용 시 항상 내부 서버(톰캣 등)를 사용하여 내장 서버 사용에 최적화되어있음, `webapp` 경로 사용 x   
> -> War는 주로 외부 서버에 배포하는 목적으로 사용 
   
