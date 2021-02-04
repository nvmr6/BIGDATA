#####CH 5. 데이터 전처리

###1. 파일 입출력

##1.1) 시스템 인코딩 조회
Sys.getlocale()

##1.2) write.table
class(iris)
write.table(iris, file='outData/iris.csv', sep=',', row.names = FALSE)

str(InsectSprays)
write.table(InsectSprays, file='outData/insect.csv', sep=',', row.names = FALSE)

##1.3 read.table
irisData <- read.table('outData/iris.csv',sep = ',', header = TRUE)
head(irisData)
tail(irisData)
str(irisData)
irisData$Species <-as.factor(irisData$Species, levels = c("setosa","versicolor", "virginica"))
str(irisData$Species)
summary(irisData)

##1.4) write.csv
write.csv(iris, file='outData/irisCsv.csv')
##1.5) read.csv
irisCSV <- read.csv('outData/irisCsv.csv')
head(irisCSV)

##1.6) cat : 분석 결과등 저장
irisSummary <- summary(irisCSV)
class(irisSummary)
cat('iris 요약', '\n')
for(i in 1:nrow(irisSummary)){
  cat(irisSummary[i,], '\n', file='outData/irisSummary.txt', append=T) 
}

###2. apply 계열 함수

##2.1) apply
#iris 데이터 열별 평균, 합계, 분산, 표준편차, 최소, 최대
#apply(데이터, 1, 함수) 1은 행별 함수 수행, 2는 열별 함수 수행
head(iris[,1:4])
apply(iris[,1:4], 1, mean)# 행별 평균
apply(iris[,1:4], 2, mean)# 열별 평균
apply(subset(iris[,1:4],subset = (iris$Species=='setosa')), 2, mean)# setosa열별 평균
apply(subset(iris[,1:4],subset = (iris$Species=='versicolor')), 2, mean)# versicolor열별 평균
apply(subset(iris[,1:4],subset = (iris$Species=='virginica')), 2, mean)# virginica열별 평균

apply(iris[,1:4], 2, sd)# 표준편차
apply(iris[,1:4], 2, sum)# 열별 합계
apply(iris[,1:4], 2, median)# 열별 중앙값
apply(iris[,1:4], 2, min)# 열별 최소값
apply(iris[,1:4], 2, max)# 열별 최대값

name <- c('kim', 'hong', 'park', 'han', 'jung')
kor <- c(87,65,84,95,62)
eng <- c(54,87,32,65,97)
mat <- c(54,87,65,29,15)
student <- data.frame(name, kor, eng, mat)
student

apply(student[,-1], 1, mean) #학생별
apply(student[, -1], 2, mean)#과목별

##2.2) lapply: list apply: 결과도 list
x <- list(a=1:10, b=exp(-3:3), logic=c(T, F, F, T))
x
lapply(x, mean) #항목별 평균, 리스트 스타일일
lapply(x, quantile)  
lapply(x, quantile, 1:3/4)#4분할점

##2.3) sapply: list apply: 결과도 matrix, vector
sapply(x, mean)#항목별 평균, 행렬 반환
sapply(x, quantile)

fivenum(0:10)
(i39 <- sapply(c(3:9), seq))
sapply(i39, fivenum)

###EX
irisList <- as.list(iris[,-5])
lapply(irisList, mean)
sapply(irisList, mean)

##3.4 vapply: list apply: 결과는 모든 값이 특별값과 호환되는지 확인
vapply(irisList,mean,numeric(1))
vapply(i39, fivenum, FUN.VALUE = c(numeric(1), numeric(1), numeric(1), numeric(1), numeric(1)))

cities <- c('seoul', 'busan', 'new york', 'tokyo')
nchar(cities[1])
sapply(cities, nchar)
lapply(cities, nchar)

##3.5 mapply: apply: 여러개의 인자를 함수에 전달
rep(c(1,2,3), each=3, times=2)
mapply(rep, x=1:4, times=4:1)

#직업별 수입
job <- c(3,3,5,2,2,3,5,3,4,4,6,3)
income <- c(4879,6509,4183,0,3894,0,3611,6454,4975,8780,0,4362)
cust <- data.frame(job, income)
cust
income.avg <- c(900,0,3500,3600,3700,6800,3900,4000)
names(income.avg) <- 0:7
income.avg
zero2mean <- function(job, income){
  if(income==0){
    return (income.avg[as.character(job)])
  }else{
    return (income)
  }
}
(cust$income2 <- mapply(zero2mean,cust$job,cust$income))
cust
###3. 데이터 그룹화 함수 
##3.1) tapply: 그룹화 처리를 위한 apply
tapply(iris$Sepal.Length, iris$Species, mean)
tapply(iris$Sepal.Length, iris$Species, sd)
boxplot(iris$Sepal.Length~iris$Species)
cust$job <- factor(cust$job, levels <- 0:7)
str(cust)
tapply(cust$income2, cust$job, mean)

InsectSprays
str(InsectSprays)
tapply(InsectSprays$count, InsectSprays$spray, mean)
tapply(InsectSprays$count, InsectSprays$spray, sd)
boxplot(InsectSprays$count~InsectSprays$spray)

##3.2) by: 그룹화 처리를 위한 apply(for data.frame)
by(iris[,-5], iris$Species, summary) ##mean, sd 불가
#cust의 직업별 평균을 income, income2 동시에
by(cust[,2], cust$job, mean)
##3.3) summayBy:그룹화 처리를 위한 apply(2개 이상의 함수)
#doBy 패키지
install.packages("doBy")
library(doBy)
summaryBy(iris[,-5] ~ Species,iris, FUN=c(sd,mean))

#emp.csv
emp <- read.csv('inData/emp.csv', header = T, stringsAsFactors = F)
emp <- read.csv(file.choose())
str(emp)
emp$deptno <- as.factor(emp$deptno)
summaryBy(sal+comm ~ deptno,emp,na.rm=T)#default: mean

##3.4) orderBy:정렬
orderBy(~Sepal.Length, data=iris)#오름차순
orderBy(~-Sepal.Length, data=iris)#내림차순
orderBy(~Species+Sepal.Length, data=iris)
orderBy(~Species+Sepal.Length, data=iris)[,c(1:4)]

orderBy(~sal, data=emp)[,c(2,6)]
orderBy(~sal, data=emp)[c(1:5),c(2,6)]

##3.5) sampleBy
sampleBy(~Species, data=iris, frac = 0.2)# 종별로 20% 표본 임의추출
sampleBy(~Species, data=iris, frac = 0.2, replace = T) # 복원 추출
sampleBy(~Species, data=iris, frac = 0.1, systematic = T)#계층적 추출 (주기적)

#벡터 샘플링
(idx <- sample(1:150, 10))
iris[idx, ]

###4. formula ~
#lm() 선형회귀식 도출 함수(독립변수, 종속변수 연속적 변수에서 사용(명명식 제외)
#EX1
x <- c(1,2,3,4,5) #공부량-독립
y <- c(20,41,59,81,99)#점수-종속 > lm() 이용
y1 <- c('f', 'f', 'f', 'p', 'p') # 당락여부 - 로지스틱 회귀> glm()
(fit <- lm(y ~ x)) #회귀분석모델
plot(x,y, col='blue')
lines(x,19.8*x+0.6, col='red')
abline(fit, lty='dashed')

#EX2
x1 = c(1,2,3,4,5) #공부량
x2 <- c(10,20,3,4,5) #문제수
y <- c(50,70,63,84,95)
(fit <- lm(y~x1+x2)) #x1, x2 가 상관관계가 없다는 전제
plot(x1,y)
plot(x2,y)
abline(fit, lty='dashed')

#EX3
cars
(fit <- lm(cars$dist ~ cars$speed))
plot(cars$speed,cars$dist, col='blue')
abline(fit, col='red')

###5. 데이터 분리
##5.1) split
(iris.species <- split(iris, iris$Species)) # list 형태로 분리

(iris.sepal <- split(iris, iris$Sepal.Length>5))

##5.2) subset
subset(iris[,c(1,3)],subset = (iris$Species=='setosa'))
subset(iris[,-5],subset = (iris$Species=='setosa'))
subset(iris[,c(-5)],subset = (iris$Species=='setosa' & iris$Sepal.Length>=4))

###6. 데이터 합치기
#cbind / rbind
student.a <- data.frame(name=c('lee', 'kim'), score=c(100,90))
student.b <- data.frame(id = c(100,101), gender = c('m', 'f'))
(student <- cbind(student.a, student.b))
student.c <- data.frame(name=c('han', 'jung'), score=c(80,65), id=c(102,103), gender = c('f', 'm'))
(student <- rbind(student, student.c))

#merge() 병합하기
student.a <- data.frame(name=c('lee', 'kim'), kor=c(100,90))
student.b <- data.frame(name=c('lee', 'kim'), eng=c(80,70), mat = c(80,90))
(student <- merge(student.a, student.b))

student.a <- data.frame(name=c('yun', 'kim'), kor=c(100,90))
student.b <- data.frame(name=c('lee', 'kim'), eng=c(80,70), mat = c(80,90))
(student <- merge(student.a, student.b, all = T)) # 결측치 포함 모든 정보 병합

###7. 데이터 정렬
#sort(): 정렬된 데이터 반환 / order(): 정렬된 데이터 인덱스 반환
data <- c(10,30,100,1,3)
w
names(data) <- c(1:5)
sort(data)
order(data)
data[order(data)]
oㅈ
iris[order(iris$Sepal.Length, decreasing = T),]

order(-iris$Sepal.Length, iris$Sepal.Width)
iris[order(-iris$Sepal.Length, iris$Sepal.Width),]

emp[order(emp$sal, decreasing = T) ,c(2,6)]
emp[order(emp$sal, decreasing = T)[1:5] ,c(2,6)]
emp[order(emp$sal)[1:5] ,c(2,6)]

###8. 데이터 프레임 이름 생략
##8.1) with, within
(iris.temp <- iris)
iris.temp[c(1,3), 1]<-NA
head(iris.temp)
#종별 중앙값
split(iris.temp$Sepal.Length, iris.temp$Species)
(mps<-sapply(split(iris.temp$Sepal.Length, iris.temp$Species), median, na.rm=T))
(mps <- tapply(iris.temp$Sepal.Length, iris.temp$Species, median, na.rm=T))
mps['setosa']
iris.temp$Sepal.Length2 <- ifelse(is.na(iris.temp$Sepal.Length), mps[iris.temp$Species], iris.temp$Sepal.Length)
iris.temp$Sepal.Length2 <- NULL

#데이터 프레임 이름 생략
iris.with <- with(iris.temp,{
  mps <- tapply(Sepal.Length, Species, median, na.rm=T)
  Sepal.Length <- ifelse(is.na(Sepal.Length), mps[Species], Sepal.Length)
})#대치된 결과값 반환
iris.with
iris.temp

iris.temp <- within(iris.temp,{
  mps <- tapply(Sepal.Length, Species, median, na.rm=T)
  Sepal.Length <- ifelse(is.na(Sepal.Length), mps[Species], Sepal.Length)
})#대치된 데이터 프레임 셋 반환
iris.temp

##8.2) attach, detach
attach(iris)
#이하는 iris$ 생략 가능
summary(Species)

###9. 데이터 집계
##9.1) table
table(iris$Species)
#factor 변수 이용
table(InsectSprays$spray)
emp
emp$deptno <- factor(emp$deptno, levels = c(10,20,30,40))
str(emp)
table(emp$deptno)

##9.2) aggregate: 데이터를 하위집합으로 분할하고 요약 통계 계산
aggregate(iris[,-5], by=list(iris[,5]),mean)

cust.id <-c(1005,1002,1003,1004,1005,1001,1005,1002,1003,1005)
hos.day <- c(2,3,20,5,13,0,8,2,3,16)
data <- data.frame(cust.id, hos.day)
daypercust <- aggregate(data$hos.day, by=list(data$cust.id), sum)
names(daypercust) <- c('환자번호', '입원일')
daypercust

aggregate(data$hos.day, by=list(data$cust.id), sum)#대상열 1개 이상 가능
tapply(data$hos.day, data$cust.id, sum) #대상열 1개 가능
library(doBy)
summaryBy(hos.day~cust.id, data=data, FUN=c(sum, mean))#2개 이상 함수 사용 가능

###10. 조건으로 인덱스 찾기
which(iris$Species=='setosa')
iris[which(iris$Species=='setosa'),]        
iris[which.max(iris$Sepal.Length),]        

