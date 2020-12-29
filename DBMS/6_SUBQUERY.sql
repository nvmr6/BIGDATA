--[6] SUB QUERY
SELECT DNAME FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND ENAME = 'SCOTT'; 
SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT';--���� ����
SELECT DNAME FROM DEPT
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT');--���� ����
SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER';--������ ���� ����
SELECT DNAME FROM DEPT
    WHERE DEPTNO IN(SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER'); --IN > ������ ���� ���� �̿�
    
--������ ���� ����
SELECT MAX(SAL) FROM EMP;--SUB(������)
SELECT ENAME FROM EMP
    WHERE SAL = (SELECT MAX(SAL) FROM EMP);--MAIN
SELECT E1.ENAME, E1.DEPTNO, E2.ENAME, E2.DEPTNO
    FROM EMP E1, EMP E2
    WHERE E1.DEPTNO = E2.DEPTNO AND E1.ENAME = 'SCOTT';
SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT';--SUB
SELECT ENAME FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT')
    AND ENAME != 'SCOTT';--MAIN

INSERT INTO DEPT VALUES (50, 'IT', 'DALLAS');
INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES(9999, 'PAUL', 50);    
    
SELECT LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND E.ENAME = 'SCOTT';--SUB
SELECT ENAME FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO 
    AND LOC = (SELECT LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND E.ENAME = 'SCOTT')
    AND E.ENAME != 'SCOTT';--MAIN
    
SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT';--SUB
SELECT SUM(SAL) FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT')
    AND ENAME != 'SCOTT';--MAIN
SELECT JOB FROM EMP WHERE ENAME = 'SCOTT';--SUB
SELECT * FROM EMP
    WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'SCOTT')
    AND ENAME != 'SCOTT';--MAIN
ROLLBACK;--DML��ɾ� ���
SELECT ENAME, DEPTNO FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS');
SELECT ENAME, SAL FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'SALES');
SELECT ENAME, SAL FROM EMP
    WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME = 'KING');
SELECT ENAME, SAL FROM EMP
    WHERE SAL <= (SELECT AVG(SAL) FROM EMP);--�׷��Լ�
SELECT * FROM EMP
    WHERE (JOB, DEPTNO) = (SELECT JOB, DEPTNO FROM EMP WHERE ENAME = 'SCOTT');--���߿�

--ex)
--1. ������̺��� ���� ���� �Ի��� ����� �̸�, �޿�, �Ի���
SELECT ENAME, SAL, HIREDATE FROM EMP
    WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP);
-- 2. ȸ�翡�� ���� �޿��� ���� ����� �̸�, �޿�
SELECT ENAME, SAL FROM EMP
    WHERE SAL = (SELECT MIN(SAL) FROM EMP);
-- 3. ȸ�� ��պ��� �޿��� ���� �޴� ����� �̸�, �޿�, �μ��ڵ�
SELECT ENAME, SAL, DEPTNO FROM EMP
    WHERE SAL >= (SELECT AVG(SAL) FROM EMP);
--4. ȸ�� ��� ������ �޿��� �޴� ����� �̸�, �޿�, �μ���
SELECT ENAME, SAL, DNAME FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND SAL <= (SELECT AVG(SAL) FROM EMP);
--5. SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���
SELECT ENAME, SAL, HIREDATE, GRADE FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL 
    AND HIREDATE <= (SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT') AND ENAME != 'SCOTT';
--6. 5��(SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���)�� �μ��� �߰��ϰ� 
    --�޿��� ū �� ����
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL 
    AND HIREDATE <= (SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT') AND ENAME != 'SCOTT'
    ORDER BY SAL DESC;
--7. ������̺��� BLAKE ���� �޿��� ���� ������� ���, �̸�, �޿��� �˻�
SELECT EMPNO, ENAME, SAL FROM EMP
    WHERE SAL > (SELECT SAL FROM EMP WHERE ENAME = 'BLAKE');
--8. ������̺��� MILLER���� �ʰ� �Ի��� ����� ���, �̸�, �Ի����� �˻��Ͻÿ�
SELECT EMPNO, ENAME, HIREDATE FROM EMP
    WHERE HIREDATE > (SELECT HIREDATE FROM EMP WHERE ENAME = 'MILLER');
--9. ������̺��� �����ü ��� �޿����� �޿��� ���� ������� ���, �̸�, �޿��� �˻�
SELECT EMPNO, ENAME, SAL FROM EMP
    WHERE SAL > (SELECT AVG(SAL) FROM EMP);
--10. ������̺��� CLARK�� ���� �μ���, ����� 7698�� ������ �޿����� 
        -- ���� �޿��� �޴� ������� ���, �̸�, �޿� �˻�
SELECT EMPNO, ENAME, SAL FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'CLARK')
    AND SAL < (SELECT SAL FROM EMP WHERE EMPNO = '7698');
--11.  �����ȭ. ������̺��� CLARK�� ���� �μ����̸�, ����� 7698�� ������ �޿����� 
    --  ���� �޿��� �޴� ������� ���, �̸�, �޿� �˻�
SELECT EMPNO, ENAME, SAL FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO 
    AND DNAME = (SELECT DNAME FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND ENAME = 'CLARK')
    AND SAL < (SELECT SAL FROM EMP WHERE EMPNO = '7698');
--12.  ��� ���̺��� BLAKE�� ���� �μ��� �ִ� ��� ����� �̸��� �Ի����ڸ� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, HIREDATE FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'BLAKE');
--13.  ��� ���̺��� ��� �޿� �̻��� �޴� ��� �������� ���ؼ� �����ȣ�� �̸��� ���
        --(�� �޿��� ���� ������ ����Ͽ���.)
SELECT EMPNO, ENAME FROM EMP
    WHERE SAL >= (SELECT AVG(SAL) FROM EMP)
    ORDER BY SAL DESC;
    
--������ ���� ����

--IN: ��� �� �ϳ��� ��ġ�ϸ� ���
SELECT DEPTNO, MAX(HIREDATE) FROM EMP
    GROUP BY DEPTNO;--SUB
SELECT EMPNO, ENAME, HIREDATE, DEPTNO FROM EMP
    WHERE (DEPTNO, HIREDATE) IN (SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO); 
--�޿��� 3000�̻� �޴� ����� �Ҽӵ� �μ����� �ٹ��ϴ� ������� ��� ����
SELECT * FROM EMP 
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE SAL>=3000);

--ALL: ��� ���� ��ġ�ϸ� ���
--30�� �μ� ����� �� �޿��� ���� ���� �޴� ������� �� ���� �޿��� �޴� ����� ����
SELECT  * FROM EMP
    WHERE SAL>(SELECT MAX(SAL) FROM EMP WHERE DEPTNO = 30);
SELECT  * FROM EMP
    WHERE SAL > ALL(SELECT SAL FROM EMP WHERE DEPTNO = 30);--��� �޿����� ū ����� ���, ���� ���

--ANY, SOME: �ϳ� �̻�� ��ġ�ϸ� ���
SELECT  * FROM EMP
    WHERE SAL > ANY(SELECT SAL FROM EMP WHERE DEPTNO = 30);--�ϳ����� ū ��� ���, �ּҰ����� ũ�� ���

--EXISTS: ���� ���� ����� �����ϸ� ���
SELECT EMPNO, ENAME, SAL FROM EMP MANAGER
    WHERE EXISTS (SELECT * FROM EMP WHERE MANAGER.EMPNO = MGR);--����� ����, ���� ����� �����ϸ� ���
SELECT * FROM EMP MANAGER
    WHERE NOT EXISTS (SELECT * FROM EMP WHERE MANAGER.EMPNO = MGR);--���� ��� ���

--�μ���ȣ ���� �ְ� �޿� �޴� ���� ����
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO;--SUB
SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP
    WHERE (DEPTNO, SAL) IN (SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO);

--ex)
--����(JOB)�� MANAGER�� ����� ���� �μ��� �μ� ��ȣ�� �μ���� ������ ���(IN)
SELECT DEPTNO, DNAME, LOC FROM DEPT 
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER');
--������ 3000�̻��� ����� �� ���� ����� ����� �ش� ��޺� �ְ� ������ �޴� ������� ���, �̸�, ����, �Ի���, �޿�, �޿������ ���
SELECT EMPNO, ENAME, JOB, HIREDATE, SAL, GRADE FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
    AND (GRADE, SAL) IN (SELECT GRADE, MAX(SAL) FROM EMP, SALGRADE WHERE SAL BETWEEN LOSAL AND HISAL AND SAL >=3000 GROUP BY GRADE)
    ORDER BY GRADE;
--�����ȭ : �Ի��� �б⺰�� ���� ���� ������ �޴� ������� �б�, ���, �̸�, JOB, �����, �Ի���, �޿�, �󿩸� ����ϼ���
SELECT CEIL(TO_CHAR(HIREDATE, 'MM')/3) QUARTER, EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, NVL(COMM, 0) FROM EMP
    WHERE (CEIL(TO_CHAR(HIREDATE, 'MM')/3), SAL) IN (SELECT CEIL(TO_CHAR(HIREDATE, 'MM')/3), MAX(SAL) FROM EMP GROUP BY CEIL(TO_CHAR(HIREDATE, 'MM')/3))
    ORDER BY QUARTER;--�б� ���
--SALESMAN ��� ����� ���� �޿��� ���� �޴� ������� �̸��� �޿��� ����(��� ����)�� ����ϵ� ���� ����� ������� �ʴ´�.(ALL�̿�)
SELECT ENAME, SAL, JOB FROM EMP
    WHERE SAL > ALL(SELECT SAL FROM EMP WHERE JOB = 'SALESMAN');
--SALESMAN �Ϻ� � �� ������� �޿��� ���� �޴� ������� �̸��� �޿��� ����(��� ����)�� ����ϵ� ���� ����� ���(ANY)
SELECT ENAME, SAL, JOB FROM EMP
    WHERE SAL > ANY(SELECT SAL FROM EMP WHERE JOB = 'SALESMAN');
--������ 3000�̸��� ��� �߿� ���� �ֱٿ� �Ի��� ����� �����ȣ�� �̸�, ����, �Ի����� ���
SELECT EMPNO, ENAME, SAL, HIREDATE FROM EMP
    WHERE HIREDATE >= ALL(SELECT HIREDATE FROM EMP WHERE SAL < 3000);
--������ ��SALESMAN���� ����� �޴� �޿��� �ּ� �޿����� ���� �޴� ������� �̸�, �޿�, ����, �μ���ȣ�� ����ϵ� �μ���ȣ�� 20���� ����� �����Ѵ�(ANY ������ �̿�)
SELECT ENAME, SAL, JOB, DEPTNO FROM EMP
    WHERE SAL > ANY(SELECT SAL FROM EMP WHERE JOB = 'SALESMAN')
    AND DEPTNO != '20';
    
--ex2)
-- 14. ��� ���̺��� �̸��� ��T���� �ִ� ����� �ٹ��ϴ� �μ����� �ٹ��ϴ� ��� �������� ����
    --��� ��ȣ,�̸�,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�. �� �����ȣ ������ ����Ͽ���.
SELECT EMPNO, ENAME, SAL FROM EMP
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%I%');
-- 15. ��� ���̺��� �μ� ��ġ�� Dallas�� ��� �������� ���� �̸�,����,�޿��� ���
SELECT ENAME, JOB, SAL FROM EMP
    WHERE ENAME IN (SELECT ENAME FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND LOC = 'DALLAS' );
-- 16. EMP ���̺��� King���� �����ϴ� ��� ����� �̸��� �޿��� ����ϴ� SELECT��
SELECT ENAME, SAL FROM EMP
    WHERE ENAME IN(SELECT E1.ENAME FROM EMP E1, EMP E2 WHERE E1.MGR = E2.EMPNO AND E2.ENAME = 'KING');
-- 17. ��� ���̺��� SALES�μ� ����� �̸�,������ ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, JOB FROM EMP
    WHERE DEPTNO IN (SELECT E.DEPTNO FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND DNAME = 'SALES');
-- 18. ��� ���̺��� ������ �μ� 30�� ���� ���޺��� ���� ����� ���
SELECT ENAME FROM EMP
    WHERE SAL > ANY(SELECT SAL FROM EMP WHERE DEPTNO = '30');
-- 19. �μ� 10���� �μ� 30�� ����� ���� ������ �ð� �ִ� ����� �̸��� ������ ���
SELECT ENAME, JOB FROM EMP
    WHERE JOB IN (SELECT JOB FROM EMP WHERE DEPTNO BETWEEN '10' AND '30');
-- 20. ��� ���̺��� FORD�� ������ ���޵� ���� ����� ��� ������ ���
SELECT * FROM EMP
    WHERE (JOB, SAL) IN (SELECT JOB, SAL FROM EMP WHERE ENAME = 'FORD');
-- 21. �̸��� JONES�� ������ JOB�� ���ų� 
    --������ FORD ���� �̻��� ����� ������ �̸�,����,�μ���ȣ,�޿��� ����ϴ� SELECT���� �ۼ�.
    -- ��, ������ ���ĺ� ��, ������ ���� ������ ����Ͽ���.
SELECT ENAME, JOB, DEPTNO, SAL FROM EMP
    WHERE JOB IN (SELECT JOB FROM EMP WHERE ENAME = 'JONES')
    OR SAL >= (SELECT SAL FROM EMP WHERE ENAME = 'FORD')
    ORDER BY JOB, SAL DESC;
-- 22. ��� ���̺��� SCOTT �Ǵ� WARD�� ������ ���� ����� ������ �̸�,����,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, JOB, SAL FROM EMP
    WHERE SAL IN (SELECT SAL FROM EMP WHERE ENAME IN ('SCOTT', 'WARD'));
-- 23. ��� ���̺��� CHICAGO���� �ٹ��ϴ� ����� ���� ������ �ϴ� ������� �̸�,������ ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT ENAME, JOB FROM EMP
    WHERE JOB IN(SELECT JOB FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND LOC = 'CHICAGO');
-- 24. ��� ���̺��� �μ����� ������ ��� ���޺��� ���� ����� �����ȣ,�̸�,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT E1.DEPTNO, EMPNO, ENAME, SAL FROM EMP E1, (SELECT DEPTNO, AVG(SAL) "AVG" FROM EMP GROUP BY DEPTNO) E2
    WHERE E1.SAL > E2.AVG AND E1.DEPTNO = E2.DEPTNO
    ORDER BY E1.DEPTNO;
SELECT DEPTNO, EMPNO, ENAME, SAL FROM EMP E
    WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO = E.DEPTNO)
    ORDER BY DEPTNO;
-- 25. ��� ���̺��� �������� ������ ��� ���޺��� ���� ����� �μ���ȣ,�̸�,�޿��� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT E1.DEPTNO, ENAME, SAL FROM EMP E1, (SELECT JOB, AVG(SAL) "AVG" FROM EMP GROUP BY JOB) E2
    WHERE E1.SAL < E2.AVG AND E1.JOB = E2.JOB
    ORDER BY E1.DEPTNO;
-- 26 ��� ���̺��� ��� �� �� �̻����κ��� ���� ���� �� �ִ� ����� ����,�̸�,�����ȣ,�μ���ȣ�� ���(��, �μ���ȣ ������ �������� ����)
SELECT JOB, ENAME, EMPNO, DEPTNO FROM EMP M
    WHERE EXISTS (SELECT * FROM EMP WHERE M.EMPNO = MGR);
-- 27. ��� ���̺��� ���� ����� �����ȣ, �̸�, ����, �μ���ȣ�� ����ϴ� SELECT���� �ۼ��Ͻÿ�.
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP MANAGER
    WHERE NOT EXISTS (SELECT * FROM EMP WHERE MANAGER.EMPNO = MGR);