
object HW7 {
  //Problem 1
  def comb_lists(xs:List[Int], ys:List[Int]):List[Int] = {
    if(xs.isEmpty && ys.isEmpty) Nil
    else if(xs.isEmpty) ys
    else if(ys.isEmpty) xs
    else xs.head::ys.head::comb_lists(xs.tail, ys.tail)
  }
  
  //Problem 2
  def comb_apply(xs:List[Int], ys:List[Int], f:(Int,Int)=>Int):List[Int] = {
    if(xs.isEmpty || ys.isEmpty) Nil
    else f(xs.head, ys.head)::comb_apply(xs.tail, ys.tail, f)
  }
  
  //Problem 3
  def true_list(xs:List[Int], f:Int=>Boolean):List[Int] = {
    if(xs.isEmpty) Nil
    else if(f(xs.head)) xs.head::true_list(xs.tail, f)
    else true_list(xs.tail, f)
  }
  
  //Problem 4
  def true_list2(f:Int=>Boolean):List[Int]=>List[Int] = {
     (xs:List[Int])=>//true_list2(f) is this anon func
        if(xs.isEmpty) Nil
        else if(f(xs.head)) xs.head::true_list2(f)(xs.tail)
        else true_list2(f)(xs.tail)
  }
    
  //main tests
  def main(args: Array[String]) {
    println("Problem 1:")
    def l1 = List(1,2,3,4)
    def l2 = List(7,8,9,10,11,12)   
    println(comb_lists(l1, l2))
    println()
    
    println("Problem 2:")
    def l3 = List(3,8,1,5)
    def l4 = List(12,6,23,1,8,4)
    println(comb_apply(l3, l4, (x,y)=>x+y))
    println(comb_apply(l3, l4, (x,y)=>x*x+y))
    println()
    
    println("Problem 3:")
    println(true_list(l1, x=>x%2==0))
    println(true_list(l2, x=>x%2==0))
    println(true_list(l3, x=>x%2==0))
    println(true_list(l4, x=>x%2==0))
    
    println(true_list(l1, x=>x>10))  
    println(true_list(l2, x=>x>10)) 
    println(true_list(l3, x=>x>10))
    println(true_list(l4, x=>x>10))
    println()
    
    println("Problem 4:")
    println(true_list2(x=>x%2==0)(l1))
    println(true_list2(x=>x%2==0)(l2))
    println(true_list2(x=>x%2==0)(l3))
    println(true_list2(x=>x%2==0)(l4))
    
    println(true_list2(x=>x>10)(l1))  
    println(true_list2(x=>x>10)(l2)) 
    println(true_list2(x=>x>10)(l3))
    println(true_list2(x=>x>10)(l4))
  }
}