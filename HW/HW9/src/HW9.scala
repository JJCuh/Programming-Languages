
object HW9 {
  //Problem 1
  abstract class BSTree{//Can't be instantiated
    def member(x:Int):Boolean
    def insert(x:Int):BSTree
    def equal(other:BSTree):Boolean
    def printy(level:Int):Unit
   
    //new functions:
    def depth():Int
    def exactsubtree(that:BSTree):Boolean
  }
  
  case object Leaf extends BSTree{
    def member(x:Int):Boolean = false  
    def insert(x:Int):BSTree = new Node(x, Leaf, Leaf)   
    def equal(other:BSTree):Boolean = {
      other match{
        case Leaf => true
        case Node(_,_,_) => false
      }
    }
    
    def printy(level:Int):Unit = {
      def loop(x:Int):Unit = if(x==0) print(" ") else {print(" "); loop(x-1)}
      loop(level)
      println("leaf")
    }
    
    //new functions:
    def depth():Int = 0
    def exactsubtree(that:BSTree):Boolean = true
  }
  
  case class Node(value:Int, left:BSTree, right:BSTree) extends BSTree{
    def member(x:Int):Boolean = 
      if(x<value) left.member(x)
      else if(x>value) right member x
      else true //x==value
      
    def insert(x:Int):BSTree = 
      if(x<value) new Node(value, left.insert(x), right)
      else if(x>value) new Node(value, left, right insert x)
      else new Node(value, left, right) //x==value
    
    def equal(other:BSTree):Boolean = {
      other match{
        case Leaf => false
        case Node(v, l, r) =>
          if(v!=value) false
          else (left equal l) && (right equal r)
      }
    }
    
    def printy(level:Int):Unit = {
      right.printy(level+1);
      def loop(x:Int):Unit = if(x==0) print(" ") else {print(" "); loop(x-1)}
      loop(level)
      println(value); left.printy(level+1)
    }
    
    //new functions:
    def depth():Int = {
      val ldep = 1+left.depth
      val rdep = 1+right.depth
      if(ldep > rdep) ldep
      else rdep
    }
    
    def exactsubtree(that:BSTree):Boolean = {
      that match{
        case Leaf => false
        case Node(v, l, r) =>
          if(that.member(value)){
            if(equal(that)) true
            else exactsubtree(l) || exactsubtree(r)
          }
          else false
      }
    }
  }
  
  //Problem 2
  def findlast(xs:List[Int], x:Int):Int = {
    def helper(ys:List[Int], i:Int):Int = { 
      ys match{
        case Nil => -1
        case z::zs => if(z==x) i+helper(zs, 1)
                      else helper(zs, i+1)
      }
    }
    helper(xs, 1)
  }
    
  def main(args:Array[String]){
    val t1 = Leaf
    val t2 = t1 insert 2 insert 4 insert 1 insert 7 insert 3
    t2.printy(0)
    println
    val t3 = t1 insert 4 insert 7 insert 3
    t3.printy(0)
    println
    
    println("Problem 1:")
    println(t2.depth)//3
    println(t3.depth)//2
    println
    
    println(t1.exactsubtree(t2))//true
    println(t2.exactsubtree(t1))//false
    println(t2.exactsubtree(t3))//false
    println(t3.exactsubtree(t2))//true
    println
    
    println("Problem 2:")
    def l1 = List(7,8,9,7,11,7,5)
    def l2 = List(1,2,3,4,5)  
    println(findlast(l1, 7))//5
    println(findlast(l2, 7))//-1
    println
  }
}