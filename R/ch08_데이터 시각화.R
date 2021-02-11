##### ch 08. 데이터 시각화 #####

#시각화: 원본 데이터, 분석된 결과 데이터를 그래프로 표현, 사용자에게 효과적으로 정보전달이 목적
#R의 그래픽 시스템
#(1)base graphics system - 전통적인 함수, 그래프별 함수가 달라 정교한 그래프 이용시 노력 필요


#(2) grid graphics system - 1의 한계를 극복을 위해 개발한 패키지(ggplot2), 유연한 환경 제공
library(ggplot2)
ggplot(data=mtcars, aes(x=wt, y=mpg)) + geom_point() + labs(title="first graph") + geom_smooth()
#데이터, 초기화, 산점도, 타이틀, 추세선

##8.2 그래프 함수의 종류
#고수준 그래프: plot, barplot, boxplot, hist, pie ...
#호출시 그래프가 새롭게 그려진다

#저수준 그래프 함수: lines, abline(회귀), point, text ...
#새로운 영역이 아닌 기존 그래프 위에 출력

##8.3 그래프 파라미터
#(1)par(): 그래프 조정, 특성 지정
#리턴값은 실행전의 특성을 리턴
plot(cars$speed, cars$dist)
oldpar <- par(bty='L')
plot(cars)
plot(iris$Sepal.Length, iris$Sepal.Width)
par(oldpar)# 다시 oldpar 설정으로 복귀
plot(cars)#원상복구

fit <- lm(dist~speed, data=cars) #회귀식
fit
abline(fit, col="red")# 저수준 그래프

#par함수의 다른 파라미터 
x <- 1:100
y1 <- rnorm(100) #평균이 0이고 표준편차가 1인 수 100개 추출
y2 <- rnorm(100)+100#평균이 100이고 표준편차가 1인 수 100개 추출

oldpar <- par(mar=c(5,5,5,5))#그래프 여백
plot(x,y1, pch=0, type = "l", col="red", ylim = c(-8,2), yaxt='n',bty='n', ylab="")# 0:square, 1:circle, 2:triangle, 3:cross, 4:X, 5:diamond, 해당문자
                              #p: point, l:line, b:point/line, o: point/line(over), h:histogram, s:stair, n:no point
                              #lim: 축 스케일 조정,  yaxt='n': 눈금 없애기  
                              #bty: 박스 타입(o,L,7,U,C,n)
axis(side=2, at=c(-2,0,2))
mtext("red line(y1)", side=2, line=2, at=1)

#고수준 그래프이지만 저수준 그래프 위에 작성
par(new=T)
plot(x,y2, pch=0, type = "l", col="blue", ylim = c(98,108), yaxt='n',bty='n', ylab="")
axis(side=4, at=c(98,100,102))
mtext("blue line(y2)", side=4, line=2, at=1)

par(oldpar)#그래프 영역 설정 원상복구

##8.4 고수준 그래프
#plot: 타입에 따라 여러 유형의 그래프를 그림, 산점도 그래프 함수
plot(cars, main="Speed and Stopping distance", xlab="speed(mph)", ylab="stopping distance(ft)", las=1)#las: 눈금 라벨 방향

#2행 3열로 그래프 영역 분리, 타입에 따른 그래프
oldpar <- par(mfrow=c(2,3))
plot(cars, type="p")
plot(cars, type="l")
plot(cars, type="b")
plot(cars, type="o")
plot(cars, type="h")
plot(cars, type="s")

par(oldpar)

#barplot: 막대 그래프
head(VADeaths)
barplot(VADeaths, main = "Deathrate in Virginia", font=2, border="red", 
        legend=rownames(VADeaths), angle = c(15,30,45,60,75), density = 50, col = topo.colors(5), beside = T)
#legend:범례 angle:빗금 각도 denstity: 빗금 밀도 beside: 옆으로 나열

#boxplot
boxplot(InsectSprays$count)
boxplot(count~spray, data=InsectSprays)


#histogram
x <- c(1,1,2,2,2,3,4,4)
hist(x, breaks=c(0,1,2,3,4))#breaks:구간

islands
class(islands)
is.vector(islands)
hist(islands)
hist(sqrt(islands))

#pie
pie.sales <- c(0.1,0.3,0.2,0.15,0.1,0.15)
names(pie.sales) <- c("c", "c++", "java", "R", "python", "oracle")
pie(pie.sales, clockwise = T, col = heat.colors(6))

#mosaicplot
Titanic
mosaicplot(~Sex+Age+Survived, data=Titanic)

##8.3 저수준 그래프 함수
#points
plot(-4:4, -4:4, type = "n")
points(1,2,col="red")
rnorm(100)#평균이 0이고 표준 편차가 1인 표준정규분포 100개개
points(rnorm(100),rnorm(100))

#lines
plot(cars)
(fit <- lm(dist~speed,cars)) #y = 3.932*x - 17.579
lines(cars$speed, 3.932*cars$speed-17.579, col="red")

#abline:회귀식선
abline(fit, col="blue", lty="dashed")

#text(x,y,출력할 텍스트, 그외 옵션)
plot(1:5,1:5,type = "n")
text(3,3,'A', adj=c(0,0), col="red")


##8.4 ggplot2
install.packages("ggplot2")
library(ggplot2)

#1. 그래프 초기와 (데이터 셋 , 변수 설정)
#2. 그래프의 결과무에 대응하는 geom 함수
#3. 제목, 캡션, 축 이름등 부가적인 요소
ggplot(data=mtcars, aes(x=wt, y=mpg))+
  geom_point(aes(pch=3))+
  labs(title="fuel comsumption (miles per gallon)",
       x="weight(1,000lbs)", y="fuel comsumption(miles per gallon)",
       subtitle = "relation of weight and fuel consumption",
       caption = "source: mpg datasets")

ggplot(data=iris, aes(x=Petal.Length, y=Petal.Width))+
  geom_point(aes(color=Species))
head(airquality)
ggplot(data=airquality, aes(x=Ozone, y=Solar.R))+
  geom_point(aes(color=Month))+
  geom_smooth()
ggplot(data=mtcars, aes(x=wt, y=mpg)) +
  geom_point(shape=25, color="blue", bg="red", size=2, stroke=2) +
  # shape = par에서 pch와 같음. stroke 테두리 두께, size 점크기
geom_smooth(method="lm", color="red", size=2, linetype=2) +
  geom_text(label=rownames(mtcars), hjust=0, vjust=0, size=3, nudge_y = 0.5) +
  labs(x = "차량 무게 (1,000lbs)",
       y="연비",
       title="차량 무게와 연비와의 관계",
       subtitle="(부제목)",
       caption = "참조:datasets의 mtcats")

?geom_text
mtcars
?geom_smooth

# 히스토그램
head(mtcars)
dim(mtcars)
str(mtcars)
mtcars$cyl <- factor(mtcars$cyl, levels = c(4,6,8),
                     labels=c('4 cylinders',
                              '6 cylinders',
                              '8 cylinders'))
head(mtcars)
str(mtcars$cyl)

ggplot(data=mtcars, aes(x=mpg)) +
  geom_histogram() +
  facet_grid(cyl~.) + # 3개의 패널에 그리는 함수
  labs(title="cyl에 따른 연비 히스토그램",
       x="연비", y="횟수")













