--[4] ������ �Լ�
--�Լ� = �������Լ� + �׷��Լ�
SELECT ENAME, TO_CHAR(HIREDATE, 'YYYY"��"MM"��"DD"��"') �Ի��� FROM EMP;
SELECT ENAME, INITCAP(ENAME) FROM EMP;--������ �Լ�
SELECT SUM(SAL) FROM EMP; --�׷��Լ�(�������� ���)
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY DEPTNO; --�׷캰 �޿� ��
--����, ����, ��¥, ����ȯ, NVL �Լ�, etc
--(1)���� �Լ�
DESC DUAL; --����Ŭ���� �����ϴ� 1�� 1��¥�� ���� ���̺�
SELECT ABS(-9) FROM DUAL;--���밪
SELECT FLOOR(34.5678) FROM DUAL;--����
SELECT TRUNC(34.5678, 1) FROM DUAL;--�Ҽ��� ���ڸ����� ����
SELECT TRUNC(34.5678, -1) FROM DUAL;--���� �ڸ����� ����
SELECT ENAME, TRUNC(SAL,-1) FROM EMP;
SELECT ROUND(34.5678) FROM DUAL;--�Ҽ������� �ݿø�
SELECT ROUND(34.5678, 1) FROM DUAL;--�Ҽ��� ���ڸ����� �ݿø�
SELECT ROUND(34.5678, -1) FROM DUAL;--���� �ڸ����� �ݿø�
SELECT 10/4 FROM DUAL;--JAVA�� �ٸ��� ����� ���
SELECT MOD(9,2) FROM DUAL; --������ ������
SELECT MOD('9',2) FROM DUAL;--�ڵ������� ����
SELECT * FROM EMP WHERE MOD(TO_CHAR(HIREDATE, 'MM'),2) = 1;

--(2)���� �Լ�
SELECT UPPER('asdfgh') FROM DUAL;
SELECT LOWER('ASDFGH') FROM DUAL;
SELECT INITCAP('asdfgh') FROM DUAL;
SELECT * FROM EMP WHERE UPPER(JOB) = 'MANAGER';
SELECT EMPNO, INITCAP(ENAME) FROM EMP;
SELECT CONCAT('ASD', 'FGH') FROM DUAL;
SELECT SUBSTR('BONJOUR', 1, 3) FROM DUAL;
SELECT SUBSTRB('����Ŭ', 1, 6) FROM DUAL;--�ѱ��� 3����Ʈ
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, 4, 2) = '09';
SELECT SUBSTR('010-9999-9999', -4, 4) FROM DUAL;--������ �ں���
SELECT LENGTH('ABCD') FROM DUAL;--���� ����
SELECT LENGTHB('ABCD') FROM DUAL;--���� ����Ʈ ��
SELECT LENGTHB('����Ŭ') FROM DUAL;--���� ����Ʈ ��
SELECT INSTR('ABCDEF', 'B') FROM DUAL;--������ �ε��� ��ġ
SELECT INSTR('ABCDEFB', 'B', 4) FROM DUAL;--������ġ���� ������ �ε��� ��ġ
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09') = 4;
SELECT LPAD('ORACLE', 20, '#') FROM DUAL;--���ڸ� �ڸ�����ŭ Ȯ���ϰ� ���ڸ��� ���� ä��
SELECT TRIM('      ORACLE             ') FROM DUAL;--�¿� ���� ����
--ex)
SELECT EMPNO, RPAD(SUBSTR(ENAME,1,1), LENGTH(ENAME),'*' ), RPAD(SUBSTR(HIREDATE,1,6), LENGTH(HIREDATE),'*' ) FROM EMP;
SELECT ENAME FROM EMP WHERE INSTR(ENAME, 'R') = 3;
SELECT ENAME FROM EMP WHERE SUBSTR(ENAME,3,1) = 'R';
SELECT ENAME FROM EMP WHERE ENAME LIKE '__R%';

--(3)��¥ �Լ�
SELECT SYSDATE FROM DUAL;--���� ��¥, ��� ����� �� ���
SELECT ENAME, TRUNC(SYSDATE-HIREDATE) FROM EMP;--�ٹ��ϼ�
SELECT ENAME, TRUNC((SYSDATE-HIREDATE)/7) FROM EMP;--�ٹ��ּ�
SELECT ENAME, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) FROM EMP;--�ٹ�����
SELECT ENAME, TRUNC((SYSDATE-HIREDATE)/365) FROM EMP;--�ٹ�����
--ADD_MONTHS(Ư����¥, ������)
SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 6) FROM EMP;--�����Ⱓ����
--NEXT_DAY(Ư����¥, ����)
SELECT NEXT_DAY(SYSDATE, '��') FROM DUAL;
--LAST_DAY(Ư����¥)
SELECT LAST_DAY(SYSDATE) FROM DUAL;
--ROUND: ��¥ �ݿø�
SELECT ROUND(SYSDATE, 'YEAR') FROM DUAL;--�� �ݿø� 1�� 1��
SELECT ROUND(SYSDATE-30, 'MONTH') FROM DUAL;--�� �ݿø� 1��
SELECT ROUND(SYSDATE, 'DAY') FROM DUAL;--���� �ݿø� �Ͽ���
SELECT ROUND(SYSDATE) FROM DUAL;--�� �ݿø� 0��

SELECT ENAME, HIREDATE, TRUNC(HIREDATE, 'MONTH') FROM EMP;
SELECT ENAME, HIREDATE, ROUND(HIREDATE-9, 'MONTH')+24 FROM EMP;
SELECT ENAME, HIREDATE, SAL, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE))*SAL FROM EMP;
SELECT ENAME, HIREDATE, SAL, NVL(COMM,0), TRUNC((SYSDATE-HIREDATE)/365)*(SAL*12+NVL(COMM,0)) FROM EMP;

--(4) ����ȯ �Լ�
SELECT ENAME, TO_CHAR(HIREDATE, 'YYYY-MM-DD, DY') FROM EMP; --��¥ ��� ���
SELECT TO_CHAR(SYSDATE, 'AM HH24:MI:SS') FROM DUAL;--�ð� ��� ���
SELECT TO_CHAR(2145008000, 'L99,999,999,999') FROM DUAL; --0: �ڸ��� ä��, 9: �ڸ��� �� ä��, $:���� �տ� ����, L:���� ��ȭ ����
SELECT * FROM EMP 
    WHERE HIREDATE BETWEEN TO_DATE('19810501', 'YYYYMMDD') AND TO_DATE('19830501', 'YYYYMMDD'); --���� ���ڸ�
SELECT ROUND(SYSDATE-TO_DATE('20201130', 'YY/MM/DD')) FROM DUAL;

--(5) NULL���� �Լ�
SELECT NVL(COMM,0) FROM EMP; --�� �Ű������� �� ��ġ
SELECT W.ENAME, NVL(M.ENAME, 'CEO') FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);
SELECT ENAME, NVL(TO_CHAR(MGR), 'CEO') FROM EMP; --����ġ

--(6) DECODE �Լ�
--(������, ��1, ���1, ..., �׿� ���)
SELECT ENAME, DEPTNO, DECODE(DEPTNO, 10, 'ACCOUNTING', 20, 'RESEARCH', 30, 'SALES', 40, 'OPERATION', 'ETC') "DNAME" FROM EMP;
SELECT ENAME,DEPTNO, 
    CASE DEPTNO
        WHEN 10 THEN 'ACCOUNTING'
        WHEN 20 THEN 'RESEARCH'
        WHEN 30 THEN 'SALES'
        WHEN 40 THEN 'OPERATION'
        ELSE 'ETC'
    END "DNAME"
    FROM EMP;
SELECT ENAME, SAL, JOB, 
    DECODE(JOB, 
    'ANALYST', SAL*1.1, 
    'SALESMAN', SAL*1.2, 
    'MANAGER', SAL*1.3, 
    'CLERK', SAL*1.4, 
    'PRESIDENT', SAL*5, 
    SAL) "NEW WAGE" 
    FROM EMP 
    ORDER BY "NEW WAGE" DESC;

--(7) �׿� �Լ�
SELECT EXTRACT (YEAR FROM HIREDATE) FROM EMP; --������ ���
--LEVEL, START WITH(�ֻ�������), CONNECT BY PRIOR(������ ���� ����)
SELECT LEVEL, LPAD(' ', LEVEL*2)||ENAME, MGR FROM EMP
    START WITH MGR IS NULL
    CONNECT BY PRIOR EMPNO = MGR;
    
--ex)
-- 1. ���� ��¥�� ����ϰ� TITLE�� ��Current Date���� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT SYSDATE "CURRENT DATE" FROM DUAL;
-- 2. EMP ���̺����� ���� �޿��� 15%�� ������ �޿��� ����Ͽ�,
-- �����ȣ,�̸�,����,�޿�,������ �޿�(New Salary),������(Increase)�� ����ϴ� SELECT ����
SELECT EMPNO, ENAME, JOB, SAL, SAL*1.15 "NEW SALARY", SAL*0.15 "INCREASE" FROM EMP; 
--3. �̸�, �Ի���, �Ի��Ϸκ��� 6���� �� ���ƿ��� ������ ���Ͽ� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, HIREDATE, NEXT_DAY(ADD_MONTHS(HIREDATE, 6), '��') FROM EMP;
--4. �̸�, �Ի���, �Ի��Ϸκ��� ��������� ������, �޿�, �Ի��Ϻ��� ��������� ���� �޿��� �Ѱ踦 ���
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)),SAL, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE))*SAL FROM EMP;
--5. ��� ����� �̸��� �޿�(15�ڸ��� ��� ������ �� ���� ��*���� ��ġ)�� ���
SELECT ENAME, LPAD(SAL, 15, '*' )FROM EMP;
--6. ��� ����� ������ �̸�,����,�Ի���,�Ի��� ������ ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'DY') FROM EMP;
--7. �̸��� ���̰� 6�� �̻��� ����� ������ �̸�,�̸��� ���ڼ�,������ ���
SELECT ENAME, LENGTH(ENAME), JOB FROM EMP WHERE LENGTH(ENAME) >= 6 ;
--8. ��� ����� ������ �̸�, ����, �޿�, ���ʽ�, �޿�+���ʽ��� ���
SELECT ENAME, JOB, SAL, NVL(COMM, 0), SAL+NVL(COMM, 0) FROM EMP;
-- 9.��� ���̺��� ��������� 2��° ���ں��� 3���� ���ڸ� �����Ͻÿ�. 
SELECT SUBSTR(ENAME,2,3) FROM EMP;
--10. ��� ���̺����� �Ի����� 12���� ����� ���, �����, �Ի����� �˻��Ͻÿ�. 
--  �ý��ۿ� ���� DATEFORMAT �ٸ� �� �����Ƿ� �Ʒ��� ����� �˾ƺ���
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE EXTRACT(MONTH FROM HIREDATE) = '12';
--11. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
--EMPNO		ENAME		�޿�
--7369		       SMITH		*******800
--7499		       ALLEN		******1600
--7521		       WARD		******1250
--����. 
SELECT EMPNO, LPAD(ENAME, 10 ,' ' ), LPAD(SAL, 10,'*' ) FROM EMP;
-- 12. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
-- EMPNO	 ENAME 	�Ի���
-- 7369	  SMITH		1980-12-17
-- ��.
SELECT EMPNO, ENAME, TO_CHAR(HIREDATE, 'YYYY-MM-DD') FROM EMP;
--13. ��� ���̺����� �μ� ��ȣ�� 20�� ����� ���, �̸�, ����, �޿��� ����Ͻÿ�.
    --(�޿��� �տ� $�� �����ϰ�3�ڸ����� ,�� ����Ѵ�)
SELECT EMPNO, ENAME, JOB, TO_CHAR(SAL, '$999,999') FROM EMP;
-- 14. ��� ���̺����� �޿��� ���� ���, �̸�, �޿�, ����� �˻��ϴ� SQL ������ �ۼ� �Ͻ� ��.
-- �޿��� 0~1000 E / 1001~2000 D / 2001~3000 C / 3001~4000 B / 4001~5000 A
SELECT EMPNO, ENAME, SAL,  
    CASE TRUNC((SAL-1)/1000) 
    WHEN 0 THEN 'E' 
    WHEN 1 THEN 'D'
    WHEN 2 THEN 'C'
    WHEN 3 THEN 'B'
    WHEN 4 THEN 'A'
    ELSE 'ETC'
    END "GRADE"
    FROM EMP;