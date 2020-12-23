--[3] JOIN: 테이블 2개 이상 연결하여 검색
SELECT * FROM EMP WHERE ENAME = 'SCOTT'; --부서번호 DEPTNO:20
SELECT * FROM DEPT;--두번의 연산 필요
--CROSS JOIN(FROM절에 테이블 2개 이상, N*M)
SELECT * FROM EMP,DEPT WHERE ENAME = 'SCOTT';
--EQUI JOIN(같은 값만 JOIN)
SELECT * FROM EMP,DEPT WHERE ENAME = 'SCOTT' AND EMP.DEPTNO = DEPT.DEPTNO;
SELECT * FROM EMP,DEPT WHERE EMP.DEPTNO = DEPT.DEPTNO;
--이름, 부서명, 부서번호
SELECT ENAME, DNAME, E.DEPTNO FROM EMP E,DEPT D WHERE E.DEPTNO = D.DEPTNO; --테이블의 ALIAS는 무조건 사용, 중복되지 않는 요소는 테이블명 생략 
SELECT E.*, DNAME, LOC FROM EMP E,DEPT D WHERE E.DEPTNO = D.DEPTNO;
SELECT EMPNO, ENAME, E.DEPTNO, DNAME, LOC FROM EMP E,DEPT D WHERE E.DEPTNO = D.DEPTNO;
SELECT ENAME, JOB, SAL, DNAME, LOC FROM EMP E,DEPT D WHERE E.DEPTNO = D.DEPTNO AND SAL>=2000;
SELECT ENAME, JOB, DNAME, LOC FROM EMP E,DEPT D WHERE E.DEPTNO = D.DEPTNO AND LOC = 'CHICAGO';
SELECT ENAME, JOB, LOC FROM EMP E,DEPT D WHERE E.DEPTNO = D.DEPTNO AND E.DEPTNO IN (10,20) ORDER BY SAL;
SELECT ENAME, SAL, COMM, SAL*12+NVL(COMM,0) ANNUAL, DNAME, LOC FROM EMP E,DEPT D WHERE E.DEPTNO = D.DEPTNO;
SELECT ENAME, SAL, COMM, SAL*12+NVL(COMM,0) ANNUAL, DNAME, LOC FROM EMP E,DEPT D WHERE E.DEPTNO = D.DEPTNO AND JOB IN ('SALESMAN','MANAGER') ORDER BY ANNUAL DESC;
SELECT ENAME, SAL, HIREDATE, D.DEPTNO, DNAME FROM EMP E,DEPT D WHERE E.DEPTNO = D.DEPTNO AND COMM IS NULL AND SAL>=1200 ORDER BY DNAME, SAL DESC;