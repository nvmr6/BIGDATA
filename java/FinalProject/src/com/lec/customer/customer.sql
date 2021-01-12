DROP TABLE CUSTOMER;
DROP TABLE CUS_LEVEL;

CREATE TABLE CUS_LEVEL(
    LEVELNO NUMBER(1) PRIMARY KEY,
    LEVELNAME VARCHAR2(20),
    LOW NUMBER(9),
    HIGH NUMBER(9)
);

DROP SEQUENCE CUS_SEQ;
CREATE SEQUENCE CUS_SEQ
    MAXVALUE 99999
    MINVALUE 1
    NOCYCLE 
    NOCACHE;
    
CREATE TABLE CUSTOMER(
    CID NUMBER(6) PRIMARY KEY,
    CTEL VARCHAR2(20) NOT NULL,
    CNAME VARCHAR2(30) NOT NULL,
    CPOINT NUMBER(9) DEFAULT 1000,
    CAMOUNT NUMBER(9) DEFAULT 0,
    LEVELNO NUMBER(1) DEFAULT 1 REFERENCES CUS_LEVEL(LEVELNO)
);

SELECT * FROM CUS_LEVEL;
SELECT * FROM CUSTOMER;
INSERT INTO CUS_LEVEL VALUES (1, 'NORMAL', 0, 999999);
INSERT INTO CUS_LEVEL VALUES (2, 'SILVER', 1000000, 1999999);
INSERT INTO CUS_LEVEL VALUES (3, 'GOLD', 2000000, 2999999);
INSERT INTO CUS_LEVEL VALUES (4, 'VIP', 3000000, 3999999);
INSERT INTO CUS_LEVEL VALUES (5, 'VVIP', 4000000, 999999999);

INSERT INTO CUSTOMER (CID, CTEL, CNAME) VALUES (CUS_SEQ.NEXTVAL, '010-9999-9999', '이정수');
INSERT INTO CUSTOMER VALUES (CUS_SEQ.NEXTVAL, '010-8888-9999', '한수아', 1000, 5000000, 5);

COMMIT;
ROLLBACK;
-- 0. 레벨이름들 검색 : public Vector<String> getLevelNames()
SELECT LEVELNAME FROM CUS_LEVEL ORDER BY LEVELNO;
-- 1. 아이디 검색 - CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 레벨업을 위한 쓸 돈
--public CustomerDto cIdGetCustomers(String cId);
SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 
    (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID = C.CID AND LEVELNO!=5) FORLEVELUP
    FROM CUSTOMER C, CUS_LEVEL L 
    WHERE C.LEVELNO = L.LEVELNO AND CID = 1; 
-- 2. 폰뒤4자리(FULL) 검색 - CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 레벨업을 위한 쓸 돈
--public ArrayList<CustomerDto> cTelGetCustomers(String cTel);
SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 
    (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID = C.CID AND LEVELNO!=5) FORLEVELUP
    FROM CUSTOMER C, CUS_LEVEL L 
    WHERE C.LEVELNO = L.LEVELNO AND CTEL LIKE '%'||'9999'; -- ? > '%'+'9999' 
-- 3. 고객이름검색 - CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 레벨업을 위한 쓸 돈
--public ArrayList<CustomerDto> cNameGetCustomers(String cName);
SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 
    (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID = C.CID AND LEVELNO!=5) FORLEVELUP
    FROM CUSTOMER C, CUS_LEVEL L 
    WHERE C.LEVELNO = L.LEVELNO AND CNAME = '한수아';
-- 4. 포인트로만 구매(1000원짜리를 포인트로만 구매) 
--public int buyWithPoint(int cAmount, int cId)
UPDATE CUSTOMER SET CPOINT = CPOINT - 500 WHERE CID = 1 AND CPOINT > 500;
-- 5. 물품구매 (1000000원짜리를 구매할 경우. 포인트는 구매금액의 5%)
-- 물품구매시 UPDATE 2회 필요(CPOINT, CAMOUNT, LEVELNO UPDATE)
--  public int buy(int cAmount, int cId)
UPDATE CUSTOMER SET CPOINT = CPOINT + 1000000*0.05, CAMOUNT = CAMOUNT + 1000000 WHERE CID = '1'; --1 포인트 누적
SELECT CNAME, CAMOUNT, C.LEVELNO, L.LEVELNO, LOW, HIGH FROM CUSTOMER C, CUS_LEVEL L
    WHERE CAMOUNT BETWEEN LOW AND HIGH;--2 레벨 변경
SELECT L.LEVELNO FROM CUSTOMER C, CUS_LEVEL L WHERE CAMOUNT BETWEEN LOW AND HIGH AND CID = 1; --서브 쿼리
UPDATE CUSTOMER SET LEVELNO = (SELECT L.LEVELNO FROM CUSTOMER C, CUS_LEVEL L WHERE CAMOUNT BETWEEN LOW AND HIGH AND CID = 1) WHERE CID =1;
UPDATE CUSTOMER SET CPOINT = CPOINT + 1000000*0.05, CAMOUNT = CAMOUNT + 1000000, 
    LEVELNO = (SELECT L.LEVELNO FROM CUSTOMER C, CUS_LEVEL L WHERE CAMOUNT+1000000 BETWEEN LOW AND HIGH AND CID = 1)
    WHERE CID = 1 AND CTEL LIKE '%'||'9999';
-- 6. 등급별출력 - CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 레벨업을위한쓸돈
--public ArrayList<CustomerDto> levelNameGetCustomers(String levelName)
SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 
    (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID = C.CID AND LEVELNO!=5) FORLEVELUP
    FROM CUSTOMER C, CUS_LEVEL L 
    WHERE C.LEVELNO = L.LEVELNO AND LEVELNAME = 'NORMAL';
-- 7.전체출력 - CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 레벨업을위한쓸돈
--public ArrayList<CustomerDto> getCustomers()
SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 
    (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID = C.CID AND LEVELNO!=5) FORLEVELUP
    FROM CUSTOMER C, CUS_LEVEL L 
    WHERE C.LEVELNO = L.LEVELNO; 
-- 8. 회원가입(고객전화와 고객이름은 입력받아 INSERT)
--public int insertCustomer(String cTel, String cName)
INSERT INTO CUSTOMER (CID, CTEL, CNAME) VALUES ( CUS_SEQ.NEXTVAL , '010-7215-1187', '이정백'); 
-- 9. 번호수정 : public int updateCustomer(String cTel, int cId)
UPDATE CUSTOMER SET CTEL = '010-8854-6542' WHERE CID = 3;
-- 10. 회원탈퇴 : public int deleteCustomer(String cId)
DELETE FROM CUSTOMER WHERE CID = 3;
COMMIT;
SELECT * FROM CUSTOMER;