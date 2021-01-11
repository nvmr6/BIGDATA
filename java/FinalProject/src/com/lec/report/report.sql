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

INSERT INTO MAJOR VALUES (1, '빅데이터학');
INSERT INTO MAJOR VALUES (2, '경영정보학');
INSERT INTO MAJOR VALUES (3, '컴퓨터공학');
INSERT INTO MAJOR VALUES (4, '소프트웨어');
INSERT INTO MAJOR VALUES (5, '인공지능학');
COMMIT;
SELECT * FROM MAJOR;
SELECT * FROM STUDENT;
COMMIT;

-- SwingStudentMng에서 필요한 Query
-- 0. 첫화면에 전공이름들 콤보박스에 추가(mName) : DAO에서 public Vector<String> getMNamelist()
SELECT MNAME FROM MAJOR;
-- 1. 학번검색 (sNo, sName, mName, score) : DAO에서 public StudentSwingDto sNogetStudent(String sNo)
SELECT SNO, SNAME, MNAME, SCORE FROM STUDENT S, MAJOR M 
    WHERE S.MNO=M.MNO AND SNO='2021001';
-- 2. 이름검색 (sNo, sName, mName, score)  : DAO에서 public ArrayList<StudentSwingDto> sNamegetStudent(String sName)
SELECT SNO, SNAME, MNAME, SCORE FROM STUDENT S, MAJOR M 
    WHERE S.MNO=M.MNO AND SNAME='정우성';
-- 3. 전공검색 (rank, sName(sNo포함), mName(mNo포함), score) : DAO에서 public ArrayList<StudentSwingDto> mNamegetStudent(String mName)
--- 출력 : 1 정우성(2021001) 빅데이터학(1) 90 
SELECT ROWNUM RANK, T.* FROM(SELECT SNAME||'('||SNO||')' SNAME, MNAME||'('||S.MNO||')' MANME, SCORE FROM STUDENT S, MAJOR M
                                WHERE S.MNO = M.MNO AND M.MNAME = '빅데이터학'
                                ORDER BY SCORE DESC) T;
-- 4. 학생입력 : DAO에서 public int insertStudent(String sName, String mName, int score)
--              DAO에서 public int insertStudent(StudentSwingDto dto)
INSERT INTO STUDENT VALUES ( TO_CHAR(SYSDATE, 'YYYY')||TRIM(TO_CHAR(SEQ_STUDENT.NEXTVAL,'000')), '곽세만', (SELECT MNO FROM MAJOR WHERE MNAME = '컴퓨터공학'), 60, 1); 
-- 5. 학생수정 : DAO에서 public int updateStudent(String sNo, String sName, String mName, int score)
--              DAO에서 public int updateStudent(StudentSwingDto dto)
UPDATE STUDENT SET  SNAME='이지영', MNO=(SELECT MNO FROM MAJOR WHERE MNAME='인공지능학'), SCORE = 80
                                WHERE SNO='2021003';

-- 6. 학생출력 (rank, sName(sNo포함), mName(mNo포함), score) : DAO에서 public ArrayList<StudentSwingDto> getStudents()
-- 출력 : 1 정우성(2021001) 빅데이터학(1) 90
SELECT ROWNUM RANK, T.* FROM(SELECT SNAME||'('||SNO||')' SNAME, MNAME||'('||S.MNO||')' MANME, SCORE FROM STUDENT S, MAJOR M
                                WHERE S.MNO = M.MNO AND SEXPEL = 0
                                ORDER BY SCORE DESC) T;
-- 7. 제적자출력  (rank, sName(sNo포함), mName(mNo포함), score) : DAO에서 public ArrayList<StudentSwingDto> getStudentsExpel()
-- 출력 : 1 김제적(2021004) 컴퓨터공학(3) 10
SELECT ROWNUM RANK, T.* FROM(SELECT SNAME||'('||SNO||')' SNAME, MNAME||'('||S.MNO||')' MANME, SCORE FROM STUDENT S, MAJOR M
                                WHERE S.MNO = M.MNO AND SEXPEL = 1
                                ORDER BY SCORE DESC) T;
-- 8. 제적처리 : DAO에서 public int sNoExpel(String sNo)
UPDATE STUDENT SET SEXPEL = 1 WHERE SNO='2021001';

