
object HW8 {
  //Problem 2
  def forLoop(i:Int, conf:Int=>Boolean, incf:Int=>Int)(exp: =>Unit):Unit =
    if(conf(i)){
      exp
      forLoop(incf(i), conf, incf)(exp)
    }
  
  //Problem 3
  def and(x:Boolean, y: =>Boolean) =
    if(!x) false else y
  
  def or(x:Boolean, y: =>Boolean) = 
    if(x) true else y
    
  //Problem 4
  class Biguint(x:List[Int]){
    //Constructors
    def this() = this(0::Nil)
    def this(s:String) = 
       this({def convert(s:String):List[Int] =
         if(s.isEmpty) Nil else convert(s.tail):::List((s.head-'0'));
       convert(s)})
    
    //Member Variable
    val list = x
    
    //Member Functions
    def +(that:Biguint):Biguint = {
      def adder(xs:List[Int], ys:List[Int], c:Int):List[Int] = {
        if(xs.isEmpty && ys.isEmpty && c==0) Nil
        else if(xs.isEmpty && ys.isEmpty) List(c)
        else if(xs.isEmpty) if(c==0) ys else adder(List(c), ys, 0)
        else if(ys.isEmpty) if(c==0) xs else adder(xs, List(c), 0)
        else {
          val sum = (xs.head+ys.head+c)%10
          val carry = (xs.head+ys.head+c)/10
          sum::adder(xs.tail, ys.tail, carry)
        }
      }
      new Biguint(adder(this.list, that.list, 0))
    }

  }
  
  //main tests
  def main(args: Array[String]) {
    println("Problem 2:")
    forLoop(0, x=>x<10, x=>x+1){
      println("Hello World")
    }
    println()
    
    println("Problem 3:")
    println(and(5>10, 4<6))//false
    println(and(10>5, 6<4))//false
    println(and(10>5, 4<6))//true
    println(and(10>5, 6<4))//false
    println()
    
    println(or(5>10, 4<6))//true
    println(or(5>10, 6<4))//false
    println(or(10>5, 4<6))//true
    println(or(10>5, 6<4))//true
    println()
    
    println("Problem 4:")
    val a = new Biguint("1572")
    val b = new Biguint(List(2,7,5,1))
    println(a.list)
    println(b.list)
    val c = a + b
    println(c.list)
    val d = new Biguint("999")
    val e = new Biguint(List(1))
    println(d.list)
    println(e.list)
    val f = d + e
    println(f.list)
    val g = new Biguint("256")
    val h = new Biguint(List(0))
    println(g.list)
    println(h.list)
    val i = g + h
    println(i.list)
  }

}