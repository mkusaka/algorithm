// view bounds ("type classes")

implicit def strToInt(x: String) = x.toInt

val y: Int = "123"
math.ma("123", 111)

class Container[A <% Int] { def addIt(x: A) = 123 + x }

(new Container[String]).addIt("123")
(new Container[Int]).addIt(123)
(new Container[Float]).addIt(123.2F) // err. noimplicit definition Float => Int

implicit def f(x: Float) = x.toInt
(new Container[Float]).addIt(123.2F) //works

// Ohter type bounds
sum[B >: A](implicit num: Numeric[B]): B

// Generic programming with views
def min[B >: A](implicit cmp: Ordering[B]): A = {
  if(isEmpty)
    throw new UnsupportedOperationException("empty.main")

  reduceLeft((x, y) => if (cmp.lteq(x, y) x else y))
}

List(1,2,3,4).min
List(1,2,3,4).min(new Ordering[Int] { def compare(a: Int, b: Int) = b compare a }) // 4
List(1,2,3,4).min(new Ordering[Int] { def compare(a: Int, b: Int) = a compare b }) // 1

// Context bounds & implicitly[]

def foo[A](implicit x: Ordered[A]) {}

def foo[A: Orderd] {}

implicitly[Ordering[Int]] // access to implicit values

implicitly[strToInt[String]]


// Higher kinded types (like higher order function) & ad-hoc polymorphism  https://qiita.com/poly_soft/items/1d7363b85b04e48a6e24
/// ???
trait Container[M[_]] { def put[A](x: A): M[A]; def get[A](m: M[A]): A }

val container = new Container[List] { def put[A](x: A) = List(x); def get[A](m: List[A]) = m.head}

container.put("hey")
container.put(123)


// F-bounded polymorphism
// TBD

// Structual types
def foo(x: { def get: Int }) = 123 + x.get
foo(new { def get = 10 })

// Abstruct type members
trait Foo { type A; val x: A; def getX: A = x }

(new Foo{ type A = Int; val x = 123}).getX

(new Foo{ type A = String; val}).getX

// Type erasured & manifests

class MakeFoo[A](implicit manifest: Mainfest) {
  def make: A = manifest.erasure.newInstance.asInstanceOf[A]
}


