# KNU 도서관리 시스템
## 테이블 생성 및 테스트 데이터 삽입
- 루트 폴더의 `dbinit.sql`을 DBEaver에서 전체 실행해주세요. DB는 `mydb`를 사용합니다.
## E-R 다이어그램
![erd](https://github.com/KNU-DBP-2023-1/library/assets/70526479/d0e91c22-726e-4049-97ee-c87873f1c768)

## 테스트 데이터 목록
- id: 1 / title: 책제목1 / author:	작가1 / publisher: 출판사1	/ onRent: false / userid: null
- id: 2 / title: 책제목2 / author:	작가2 / publisher: 출판사2	/ onRent: false / userid: null
- id: 3 / title: 책제목3 / author:	작가3 / publisher: 출판사3	/ onRent: false / userid: null
- id: 4 / title: 책제목4 / author:	작가4 / publisher: 출판사4	/ onRent: false / userid: null
- id: 5 / title: 책제목5 / author:	작가5 / publisher: 출판사5	/ onRent: false / userid: null
## 테스트 계정 목록
- id: test1 / pw: test! / name: testname1
- id: test2 / pw: test! / name: testname2
- id: test3 / pw: test! / name: testname3

## Git 브랜치 전략(규칙)
- **`main`브랜치는 팀원들이 작업한 브랜치를 병합하고 배포하는 용도로만 사용합니다.**
- **팀원들은 본인의 브랜치에서 기능을 개발합니다.** 예시) `git switch <브랜치명>`
- 기능을 개발하기 전 반드시 **자신의 브랜치**에서 `git pull origin main`을 실행합니다.
- 기능 개발을 마쳤다면 `git add .` `git commit -m "<메시지>"` `git push origin <브랜치명>` 합니다.
- GitHub에서 **Pull Request**를 올리고 본인이 작업한 내용은 본인이 **직접 Merge** 합니다.