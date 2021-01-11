DROP TABLE STUDENT;
DROP TABLE MAJOR;

CREATE TABLE MAJOR(
    MNO NUMBER(2) PRIMARY KEY,
    MNAME VARCHAR2(30) NOT NULL
);
DROP SEQUENCE SEQ_STUDENT;
CREATE SEQUENCE SEQ_STUDENT
    MAXVALUE 999
    MINVALUE 1
    NOCYCLE 
    NOCACHE;
    
CREATE TABLE STUDENT(
    SNO VARCHAR2(7) PRIMARY KEY,
    SNAME VARCHAR2(30) NOT NULL,
    MNO NUMBER(2) REFERENCES MAJOR(MNO),
    SCORE NUMBER(3),
    SEXPEL NUMBER(1)
);

INSERT INTO MAJOR VALUES (1, '��������');
INSERT INTO MAJOR VALUES (2, '�濵������');
INSERT INTO MAJOR VALUES (3, '��ǻ�Ͱ���');
INSERT INTO MAJOR VALUES (4, '����Ʈ����');
INSERT INTO MAJOR VALUES (5, '�ΰ�������');
COMMIT;
SELECT * FROM MAJOR;
SELECT * FROM STUDENT;
COMMIT;

-- SwingStudentMng���� �ʿ��� Query
-- 0. ùȭ�鿡 �����̸��� �޺��ڽ��� �߰�(mName) : DAO���� public Vector<String> getMNamelist()
SELECT MNAME FROM MAJOR;
-- 1. �й��˻� (sNo, sName, mName, score) : DAO���� public StudentSwingDto sNogetStudent(String sNo)
SELECT SNO, SNAME, MNAME, SCORE FROM STUDENT S, MAJOR M 
    WHERE S.MNO=M.MNO AND SNO='2021001';
-- 2. �̸��˻� (sNo, sName, mName, score)  : DAO���� public ArrayList<StudentSwingDto> sNamegetStudent(String sName)
SELECT SNO, SNAME, MNAME, SCORE FROM STUDENT S, MAJOR M 
    WHERE S.MNO=M.MNO AND SNAME='���켺';
-- 3. �����˻� (rank, sName(sNo����), mName(mNo����), score) : DAO���� public ArrayList<StudentSwingDto> mNamegetStudent(String mName)
--- ��� : 1 ���켺(2021001) ��������(1) 90 
SELECT ROWNUM RANK, T.* FROM(SELECT SNAME||'('||SNO||')' SNAME, MNAME||'('||S.MNO||')' MANME, SCORE FROM STUDENT S, MAJOR M
                                WHERE S.MNO = M.MNO AND M.MNAME = '��������'
                                ORDER BY SCORE DESC) T;
-- 4. �л��Է� : DAO���� public int insertStudent(String sName, String mName, int score)
--              DAO���� public int insertStudent(StudentSwingDto dto)
INSERT INTO STUDENT VALUES ( TO_CHAR(SYSDATE, 'YYYY')||TRIM(TO_CHAR(SEQ_STUDENT.NEXTVAL,'000')), '������', (SELECT MNO FROM MAJOR WHERE MNAME = '��ǻ�Ͱ���'), 60, 1); 
-- 5. �л����� : DAO���� public int updateStudent(String sNo, String sName, String mName, int score)
--              DAO���� public int updateStudent(StudentSwingDto dto)
UPDATE STUDENT SET  SNAME='������', MNO=(SELECT MNO FROM MAJOR WHERE MNAME='�ΰ�������'), SCORE = 80
                                WHERE SNO='2021003';

-- 6. �л���� (rank, sName(sNo����), mName(mNo����), score) : DAO���� public ArrayList<StudentSwingDto> getStudents()
-- ��� : 1 ���켺(2021001) ��������(1) 90
SELECT ROWNUM RANK, T.* FROM(SELECT SNAME||'('||SNO||')' SNAME, MNAME||'('||S.MNO||')' MANME, SCORE FROM STUDENT S, MAJOR M
                                WHERE S.MNO = M.MNO AND SEXPEL = 0
                                ORDER BY SCORE DESC) T;
-- 7. ���������  (rank, sName(sNo����), mName(mNo����), score) : DAO���� public ArrayList<StudentSwingDto> getStudentsExpel()
-- ��� : 1 ������(2021004) ��ǻ�Ͱ���(3) 10
SELECT ROWNUM RANK, T.* FROM(SELECT SNAME||'('||SNO||')' SNAME, MNAME||'('||S.MNO||')' MANME, SCORE FROM STUDENT S, MAJOR M
                                WHERE S.MNO = M.MNO AND SEXPEL = 1
                                ORDER BY SCORE DESC) T;
-- 8. ����ó�� : DAO���� public int sNoExpel(String sNo)
UPDATE STUDENT SET SEXPEL = 1 WHERE SNO='2021001';

