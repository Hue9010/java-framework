# 프레임워크 구현
## 진행 방법
* 프레임워크 구현에 대한 요구사항 관리는 [웹백엔드JAVA 레벨4](https://nextstep.camp/courses/-KtTs-ZFzvIWITSLbp3r)에 확인할 수 있다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 요구사항
#### MVC 프레임워크
* [MVC 프레임워크 구현 1단계](https://nextstep.camp/courses/-KtTs-ZFzvIWITSLbp3r/-Kf9l9BNDgvymNo6IxDs/lessons)
* [MVC 프레임워크 구현 2단계](https://nextstep.camp/courses/-KtTs-ZFzvIWITSLbp3r/-Kf9lGDk0Vc5K7GvnqC3/lessons)
* [MVC 프레임워크 구현 3단계](https://nextstep.camp/courses/-KtTs-ZFzvIWITSLbp3r/-Kf9leY0VnZi2akOLdkW/lessons)

#### JDBC 라이브러리 구현


## 코드 리뷰 과정
> 저장소 브랜치에 자신의 github 아이디에 해당하는 브랜치가 존재해야 한다. 자신의 github 아이디에 해당하는 브랜치가 있는지 확인한다.
>
> 자신의 github 아이디에 해당하는 브랜치가 없는 경우 [브랜치 생성 요청](https://codesquad-members.slack.com/messages/C74HH4RJ8/) 채널을 통해 브랜치 생성을 요청한다.

----
1. 프로젝트를 자신의 계정으로 fork한다. 저장소 우측 상단의 fork 버튼을 활용한다.

2. fork한 프로젝트를 자신의 컴퓨터로 clone한다.
```
git clone https://github.com/{본인_아이디}/{저장소 아이디}
ex) https://github.com/javajigi/java-racingcar
```

3. clone한 프로젝트 이동
```
cd {저장소 아이디}
ex) cd java-racingcar
```

4. 본인 아이디로 브랜치를 만들기 위한 checkout
```
git checkout -t origin/본인_아이디
ex) git checkout -t origin/javajigi
```

5. commit
```
git status //확인
git rm 파일명 //삭제된 파일
git add 파일명(or * 모두) // 추가/변경 파일
git commit -m "메세지" // 커밋
```

6. 본인 원격 저장소에 올리기
```
git push origin 본인_아이디
ex) git push origin javajigi
```

7. pull request
* pull request는 github 서비스에서 진행할 수 있다.
* pull request는 반드시 original 저장소의 브랜치와 fork한 자신의 저장소 브랜치 이름이 같아야 하며, 브랜치 이름은 자신의 github 아이디여야 한다.

8. code review 및 push
* pull request를 통해 피드백을 받는다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.

## 앞의 코드 리뷰 과정은 [영상 보기](https://youtu.be/ZSZoaG0PqLg) 를 통해 참고 가능

## 실습 중 모든 질문은 [슬랙 채널](https://codesquad-members.slack.com/messages/C74FV4Q10/)에서...