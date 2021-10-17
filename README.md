## GMakers-Android

 개발자들의 전적 또는 자신을 소개할 수 있는 카드를 만들 수 있는 모바일 어플리케이션

<img width="400" alt="스크린샷 2021-09-20 오전 9 18 17" src="https://user-images.githubusercontent.com/66577589/133947843-9f7f1a0f-e686-47b7-932f-9b66f67e1c35.png"><img width="400" alt="스크린샷 2021-09-20 오전 9 18 06" src="https://user-images.githubusercontent.com/66577589/133947883-38fd480b-dab1-42ca-af1f-7713dd46c56d.png">
<img width="400" alt="스크린샷 2021-09-20 오전 9 17 04" src="https://user-images.githubusercontent.com/66577589/133947897-0a383c79-94dd-4f8b-94c3-67344767bc9d.png">
<img width="400" alt="스크린샷 2021-09-20 오전 9 17 17" src="https://user-images.githubusercontent.com/66577589/133947906-324f2688-5a2e-4aff-8504-b987646ed4b7.png">
<img width="400" alt="스크린샷 2021-09-20 오전 9 17 27" src="https://user-images.githubusercontent.com/66577589/133947939-025b0974-eea3-401a-acf1-6628f8651490.png">
<img width="400" alt="스크린샷 2021-09-20 오전 9 17 47" src="https://user-images.githubusercontent.com/66577589/133947951-8fba7cda-d614-4f23-81d9-04c50f5152ea.png">
<img width="400" alt="스크린샷 2021-09-20 오전 9 17 36" src="https://user-images.githubusercontent.com/66577589/133947964-28061365-45b9-4ca5-92a7-e6928f8378b7.png">



### ``` 기술스택```

언어 :  ```Kotlin```
  <br>
아키텍쳐 :``` MVVM```
  <br>
라이브러리 :  ```Retrofit2```, ```Android Jetpack libraries```



###  ``` 개발규칙```
모든 개발은 master branch가 아닌 ```feature```에서 진행하며, 개발 완료시 ```develop```으로 merge 한다.
</br>
Resource는 아래 해당 사항에 맞추어 사용한다.

#### drawable
`[what_description_where]`
<br>
where은 여러곳에 사용되면 쓰지 않습니다.
<br>
icon -> ic, background -> back  (what)
<br>
ex) ic_list, back_broder_black
<br>
 
#### layout
`[what_description]`
<br>
ex) activity_main, fragment_chatting
  
#### ID
`[what_description]`
<br>
 textview -> tv, editText -> et, button -> btn, customview → cv 등등등 줄여서 사용
 <br>
 ex) `intro_tv`, `submit_btn`

  
#### colors.xml
color[What] 으로 작성하여 사용합니다.
<br>



### ```	Git 관련   ```

  ##### 	커밋 메시지 컨벤션 
  
  ```[UPDATE]``` — 신규파일 추가 또는 코드 변경시
  <br>
  ```[REFACTOR]``` — 코드를 리팩토링시
    <br>
  ```[FIX]``` — 잘못된 링크 정보 변경, 필요한 모듈 추가 및 삭제시
    <br>
  ```[REMOVE]``` — 파일 제거시
    <br>
  ```[STYLE]``` — 디자인 관련 변경사항시
    <br>
    <br>
 커밋 메시지는 최대한 상세하게 적어서 그 목적을 알게 한다


<br>

```CodeReview``` 또는 ```issue```는 환영입니다
