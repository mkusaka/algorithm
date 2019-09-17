// arrays
val numbers = Array(1, 2, 3, 4, 5)

numbers(2)

// lists

val numbers2 = List(1,3,4,5)

numbers2(3)
numbers2(3) = 10

// sets
val numbers3 = Set(1,2,3,4,5)

// Tuple
val hostPort = ("localhost", 80)

hostPort._1

1 -> 2 // same as (1, 2)

// Map (same as hash or object)
Map(1 -> 2)


Map(1 -> Map("foo" -> "bar"))

/*
def multiply(m: Int)(n: Int): Int = m * n

multiply(2)(3)

val TimesTwo = multiply(2) _

TimesTwo(3)
*/
Map("timesTwo" -> { TimesTwo(_)})

// Option
/*
// option interface ↓
trait Option[T] {
  def isDefined: Boolean
  def get: T
  def getOrElse(t: T): T
}
*/

val numbers4 = Map("one" -> 1, "two" -> 2)

numbers4.get("two") // Some
val response = numbers4.get("three") // None

val result = if (response.isDefined) {
  response.get + 3
} else {
  0
}

val result2 = response match {
  case Some(n) => n * 2
  case None => 0
}


// functional combinatiors
// map

val numbers5 = List(1,2,4,5,6,7)
numbers5.map((i: Int) => i * 2)

numbers5.map(TimesTwo)

// foreach
numbers5.foreach((i: Int) => i * 2) // retunes nothing

// filter
numbers5.filter((i: Int) => i % 2 == 0)

// zip
List(1,2,3).zip(List("a", "b", "c"))

// partision
numbers5.partision(_ % 2 == 0)

// find
numbers5.find((i: Int) => i > 5)

// drop & dropwhile
numbers5.drop(5)

numbers5.dropWhile(_ % 3 != 0)

// foldLeft
numbers5.foldLeft(1) {(m: Int, n: Int) => println("m: " + m + " n: " + n); m * n}

// foldRight
numbers5.foldRight(1) {(m: Int, n: Int) => println("m: " + m + " n: " + n); m - n}

// flatten
List(List(1,3), List(3,4)).flatten
List(List(1,3), List("foo","bar")).flatten // List[Any]

Array(Array(1,3), Array("foo","bar")).flatten // exception
Array(Array(1,3), Array(3,4)).flatten

// flatmap
List(List(1, 2), List(3, 4)).flatMap(x => x.map(_ * 2))
List(List(List(1, 2), List(1, 2)), List(List(3, 4), List(3, 4))).flatMap(x => x.flatten.map((x: Int) => x * 2))

// generalized functional combinators

def ourMap(numbers: List[Int], fn: Int => Int): List[Int] = {
  numbers.foldRight(List[Int]()) { (x: Int, xs: List[Int]) =>
    println(x)
    println(xs)
    fn(x) :: xs
  }
}
