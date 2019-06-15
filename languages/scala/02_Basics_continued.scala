// apply methods

class Foo {}

object FooMaker {
  // call when instance made
  def apply() = new Foo
}

val newFoo = FooMaker()

class Bar {
  def apply() = 0
}

val bar = new Bar

bar() // returns 0

//  Objects

object Timer {
  var count = 0

  def currentCount(): Long = {
    count += 1
    count
  }
}

// Functions are Objects

object addOne extends Function1[Int, Int] {
  def apply(m: Int): Int = m + 1
}

addOne(1)


class AddOne extends Function1[Int, Int] {
  def apply(m: Int): Int = m + 1
}

val plusOne = newe AddOne()

plusOne(1) // retuns 2

// packages
/*
package com.twitter.example

object colorHolder {
  val BLUE = "BLUE"
  val RED = "RED"
}
*/

println("the color is:" + com.twitter.example.colorHolder.BLUE)

// pattern matching

val times = 1

times match {
  case 1 => "one"
  case 2 => "two"
  case _ => "some ohter number"
}

times match {
  case i if i == 1 => "one"
  case i if i == 2 => "two"
  case _ => "some other number" // `_` is wild card
}

// matching on time

def bigger(o: Any): Any = {
  o match {
    case i: Int if i < 0 => i - 1
    case i: Int => i + 1
    case d: Double if d < 0.0 => d - 0.1
    case d: Double => d + 0.1
    case text: String => text + "s"
  }
}

// matching on class members

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
} // same as defiend one at 01_Basic

def calcType(calc: Calculator) = calc match {
  case _ if calc.brand == "HP" && calc.model == "20B" => "financial"
  case _ if calc.bland == "HP" && calc.model == "48G" => "scientific"
}

// case classes

case class Calculator(brand: String, model: String)

val hp20b = Calculator("HP", "20B")
val hp20B = Calculator("HP", "20B")
hp20b == hp20B // true

val hp30b = Calculator("HP", "30B")

def calcType(calc: Calculator) = calc match {
  case Calculator("HP", "20B") => "financial"
  case Calculator("HP", "48G") => "scientific"
}

// exceptions

try {
  remoteCalService.add(1, 2)
} catch {
  case e: ServiceException => log.error(e)
} finally {
  remoteCalService.close()
}
