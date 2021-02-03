prime <- function(num){
  count <- 0
  if(num == 1){
      return (FALSE)
    }else{
      for(val in 2:num){
        if(num%%val==0){
          count <- count + 1
        }
      }
    }
    if(count==1){
      return (TRUE)
    }else{
      return (FALSE)
    }
}
prime(3)
prime(17)
prime(1)
