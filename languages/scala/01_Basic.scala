// functions

def addOne(m: Int): Int = m + 1

def three() = 1 + 2

// anonymous functions

(x: Int) => x + 1

val addOne2 = (x: Int) => x + 1

// partial application

def adder(m: Int, n: Int) = m + n

val add2 = adder(2, _:Int)

add2(2)

// curried functions

def multiply(m: Int)(n: Int): Int = m * n

multiply(2)(3)

val timesTwo = multiply(2) _

timesTwo(3)

val curriedAdd = (adder _).curried

val addTwo = curriedAdd(2)

addTwo(4)

def capitalizeAll(args: String*) = {
  args.map { arg =>
    arg.capitalize
  }
}

// variable length arguments

capitalizeAll("rarity", "applejack", "applejsdafack")

// # classes

// class Calculator {
//   val brand: String = "HP"
//   def add(m: Int, n: Int): Inte = m + n
// }

// val calc = new Calculator

// calc.add(1, 2)

// calc.brand

// constructor

class Calculator(brand: String) {
  /**
   * A constructor.
   */

  val color: String = if (brand == "TI") {
    "blue"
  } else if (brand == "HP") {
    "black"
  } else {
    "white"
  }

  def add(m: Int, n: Int): Int = m + n
}

val calc = new Calculator("HP")

calc.color


// expressions

class C {
  var acc = 0
  def minc = { acc += 1 } // calls minc method
  val finc = { () => acc += 1 } // returns function as a value
}

// Inheritance

class ScientificCalculartor(brand: String) extends Calculator(brand) {
  def log(m: Double, base: Double) = math.log(m) / math.log(base)
}

// Overloading methods

class EvenMoreScientificCalculator(brand: String) extends ScientificCalculartor(brand) {
  def log(m: Int): Double = log(m, math.exp(1))
}

// Abstract Classes

abstract class Shape {
  def getArea(): Int
}

class Circle(r: Int) extends Shape {
  def getArea(): Int ={ r * r * 3 }
}

val s = new Shape // error

val c = new Circle(2) // works

// Traits

trait Car {
  val brand: String
}

trait Shiny {
  val shineRefraction: Int
}


class BMW extends Car { // one extends
  val brand = "MBW"
}

class BMW extends Car with Shiny { // two or more extend parent. (abstract class can't.)
  val brand = "BMW"
  val shineRefraction = 12
}

// Types

trait Cache[K, V] {
  def get(key: K): V
  def put(key: K, value: V)
  def delete(key: K)
}

