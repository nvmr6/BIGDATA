--[11] INDEX
--��ȸ�� ������ �ϱ� ����
SELECT * FROM USER_INDEXES;
DROP TABLE EMP01;
CREATE TABLE EMP01
    AS SELECT * FROM EMP;
INSERT INTO EMP01 SELECT * FROM EMP01; --1ȸ ����� �ι�
SELECT COUNT (*) FROM EMP01;
INSERT INTO EMP01 SELECT * FROM EMP01;
INSERT INTO EMP01 (EMPNO, ENAME, DEPTNO) VALUES (1111,'WER',40);
SELECT * FROM EMP01 WHERE ENAME = 'WER';

CREATE INDEX IDX_EMP01_ENAME ON EMP01(ENAME);
SELECT * FROM EMP01 WHERE ENAME = 'WER';
DROP INDEX IDX_EMP01_ENAME;
DROP TABLE EMP01;