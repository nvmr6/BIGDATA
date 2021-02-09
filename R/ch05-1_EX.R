###############################################
# # # # #  혼 자 서 해 보 기   (1)    # # # # # 
###############################################
mpg <- as.data.frame(ggplot2::mpg)
library(dplyr)
library(doBy)
# Q1. 자동차 배기량에 따라 고속도로 연비가 다른지 알아보려고 합니다. displ(배기량)이 4 이하인 자동차와 5 이상인 자동차 중 어떤 자동차의 hwy(고속도로 연비)가 평균적으로 더 높은지 알아보세요
# (1) dplyr 패키지 이용
mpg %>% 
  mutate(group = ifelse(displ<=4, "배기량4이하", ifelse(displ>=5, "배기량5이상", NA))) %>% 
  group_by(group) %>% 
  summarise(mean_total=mean(hwy)) %>% 
  filter(!is.na(group))

mpg %>% 
  filter(displ<=4 | displ>=5) %>% 
  mutate(group = ifelse(displ<=4, "배기량4이하", ifelse(displ>=5, "배기량5이상", NA))) %>% 
  group_by(group) %>% 
  summarise(mean_total=mean(hwy)) 
# (2) apply계열 함수 이용 : tapply, by, summaryBy(doBy), aggregate
df <- mpg[(mpg$displ<=4 | mpg$displ>= 5),]

df$group <- ifelse(df$displ<=4, "배기량4이하", ifelse(df$displ>=5, "배기량5이상", NA))
head(df)
tapply(df$hwy, df$group, mean)
by(df$hwy, df$group, mean) # 다수개 열일때는 mean은 안되고 summary, sum 등 됨
summaryBy(hwy~group, df, FUN=mean) # 다수개 열과 다수개 함수 가능
aggregate(df$hwy, by=list(df$group), mean) 

# Q2. 자동차 제조 회사에 따라 도시 연비가 다른지 알아보려고 합니다. "audi"와 "toyota" 중 어느 manufacturer(자동차 제조 회사)의 cty(도시 연비)가 평균적으로 더 높은지 알아보세요.
#(1) 방법
mpg %>% 
  group_by(manufacturer) %>% 
  summarise(mean_cty = mean(cty)) %>% 
  filter(manufacturer %in% c("audi", "toyota"))

mpg %>% 
  filter(manufacturer %in% c("audi", "toyota")) %>% 
  group_by(manufacturer) %>% 
  summarise(mean_cty = mean(cty))

#(2) 방법
df <- mpg[mpg$manufacturer %in% c("audi", "toyota"),]
head(df)
tapply(df$cty, df$manufacturer, mean)
by(df$cty, df$manufacturer, mean) # 다수개 열 가능
summaryBy(cty~manufacturer, df, FUN=c(mean)) # 다수개 열과 다수개 함수
aggregate(df$cty, by=list(df$manufacturer), mean) #다수개열 가능

# Q3. "chevrolet", "ford", "honda" 자동차의 고속도로 연비 평균을 알아보려고 합니다. 이 회사들의 자동차를 추출한 뒤 hwy 전체 평균을 구해보세요.
# (1) 방법
mpg %>% 
  filter(manufacturer %in% c("chevrolet", "ford", "honda")) %>% 
  group_by(manufacturer) %>% 
  summarise(mean_hwy = mean(hwy))

#(2) 방법
df <- mpg[mpg$manufacturer %in% c("chevrolet", "ford", "honda"),]
df <- subset(mpg, (mpg$manufacturer %in% c("chevrolet", "ford", "honda")) )
df <- subset(mpg, (manufacturer %in% c("chevrolet", "ford", "honda")) )
tapply(df$hwy, df$manufacturer, mean)
by(df$hwy, df$manufacturer, mean)
summaryBy(hwy~manufacturer, df, FUN=mean)
aggregate(df$hwy, by=list(df$manufacturer), mean)

###############################################
# # # # #  혼 자 서 해 보 기   (2)    # # # # # 
###############################################
# Q1. mpg 데이터는 11개 변수로 구성되어 있습니다. 이 중 일부만 추출해서 분석에 활용하려고 합니다. mpg 데이터에서 class(자동차 종류), cty(도시 연비) 변수를 추출해 새로운 데이터를 만드세요. 새로 만든 데이터의 일부를 출력해서 두 변수로만 구성되어 있는지 확인하세요.
dim(mpg)
df <- mpg %>% select(class, cty)    
head(df)

mpg[,c('class','cty')]
subset(mpg, select=c('class','cty'))

#Q2. 자동차 종류에 따라 도시 연비가 다른지 알아보려고 합니다. 앞에서 추출한 데이터를 이용해서 class(자동차 종류)가 "suv"인 자동차와 "compact"인 자동차 중 어떤 자동차의 cty(도시 연비)가 더 높은지 알아보세요.
table(mpg$class)
# (1) 방법
mpg %>% 
  filter(class %in% c('suv','compact')) %>% 
  group_by(class) %>% 
  summarise(mean_cty = mean(cty))
# (2) 방법
df <- mpg[mpg$class %in% c('suv','compact') ,]
df
tapply(df$cty, df$class, mean)
by(df$cty, df$class, mean)
summaryBy(cty~class, df, FUN=mean)
aggregate(df$cty, by=list(df$class), mean)

# Q3. "audi"에서 생산한 자동차 중에 어떤 자동차 모델의 hwy(고속도로 연비)가 높은지 알아보려고 합니다. "audi"에서 생산한 자동차 중 hwy가 1~5위에 해당하는 자동차의 데이터를 출력하세요.
# 방법(1)
mpg %>% 
  filter(manufacturer=='audi') %>% 
  arrange(desc(hwy)) %>% 
  head(5)

# 방법(2)
df<- mpg[mpg$manufacturer=='audi',]
head(orderBy(~-hwy, df),5)
head(df1[order(df$hwy, decreasing = T),],5)

###############################################
# # # # #  혼 자 서 해 보 기   (3)    # # # # # 
###############################################
#Q1. mpg 데이터 복사본을 만들고, cty와 hwy를 더한 '합산 연비 변수'를 추가하세요.
# (1)방법
mpg %>% 
  mutate(total = cty+hwy)

# (2) 방법
df<-mpg
df$total <- df$cty + df$hwy
df

#Q2. 앞에서 만든 '합산 연비 변수'를 2로 나눠 '평균 연비 변수'를 추가세요.
# (1) 방법
mpg %>% 
  mutate(total = (cty+hwy)/2)

# (2) 방법
mpg$total <- (mpg$cty+mpg$hwy)/2

# Q3. '평균 연비 변수'가 가장 높은 자동차 3종의 데이터를 출력하세요.
# (1) 방법
mpg %>% 
  mutate(total = (cty+hwy)/2) %>% 
  arrange(desc(total)) %>% 
  head(3)
# (2) 방법
head(orderBy(~-total, mpg),3)
orderBy(~-total, mpg)[1:3,]
head(mpg[order(mpg$total, decreasing = T),],3)
head(mpg[order(-mpg$total),],3) # mpg$total앞에 -를 붙여 내림차순정렬을 할 수 있는 것은 total이 숫자이기 때문. 문자나 logical일 경우 아래와 같이 desc이용
head(mpg[order(desc(mpg$total)),],3)

#Q4. 1~3번 문제를 해결할 수 있는 하나로 연결된 dplyr 구문을 만들어 출력하세요. 데이터는 복사본 대신 mpg 원본을 이용하세요.
# (1) 방법
mpg %>% 
  mutate(total = (cty+hwy)/2) %>% 
  arrange(desc(total)) %>% 
  head(3)

# (2) 방법
head(orderBy(~-total, mpg),3)
head(mpg[order(mpg$total, decreasing = T),],3)

###############################################
# # # # #  혼 자 서 해 보 기   (4)    # # # # # 
###############################################
#Q1. mpg 데이터의 class는 "suv", "compact" 등 자동차를 특징에 따라 일곱 종류로 분류한 변수입니다. 어떤 차종의 연비가 높은지 비교해보려고 합니다. class별 cty 평균을 구해보세요.
table(mpg$class)
# (1) 방법
library(dplyr)
mpg %>% 
  group_by(class) %>% 
  summarise(mean_cty=mean(cty))

# (2) 방법
tapply(mpg$cty, mpg$class, mean)
by(mpg$cty, mpg$class, mean)
summaryBy(cty~class, mpg)
aggregate(mpg$cty, by=list(mpg$class), mean)

#Q2. 앞 문제의 출력 결과는 class 값 알파벳 순으로 정렬되어 있습니다. 어떤 차종의 도시 연비가 높은지 쉽게 알아볼 수 있도록 cty 평균이 높은 순으로 정렬해 출력하세요.
# (1) 방법
mpg %>% 
  group_by(class) %>% 
  summarise(mean_cty=mean(cty)) %>% 
  arrange(desc(mean_cty))

# (2) 방법 - tapply - sort
sort(tapply(mpg$cty, mpg$class, mean), decreasing = TRUE)
# (2) 방법 -  tapply - order
result <- tapply(mpg$cty, mpg$class, mean)
class(result) # array 형태
result[order(result, decreasing = T)]

tapply(mpg$cty, mpg$class, mean)[order(tapply(mpg$cty, mpg$class, mean), decreasing = T)]
# (2) 방법 - by -sort
sort(by(mpg$cty, mpg$class, mean), decreasing = T)
# (2) 방법 - by -order
by(mpg$cty, mpg$class, mean)[order(by(mpg$cty, mpg$class, mean), decreasing = T)] # 가독성을 올리려면 결과를 변수로 뺌
result <- by(mpg$cty, mpg$class, mean)
result[order(result, decreasing = T)]

# (2) 방법 - summaryBy - order
result <- summaryBy(cty~class, mpg)
result # result가 data.frame 형태
result[order(result$cty.mean, decreasing = T),]
# (2) 방법 - summaryBy - orderBy
orderBy(~-cty.mean, result)
# (2) 방법 - aggregate - order
result<-aggregate(mpg$cty, by=list(mpg$class), mean)
result
result[order(result$x, decreasing = T),]
orderBy(~-x, result)

#Q3. 어떤 회사 자동차의 hwy(고속도로 연비)가 가장 높은지 알아보려고 합니다. hwy 평균이 가장 높은 회사 세 곳을 출력하세요.
# (1) 방법
mpg %>% 
  group_by(manufacturer) %>% 
  summarise(mean_hwy = mean(hwy)) %>% 
  arrange(desc(mean_hwy)) %>% 
  head(3)

# (2) 방법
result <-aggregate(mpg$hwy, by=list(mpg$manufacturer), mean)
result # result가 data.frame형태
head(result[order(result$x, decreasing = T),] , 3)
result[order(result$x, decreasing = T),][1:3,]
head(orderBy(~-x, result), 3)
# Q4. 어떤 회사에서 "compact"(경차) 차종을 가장 많이 생산하는지 알아보려고 합니다. 각 회사별 "compact" 차종 수를 내림차순으로 정렬해 출력하세요.
# (1) 방법
mpg %>% 
  filter (class=='compact') %>% 
  group_by(manufacturer) %>% 
  summarise(cnt = n()) %>% 
  arrange(desc(cnt))

df <- mpg[mpg$class=='compact',]
df <- subset(mpg, mpg$class=='compact')
df <- subset(mpg, class=='compact')
df
sort(table(df$manufacturer), decreasing = T)

#혼자서 해보기 5
library(dplyr)
#Q1. mpg 데이터에는 연료 종류를 나타낸 fl 변수는 있지만 연료
#가격을 나타낸 변수는 없습니다 . 위에서 만든 fuel 데이터를 이용해서
#mpg 데이터에 price_fl 연료 가격 ) 변수를 추가하세요
mpg <- as.data.frame(ggplot2::mpg)
fuel <- data.frame(fl=c('c','d','e','p','r'), 
                   kind=c('CNG','disel','ethanol E85', 'premium','regular'),
                   price_fl=c(2.35,2.38,2.11,2.76,2.22))
mpg <- left_join(mpg,fuel[,c(1,3)],id="fl")
#Q2. 연료 가격 변수가 잘 추가됐는지 확인하기 위해서 model, fl ,
#price_fl 변수를 추출해 앞부분 5 행을 출력해 보세요
head(mpg,5)


#혼자서 해보기 6. mpg 데이터를 이용해서 분석 문제를 해결해 보세요

#우선 mpg 데이터를 불러와서 일부러 이상치를 만들겠습니다 . drv 구동
#방식 ) 변수의 값은 4( 사륜구동 ), 전륜구동 ), 후륜구동 ) 세 종류로 되어
#있습니다 . 몇 개의 행에 존재할 수 없는 값 k 를 할당하겠습니다 . cty 도
#시 연비 ) 변수도 몇 개의 행에 극단적으로 크거나 작은 값을 할당하겠습
#니다

mpg <- as.data.frame (ggplot2::mpg) # mpg 데이터 불러오기
mpg[ c (10, 14, 58, 93), "drv" ] <-"k" # drv 이상치 할당
mpg[ c (29, 43, 129, 203), "cty"] <- c (3, 4, 39, 42) # cty 이상치 할당

#이상치가 들어있는 mpg 데이터를 활용해서 문제를 해결해보세요

#구동방식별로 도시 연비가 다른지 알아보려고 합니다 . 분석을 하려면
#우선 두 변수에 이상치가 있는지 확인하려고 합니다

#Q1. drv 에 이상치가 있는지 확인하세요 . 이상치를 결측 처리한 다음
#이상치가 사라졌는지 확인하세요 . 결측 처리 할 때는 %in% 기호를
#활용하세요
mpg$drv <- ifelse((mpg$drv!="f" & mpg$drv!="4" & mpg$drv!="r"), NA, mpg$drv)
table(is.na(mpg$drv))
#Q2. 상자 그림을 이용해서 cty 에 이상치가 있는지 확인하세요 . 상자
#그림의 통계치를 이용해 정상 범위를 벗어난 값을 결측 처리한 후 다시
#상자 그림을 만들어 이상치가 사라졌는지 확인하세요
result <- boxplot(mpg$hwy)$stats
mpg$cty <- ifelse(mpg$cty>result[5]|mpg$cty<result[1], NA, mpg$cty)
table(is.na(mpg$cty))
#Q3. 두 변수의 이상치를 결측처리 했으니 이제 분석할 차례입니다 . 이상
#치를 제외한 다음 drv 별로 cty 평균이 어떻게 다른지 알아보세요 . 하나
#의 dplyr 구문으로 만들어야 합니다

mpg %>%
  group_by(drv) %>% 
  summarise(cty_mean=mean(cty, na.rm=T))


#분석도전

#미국 동북중부 437 개 지역의 인구통계 정보를 담고 있는 midwest 데이터를 사용해
#데이터 분석 문제를 해결해 보세요 . midwest 는 ggplot2 패키지에 들어 있습니다
midwest <- as.data.frame (ggplot2::midwest)
#문제 1. popadults 는 해당 지역의 성인 인구 , poptotal 은 전체 인구를 나타냅니다 .
#midwest 데이터에 전체 인구 대비 미성년 인구 백분율 ' 변수를 추가하세요
midwest <-midwest %>% 
  mutate(popteens=(poptotal-popadults)/poptotal)

#문제 2. 미성년 인구 백분율이 가장 높은 상위 5 개 county( 지역 의 미성년 인구
#백분율을 출력하세요
midwest <- as.data.frame (ggplot2::midwest)
midwest %>% 
  mutate(popteens=(poptotal-popadults)/poptotal) %>% 
  arrange(popteens) %>% 
  select(county) %>% 
  head(5)

#문제 3. 분류표의 기준에 따라 미성년 비율 등급 변수를 추가하고 , 각 등급에 몇 개의
#지역이 있는지 알아보세요
midwest <- as.data.frame (ggplot2::midwest)
midwest <-midwest %>% 
  mutate(popteens=(poptotal-popadults)/poptotal)
midwest$ratio <- ifelse(midwest$popteens>0.4, "large", "middle")
midwest$ratio <- ifelse(midwest$popteens<0.3, "small", midwest$ratio)
midwest %>% 
  group_by(ratio) %>% 
  summarise(cnt=n())

#문제 4. popasian 은 해당 지역의 아시아인 인구를 나타냅니다 . 전체 인구 대비
#아시아인 인구 백분율 ' 변수를 추가하고 , 하위 10 개 지역의 state( 주 ),
#county( 지역명 ), 아시아인 인구 백분율을 출력하세요
midwest <- as.data.frame (ggplot2::midwest)
midwest %>% 
  mutate(asianratio=popasian/poptotal) %>% 
  select(state, county, asianratio) %>% 
  arrange(asianratio) %>% 
  head(10)
