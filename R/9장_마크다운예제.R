library(ggplot2)
library(gapminder)
library(dplyr)

#1. datasets::cars 데이터 셋을 이용하여 속도에 대한 제동거리의 산점도와 적합도 신뢰구간
#그래프 를 나타내시오 단 , 속도가 5 부터 20 까지 제동거리 0 부터 100 까지만 그래프에 나타냄
ggplot(cars,aes(x=speed, y=dist))+
  geom_point()+
  geom_smooth()+
  coord_cartesian(xlim=c(5,20), ylim=c(0,100))+
  labs(title="연습문제1", 
       subtitle="속도에 대한 제동거리 산점도")
ggsave('outData/ex1.png')

#2. gapminder gapminder 데이터 셋을 이용하여 1 인당국내총생산에 대한 기대수명의 산점
#도를 대륙별 다른 색으로 나타내시오
ggplot(gapminder, aes(x=gdpPercap, y=lifeExp))+
  geom_point(aes(color=continent))+
  labs(title="연습문제2", 
       subtitle="1인당 국내총생산에 대한 기대수명 산점도")
ggsave('outData/ex2.png')

#3. gapminder gapminder 데이터 셋을 이용하여 개대 수명이 70 을 초과하는 데이터에 대해
#대륙별 데이터 갯수
gapminder %>% 
  filter(lifeExp>=70) %>% 
  group_by(continent) %>% 
  summarise(n=n()) %>% 
  ggplot(aes(x=continent, y=n))+
  geom_col(aes(fill=continent))+
  labs(x = "대륙",
       y="빈도",
       title="연습문제3",
       subtitle="기대수명이 70을 초과하는 데이터 빈도(대륙별)")
ggsave('outData/ex3.png')

#4. gapminder gapminder 데이터 셋을 이용하여 기대수명이 70 을 초과하는 데이터에 대해
#대륙별 나라 갯수
gapminder %>% 
  filter(lifeExp>=70) %>% 
  group_by(continent) %>% 
  summarise(n=n_distinct(country)) %>% 
  ggplot(aes(x=continent, y=n))+
  geom_col(aes(fill=continent))+
  labs(x = "대륙",
       y="나라 빈도",
       title="연습문제4", 
       subtitle="기대수명이 70을 초과하는 대륙별 나라 빈도")
ggsave('outData/ex4.png')

#5. gapminder gapminder 데이터 셋을 이용하여 대륙별 기대수명의 사분위수를 시각화
ggplot(gapminder, aes(x=continent, y=lifeExp))+
  geom_boxplot(aes(color=continent))+
  labs(title="연습문제5", 
       subtitle="대륙별 기대수명의 사분위수")
ggsave('outData/ex5.png')

#6. gapminder gapminder 데이터 셋을 이용하여 년도별로 gdp 와 기대수명과의 관계를 산점
#도를 그리고 대륙별 점의 색상을 달리 시각화
ggplot(gapminder, aes(x=gdpPercap, y=lifeExp))+
  facet_wrap(~year)+
  geom_point(aes(color=continent))+
  labs(title="연습문제6", 
       subtitle="GDP와 기대수명과의 관계")
ggsave('outData/ex6.png')

#7. gapminder gapminder 데이터 셋에서 북한과 한국의 년도별 GDP 변화를 산점도로 시각
#화하시오 북한 :Korea, Dem. Rep. 한국 :Korea, Rep. substr str , start, 함수 이용
gapminder %>% 
  filter(country %in% c('Korea, Rep.', 'Korea, Dem. Rep.')) %>% 
  ggplot(aes(x=year, y=gdpPercap))+
  geom_point(aes(color=country, pch=country))+
  labs(title="연습문제7", 
       subtitle="GDP의 변화 (한국과 북한)")+
  theme(legend.position = c(0.2,0.8))
ggsave('outData/ex7.png')

#8. gapminder gapminder 데이터 셋을 이용하여 한중일 4 개국별 GDP 변화를 산점도와 추
#세션으로 시각화 하시오
gapminder %>% 
  filter(country %in% c('Korea, Rep.', 'Korea, Dem. Rep.', 'China', 'Japan')) %>% 
  ggplot(aes(x=year, y=gdpPercap))+
  geom_point(aes(color=country))+
  geom_line(aes(color=country))+
  labs(title="연습문제8", 
       subtitle="한중일 4개국의 GDP변화의 산점도와 추세선")
ggsave('outData/ex8.png')

#9. gapminder gapminder 데이터 셋에서 한중일 4 개국별 인구변화 변화를 산점도와 추세선
#으로 시각화 하시오 scale_y_continuous (labels = comma) 추가시 우측처럼)
gapminder %>% 
  filter(country %in% c('Korea, Rep.', 'Korea, Dem. Rep.', 'China', 'Japan')) %>% 
  ggplot(aes(x=year, y=pop))+
  geom_point(aes(color=country))+
  geom_line(aes(color=country))+
  labs(title="연습문제9", 
       subtitle="한중일 4개국의 인구 변화의 산점도와 추세선")
ggsave('outData/ex9.png')

#10. Ggplot2::economic 데이터 셋의 개인 저축률 psavert 가 시간에 따라 어떻게 변해 왔는지
#알아보려 한다 . 시간에 따른 개인 저축률의 변화를 나타낸 시계열 그래프와 추세선을 시각
#화하시오
ggplot(economics, aes(x=date, y=psavert))+
  geom_line(color="red", size=2)+
  geom_smooth(color="pink")+
  labs(title="연습문제10", 
       subtitle="개인저축률 시계열 그래프")
ggsave('outData/ex10.png')
