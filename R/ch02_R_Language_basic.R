#####2장

##1. 도움말 기능

#1.1 도움말
iris
edit(iris)
?iris
help(iris)

#1.2 검색기능
??iris
help.search('iris')

#1.3패키지 도움말
library(help="datasets")

#1.4 함수 도움말
methods(as) #형변환 함수
as.integer(1.25)
?as.integer
example(as.integer) #예제 출력

data <- c(10,20,30)
mean(data)
example(mean)#열이름, 행이름, 타입
#주석과 자동완성
# 자동완성 tab

#1.5 정보 조회
edit(iris)
attributes(iris)

##2. 패키지
#R내의 기본 패키지(이외의 패키지 설치)

#2.1 패키지 설치
#설치 :install.package("패키지명")
#메모리 로드: library("패키지명")
#함수 사용
#패키지 언로드: detach("패키지명", unload=TRUE)
iris
detach("package:datasets", unload=TRUE)
iris
install.packages("arules")
library("arules")
?apriori
detach("package:arules", unload=TRUE)
?apriori

#데이터의 경우는 메모리에 패키지 로드 없이 사용 가능
iris <- data(list="iris", package="datasets")
iris

#변수 삭제
ls()
rm(list=ls())
ls()

##3. 변수
#변수: _ . 
#할당: <-, <<-
result<-0 #전역변수
class(result)
add <- function(a,b){
  result <<- a+b #지역변수 <<- a+b 전역 변수
  return (result)
}
add(10,20)

#변수 목록
ls()

##4. 출력
paste('hello', 'world')
paste('result 값은', result)
paste('hello', 'world', sep=',')
paste(1:10)
paste(c(1,2,3), c('하나', '둘', '셋'), sep='은 ')
paste(c(1,2,3), c('하나', '둘', '셋'), sep='은 ', collpase='/')
month.name
(nth<-paste(1:12, c('st', 'nd', 'rd', rep('th', 9)), sep=''))
paste(month.name, nth, sep='은 ', collapse=" ; ")
rm(list=ls())
rm(list=ls(all.names = TRUE))#히든 변수까지 삭제

#ex1
kor<-c('한국', '일본', '미국')
eng<-c('korea', 'japan', 'USA')
paste(kor,eng,sep=': ')
paste(kor,eng,sep=': ',collapse=', ')

#ex2
Cars93 #>패키지 로드
library(MASS)#패키지 설치
install.packages("MASS")
edit(Cars93)
