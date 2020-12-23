--[2] Select
--1. SQL�ۼ�
SELECT * FROM TAB; -- SCOTT������ ���� ���̺�� ����Ʈ
SELECT * FROM DEPT;-- DEPT���̺��� ��� ��, ��� ��(* > ��� ��)
SELECT * FROM EMP;-- EMP���̺��� ��� ��, ��� ��
DESC DEPT;-- DEPT ���̺��� ����(ORACLE)

--2.SQP���� ���� (Ư����)
SELECT * FROM EMP;
SELECT EMPNO, ENAME, SAL, JOB FROM EMP;
SELECT EMPNO AS "���", ENAME AS "�̸�", SAL AS "�޿�", JOB AS "����" FROM EMP;--Ÿ��Ʋ �ޱ�
SELECT EMPNO AS ���, ENAME AS �̸�, SAL AS �޿�, JOB AS ���� FROM EMP;--Ÿ��Ʋ �ޱ�
SELECT EMPNO ���, ENAME �̸�, SAL �޿�, JOB ���� FROM EMP;--Ÿ��Ʋ �ޱ�
SELECT EMPNO NO, ENAME NAME, SAL SALARY, JOB  FROM EMP;--Ÿ��Ʋ �ޱ�

--3.WHERE ��(����) �� ������
SELECT EMPNO NO, ENAME NAME, SAL SALARY FROM EMP WHERE SAL=3000;--3000�� �ุ ���
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL!=3000; --!=, ^=, <> �ٸ���
SELECT * FROM EMP;
SELECT * FROM EMP WHERE DEPTNO = 10;
SELECT * FROM EMP WHERE ENAME = 'FORD';--�����ʹ� ��ҹ��� ����

--4. �� ������
SELECT * FROM EMP WHERE SAL>=2000 AND SAL<=3000; --AND������, �񱳿����� ����, ����, DATE�� ��� �����ϴ�
SELECT * FROM EMP WHERE ENAME < 'F'; --A,B,C,D,E�� �����ϴ� �̸�
SELECT * FROM EMP WHERE HIREDATE < '81/01/01'; --����Ʈ�� �� ����
SELECT * FROM EMP WHERE HIREDATE >= '82/01/01' AND HIREDATE <= '82/12/31';
SELECT ENAME �̸�, SAL ����, SAL*12 ���� FROM EMP 
    WHERE SAL*12 >= 2400--WHERE������ Ÿ��Ʋ ��� �Ұ���
    ORDER BY ����;--WHERE������ Ÿ��Ʋ ��� ����
 
--5. ��� ǥ����
SELECT ENAME, SAL, SAL+300 UPGRADESAL FROM EMP;
SELECT ENAME, SAL, COMM, SAL*12+COMM FROM EMP;--��� ����� NULL�� �����ϸ� ����� NULL
SELECT ENAME, SAL, COMM, SAL*12+NVL(COMM,0) FROM EMP;--NVL > NULL�� 0���� �ٲ�(�ʵ��, ��ġ��)
SELECT ENAME, SAL, NVL(COMM,0), SAL*12+NVL(COMM,0) FROM EMP;
SELECT ENAME, NVL(MGR,0) FROM EMP;--'CEO' �Ұ���
SELECT ENAME, NVL(MGR,0) FROM EMP;

--6. ���� ������(||) ���̳� ���� ����
SELECT ENAME||'�� '||JOB||'�̴�.' FROM EMP;
SELECT ENAME||'IS '||JOB EMPLOYEE FROM EMP;

--7. �ߺ� ����
SELECT DISTINCT JOB FROM EMP;--�ߺ� ����

--EX
--1. emp ���̺��� ���� ���
DESC EMP;
--2. emp ���̺��� ��� ������ ��� 
SELECT * FROM EMP;
--3. �� scott �������� ��밡���� ���̺� ���
SELECT * FROM TAB;
--4. emp ���̺��� ���, �̸�, �޿�, ����, �Ի��� ���
SELECT  EMPNO, ENAME, SAL, JOB, HIREDATE FROM EMP;
--5. emp ���̺��� �޿��� 2000�̸��� ����� ���, �̸�, �޿� ���
SELECT  EMPNO, ENAME, SAL FROM EMP WHERE SAL<2000;
--6. �Ի����� 81/02���Ŀ� �Ի��� ����� ���, �̸�, ����, �Ի��� ���
SELECT  EMPNO, ENAME, JOB, HIREDATE FROM EMP WHERE HIREDATE>='81/02/01';
--7. ������ SALESMAN�� ����� ��� �ڷ� ���
SELECT  * FROM EMP WHERE JOB = 'SALESMAN';
--8. ������ CLERK�� �ƴ� ����� ��� �ڷ� ���
SELECT  * FROM EMP WHERE JOB != 'CLERK';
--9. �޿��� 1500�̻��̰� 3000������ ����� ���, �̸�, �޿� ���
SELECT  EMPNO, ENAME, SAL FROM EMP WHERE SAL>=1500 AND SAL<=3000;
--10. �μ��ڵ尡 10���̰ų� 30�� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT  EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO = 10 OR DEPTNO=30;
--11. ������ SALESMAN�̰ų� �޿��� 3000�̻��� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT  EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE JOB = 'SALESMAN' OR SAL>=3000;
--12. �޿��� 2500�̻��̰� ������ MANAGER�� ����� ���, �̸�, ����, �޿� ���
SELECT  EMPNO, ENAME, JOB, SAL FROM EMP WHERE JOB = 'MANAGER' AND SAL>=2500;
--13.��ename�� XXX �����̰� ������ XX�١� ��Ÿ�Ϸ� ��� ���
SELECT ENAME||'�� '||JOB||'�����̰� ������ '||(SAL*12+NVL(COMM,0))||'��.' FROM EMP;

--8.SQL ������
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000;--������ �� (���۰� ���ᰪ ����)
SELECT * FROM EMP WHERE HIREDATE BETWEEN '82/01/01' AND '82/12/31'; --���� �� ����
SELECT * FROM EMP WHERE ENAME BETWEEN 'B' AND 'D';--D�� �����ϴ� ����� ������ ���� 
SELECT * FROM EMP WHERE DEPTNO = 10 OR DEPRTNO = 20;
SELECT * FROM EMP WHERE DEPTNO IN (10,20);--LIST���� �� �߿� ��ġ
SELECT * FROM EMP WHERE DEPTNO NOT IN (10,20);--LIST���� �� �߿� ����ġ
SELECT * FROM EMP WHERE EMPNO IN (7902,7788,7566);
SELECT * FROM EMP WHERE ENAME LIKE 'M%';--�� �����ϴ� �̸� (%: 0���� �̻� -: �ѱ���)
SELECT * FROM EMP WHERE ENAME LIKE '%N%';--�� �� �̸�
SELECT * FROM EMP WHERE ENAME LIKE '%S';--�� ������ �̸�
INSERT INTO EMP VALUES (9999,'%A', NULL, NULL, NULL, 9000, 9000, 40); --������ %�� �����ÿ� %\%% ��� �� ESCAPE '\';
ROLLBACK;-- ������ ���۾� ���
SELECT * FROM EMP;
SELECT * FROM EMP WHERE SAL LIKE '%5'; --���ڵ� LIKE ����
SELECT * FROM EMP WHERE HIREDATE LIKE '82/%';--DATE���� LIKE ����
SELECT * FROM EMP WHERE HIREDATE LIKE '__/01/__';
SELECT * FROM EMP WHERE COMM IS NULL;--���� ���� ����, =NULL�� �ƴ� IS NULL
SELECT * FROM EMP WHERE COMM IS NOT NULL;
SELECT ENAME, SAL FROM EMP ORDER BY SAL;--��������
SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC;--��������
SELECT * FROM EMP ORDER BY SAL DESC, HIREDATE DESC, ENAME;--�ߺ��� �Ի��Ϸ� ����, �Ի��� �ߺ��� �̸���
SELECT ENAME, SAL*12+NVL(COMM,0) ���� FROM EMP ORDER BY ���� DESC;--ALIAS ��� ����
SELECT ENAME, SAL*12+NVL(COMM,0) ���� FROM EMP WHERE SAL*12+NVL(COMM,0) >=2000 ORDER BY ���� DESC ;--WHERE���� ALIAS �Ұ���

--EX2
--1.	EMP ���̺��� sal�� 3000�̻��� ����� empno, ename, job, sal�� ���
 SELECT EMPNO, ENAME,JOB, SAL FROM EMP WHERE SAL>=3000;
--2.	EMP ���̺��� empno�� 7788�� ����� ename�� deptno�� ���
SELECT ENAME, DEPTNO FROM EMP WHERE EMPNO = 7788;
--3.	������ 24000�̻��� ���, �̸�, �޿� ��� (�޿�������)
SELECT EMPNO, ENAME, SAL FROM EMP WHERE (SAL*12+NVL(COMM,0))>=24000 ORDER BY SAL;
--4.	EMP ���̺��� hiredate�� 1981�� 2�� 20�� 1981�� 5�� 1�� ���̿� �Ի��� ����� 
--ename,job,hiredate�� ����ϴ� SELECT ������ �ۼ� (�� hiredate ������ ���)
SELECT ENAME, JOB, HIREDATE FROM EMP WHERE HIREDATE>='81/02/20' AND HIREDATE<='81/05/01' ORDER BY HIREDATE;
--5.	EMP ���̺��� deptno�� 10,20�� ����� ��� ������ ��� (�� ename������ ����)
SELECT * FROM EMP WHERE DEPTNO IN(10, 20) ORDER BY ENAME;
--6.	EMP ���̺��� sal�� 1500�̻��̰� deptno�� 10,30�� ����� ename�� sal�� ���
-- (�� HEADING�� employee�� Monthly Salary�� ���)
SELECT ENAME "employee", SAL "Monthly Salary" FROM EMP WHERE SAL>=1500 AND DEPTNO IN (10,30); 
--7.	EMP ���̺��� hiredate�� 1982���� ����� ��� ������ ���
SELECT * FROM EMP WHERE HIREDATE LIKE '82/%';
--8.	�̸��� ù�ڰ� C����  P�� �����ϴ� ����� �̸�, �޿� �̸��� ����
SELECT ENAME, SAL FROM EMP WHERE ENAME BETWEEN 'C' AND 'P' AND ENAME!='P' ORDER BY ENAME;
--9.	EMP ���̺��� comm�� sal���� 10%�� ���� ��� ����� ���Ͽ� �̸�, �޿�, �󿩱��� 
--����ϴ� SELECT ���� �ۼ�
SELECT ENAME, SAL, COMM FROM EMP WHERE NVL(COMM,0)>(SAL*1.1);
--10.	EMP ���̺��� job�� CLERK�̰ų� ANALYST�̰� sal�� 1000,3000,5000�� �ƴ� ��� ����� ������ ���
SELECT * FROM EMP WHERE JOB IN ('ANALYST','CLERK') AND SAL NOT IN(1000,3000,5000);
--11.	EMP ���̺��� ename�� L�� �� �ڰ� �ְ� deptno�� 30�̰ų� �Ǵ� mgr�� 7782�� ����� 
--��� ������ ����ϴ� SELECT ���� �ۼ��Ͽ���.
SELECT * FROM EMP WHERE ENAME LIKE '%L%L%' AND (DEPTNO=30 OR MGR=7782);
--12.	��� ���̺��� �Ի����� 81�⵵�� ������ ���,�����, �Ի���, ����, �޿��� ���
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE HIREDATE LIKE '81/%';
--13.	��� ���̺��� �Ի�����81���̰� ������ 'SALESMAN'�� �ƴ� ������ ���, �����, �Ի���, 
-- ����, �޿��� �˻��Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE HIREDATE LIKE '81/%' AND JOB != 'SALESMAN';
--14.	��� ���̺��� ���, �����, �Ի���, ����, �޿��� �޿��� ���� ������ �����ϰ�, 
-- �޿��� ������ �Ի����� ���� ������� �����Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP ORDER BY SAL DESC, HIREDATE;
--15.	��� ���̺��� ������� �� ��° ���ĺ��� 'N'�� ����� ���, ������� �˻��Ͻÿ�
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '__N%';
--16.	��� ���̺��� ����(SAL*12)�� 35000 �̻��� ���, �����, ������ �˻� �Ͻÿ�.
SELECT EMPNO, ENAME, SAL*12 FROM EMP WHERE (SAL*12)>=35000;