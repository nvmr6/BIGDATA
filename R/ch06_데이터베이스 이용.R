##### ch06. DB 이용 #####
#SQL문으로 데이터 프레임과 DB테이블 이용

###6.1 SQL문을 이용한 데이터 프레임 처리
install.packages("sqldf")
library(sqldf)
library(dplyr)
library(doBy)
sqldf("SELECT DISTINCT SPECIES FROM iris") #종만 출력
names(table(iris$Species))
iris %>% 
  group_by(Species) %>% 
  summarise()

sqldf("select * from iris where Species = 'virginica'")#viginica종만 출력
iris[iris$Species=='virginica',]
iris %>% 
  filter(Species=='virginica')

sqldf("select * from iris where Species = 'virginica' and `sepal.length` >= 7.5")
iris[iris$Species == 'virginica' & iris$Sepal.Length >= 7.5,]
iris %>% 
  filter(iris$Species == 'virginica' & iris$Sepal.Length >= 7.5)

sqldf("select species, sum(`sepal.length`) from iris group by species")
tapply(iris$Sepal.Length, iris$Species, sum)
by(iris$Sepal.Length, iris$Species, sum)
summaryBy(Sepal.Length~Species,iris,FUN=sum)
aggregate(iris$Sepal.Length, by=list(iris$Species), sum)
iris %>% 
  group_by(Species) %>% 
  summarise(sum=sum(Sepal.Length))

sqldf("select * from iris order by `sepal.length` limit 5") #TOP-N (0-4)
sqldf("select * from iris order by `sepal.length` limit 5, 5") #TOP-N (5-9)

#평균과 표준편차
sqldf("select avg(`petal.length`) avgPL, avg(`petal.width`) avgPW, stdev(`petal.length`) sdPL, stdev(`petal.width`) sdPW from iris")
apply(iris[,3:4], 2, mean)
apply(iris[,3:4], 2, sd)

#종별 출력
sqldf("select species, avg(`petal.length`) avgPL, avg(`petal.width`) avgPW, stdev(`petal.length`) sdPL, stdev(`petal.width`) sdPW from iris group by species")
summaryBy(Petal.Length+Petal.Width~Species,iris,FUN=c(mean, sd))

#join
getwd()#작업 디렉토리 출력
setwd()#작업 디렉토리 변경
emp <- read.csv("inData/emp.csv")
dept <- read.csv("inData/dept.csv")

sqldf("select empno, ename, job, sal, e.deptno, dname from emp e, dept d where e.deptno = d.deptno") #테이블명 .은 ``불필요
sqldf("select empno, ename, e.deptno, dname from emp e join dept d on e.deptno = d.deptno")

###6.2 오라클 데이터 베이스 연동
#사전 작업: 자바 설치 > 환경설정(JAVA_HOME) > 작업 디렉토리(getwd())에 ojdbc6.JAR

#패키지 설치: RJDBC
install.packages("RJDBC")
library(RJDBC) #오라클 연동

#드라이버 클래스 로드
drv <- JDBC(driverClass = "oracle.jdbc.driver.OracleDriver", classPath = "ojdbc6.jar")
#데이터베이스 연결
con <- dbConnect(drv, "jdbc:oracle:thin:@127.0.0.1:1521:xe", "scott", "tiger")
#SQL 전송 후 결과 받기
emp <- dbGetQuery(con, "select * from emp")
emp

#테이블 전체 데이터
dept <- dbReadTable(con, "dept")
dept

#SQL전송 - DB 수정
dbSendUpdate(con, "INSERT INTO DEPT VALUES (90, 'www', 'aaa')")
dbSendUpdate(con, "UPDATE DEPT SET LOC='INCHEON' WHERE DEPTNO=90")
dbSendUpdate(con, "DELETE FROM DEPT WHERE DEPTNO = 60")
#DB 연결 해제 / 드라이버 언로드
dbDisconnect(con)
dbUnloadDriver(drv)
detach("package:RJDBC", unload = T)

###6.3 MySQL 데이터 베이스 연동
# MySQL Workbench에서 
# ALTER USER '아이디'@'localhost' IDENTIFIED WITH mysql_native_password BY '비밀번호';
# ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'mysql';
install.packages("RMySQL")
library(RMySQL)
drv <- dbDriver("MySQL")
con <- dbConnect(drv, host="127.0.0.1", dbname="kimdb", user="root", password="mysql")
rs <- dbSendQuery(con, "select * from personal")
personal <- fetch(rs, n=-1)
personal
dbUnloadDriver(drv)
dbDisconnect(con)
