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




















