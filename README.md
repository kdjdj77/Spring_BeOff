# Spring Project - BeOff

팀명 : 떠나자

팀장 : 김대진

팀원 : 김재윤, 노진수, 안일찬, 이수민, 진하륜

주제 : 여행 패키지

프로젝트 발표 url : 

★처음 프로젝트 실행 시 해야 할 것

0. db 설정할 것
    (db name : travel
    id	 : beoff
    pw   : 1234)

    DB 설정
      mysql -u root -p
      CREATE DATABASE travel default CHARACTER SET UTF8;
      CREATE USER 'beoff'@'localhost' IDENTIFIED BY '1234';
      GRANT ALL PRIVILEGES ON travel.* TO 'beoff'@'localhost';
      FLUSH PRIVILEGES;

1. dbeaver 설정 (db 설정한 대로)
