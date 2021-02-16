##### ch.10 t-test 분석 vs ANOVA 분석 #####

#두 그룹간의 평균의 차이가 통계적으로 유의한지 검증: t-test
#세 그룹 이상 집단의 평균 차이를 통계적으로 유의한지 검증: ANOVA

#1. 두 그룹 간 평균 차의 유의성 분석
ToothGrowth <- rbind(ToothGrowth, ToothGrowth)
nrow(ToothGrowth)
#(1) 도표로 차이의 유의성을 표현 (평균, 분산)
#(2) 그래프로 시각화된 유의성 표현
#(3) 통계적으로 유의한지 검증

#기니피그 치아 성장에 비타민 종류가 유의미하게 작용하는지 

#(1) 도표
library(doBy)
summaryBy(len~supp, data = ToothGrowth, FUN=c(mean, sd))
library(dplyr)
ToothGrowth %>% 
  filter(!is.na(supp) & !is.na(len)) %>% 
  group_by(supp) %>% 
  summarise(len.mean = mean(len), len.sd=sd(len))

#(2) 그래프
library(ggplot2)
ToothGrowth %>% 
  group_by(supp) %>% 
  summarise(len.mean = mean(len)) %>% 
  ggplot(aes(x=supp, y=len.mean)) +
  geom_col()

ggplot(ToothGrowth, aes(x=supp, y=len))+
  geom_violin()+
  geom_point(position = 'jitter', alpha=0.3)+
  geom_boxplot(aes(fill=supp), notch = T, width=0.3)

#(3) 통계적인 분석
#일원 표본 t-test
table(ToothGrowth$supp, useNA="ifany") #결측치 포함
a <- ToothGrowth[ToothGrowth$supp=='OJ', 'len']
b <- ToothGrowth[ToothGrowth$supp=='VC', 'len']
t.test(a-b)
t.test(a,b)
#p-value가 0.05보다 작은 경우 귀무가설(두 그룹이 같다)을 기각한다. > 다르다
#p-value가 0.05보다 큰 경우 귀무가설(두 그룹이 같다)을 기각할 수 없다.

#이원표본 t-test(등분산성 테스트 -> t-test)
var.test(len~supp, data= ToothGrowth)
#p-value가 0.05보다 작은 경우 귀무가설(두 그룹의 분산이 같다)을 기각한다. > 다르다, 등분산성 성립되지 않는다
#p-value가 0.05보다 큰 경우 귀무가설(두 그룹의 분산이 같다)을 기각할 수 없다.> 같다, 등분산성 성립
t.test(len~supp, data=ToothGrowth, var.equal=F)#두 그룹의 등분산성이 성립되지 않는 경우 (다를 경우)
# -> p-value가 0.05보다 작아 귀무가설 기각 > 다르다

sleep <- datasets::sleep
head(sleep)
str(sleep)

sleep <- rbind(sleep, sleep)
nrow(sleep)

#(1)
sleep %>% 
  filter(!is.na(extra) & !is.na(group)) %>% 
  group_by(group) %>% 
  summarise(extra.mean = mean(extra), extra.sd=sd(extra))
#(2)
ggplot(sleep, aes(x=group, y=extra))+
  geom_violin()+
  geom_point(position = 'jitter', alpha=0.3)+
  geom_boxplot(aes(fill=group), notch = T, width=0.3)
#(3)
var.test(extra~group, data=sleep) #p-value가 0.05보다 크다
t.test(extra~group, data=sleep, var.equal=T)#귀무가설 기각


#2. 3개 이상의 집단간 평균의 차이를 비교할 때 분산분석(ANOVA)
#(1) aov()
#iris 에서 종에 따라 sepal.length의 평균이 다른지
ggplot(iris, aes(x=Species, y=Sepal.Length))+
  geom_boxplot(aes(fill=Species))
table(iris$Species)#3개 그룹
result <- aov(Sepal.Length~Species, data=iris)
summary(result) #F value < 0.05 귀무가설 기각(다름): 귀무가설 기각x(같음)
#(2) anova()
#mpg cyl에 따라 mpg의 평균이 다른가
table(mtcars$cyl, useNA="ifany") 
#3개 그룹 / cyl이 범주형이 아님
fit <- lm(mpg~cyl, data=mtcars)
fit
anova(fit)#F value < 0.05 귀무가설 기각(다름): 귀무가설 기각x(같음)


orange <- datasets::Orange
str(orange)
table(orange$age)
(fit <- lm(circumference~age, data=orange))
anova(fit)#F value < 0.05 귀무가설 기각(다름): 귀무가설 기각x(같음)


















