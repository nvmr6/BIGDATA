########## ch 12. 웹 데이터 수집 ##########
#1. 정적 웹 크롤링 (단일 페이지 크롤링) - rvest package
install.packages("rvest")
library(rvest)
library(dplyr)
library(stringr)
library(KoNLP)
library(ggplot2)
library(wordcloud)

url <- 'https://movie.naver.com/movie/point/af/list.nhn'
(text <- read_html(url, encoding = 'CP949'))

#영화 제목: .movie
(nodes <- html_nodes(text, '.movie'))
(title <- html_text(nodes))
#영화에 대한 페이지
movieInfo <- html_attr(nodes, 'href')
movieInfo <- paste0(url, movieInfo)
#평점: .list_netizen_score em
(nodes <- html_nodes(text, ".list_netizen_score em"))
(point <- html_text(nodes))
#영화 리뷰: 
(nodes <- html_nodes(text, '.title'))
(review <- html_text(nodes))
review <- gsub('\t', '', review)
review <- gsub('\n', '', review)
review <- unlist(strsplit(review, '중[0-9]{1,2}'))[seq(2,20,2)]
review <- gsub('신고', '', review)
review
page <- cbind(title, movieInfo)
page <- cbind(page, point)
page <- cbind(page, review)
View(page)
write.csv(page, 'outData/movie_review.csv', row.names = F)

#여러 페이지 웹 크롤링
home <- 'https://movie.naver.com/movie/point/af/list.nhn'
site <- 'https://movie.naver.com/movie/point/af/list.nhn?&page='
movie.review <- NULL
for(i in 1:100){
  url <- paste0(site,i)
  text <- read_html(url, encoding = 'CP949')
  
  nodes <- html_nodes(text, '.movie')
  title <- html_text(nodes)
  
  movieInfo <- html_attr(nodes, 'href')
  movieInfo <- paste0(home, movieInfo)
  
  nodes <- html_nodes(text, ".list_netizen_score em")
  point <- html_text(nodes)
  
  nodes <- html_nodes(text, '.title')
  review <- html_text(nodes)
  review <- gsub('\t', '', review)
  review <- gsub('\n', '', review)
  review <- unlist(strsplit(review, '중[0-9]{1,2}'))[seq(2,20,2)]
  review <- gsub('신고', '', review)
  page <- cbind(title, movieInfo)
  page <- cbind(page, point)
  page <- cbind(page, review)
  movie.review <- rbind(movie.review, page)
}
write.csv(movie.review, 'outData/movie_review_100page.csv', row.names = F)


#EX
class(movie.review)
movie <- as.data.frame(movie.review)
head(movie.review)
movie$review <- str_replace_all(movie$review, '\\W', ' ')
movie$review <- str_replace_all(movie$review, '[ㄱ-ㅎ]', '')
movie$review <- str_replace_all(movie$review, '[ㅏ-ㅣ]', '')
movie$review <- str_replace_all(movie$review, '[0-9]', '')
movie$point <- as.integer(movie$point)
str(movie)

result <- movie %>% 
  group_by(title) %>% 
  summarise(point.mean = mean(point),
            point.sum  = sum(point),
            n=n()) %>% 
  arrange(desc(point.mean), desc(point.sum)) %>% 
  head(10)

ggplot(result, aes(x=point.sum, y=reorder(title, point.sum)), vjust=1) +
  geom_col(aes(fill=title)) +
  labs(title = "평점이 높은 top10", x="평점 총점")+
  geom_text(aes(label=paste('총점:',point.sum,'평균:',point.mean)), hjust=0) +
  coord_cartesian(xlim=c(0,120))  +
  theme(axis.title.y = element_blank(),
        legend.position = "none")


nouns <- extractNoun(movie$review)
nouns
wordcount <- table(unlist(nouns))
df_word <- as.data.frame(wordcount, stringsAsFactors = F)
df_word <- rename(df_word, word=Var1, freq=Freq)
head(df_word)
df_word <- df_word %>% 
  filter(nchar(word)>=2)
head(df_word)

#word cloud
pal <- brewer.pal(8,'Accent')

set.seed(123)
wordcloud(words = df_word$word,
          freq = df_word$freq,
          min.freq = 2,
          max.words = 200,
          random.order = F,
          rot.per = 0.1,
          scale = c(4,0.5),
          colors = pal
)

#2. 동적 웹 크롤링 (셀레니움 패키지): 스크롤 다운, 로그인, 버튼 ...

#특정 폴더 생성 > 3개의 파일 다운로드 > 셀레니움 서버 가동
#라이브러리 로드
install.packages("RSelenium")
library(httr)
library(rvest)
library(RSelenium)
#셀레니움 동적 웹 크롤링 준비

#ex1 데이터 입력후 엔터 목록 
remDr <- remoteDriver(port=4445L, browser='chrome')
remDr$open()
remDr$navigate('http://www.youtube.com')
welElem <- remDr$findElement(using='css', '#search') #검색창 엑세스
welElem$sendKeysToElement(list('과학 다큐 비욘드', key='enter')) #데이터 입력
html <- remDr$getPageSource()[[1]] #현재의 페이지 소스
html <- read_html(html)

youtube_title <- html %>%
  html_nodes('#video-title') %>% 
  html_text()
youtube_title <- gsub('\n', '', youtube_title)
youtube_title <- trimws(youtube_title)

youtube_title_url <- html %>% 
  html_nodes('#video-title') %>% 
  html_attr('href')
youtube_title_url <- ifelse(is.na(youtube_title_url), '', paste0('http://www.youtube.com', youtube_title_url))
write.table(youtube_title, file='outData/과학다큐결과.txt', sep=', ', row.names=F, quote=F)

#ex2 스크롤 다운
remD <- remoteDriver(port=4445L, browser='chrome')
remD$open()
remD$navigate('https://youtu.be/tZooW6PritE')
btn <- remD$findElement(using = 'css selector',
                        value = '.html5-main-video')
btn$clickElement() #메인 영상 정지
remD$executeScript("window.scrollTo(0,500)")
remD$executeScript("window.scrollTo(500,3000)")

html <- remD$getPageSource()[[1]] #현재의 페이지 소스
html <- read_html(html)
comment <- html %>% html_nodes('#content-text') %>% html_text()
write.table(comment, file='outData/유튜브댓글.txt', sep=', ', row.names=F, quote=F)
























