--[3] JOIN: ���̺� 2�� �̻� �����Ͽ� �˻�

SELECT * FROM EMP 
    WHERE ENAME = 'SCOTT'; --�μ���ȣ DEPTNO:20
SELECT * FROM DEPT;--�ι��� ���� �ʿ�

--CROSS JOIN(FROM���� ���̺� 2�� �̻�, N*M)
SELECT * FROM EMP,DEPT 
    WHERE ENAME = 'SCOTT';
    
--EQUI JOIN(���� ���� JOIN)
SELECT * FROM EMP,DEPT 
    WHERE ENAME = 'SCOTT' AND EMP.DEPTNO = DEPT.DEPTNO;
SELECT * FROM EMP,DEPT 
    WHERE EMP.DEPTNO = DEPT.DEPTNO;
--�̸�, �μ���, �μ���ȣ
SELECT ENAME, DNAME, E.DEPTNO FROM EMP E,DEPT D 
    WHERE E.DEPTNO = D.DEPTNO; --���̺��� ALIAS�� ������ ���, �ߺ����� �ʴ� ��Ҵ� ���̺�� ���� 
SELECT E.*, DNAME, LOC FROM EMP E,DEPT D 
    WHERE E.DEPTNO = D.DEPTNO;
SELECT EMPNO, ENAME, E.DEPTNO, DNAME, LOC FROM EMP E,DEPT D 
    WHERE E.DEPTNO = D.DEPTNO;
SELECT ENAME, JOB, SAL, DNAME, LOC FROM EMP E,DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND SAL>=2000;
SELECT ENAME, JOB, DNAME, LOC FROM EMP E,DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND LOC = 'CHICAGO';
SELECT ENAME, JOB, LOC FROM EMP E,DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND E.DEPTNO IN (10,20) 
    ORDER BY SAL;
SELECT ENAME, SAL, COMM, SAL*12+NVL(COMM,0) ANNUAL, DNAME, LOC FROM EMP E,DEPT D 
    WHERE E.DEPTNO = D.DEPTNO;
SELECT ENAME, SAL, COMM, SAL*12+NVL(COMM,0) ANNUAL, DNAME, LOC FROM EMP E,DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND JOB IN ('SALESMAN','MANAGER') 
    ORDER BY ANNUAL DESC;
SELECT ENAME, SAL, HIREDATE, D.DEPTNO, DNAME FROM EMP E,DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND COMM IS NULL AND SAL>=1200 
    ORDER BY DNAME, SAL DESC;
--EX)
--���忡�� �ٹ��ϴ� ����� �̸��� �޿��� ����Ͻÿ�
SELECT ENAME, SAL FROM EMP E,DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND LOC = 'NEW YORK';
--ACCOUNTING �μ� �Ҽ� ����� �̸��� �Ի����� ����Ͻÿ�
SELECT ENAME,HIREDATE FROM EMP E,DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND DNAME = 'ACCOUNTING';
--������ MANAGER�� ����� �̸�, �μ����� ����Ͻÿ�
SELECT ENAME, DNAME FROM EMP E,DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND JOB = 'MANAGER';
--Comm�� null�� �ƴ� ����� �̸�, �޿�, �μ��ڵ�, �ٹ����� ����Ͻÿ�.
SELECT ENAME, SAL, D.DEPTNO, LOC FROM EMP E,DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND COMM IS NOT NULL;
--NON-EQUI JOIN (�� ������ �̿�)
SELECT ENAME, SAL FROM EMP 
    WHERE ENAME = 'SCOTT';
SELECT * FROM SALGRADE;
SELECT ENAME, SAL, GRADE, LOSAL, HISAL FROM EMP, SALGRADE 
    WHERE ENAME = 'SCOTT' AND SAL BETWEEN LOSAL AND HISAL;--ALIAS���� ����
SELECT EMPNO, ENAME, JOB, MGR, SAL, GRADE||'��' "�޿����" FROM EMP, SALGRADE 
    WHERE SAL BETWEEN LOSAL AND HISAL;
--ex2)
--Comm�� null�� �ƴ� ����� �̸�, �޿�, ���, �μ���ȣ, �μ��̸�, �ٹ����� ����Ͻÿ�.
SELECT ENAME, SAL, GRADE, E.DEPTNO, DNAME, LOC  FROM EMP E,DEPT D, SALGRADE 
    WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND COMM IS NOT NULL;
--�̸�, �޿�, �Ի���, �޿����
SELECT ENAME, SAL, HIREDATE, GRADE FROM EMP, SALGRADE 
    WHERE SAL BETWEEN LOSAL AND HISAL;
--�̸�, �޿�, �Ի���, �޿����, �μ���, �ٹ���
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME, LOC  FROM EMP E,DEPT D, SALGRADE 
    WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL;
--�̸�, �޿�, ���, �μ��ڵ�, �ٹ���. �� comm �� null�ƴ� ���
SELECT ENAME, SAL, GRADE, E.DEPTNO, LOC  FROM EMP E,DEPT D, SALGRADE 
    WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND COMM IS NOT NULL;
--�̸�, �޿�, �޿����, ����, �μ���, �μ��� ���, �μ��� ������ ������. ����=(sal+comm)*12 comm�� null�̸� 0
SELECT ENAME, SAL, GRADE, (SAL+NVL(COMM,0))*12, DNAME FROM EMP E,DEPT D, SALGRADE 
    WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL 
    ORDER BY DNAME,(SAL+NVL(COMM,0))*12;
--�̸�, ����, �޿�, ���, �μ��ڵ�, �μ��� ���. �޿��� 1000~3000����. �������� : �μ���, �μ������� ������, ���������� �޿� ū��
SELECT ENAME, SAL, GRADE, E.DEPTNO, DNAME  FROM EMP E,DEPT D, SALGRADE 
    WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND SAL BETWEEN 1000 AND 3000
    ORDER BY DNAME, JOB, SAL DESC;
--�̸�, �޿�, ���, �Ի���, �ٹ���. 81�⿡ �Ի��� ���. ��� ū��
SELECT ENAME, SAL, GRADE, HIREDATE, LOC  FROM EMP E,DEPT D, SALGRADE 
    WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND HIREDATE LIKE '81/%'
    ORDER BY GRADE DESC;
    
---SELF JOIN(�ϳ��� ���̺� ������ ����)
SELECT W.EMPNO, W.ENAME, W.MGR, M.ENAME FROM EMP W, EMP M
    WHERE W.ENAME = 'SMITH' AND W.MGR = M.EMPNO; --���� ����
SELECT W.EMPNO, W.ENAME, W.MGR, M.ENAME FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;
--ex3)
SELECT W.ENAME||'�� ���� '||M.ENAME||'��.' LIST FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;
SELECT W.ENAME, W.JOB FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO AND M.ENAME = 'KING';
SELECT W.ENAME, M.ENAME FROM EMP W, EMP M
    WHERE W.DEPTNO = M.DEPTNO AND W.ENAME = 'SCOTT' AND M.ENAME != 'SCOTT';
--SELF JOIN�� �� ���� EQUI JOIN TABLE ����
SELECT E1.ENAME, D1.LOC FROM EMP E1, DEPT D1
    WHERE E1.DEPTNO = D1.DEPTNO
    AND E1.ENAME = 'SCOTT'; 
SELECT E2.ENAME, D2.LOC FROM EMP E2, DEPT D2
    WHERE E2.DEPTNO = D2.DEPTNO
    AND E2.ENAME = 'SCOTT'; 
SELECT E1.ENAME, D1.LOC, E2.ENAME, D2.LOC FROM EMP E1, DEPT D1, EMP E2, DEPT D2
    WHERE E1.DEPTNO = D1.DEPTNO AND E2.DEPTNO = D2.DEPTNO 
    AND D1.LOC = D2.LOC AND E1.ENAME = 'SCOTT' AND E2.ENAME != 'SCOTT';
    
--OUTER JOIN(���ǿ� �������� �ʴ� ����� ���, �ܺ� ����)
SELECT W.EMPNO, W.ENAME, NVL(W.MGR, 0), NVL(M.ENAME, 'CEO') FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);--���ǿ� �������� ���� �� ��� > CEO���
SELECT W.EMPNO, W.ENAME, NVL(W.MGR, 0), NVL(M.ENAME, 'CEO') FROM EMP W, EMP M
    WHERE W.MGR(+) = M.EMPNO AND W.EMPNO IS NULL; --���� ��� ���
SELECT E.*, DNAME FROM EMP E, DEPT D
    WHERE E.DEPTNO(+) = D.DEPTNO;-- 14��� 4�� > 40���� ������ ���� > �� ������ �ʿ� (+)
SELECT W.ENAME||'�� ���� '||NVL(M.ENAME, '��')||'�Դϴ�.' LIST FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);

--EX JOIN)
--PART1
--1. �̸�, ���ӻ��
SELECT W.ENAME, M.ENAME FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;
--2. �̸�, �޿�, ����, ���ӻ��
SELECT W.ENAME, W.SAL, W.JOB, M.ENAME FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;
--3. �̸�, �޿�, ����, ���ӻ��. (��簡 ���� �������� ��ü ���� �� ���.
    --��簡 ���� �� '����'���� ���)
SELECT W.ENAME, W.SAL, W.JOB, NVL(M.ENAME, '����') FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);
--4. �̸�, �޿�, �μ���, ���ӻ���
SELECT W.ENAME, W.SAL, DNAME, M.ENAME FROM EMP W, EMP M, DEPT D
    WHERE W.MGR = M.EMPNO AND W.DEPTNO = D.DEPTNO;
--5. �̸�, �޿�, �μ��ڵ�, �μ���, �ٹ���, ���ӻ���, (��簡 ���� �������� ��ü ���� �� ���)
SELECT W.ENAME, W.SAL, W.DEPTNO, DNAME, D.LOC, M.ENAME FROM EMP W, EMP M, DEPT D
    WHERE W.MGR = M.EMPNO(+) AND W.DEPTNO = D.DEPTNO;
--6. �̸�, �޿�, ���, �μ���, ���ӻ���. �޿��� 2000�̻��� ���
SELECT W.ENAME, W.SAL, S.GRADE, D.DNAME, M.ENAME FROM EMP W, EMP M, DEPT D, SALGRADE S
    WHERE W.DEPTNO = D.DEPTNO AND W.SAL BETWEEN LOSAL AND HISAL AND W.SAL >=2000 AND W.MGR = M.EMPNO;
--7. �̸�, �޿�, ���, �μ���, ���ӻ���, (���ӻ�簡 ���� �������� ��ü���� �μ��� �� ����)
SELECT W.ENAME, W.SAL, S.GRADE, D.DNAME, M.ENAME FROM EMP W, EMP M, DEPT D, SALGRADE S
    WHERE W.DEPTNO = D.DEPTNO AND W.SAL BETWEEN LOSAL AND HISAL AND W.MGR = M.EMPNO(+)
    ORDER BY DNAME;
--8. �̸�, �޿�, ���, �μ���, ����, ���ӻ���. ����=(�޿�+comm)*12 �� comm�� null�̸� 0
SELECT W.ENAME, W.SAL, S.GRADE, D.DNAME, M.ENAME, (W.SAL+NVL(W.COMM,0)*12) FROM EMP W, EMP M, DEPT D, SALGRADE S
    WHERE W.DEPTNO = D.DEPTNO AND W.SAL BETWEEN LOSAL AND HISAL AND W.MGR = M.EMPNO;
--9. 8���� �μ��� �� �μ��� ������ �޿��� ū �� ����
SELECT W.ENAME, W.SAL, S.GRADE, D.DNAME, M.ENAME, (W.SAL+NVL(W.COMM,0)*12) FROM EMP W, EMP M, DEPT D, SALGRADE S
    WHERE W.DEPTNO = D.DEPTNO AND W.SAL BETWEEN LOSAL AND HISAL AND W.MGR = M.EMPNO
    ORDER BY DNAME, W.SAL;
--  PART2
--1.EMP ���̺��� ��� ����� ���� �̸�,�μ���ȣ,�μ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT ENAME, E.DEPTNO, DNAME FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO;
--2. EMP ���̺��� NEW YORK���� �ٹ��ϰ� �ִ� ����� ���Ͽ� �̸�,����,�޿�,�μ����� ���
SELECT ENAME, JOB, SAL, DNAME FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND LOC = 'NEW YORK';
--3. EMP ���̺��� ���ʽ��� �޴� ����� ���Ͽ� �̸�,�μ���,��ġ�� ���
SELECT ENAME, DNAME, LOC FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND COMM IS NOT NULL AND COMM != 0;
--4. EMP ���̺��� �̸� �� L�ڰ� �ִ� ����� ���Ͽ� �̸�,����,�μ���,��ġ�� ���
SELECT ENAME, JOB, DNAME, LOC FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND ENAME LIKE '%L%';
--5. ���, �����, �μ��ڵ�, �μ����� �˻��϶�. ������������ ������������
SELECT EMPNO, ENAME, E.DEPTNO, DNAME FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    ORDER BY ENAME;
--6. ���, �����, �޿�, �μ����� �˻��϶�. 
    --�� �޿��� 2000�̻��� ����� ���Ͽ� �޿��� �������� ������������ �����Ͻÿ�
SELECT EMPNO, ENAME, SAL, DNAME FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    ORDER BY SAL DESC;
--7. ���, �����, ����, �޿�, �μ����� �˻��Ͻÿ�. �� ������ MANAGER�̸� �޿��� 2500�̻���
-- ����� ���Ͽ� ����� �������� ������������ �����Ͻÿ�.
SELECT EMPNO, ENAME, JOB, DNAME FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND JOB = 'MANAGER' AND SAL>=2500
    ORDER BY EMPNO;
--8. ���, �����, ����, �޿�, ����� �˻��Ͻÿ�. ��, �޿����� ������������ �����Ͻÿ�
SELECT EMPNO, ENAME, JOB, SAL, GRADE FROM EMP, SALGRADE 
    WHERE SAL BETWEEN LOSAL AND HISAL
    ORDER BY SAL DESC;
--9. ������̺��� �����, ����� ��縦 �˻��Ͻÿ�(��簡 ���� �������� ��ü)
SELECT W.ENAME, NVL(M.ENAME, '����') FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);
--10. �����, ����, ����� ������ �˻��Ͻÿ�
SELECT W.ENAME, M.ENAME, B.ENAME FROM EMP W, EMP M, EMP B
    WHERE W.MGR = M.EMPNO AND M.MGR = B.EMPNO;
--11. ���� ������� ���� ��簡 ���� ��� ������ �̸��� ��µǵ��� �����Ͻÿ�
SELECT W.ENAME FROM EMP W, EMP M, EMP B
    WHERE W.MGR = M.EMPNO AND M.MGR = B.EMPNO(+) AND B.ENAME IS NULL;