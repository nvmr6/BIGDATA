###1. 외부파일
##1.1) 엑셀 파일 읽어오기-readxl
install.packages("readxl")
library(readxl)
getwd()
exam <- read_excel("inData/exam.xlsx")
(exam<-as.data.frame(exam))
exam[21,] <- data.frame(id=1, class=1,math=90, english=80, science=99)
exam
exam$tot <- exam$math + exam$english + exam$science # 파생변수 추가
exam
mean(exam$tot)
exam$grade <- ifelse(exam$tot>mean(exam$tot), 'up', 'down') #파생변수 추가
exam
apply(exam[,3:6], 2, mean)

#데이터 파일의 컬럼명이 없는 경우
data <- read_excel("inData/data_ex.xls", col_names = F)
colnames(data) <- c('id', 'sex', 'age', 'area')
data

##2.1) 데이터 쓰기 (파일(csv) / 변수)
write.csv(exam,"outData/exam.csv", row.names = F) #파일 쓰기
save(exam, file = "outData/exam.rda") # 변수 파일로 저장
load("outData/exam.rda")#환경창과 메모리에 표시
exam

###2. 데이터 파악하기
(mpg <- as.data.frame(ggplot2::mpg))  # 데이터 불러오기
head(mpg)
tail(mpg)
edit(mpg)
View(mpg)#뷰 창에서 데이터 확인용
dim(mpg)
summary(mpg)

#변수명 바꾸기
install.packages("dplyr")
library(dplyr)
mpg <- rename(mpg, city = cty)
mpg <- rename(mpg, highway = hwy)
#파생변수(계산식)
head(mpg)
mpg$total <- (mpg$city + mpg$highway)/2
#파생변수(조건식)
mean(mpg$total)
mpg$grade <- ifelse(mpg$total>=mean(mpg$total), "pass", "fail")
table(mpg$grade)# 빈도표
boxplot(mpg$total)#1
hist(mpg$total)#2
library(ggplot2)
install.packages("vioplot")
library(vioplot)
vioplot(mpg$total)#3
qplot(mpg$grade)

#EX1
midwest <- ggplot2::midwest
head(midwest)
View(midwest)
summary(midwest)
midwest <- rename(midwest, total=poptotal, asian=popasian)
midwest$asianRatio <- midwest$asian/midwest$total*100
hist(midwest$asianRatio)
midwest$mean <- ifelse(midwest$asianRatio>=mean(midwest$asianRatio), "large", "small")
hist(table(midwest$mean))

###3. 파악한 데이터를 dplyr 패키지를 이용하여 전처리 및 분석하기
library(dplyr)# dplyr 로드

##3.1) 조건에 맞는 데이터 추출 filter()
# >결과만 추출
exam <- read.csv("inData/exam.csv", header = T)
library(dplyr)
# %>% ctrl+shift+m
exam %>% 
  filter(class == 1)
exam %>% 
  filter(class %in% c(1,2,3))
exam1 <- exam %>% 
  filter(class == 1 & english >= 80)

#3.2) 필요한 변수 추출 select()
exam %>% 
  select(class, english, math)
exam %>% 
  filter(class %in% c(1,2)) %>% 
  select(english, math)
exam %>% 
  filter(class %in% c(1,2,3)) %>% 
  select(english, math) %>% 
  head(5) # 앞 5개 출력

#3.3) 정렬하기 arrange()
exam %>% 
  arrange(math)
exam %>% 
  arrange(desc(math))
exam %>% 
  filter(id %in% c(1:10)) %>% 
  select(english, math) %>% 
  arrange(english) %>% 
  head()

#3.4) 파생변수 추가 mutate()
exam %>% 
  mutate(total=math+english+science) #결과만 추출
exam %>% 
  mutate(total=math+english+science, avg = as.integer(total/3))

#추가한 파생변수에 dplyr에 바로 활용
exam %>% 
  mutate(total=math+english+science, avg = as.integer(total/3)) %>% 
  select(-id) %>% 
  arrange(total)

#3.5) 요약하기 summarize()
exam %>% 
  summarise(mean_math=mean(math),mean_eng=mean(english),mean_sci=mean(science))
#가능한 함수: mean, sd, sum, min, max, median, n

#3.6) 집단별로 요약하기 group_by() + summarize()
exam %>% 
  group_by(class) %>%
  summarise(mean_math = mean(math)) %>%   
  arrange(mean_math)
exam %>% 
  group_by(class) %>%
  summarise(mean_math=mean(math),mean_eng=mean(english),mean_sci=mean(science))

#ex
mpg %>% 
  filter(class=="suv") %>% #suv
  group_by(manufacturer) %>% #회사별
  mutate(mean_tot = (city+highway)/2 ) %>%# 도시, 고속도로 연비 평균
  summarise(total = mean(mean_tot)) %>% #회사별 통합 연비 평균
  arrange(desc(total)) %>% #정렬
  head(5)

###4.데이터 합치기
#열 합치기: cbind, left_join
#열 합치기: rbind, bind_rows
#merge()

##4.1 열 합치기
test1 <- data.frame(id=c(1,2,3,4,5), midterm=c(87,65,45,84,23))
test2 <- data.frame(id=c(1,2,3,4,5), final=c(87,62,64,84,98), teacherid=c(6,6,8,8,9))
teacher <- data.frame(teacherid=c(6,8,9), teachername=c('kim','lee','park'))
cbind(test1, test2)
merge(test1, test2)
left_join(test1, test2,id="id")
left_join(test2, teacher,id="teacherid")

##4.2 행 합치기
group.a <- data.frame(id=c(1,2,3,4,5), test=c(54,97,65,87,99))
group.b <- data.frame(id=c(6,7,8,9,10), test=c(44,55,61,67,88))
rbind(group.a, group.b)
bind_rows(group.a, group.b)
group.a <- data.frame(id=c(1,2,3,4,5), test1=c(54,97,65,87,99))
group.b <- data.frame(id=c(6,7,8,9,10), test2=c(44,55,61,67,88))
rbind(group.a, group.b)
bind_rows(group.a, group.b)
merge(group.a, group.b, all = T)

###5. 데이터 정제 - 결측치, 이상치 정제
##5.1 결측치 정제
df <- data.frame(name=c('kim','lee','jung','han','park'), gender=c('m','f',NA,'m','f'), score=c(5,4,4,3,NA), income=c(2000,2000,3000,4000,4600))
is.na(df)
table(is.na(df$gender))
table(is.na(df$score))
na.omit(df) #결측치 있는 행 제거, 데이터 손실

library(dplyr)
df %>% 
  filter(!is.na(score)) %>% 
  summarise(mean_score=mean(score))
mean(df$score, na.rm = T)
tapply(df$score, df$gender, mean, na.rm=T)

x <- c(11,22,33,44,55,66,77,88,99,10000)
mean(x)
median(x)

exam <- read.csv("inData/exam.csv")
exam[c(3,8,15),'math'] <- NA
exam[c(1,2),'english'] <- NA
table(is.na(exam))
apply(exam[3:5], 2, mean, na.rm=T)
tapply(exam[,3], exam$class, mean, na.rm=T)

#결측치 대체

(exam$math <- ifelse(is.na(exam$math), median(exam$math, na.rm = T), exam$math))
(exam$math <- ifelse(is.na(exam$math), mean(exam$math, na.rm = T), exam$math))

(exam$english <- ifelse(is.na(exam$english), median(exam$english, na.rm = T), exam$english))

exam[c(3,8,15),'math'] <- NA
exam[c(1,2),'english'] <- NA
exam[c(9,7,12),'science'] <- NA
median <- round(apply(exam[3:5], 2, mean, na.rm=T))
median['math']
median['english']
median['science']

exam <- within(exam, {
  math <- ifelse(is.na(math), median['math'], math)
  english <- ifelse(is.na(english), median['english'], english)
  science <- ifelse(is.na(science), median['science'], science)
}) #within 대체
colSums(is.na(exam))#변수별 결측치 확인

#결측치 대체 2
median['math']
median['english']
median['science']
exam <- exam %>% 
  mutate(
    math <- ifelse(is.na(math), median['math'], math),
    english <- ifelse(is.na(english), median['english'], english),
    science <- ifelse(is.na(science), median['science'], science)
  )
colSums(is.na(exam))#변수별 결측치 확인

##5.2 이상치 정제
#집단적인 이상치 / 논리적인 이상치
#(1)논리적인 이상치
outlier <- data.frame(gender=c(1,2,1,2,3), score=c(90,95,100,99,101))
outlier$gender <- ifelse(outlier$gender==3, NA, outlier$gender)
outlier$score <- ifelse(outlier$score > 100, NA, outlier$score)
outlier

#(2) 정상범위 기분으로 많이 벗어난 이상치: 상하위 0.3% 또는 평균+표준편차*3
mpg <- as.data.frame(ggplot2::mpg)
mpg$hwy
mean(mpg$hwy)+sd(mpg$hwy)*3
mean(mpg$hwy)-sd(mpg$hwy)*3
result <- boxplot(mpg$hwy)$stats #극단치 경계, 1사분위, 중앙값, 3사분위, 극단치 경계
mpg$hwy <- ifelse(mpg$hwy>result[5]|mpg$hwy<result[1], NA, mpg$hwy)
head(mpg)
