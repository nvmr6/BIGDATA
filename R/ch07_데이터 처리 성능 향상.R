##### ch07. 데이터 처리 성능 향상 #####
#plyr 패키지, 구조 변경, 데이터 테이블
detach("package:dplyr", unload = T)

#1. plyr 패키지: 데이터 분할, 함수 적용 등 사용
install.packages("plyr")
library(plyr)
apply(iris[,1:4],2,mean) # mean(iris[,1])
apply(iris[,1:4],2,function(col){
  mean(col)
})
sapply(iris[,1:4], function(col){
  mean(round(col))
})#함수 삽입

x <- data.frame(v1=c(4,9,16), v2=c(25,36,49))
apply(x, 2, function(col){
  mean(sqrt(col))
})

#apply, sapply ...와 유사
adply(.data=iris[,1:4], .margins=2,function(col){sum(col)})

#summaryBy와 유사
ddply(.data=iris, .(Species), function(group){
  data.frame(SL.mean=mean(group$Sepal.Length),
             SWmean = mean(group$Sepal.Width))
})
ddply(iris,.(Species), summarize, SLmean=mean(Sepal.Length), SWmean = mean(Sepal.Width))

dfx <- data.frame(group=c(rep('A',8), rep('B',15), rep('C', 6)), 
                  gender = sample(c('M', 'F'), size=29, replace = T), 
                  age=round(runif(29, min=18, max=54)))
dfx
ddply(dfx, .(group, gender), summarise, mean = mean(age), sd = sd(age))


###7.2 데이터 구조 변경(melt, cast)
install.packages("reshape2")
library(reshape2)
airquality
airquality[airquality$Month==5 & airquality$Day==1,]
subset(airquality, Month==5 & Day==1)

#melt
airquality.melt <- melt(airquality, id=c('Month', 'Day'), na.rm = T) #결측치 제거
head(airquality.melt)
airquality.melt[airquality.melt$Month==5 & airquality.melt$Day==1,]
subset(airquality.melt, Month==5 & Day==5)

#melt 복구 > dcast / acast
airquality.dc <- dcast(airquality.melt, Month+Day~variable)
head(airquality.dc)

airquality.ac <- acast(airquality.melt, Month+Day~variable)
head(airquality.ac)

###6.3 데이터 테이블: 짧고 유연한 구문 사용
flights_df <- read.csv("inData/flights14.csv")
head(flight_df)
class(flight_df)
library(readxl)
exam <- read_excel("inData/exam.xlsx")
class(exam) #data frame으로 읽어 온다

install.packages("data.table") #fread
library(data.table)
flights <- fread("indata/flights14.csv")
head(flights)
class(flights)#data table로 읽어 온다

flight_df
library(dplyr)

#1.origin 이 JFK 이고 month 가 5 월인 모든 행을 result 에 얻는다
(result <- flights_df[flights_df$origin == "JFK" & flights_df$month == 5,])
(result <- flights[origin == "JFK" & month == 5])
#2.처음 두 행을 result 에 얻는다
head(flights_df,2)
(result <- flights[1:2])
#3.origin 으로 오름차순 , desc 로 내림차순으로 정렬하여 출력
flight_df[order(flights_df$origin, -flights_df$dest)]
flights[order(origin, -dest)]
#4.arr_delay 열만 출력
flights_df %>% 
  select(delay_arr)
flights[,arr_delay]
#5.y ear 열 부터 dep_time 열까지 출력
flights_df[,1:4]
flights[,year:dep_time]
#6.y ear 열과 dep_time 열 출력
flights_df[,c("year","dep_time")]
flights[,.(year, dep_time)]
# 7. arr_delay열과 dep_delay열을 출력하되 열이름을 delay_arr과 delay_dep로 변경
temp <- flights_df[,c('arr_delay','dep_delay')]
names(temp) <- c('delay_arr','delay_dep')
colnames(temp) <- c('delay_arr','delay_dep')
temp
flights[,.(delay_arr=arr_delay, delay_dep=dep_delay)]
# 8. 지연시간(arr_delay, dep_delay모두 0미만인 비행이 몇 번인지 출력
nrow(flights_df[flights_df$arr_delay<0 & flights_df$dep_delay<0,])
flights[arr_delay<0 & dep_delay<0, .(cnt=.N)] #.N: 갯수
# 8-1 지연시간의 합이 0 미만인 비행이 몇번인지 출력
nrow(flights_df[flights_df$arr_delay+flights_df$dep_time <0,])
flights[arr_delay+dep_delay<0, .(cnt=.N)] #.N: 갯수
# 9. 6월에 출발 공항이 JFK인 모든 항공편의 도착지연 및 출발지연 시간의 평균을 계산
apply(subset(flights_df, origin=='JFK' & month==6, select = c('arr_delay', 'dep_delay')), 2, mean)
flights[origin=='JFK'&month==6, .(mean(arr_delay),mean(dep_delay))]
# 10. 9번의 결과에 title에 mean_arr, mean_dep로 출력
x <- apply(subset(flights_df, origin=='JFK' & month==6, select = c('arr_delay', 'dep_delay')), 2, mean)
names(x) <- c('mean_arr', 'mean_dep')
x
flights[origin=='JFK' & month==6, .(mean_arr=mean(arr_delay), mean_dep=mean(dep_delay))]
# 11. JFK 공항의 6월 운항 횟수
nrow(subset(flights_df,origin=='JFK' & month==6))
flights[origin=='JFK' & month==6, .(cnt=.N)] #.N: 갯수
# 12. JFK 공항의 6월 운항 데이터 중 arr_delay열과 dep_delay열을 출력
subset(flights_df, subset=(origin=='JFK' & month==6), select=c("arr_delay","dep_delay"))
subset(flights_df, origin=='JFK' & month==6, select=c("arr_delay","dep_delay"))
flights_df[flights_df$origin=='JFK' & flights_df$month==6, c("arr_delay","dep_delay")]

flights[origin=='JFK' & month==6, .(arr_delay, dep_delay)]
# 13. JFK 공항의 6월 운항 데이터 중 arr_delay열과 dep_delay열을 제외한 모든 열 출력
subset(flights_df, subset=(origin=='JFK' & month==6), select=-c(5,7))
subset(flights_df, subset=(origin=='JFK' & month==6), select=c(-5,-7))
subset(flights_df, subset=(origin=='JFK' & month==6), select=-c("arr_delay","dep_delay")) #불가

flights[origin=='JFK' & month==6, -c('arr_delay', 'dep_delay')]
# 14. 출발 공항(origin)별 비행 수 출력 (JFK 81483 LGA 84433 EWR 87400)
table(flights_df$origin)
flights[,.(.N), by=.(origin)]
# 15. 항공사코드(carrier)가 AA에 대해 출발공항별 비행횟수 계산
table(subset(flights_df, carrier=='AA')$origin)
flights[carrier=='AA', .(.N), .(origin)]
# 16. origin, dest별로 비행횟수 출력
table(flights_df$origin, flights_df$dest)
flights[,.(.N), .(origin, dest)]
# 17. 항공사코드(carrier)가 AA에 대해 origin, dest별로 비행횟수 출력
table(flights_df[flights_df$carrier=='AA',]$origin, flights_df[flights_df$carrier=='AA',]$dest)
table(subset(flights_df, carrier=='AA')$origin, subset(flights_df, carrier=='AA')$dest)

flights[carrier=='AA', .(.N), .(origin, dest)]
# 18. 항공사 코드가 AA에 대해, origin, dest, 월별 평균arr_delay, 평균 dep_delay 출력
library(doBy)
summaryBy(arr_delay+dep_delay~origin+dest+month, subset(flights_df, carrier=='AA'), FUN=mean)

flights[carrier=='AA', .(mean(arr_delay), mean(dep_delay)), .(origin,dest,month)]
# 19. dep_delay>0가 참이거나 거짓, arr_delay>0가 참이거나 거짓인 각각의 비행횟수
table(flights_df$dep_delay>0, flights_df$arr_delay>0)
flights[,.(.N),.(dep_delay>0, arr_delay>0)]
# 20. Origin==“JFK”에 대해 월별 최대 출발 지연 시간 출력(month로 정렬)
sort(tapply(subset(flights_df, origin=='JFK')$dep_delay, subset(flights_df, origin=='JFK')$month, max))
flights[origin=='JFK', .(max(dep_delay)), .(month)]
