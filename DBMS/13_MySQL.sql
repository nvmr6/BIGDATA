-- 계정 생성, 권한 부여, 권학 박탈, 계정 삭제
-- DDL(제약조건, 시퀀스 없음), DML(OUTER JOIN, AND &&, OR || )

show tables;
show databases;
-- DCL
create user user01 identified by 'password';
grant all on *.* to user01; -- DBA권한 부여
flush privileges;
revoke all on *.* from user01; -- 권한 박탈
drop user user01; -- 계정 삭제

-- DDL
show databases;
create database kimdb; -- 새로운 데이터 베이스 생성
show databases;
use kimdb; -- 데이터 베이스로 들어감
select database(); -- 현재 데이터 베이스

create table emp(
	empno numeric(4) primary key,
    ename varchar(20) not null,
    nickname varchar(20) unique,
    sal numeric(7,2) check(sal>0),
    hiredate datetime default now(),
    comm numeric(7,2) default 0
);
drop table if exists emp;
create table emp(
	empno numeric(4),
    ename varchar(20) not null,
    nickname varchar(20),
    sal numeric(7,2),
    hiredate datetime default now(),
    comm numeric(7,2) default 0,
    primary key(empno),
    unique(nickname),
    check(sal>0)
);
insert into emp (empno, ename, nickname, sal)
	values (1111,'kim', 'he', 7000);
    
create table major(
	mCode int primary key auto_increment,-- 시퀀스
    mName varchar(20),
    mOffice varchar(30)
);

create table student(
    sNo int primary key,
    sName varchar(20) not null,
    mCode int references major(mCode)
);


insert into major (mName, mOffice) values ('컴퓨터', '704호');
insert into major (mName, mOffice) values ('전자', '705호');
insert into major (mName, mOffice) values ('기계', '706호');
insert into major (mName, mOffice) values ('화공', '707호');

select * from major;

insert into student values (1111, 'kim', 1);
insert into student values (1112, 'lee', 2);
insert into student values (1113, 'jung', 2);
insert into student values (1114, 'han', 5); -- 입력 가능 > foreign key 연결 에러

drop table if exists student;
drop table if exists major;

create table major(
	mCode int primary key auto_increment,-- 시퀀스
    mName varchar(20),
    mOffice varchar(30)
);

create table student(
    sNo int primary key,
    sName varchar(20) not null,
    mCode int,
    foreign key(mCode) references major(mCode)
);

insert into major (mName, mOffice) values ('컴퓨터', '704호');
insert into major (mName, mOffice) values ('전자', '705호');
insert into major (mName, mOffice) values ('기계', '706호');
insert into major (mName, mOffice) values ('화공', '707호');

select * from major;

insert into student values (1111, 'kim', 1);
insert into student values (1112, 'lee', 2);
insert into student values (1113, 'jung', 2);
insert into student values (1114, 'han', 5); -- 입력 오류, increment

select sNo, sName, mName, m.mCode from major m, student s
	where m.mCode = s.mCode;
select sNo, sName, mName, m.mCode, mName, mOffice from student s right outer join major m
	on m.mCode = s.mCode;
    
-- JDBC(JAVA)
drop table if exists personal;
drop table if exists division;

create table division(
	dno int,
    dname varchar(20),
    phone varchar(20),
    position varchar(20),
    primary key(dno)
);

create table personal(
	pno int,
    pname varchar(20) not null,
    job varchar(20) not null,
    manager int,
    startdate date,
    pay int,
    bonus int,
    dno int,
    primary key(pno),
    foreign key(dno) references division(dno)
);
select * from division;
select * from personal;

insert into division values (10, 'finance', '02-569-1009', '신촌');
insert into division values (20, 'research', '02-559-1008', '합정');
insert into division values (30, 'sales', '02-578-1007', '이대');
insert into division values (40, 'marketing', '02-521-1006', '상수');
commit;
insert into personal values (1111,'smith','manager', 1001, '1990-12-17', 1000, null, 10);
insert into personal values (1112,'ally','salesman',1116,'1991-02-20',1600,500,30);
insert into personal values (1113,'word','salesman',1116,'1992-02-24',1450,300,30);
insert into personal values (1114,'james','manager',1001,'1990-04-12',3975,null,20);
insert into personal values (1001,'bill','president',null,'1989-01-10',7000,null,10);
insert into personal values (1116,'johnson','manager',1001,'1991-05-01',3550,null,30);
insert into personal values (1118,'martin','analyst',1111,'1991-09-09',3450,null,10);
insert into personal values (1121,'kim','clerk',1114,'1990-12-08',4000,null,20);
insert into personal values (1123,'lee','salesman',1116,'1991-09-23',1200,0,30);
insert into personal values (1226,'park','analyst',1111,'1990-01-03',2500,null,10);
commit;
-- ex)
-- 1. 사번, 이름, 급여를 출력
select pno, pname, pay from personal;
-- 2. 급여가 2000~5000 사이 모든 직원의 모든 필드
select * from personal
	where pay between 2000 and 5000;
-- 3. 부서번호가 10또는 20인 사원의 사번, 이름, 부서번호
select pno, pname, dno from personal
	where dno = 10 || dno = 20;
-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬
select pno, pname, pay from personal
	where bonus is null
    order by pay desc;
-- 5. 사번, 이름, 부서번호, 급여. 부서코드 순 정렬 같으면 PAY 큰순
select pno, pname, dno, pay from personal
	order by dno,pay desc;
-- 6. 사번, 이름, 부서명
select pno, pname, dname from personal p, division d
	where p.dno = d.dno;
-- 7. 사번, 이름, 상사이름
select w.pno, w.pname, m.pname from personal w, personal m
	where w.manager = m.pno;
-- 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력)
select w.pno, w.pname, m.pname from personal w left outer join personal m
	on w.manager = m.pno;
select w.pno, w.pname, ifnull(m.pname, 'no manager') from personal w left outer join personal m
	on w.manager = m.pno;
select w.pno, w.pname, if(m.pname is null, 'no manager', m.pname) from personal w left outer join personal m
	on w.manager = m.pno;
-- 9. 이름이 s로 시작하는 사원 이름
select pname from personal
	where pname like 's%';
-- 10. 사번, 이름, 급여, 부서명, 상사이름
select w.pno, w.pname, w.pay, dname, m.pname from personal w, personal m, division d
	where w.manager = m.pno and w.dno = d.dno;
-- 11. 부서코드, 급여합계, 최대급여
select dno, sum(pay), max(pay) from personal
	group by dno;
-- 12. 부서명, 급여평균, 인원수
select dname, round(avg(pay)), count(*) from personal p, division d
	where p.dno = d.dno
    group by dname;
-- 13. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력
select dno, sum(pay), count(*) from personal
	group by dno
    having count(*) >= 4;
-- 14. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람
select pno, pname, pay from personal
	where pay in (select max(pay) from personal);
-- 15. 회사 평균보다 급여를 많이 받는 사람 이름, 급여, 부서번호
select pname, pay, dno from personal
	where pay > (select avg(pay) from personal);
-- 16. 14번에 부서명을 추가하고 부서명순 정열 같으면 급여 큰순
select pno, pname, pay, dname from personal p, division d
	where pay = (select max(pay) from personal)
    and p.dno = d.dno;
-- 17. 자신이 속한 부서의 평균보다 많인 받는 사람의 이름, 금여, 부서번호, 반올림한 해당부서평균
select pname, pay, p.dno, a.avg  from personal p, (select dno, round(avg(pay)) avg from personal group by dno) a
	where pay > a.avg and p.dno = a.dno;
-- 18. 입사가 가장 빠른 사람의 이름, 급여, 부서명
select pname, pay, dname from personal p, division d
	where startdate in (select max(startdate) from personal)
    and p.dno = d.dno;
-- 19. 이름, 급여, 해당부서평균
select pname, pay, a.avg  from personal p, (select dno, avg(pay) avg from personal group by dno) a;
-- 20. 이름, 급여, 부서명, 해당부서평균
select pname, pay, dname, a.avg  from personal p, division d, (select dno, avg(pay) avg from personal group by dno) a
	where p.dno = d.dno;

-- 단일행 함수 <mysql 컬럼 함수>
select concat(pname, '은 ', job, '다.') from personal; -- 계속 연결 가능
select round(356.98,1); -- from 생략가능
select year(startdate), month(startdate), monthname(startdate), dayname(startdate) from personal;
-- 현재시간 2021/01/05 16:05 > %y:21 %Y:2021 %M:january %m:01 %b:jan %c:1 %e:5 %d;05 %H:16 %h:04 p:pm %i:05 %s:24
select date_format(now(), '%y년 %c월 %d일 %p %h시 %i분 %s초'); 
select sysdate(), now();
select format(pay,1) from personal;
select pname, pay, if(pay>=3000, 'higher', 'lower') from personal;

-- top n 구문
select pname, pay from personal order by pay desc;
select pname, pay from personal order by pay desc limit 5;-- 5등까지
select pname, pay from personal order by pay desc limit 3,3;