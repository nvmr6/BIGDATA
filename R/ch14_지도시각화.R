########## ch14 지도 시각화 ##########
#1. 미국 주별 강력 범죄율 시각화 - 데이터 셋 이용
#패키지 준비
install.packages("ggiraphExtra")#지도 시각화
library(ggiraphExtra)
install.packages("mapproj")#ggchoropleth함수 사용
library(mapproj)
install.packages("maps")#지도 정보(위도, 경도)
library(maps)
library(ggplot2)
library(tibble) #행이름을 변수로 하기 위함

#행이름을 변수로
head(USArrests)
crime <- rownames_to_column(USArrests, var="state")
View(crime)
crime$state <- tolower(crime$state) #주명을 소문자로

#미국 지도 주 정보 가져오기
state_map <-  map_data("state")

#지도 시각화
ggChoropleth(data=crime,
             aes(fill=Murder,
                 map_id=state),
             map=state_map,
             interactive = T)

#2. 대한민국 시도별 인구 수 단계 구분도
install.packages("stringi")
install.packages("devtools")
devtools::install_github("cardiomoon/kormaps2014")
library(kormaps2014)
head(korpop1) #2015 센서스 데이터
str(changeCode(korpop1))
library(dplyr)
korpop1 <- rename(korpop1, pop=총인구_명, name=행정구역별_읍면동)

ggChoropleth(data=korpop1,
             aes(fill=pop,
                 map_id=code,
                 tooltip=name),
             map=kormap1,
             interactive = T)

