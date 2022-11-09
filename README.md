# Spring Project - BeOff

팀명 : 떠나자

팀장 : 김대진

팀원 : 김재윤, 노진수, 안일찬, 진하륜

주제 : 여행 패키지

프로젝트 발표 url : 

사이트 주소 : http://localhost:8081/home

★처음 프로젝트 실행 시 해야 할 것

1. db 설정할 것

    DB 설정
      mysql -u root -p
      
      비밀번호 입력
      
      CREATE DATABASE beoff default CHARACTER SET UTF8;
      CREATE USER 'beoff'@'localhost' IDENTIFIED BY '1234';
      GRANT ALL PRIVILEGES ON beoff.* TO 'beoff'@'localhost';
      FLUSH PRIVILEGES;

2. dbeaver 설정

    db  : beoff
    
    id  : beoff
    
    pw  : 1234
    
    allowPublicKeyRetrieval=true
   
3. 테이블 + 더미데이터 생성
    
    1) application.properties 에서 spring.jpa.hibernate.ddl-auto=create 로 수정
    2) src/test/java/com/lec/repository/RepositoryTest 를 JUnitTest로 실행
    3) application.properties 에서 spring.jpa.hibernate.ddl-auto=update 로 수정
    4) src/test/java/com/lec/repository/RegionTest 를 JUnitTest로 실행
    5) src/test/java/com/lec/repository/AirTest 를 JUnitTest로 실행
    6) src/test/java/com/lec/repository/HotelRepositoryTest 를 JUnitTest로 실행
    7) src/test/java/com/lec/repository/CarRepositoryTest 를 JUnitTest로 실행

