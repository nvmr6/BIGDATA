#####CH4 R 프로그래밍

###1. 제어문
##1.1) 조건문
#if
num<- 9
if(num%%2==0){
  cat(num, ' 짝수')
}else{
  cat(num, ' 홀수')
}

#ifelse
ifelse(num%%2==0,'even', 'odd')
nums <- c(10,9,16,17,20)
result <- ifelse(nums%%2==0,'even', 'odd')
(m <- matrix(c(nums, result), ncol=5, byrow = TRUE))

#switch
switch(2, 'red','green','blue')

#readline
(colorValue <- readline(prompt="색: (red:1, green:2, blue:3)"))
switch(as.numeric(colorValue), 'red','green','blue')

color <- readline(prompt="색: (red / green / blue)")
colorValue <- switch(color, 'red'=1,'green'=2,'blue'=3)
cat(color, colorValue)

score <- readline(prompt="점수: ")
switch ((as.integer(score)/10-4),'F', 'D', 'C', 'B', 'A', 'perfect')

getgrade <- function(){
  score <- readline(prompt="점수: ")
  grade <- switch ((as.integer(score)/10-4),'F', 'D', 'C', 'B', 'A', 'perfect')
  cat(score, '점은 ' ,grade)
}
getgrade()

##1.2) 반복문
#for
x <- c(2,5,4,8)
for(val in x){
  cat(val,'\t')
}
count <- 0
for(val in x){
  if(val%%2==0){
    count <- count+1
  }
}
count

factorial <- function(num){
  result <- 1
  if(num == 0){
    result <- 1
  }else{
    for(val in 1:num){
      result <- result * val
    }
  }
  cat(result)
}
factorial(4)
factorial(0)

rm(list=ls())
getwd()
source('factorial.R', encoding = 'utf-8')
factorial(4)
factorial(0)

#while
i <- 1
while(i<10){
  cat(i)
  i <- i+1
}

#repeat
i <- 1
repeat{
  if(i>6) break
  print(i)
  i<-i+1
}
x<-1
while(x<10){
  x<-x+1
  if(x==3) break
  cat(x, '\t')
}
while(x<10){
  x<-x+1
  if(x==3) next
  cat(x, '\t')
}

###2. 연산자
##2.1) 논리 연산자
TRUE & TRUE
TRUE && TRUE
x <- c(TRUE, TRUE, FALSE, FALSE)
y <- c(TRUE, FALSE, TRUE, FALSE)
x&y #모든 요소 검사
x && y #첫 요소만 검사
x|y #모든 요소 검사
x || y #첫 요소만 검사

## 2.2) 중위 연산자
'%add%' <- function(x,y){
  return (x+y)
}
9%add%4
## %in%:요소 확인, %o%:외적, %*%: 행렬곱
(matrix.a <- matrix(1:6, nrow=3, ncol=2))
(matrix.b <- matrix(1:6, nrow=2, ncol=3))
matrix.a %*% matrix.b

###3. 함수
poe <- function(x,y){
  return (x^y);
}
poe
poe(2,3)

#가변 인자 함수
total <- function(...){
  args <- list(...)
  sum <- 0
  for(val in args){
    sum <- sum+val
  }
  return(sum)
}
total(1,2,3,4,5)

#재귀 호출
fact <- function(num){
  if(num<0){
    return()
  }else if(num==1){
    return (1);
  }else{
    return(num*fact(num-1))
  }
}
fact(4)

###4. R환경
environment()
f <- function(f_x){
  g <- function(g_x){
    print('in g')
    print(environment())
    print(ls())
  }
  g(5)
  print(environment())
  ls()
}
f(10)




