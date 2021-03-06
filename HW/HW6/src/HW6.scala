

object HW6 {
  //Problem 1
  def GCD(a:Int, b:Int):Int = {
    if(a==b) a
    else if(a > b) GCD(a-b, b)
    else GCD(a, b-a)
  }
  
  //Problem 2
  def apply_combine(f:Int=>Int, x:Int, g:(Int,Int)=>Int):Int = {
    if(x <= 0) -1
    else if(x == 1) f(1)
    else g(f(x), apply_combine(f, x-1, g))
  }
  
  //Problem 3
  def apply_combine2(f:Int=>Int):Int=>(((Int,Int)=>Int)=>Int) = {
    def ret_fun(x:Int):((Int,Int)=>Int)=>Int = {
      def ret_fun2(g:(Int,Int)=>Int) = {
        if(x <= 0) -1
        else if(x == 1) f(1)
        else g(f(x), ret_fun(x-1)(g))
      }
      ret_fun2
    }
    ret_fun
  }
  
  //main tests
  def main(args: Array[String]) {
    println(GCD(1,20))
    println(GCD(6,4))
    println(GCD(9,15))
    
    println(apply_combine(x=>x*x, 4, (x:Int, y:Int)=>x+y))
    println(apply_combine(x=>x, 4, (x:Int, y:Int)=>x*y))
    
    println(apply_combine2((x)=>x*x)(4)((x, y)=>x+y))
    println(apply_combine2((x)=>x)(4)((x, y)=>x*y))
  }
}