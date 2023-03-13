# spring boot
doc + 탭 기본 html 코드 작성


## MVC 
클라이언트로 부터 컨트롤러가 요청받고
뷰는 최종페이지 만들어주고
모델은 최종페이지에서 쓰일 데이터를 뷰에 전달


---
## CRUD(8강)

Create  
	폼데이터 주고받기
	어디로 보낼지(Action) 어떻게 보낼지(Method)
	폼 데이터를 받아올 그릇 / 객채로 담아서 보낸다(DTO)
	
Read  
Update  
Delete  

---

## JPA
DB에 대이터를 기록하려면… DB는 자바를 모른다. 이를 위한 도구가 JPA다.  
DTO > Entity(Repository) > Table

컨트롤러에서..  
DTO를 Entity로 변환(Entity타입 > Entity 변환)  
Repository 에게 Entity를 DB안에 저장하게 함.