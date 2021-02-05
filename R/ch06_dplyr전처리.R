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








