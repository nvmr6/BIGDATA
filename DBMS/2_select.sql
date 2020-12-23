--[2] Select
--1. SQL작성
SELECT * FROM TAB; -- SCOTT계정이 가진 테이블들 리스트
SELECT * FROM DEPT;-- DEPT테이블의 모든 열, 모든 행(* > 모든 열)
SELECT * FROM EMP;-- EMP테이블의 모든 열, 모든 행
DESC DEPT;-- DEPT 테이블의 구조(ORACLE)

--2.SQP문장 실행 (특정열)
SELECT * FROM EMP;
SELECT EMPNO, ENAME, SAL, JOB FROM EMP;
SELECT EMPNO AS "사번", ENAME AS "이름", SAL AS "급여", JOB AS "직업" FROM EMP;--타이틀 달기
SELECT EMPNO AS 사번, ENAME AS 이름, SAL AS 급여, JOB AS 직업 FROM EMP;--타이틀 달기
SELECT EMPNO 사번, ENAME 이름, SAL 급여, JOB 직업 FROM EMP;--타이틀 달기
SELECT EMPNO NO, ENAME NAME, SAL SALARY, JOB  FROM EMP;--타이틀 달기

--3.WHERE 절(조건) 비교 연산자
SELECT EMPNO NO, ENAME NAME, SAL SALARY FROM EMP WHERE SAL=3000;--3000인 행만 출력
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL!=3000; --!=, ^=, <> 다르다
SELECT * FROM EMP;
SELECT * FROM EMP WHERE DEPTNO = 10;
SELECT * FROM EMP WHERE ENAME = 'FORD';--데이터는 대소문자 구분

--4. 논리 연산자
SELECT * FROM EMP WHERE SAL>=2000 AND SAL<=3000; --AND연산자, 비교연산은 숫자, 문자, DATE형 모두 가능하다
SELECT * FROM EMP WHERE ENAME < 'F'; --A,B,C,D,E로 시작하는 이름
SELECT * FROM EMP WHERE HIREDATE < '81/01/01'; --데이트형 비교 연산
SELECT * FROM EMP WHERE HIREDATE >= '82/01/01' AND HIREDATE <= '82/12/31';
SELECT ENAME 이름, SAL 월급, SAL*12 연봉 FROM EMP 
    WHERE SAL*12 >= 2400--WHERE절에는 타이틀 사용 불가능
    ORDER BY 연봉;--WHERE절에는 타이틀 사용 가능
 
--5. 산술 표현식
SELECT ENAME, SAL, SAL+300 UPGRADESAL FROM EMP;
SELECT ENAME, SAL, COMM, SAL*12+COMM FROM EMP;--산술 연산시 NULL과 연산하면 결과값 NULL
SELECT ENAME, SAL, COMM, SAL*12+NVL(COMM,0) FROM EMP;--NVL > NULL을 0으로 바꿈(필드명, 대치값)
SELECT ENAME, SAL, NVL(COMM,0), SAL*12+NVL(COMM,0) FROM EMP;
SELECT ENAME, NVL(MGR,0) FROM EMP;--'CEO' 불가능
SELECT ENAME, NVL(MGR,0) FROM EMP;

--6. 연결 연산자(||) 열이나 문자 연결
SELECT ENAME||'은 '||JOB||'이다.' FROM EMP;
SELECT ENAME||'IS '||JOB EMPLOYEE FROM EMP;

--7. 중복 제거
SELECT DISTINCT JOB FROM EMP;--중복 제거

--EX
--1. emp 테이블의 구조 출력
DESC EMP;
--2. emp 테이블의 모든 내용을 출력 
SELECT * FROM EMP;
--3. 현 scott 계정에서 사용가능한 테이블 출력
SELECT * FROM TAB;
--4. emp 테이블에서 사번, 이름, 급여, 업무, 입사일 출력
SELECT  EMPNO, ENAME, SAL, JOB, HIREDATE FROM EMP;
--5. emp 테이블에서 급여가 2000미만인 사람의 사번, 이름, 급여 출력
SELECT  EMPNO, ENAME, SAL FROM EMP WHERE SAL<2000;
--6. 입사일이 81/02이후에 입사한 사람의 사번, 이름, 업무, 입사일 출력
SELECT  EMPNO, ENAME, JOB, HIREDATE FROM EMP WHERE HIREDATE>='81/02/01';
--7. 업무가 SALESMAN인 사람들 모든 자료 출력
SELECT  * FROM EMP WHERE JOB = 'SALESMAN';
--8. 업무가 CLERK이 아닌 사람들 모든 자료 출력
SELECT  * FROM EMP WHERE JOB != 'CLERK';
--9. 급여가 1500이상이고 3000이하인 사람의 사번, 이름, 급여 출력
SELECT  EMPNO, ENAME, SAL FROM EMP WHERE SAL>=1500 AND SAL<=3000;
--10. 부서코드가 10번이거나 30인 사람의 사번, 이름, 업무, 부서코드 출력
SELECT  EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO = 10 OR DEPTNO=30;
--11. 업무가 SALESMAN이거나 급여가 3000이상인 사람의 사번, 이름, 업무, 부서코드 출력
SELECT  EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE JOB = 'SALESMAN' OR SAL>=3000;
--12. 급여가 2500이상이고 업무가 MANAGER인 사람의 사번, 이름, 업무, 급여 출력
SELECT  EMPNO, ENAME, JOB, SAL FROM EMP WHERE JOB = 'MANAGER' AND SAL>=2500;
--13.“ename은 XXX 업무이고 연봉은 XX다” 스타일로 모두 출력
SELECT ENAME||'은 '||JOB||'업무이고 연봉은 '||(SAL*12+NVL(COMM,0))||'다.' FROM EMP;

--8.SQL 연산자
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000;--사이의 값 (시작값 종료값 포함)
SELECT * FROM EMP WHERE HIREDATE BETWEEN '82/01/01' AND '82/12/31'; --작은 값 먼저
SELECT * FROM EMP WHERE ENAME BETWEEN 'B' AND 'D';--D로 시작하는 사람은 나오지 않음 
SELECT * FROM EMP WHERE DEPTNO = 10 OR DEPRTNO = 20;
SELECT * FROM EMP WHERE DEPTNO IN (10,20);--LIST안의 수 중에 일치
SELECT * FROM EMP WHERE DEPTNO NOT IN (10,20);--LIST안의 수 중에 불일치
SELECT * FROM EMP WHERE EMPNO IN (7902,7788,7566);
SELECT * FROM EMP WHERE ENAME LIKE 'M%';--로 시작하는 이름 (%: 0글자 이상 -: 한글자)
SELECT * FROM EMP WHERE ENAME LIKE '%N%';--가 들어간 이름
SELECT * FROM EMP WHERE ENAME LIKE '%S';--로 끝나는 이름
INSERT INTO EMP VALUES (9999,'%A', NULL, NULL, NULL, 9000, 9000, 40); --문자중 %가 있을시엔 %\%% 사용 후 ESCAPE '\';
ROLLBACK;-- 데이터 조작어 취소
SELECT * FROM EMP;
SELECT * FROM EMP WHERE SAL LIKE '%5'; --숫자도 LIKE 가능
SELECT * FROM EMP WHERE HIREDATE LIKE '82/%';--DATE형도 LIKE 가능
SELECT * FROM EMP WHERE HIREDATE LIKE '__/01/__';
SELECT * FROM EMP WHERE COMM IS NULL;--값을 갖지 않음, =NULL이 아닌 IS NULL
SELECT * FROM EMP WHERE COMM IS NOT NULL;
SELECT ENAME, SAL FROM EMP ORDER BY SAL;--오름차순
SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC;--내림차순
SELECT * FROM EMP ORDER BY SAL DESC, HIREDATE DESC, ENAME;--중복시 입사일로 정렬, 입사일 중복시 이름순
SELECT ENAME, SAL*12+NVL(COMM,0) 연봉 FROM EMP ORDER BY 연봉 DESC;--ALIAS 사용 가능
SELECT ENAME, SAL*12+NVL(COMM,0) 연봉 FROM EMP WHERE SAL*12+NVL(COMM,0) >=2000 ORDER BY 연봉 DESC ;--WHERE절은 ALIAS 불가능

--EX2
--1.	EMP 테이블에서 sal이 3000이상인 사원의 empno, ename, job, sal을 출력
 SELECT EMPNO, ENAME,JOB, SAL FROM EMP WHERE SAL>=3000;
--2.	EMP 테이블에서 empno가 7788인 사원의 ename과 deptno를 출력
SELECT ENAME, DEPTNO FROM EMP WHERE EMPNO = 7788;
--3.	연봉이 24000이상인 사번, 이름, 급여 출력 (급여순정렬)
SELECT EMPNO, ENAME, SAL FROM EMP WHERE (SAL*12+NVL(COMM,0))>=24000 ORDER BY SAL;
--4.	EMP 테이블에서 hiredate가 1981년 2월 20과 1981년 5월 1일 사이에 입사한 사원의 
--ename,job,hiredate을 출력하는 SELECT 문장을 작성 (단 hiredate 순으로 출력)
SELECT ENAME, JOB, HIREDATE FROM EMP WHERE HIREDATE>='81/02/20' AND HIREDATE<='81/05/01' ORDER BY HIREDATE;
--5.	EMP 테이블에서 deptno가 10,20인 사원의 모든 정보를 출력 (단 ename순으로 정렬)
SELECT * FROM EMP WHERE DEPTNO IN(10, 20) ORDER BY ENAME;
--6.	EMP 테이블에서 sal이 1500이상이고 deptno가 10,30인 사원의 ename과 sal를 출력
-- (단 HEADING을 employee과 Monthly Salary로 출력)
SELECT ENAME "employee", SAL "Monthly Salary" FROM EMP WHERE SAL>=1500 AND DEPTNO IN (10,30); 
--7.	EMP 테이블에서 hiredate가 1982년인 사원의 모든 정보를 출력
SELECT * FROM EMP WHERE HIREDATE LIKE '82/%';
--8.	이름의 첫자가 C부터  P로 시작하는 사람의 이름, 급여 이름순 정렬
SELECT ENAME, SAL FROM EMP WHERE ENAME BETWEEN 'C' AND 'P' AND ENAME!='P' ORDER BY ENAME;
--9.	EMP 테이블에서 comm이 sal보다 10%가 많은 모든 사원에 대하여 이름, 급여, 상여금을 
--출력하는 SELECT 문을 작성
SELECT ENAME, SAL, COMM FROM EMP WHERE NVL(COMM,0)>(SAL*1.1);
--10.	EMP 테이블에서 job이 CLERK이거나 ANALYST이고 sal이 1000,3000,5000이 아닌 모든 사원의 정보를 출력
SELECT * FROM EMP WHERE JOB IN ('ANALYST','CLERK') AND SAL NOT IN(1000,3000,5000);
--11.	EMP 테이블에서 ename에 L이 두 자가 있고 deptno가 30이거나 또는 mgr이 7782인 사원의 
--모든 정보를 출력하는 SELECT 문을 작성하여라.
SELECT * FROM EMP WHERE ENAME LIKE '%L%L%' AND (DEPTNO=30 OR MGR=7782);
--12.	사원 테이블에서 입사일이 81년도인 직원의 사번,사원명, 입사일, 업무, 급여를 출력
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE HIREDATE LIKE '81/%';
--13.	사원 테이블에서 입사일이81년이고 업무가 'SALESMAN'이 아닌 직원의 사번, 사원명, 입사일, 
-- 업무, 급여를 검색하시오.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE HIREDATE LIKE '81/%' AND JOB != 'SALESMAN';
--14.	사원 테이블의 사번, 사원명, 입사일, 업무, 급여를 급여가 높은 순으로 정렬하고, 
-- 급여가 같으면 입사일이 빠른 사원으로 정렬하시오.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP ORDER BY SAL DESC, HIREDATE;
--15.	사원 테이블에서 사원명의 세 번째 알파벳이 'N'인 사원의 사번, 사원명을 검색하시오
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '__N%';
--16.	사원 테이블에서 연봉(SAL*12)이 35000 이상인 사번, 사원명, 연봉을 검색 하시오.
SELECT EMPNO, ENAME, SAL*12 FROM EMP WHERE (SAL*12)>=35000;