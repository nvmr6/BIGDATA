#####3장

##1. 데이터 종류: 기본 데이터 타입(문자, 숫자, logical) - 스칼라
#         그 외 팩터, 벡터, 리스트, 행렬, 배열, 데이터프레임, 날짜, 특별한 값
##2. 기본 데이터 타입: character, numeric, logical
a <- "Hello"
a
class(a)
cat(a) #print와 같음

b <- 10
b
class(b)

strB <- as.character(b) #형변환
class(strB)

c <- TRUE
c
class(c)
is.logical(c)

str(a)#R의 내부 구조를 간결하게 표시
str(b)
##3. 특별한 값(Null, NA;결측치, NaN, Inf)
result <- 0
add <- function(a,b){
  result<-a+b
  return(result)
}
(temp <- add(2,3))
(temp <- add(a=2,b=3))
(temp <- add(b=2, a=3))

addNull <- function(a,b){
  result<-a+b
  return()
}
(temp <- addNull(2,3)) #null
is.null(temp)

d <- c(2,4, NA, 6, NA, 12) #벡터 - 동일 자료형 집합
d
#결측치 관련 함수
is.na(d[3])
is.na(d)
complete.cases(d) # is.na와 반대
na.omit(d) #결측치 제외
na.pass(d) # 모두 출력

mean(d) #NA 포함시 NA
mean(d, na.rm=TRUE) #NA 제외 평균
boxplot(d)

##4. 팩터: 범주형 데이터 , 명명식, 순서식
gender1 <- c('m', 'm', 'f')
gender <- factor(c('m', 'm', 'f'), levels=c('m', 'f'))
class(gender)
gender
str(gender)
gender1 <- as.factor(gender1) #팩터형으로
gender1
level <- factor(c('good', 'bad', 'nice', 'nice', 'best'), levels=c('worst', 'bad', 'good', 'nice', 'best'), ordered = TRUE)
#level <- ordered(c('good', 'bad', 'nice', 'nice', 'best'), levels=c('worst', 'bad', 'good', 'nice', 'best'))
level
str(level)
nlevels(level)#범주 수수
levels(level)#범주


# 5. 구조형 변수와 복합형 변수
#(1) 구조형 변수 > 동일 자료형 ex)벡터, 행렬, 배열
#(2) 복합형 변수 > 다른 자료형 허용 ex) 리스트, 데이터프레임임

#6. 벡터: 동일 자료형 집합
data1 <- c(11,22,33, 'test') # 문자 포함시 문자형으로 지정
class(data1)
data2 <- c(11,22,33, TRUE) # TRUE:1, FALSE:0
class(data2)
data3 <- c('test', TRUE) # 문자형
class(data3)

data <- c(1,2,3) # 1인덱스부터 시작
NROW(data) #항목 수
length(data) # 항목 수
data <- c(1:100)
data
data <- c(1:4)
names(data) <- c('A','B', 'C', 'D')
data
data[1] 
data['A'] #특정값 조회
data[c(2,3)] #여러값 조회
data[c(1:3)] #여러값 조회
data[-2]# 값 제외
data[data>2]# 값 이상 조회
data[c(TRUE, TRUE, FALSE, TRUE)]# 특정값 조회
2 %in% data #특정값 존재하는지

score <- c(80,60,70,50,90,NA)
names(score) <- c('A','B', 'C', 'D', 'E','F')
score
mean(score, na.rm=TRUE)
cat(score)
cat(paste("score:",score))
is.vector(score)

#1) character()
charArr <- character(5) #length가 5인 벡터
is.vector(charArr)
length(charArr)
charArr # 빈 스트링
charArr[7] = "abc"
charArr # 6인덱스 NA
#2) numeric()
numArr <- numeric(5) #length가 5인 벡터
is.vector(numArr)
length(numArr)
numArr # 0
#3) logical()
logArr <- logical(2) #length가 2인 벡터
is.vector(logArr)
length(logArr)
logArr #FALSE
#4)seq(): 순서 객체
a <- seq(from=1,to=10, by=2)
is.vector(a)
#5) rep(): 반복 객체
rep(1:4, 2)
rep(1:4, 3, 9)
#6) 벡터의 연산
a <- c(1,2,3)
b <- c(10,20,30)
a+b
a-b
a*b
a/b
a%%b
c(a,b) # 벡터 결합

a <- c(1,2,3)
b <- c('a', 'b', 'c')
c <- c(TRUE, FALSE)
(z <- c(a,b,c)) # 타입 변경
(a <- append(a,c(4,5,6)))

# 벡터의 집합 연산(합, 교, 차, 비교)
a <- c(1,2,3,4,5,6)
b <- c(2,4,6)
union(a,b) #합집합
intersect(a,b) #교집합합
setdiff(a,b) #차집합
setdiff(b,a) #차집합
setequal(a,b) #비교 연산

##7.리스트
student <- list(name='hong', age=25)
student
(studentVector <- unlist(student))
(as.list(score))

student$name
student[1]
student[[1]]

student$age <- NULL
student


##8.행렬
(colMatrix <- matrix(1:15, 5)) # 열수 3 열 중심 정렬
(colMatrix <- matrix(1:15, 5,3, TRUE))#행 중심 정렬
dim(colMatrix)
nrow(colMatrix)
ncol(colMatrix)
dimnames(colMatrix) <- list(c('1월', '2월', '3월', '4월', '5월'), c('hong', 'kim','lee'))
colMatrix


#행렬의 곱을 이용하여 선형회귀식 도출
x <- c(2,4)
y <- c(40,60)
X <- matrix(c(x,rep(1,NROW(x))), nrow = 2, ncol = 2)
X
Y <- matrix(y,ncol = 1)
Y
#X %*% ab = Y
(ab <- solve(X) %*% Y)
ab[1]
ab[2]
plot(x,y)
lines(x, y)
lines(x, ab[1]*x+ab[2])

x <- c(32,64,96,118,126,144,152.5,158)#독립변수
y <- c(18,24,61.5,49,52,105,130.3,125)#종속변수
X <- matrix(c(x, rep(1,NROW(x))), ncol=2)
Y <- matrix(y,ncol=1)
X
Y
#정방행렬이 아니기 때문에 역행렬 불가 > 전치 행렬 이용
t(X)
t(X) %*% X # 2*8 %*% 8*2 = 2*2
(ab <- solve(t(X) %*% X) %*% t(X) %*% Y)
plot(x,y)
lines(x, ab[1]*x+ab[2])

#다변량 회귀분석
x1 <- c(60,65,55) #몸무게
y1 <- c(5.5,5.0,6.0) #키
z1 <- c(1,0,1) #흡연유무
y <- c(66,74,78) #결과
X <- matrix(c(x1,y1,z1), ncol = 3)
Y <- matrix(y, ncol = 1)
ab <- solve(X) %*% Y

a <- matrix(1:4, nrow=2, ncol = 2)
b <- matrix(seq(10,40,10), nrow=2, ncol = 2)
a
b
a+b
a*b
a^b
a%%b
a%*%b
(payMatrix <- matrix(c(12000,26000,18000), ncol = 3))#각자 시간당 수당
(workerMatrix <- matrix(c(c(5,4,9), c(7,3,2)), ncol = 2)) #매달 각자 일한 시간
(pay <- payMatrix %*% workerMatrix) # 월별 급여 지급급

##9. 배열
dataArray <- array(1:24, dim=c(3,4,2))#3행 4열 2면 배열
dim(dataArray)
length(dataArray)
dim(dataArray) <- c(3,8) #reshape

##10. 데이터 프레임(객체배열)
student_id <- c('20211','20212','20213','20214')
student_name <- c('hong', 'kim', 'lee', 'jung')
student_kor <- c(87,98,65,47)
student_eng <- c(48,31,98,44)
student_gender <- c('남', '여','남', '여')
(student_data <- data.frame(student_id, student_name, student_kor, student_eng, student_gender))

student_data$student_mat <- c(78,98,56,77) # 열 추가
student_data$mat <- NULL # 열 삭제
student_data
student_data$student_gender <- as.factor(student_data$student_gender) # 열 형변환
class(student_data$student_gender)
str(student_data) #구조 보기기
summary(student_data)

#데이터 프레임 합치기
#행 합치기 rbind
#열 합치기 cbind
id <- data.frame(student_id)
student <- cbind(id, student_data)
student

#부분 데이터 조회
student <-rbind(student, student)
student
student$student_id <- NULL
student
student[1,1]
student[,1]
student[c(1:3),]
student[,c(3,4,6)]

subset(student, subset=(student$student_mat>=90))
head(student, 3)

#############################EX#####################################
emp <- read.csv(file.choose())
emp
class(emp)
#1. ename
emp[,2, drop=FALSE]
#2. ename, job, sal
emp[,c(2,3,6)]
#3. empno, job, hiredate, sal (king)
subset(emp[,c(1,3,5,6)], subset = (emp$ename=='KING'))
#4. empno, ename, sal (sal>=2000)
subset(emp[,c(1,2,6)], subset = (emp$sal>=2000))
#5. ename, sal (2000<= sal <= 3000)
subset(emp[,c(2,6)], subset = (emp$sal>=2000) & (emp$sal <= 3000))

##11. 타입 판별 및 타입 변환
class(emp$deptno)
str(emp)
emp$deptno <- as.factor(emp$deptno) #타입 변환

edit(iris)
iris$Species <- as.character(iris$Species)# 그룹화에 위험
str(iris)
iris$Species <- as.factor(iris$Species) 
class(iris$Species)

#12. 문자열과 날짜
name <- 'dan'
length(name)
nchar(name) #문자의 갯수

names <- c('dan', 'kim', 'wen')
nchar(names)
length(names)
#하위 문자열 추출: substr
substr('abcdef', 1, 4) #인덱스 그대로 출력 (4 전까지 X)
substr(names, 1,2)
substr(names, nchar(names)-1,nchar(names) )
paste(names, 'is', 'fine')

#문자열 분할
path <- 'home/hadoop/data/speech.csv'
strsplit(path, '/')

#문자열 대체
s <- "Curly is smart, Curly is funny, too"
sub('Curly', 'Eric', s)
gsub('Curly', 'Eric', s)
