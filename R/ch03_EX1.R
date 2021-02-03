dim(iris)
colnames(iris)
str(iris)
colnames(iris)

summary(iris)
iris[c(1:10),c(1), drop=FALSE]

(virginica <- subset(iris, subset = (iris$Species == 'virginica')))
(setosa <- subset(iris, subset = (iris$Species == 'setosa')))
rbind(virginica,setosa)

subset(iris[,c(1,2)], subset = (iris$Species == 'setosa'))

(payMatrix <- matrix(c(12000,26000,18000), ncol = 3))
(workerMatrix <- matrix(c(c(5,4,9), c(7,3,2)), ncol = 2))
(pay <- payMatrix %*% workerMatrix)
