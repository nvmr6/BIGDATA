########## ch 11. 텍스트 마이닝 ##########
#문자로 된 비정형 텍스트로부터 가치 있는 정보를 얻어내는 분석
#형태소 분석
install.packages("rJava")
install.packages("memoise")
install.packages("KoNLP")

#우측의 package install 도구 (수동 설치)
install.packages("devtools")

#KoNLP가 의존하는 package 미리 설치
install.packages("hash")
install.packages("tau")
install.packages("Sejong")

#packages -> install 도구를 이용하여 KoNLP 패키지 설치
library(KoNLP)
Sys.getenv("JAVA_HOME")
useNIADic()#사전 로드
extractNoun('대한민국의 영토는 한반도와 그 부속 도서로 한다')
extractNoun('의미있는 하루 하루, 알차고 환희찬 하루 감사해요')

#1. 가사 텍스트 마이닝
txt <- readLines('inData/hiphop.txt')

#특수문자 제거
library(stringr)
txt <- gsub('\\W', ' ', txt) 

#명사 추출 > list 형태로 추출
noun <- extractNoun(txt) 
head(noun)
head(unlist(noun))
wordcount <- table(unlist(noun))
sort(wordcount)
df_word <- as.data.frame(wordcount, stringsAsFactors = F) #문자 팩터형 X
library(dplyr)
df_word <- rename(df_word, word=Var1, freq=Freq)
head(df_word)
df_word <- df_word %>% 
  filter(nchar(word)>=2)
head(df_word)

#자주 사용되는 단어 빈도표 top20
df_word[order(-df_word$freq),][1:20,]
top20 <- df_word %>% 
  arrange(desc(freq)) %>% 
  head(20)
top20

#자주 사용되는 단어 그래프
library(ggplot2)
ggplot(top20, aes(x=freq, y=reorder(word, freq)))+
  geom_col(aes(fill=word))+
  theme(legend.position = 'none')

#word cloud
#1. 비정형 데이터 확보
#2. 패키지 설치 및 로드 - KoNLP,wordcloud
#3. 확보된 텍스트 읽어오기
#4. 명사 추출
#5. 필요없는 데이터 삭제
#6. word count
#7. word cloud 함수 이용

install.packages("wordcloud")
library(wordcloud)
set.seed(1234)#난수 생성 결과 일치
round(runif(6, min=1, max=45))#확인
display.brewer.all()
pal <- brewer.pal(8,'Dark2')

set.seed(1234)
wordcloud(words = df_word$word,
          freq = df_word$freq,
          min.freq = 2,
          max.words = 200,
          random.order = F,
          rot.per = 0.1,
          scale = c(4,0.3),
          colors = pal
          )


#2. 트윗 텍스트 마이닝
rm(list=ls())
twitter <- read.csv('inData/twitter.csv', header = T, stringsAsFactors = F, fileEncoding = 'UTF-8')
head(twitter)
twitter <- rename(twitter, no='번호', id='계정이름', date='작성일', tw='내용')
View(twitter)
twitter$tw <- str_replace_all(twitter$tw, '\\W', ' ')
twitter$tw <- str_replace_all(twitter$tw, '[ㄱ-ㅎ]', ' ')
twitter <- twitter %>% 
  group_by(id) %>% 
  mutate(count=n()) %>% 
  filter(count >= 150)
nouns <- extractNoun(twitter$tw)
wordcount <- table(unlist(nouns))
df_word <- as.data.frame(wordcount, stringsAsFactors = F)
df_word <- rename(df_word, word=Var1, freq=Freq)
head(df_word)
df_word <- df_word %>% 
  filter(nchar(word)>=2)
head(df_word)
#자주 사용되는 단어 빈도표 top20
df_word[order(-df_word$freq),][1:20,]
top20 <- df_word %>% 
  arrange(desc(freq)) %>% 
  head(20)
top20

#자주 사용되는 단어 그래프
ggplot(top20, aes(x=freq, y=reorder(word, freq)))+
  geom_col(aes(fill=word))+
  theme(legend.position = 'none')

#word cloud
set.seed(1234)#난수 생성 결과 일치
round(runif(6, min=1, max=45))#확인
display.brewer.all()
pal <- brewer.pal(8,'Accent')

set.seed(1234)
wordcloud(words = df_word$word,
          freq = df_word$freq,
          min.freq = 2,
          max.words = 200,
          random.order = F,
          rot.per = 0.1,
          scale = c(4,0.5),
          colors = pal
)


