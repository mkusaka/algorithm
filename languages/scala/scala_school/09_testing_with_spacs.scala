// extends Specification

import org.specs._

// basic example
// object ArithmeticSpec extends Specification {
//   "Arithmetic" should {
//     "add two numbers" in {
//       1 + 1 mustEqual 2
//     }
//     "add three numbers" in {
//       1 + 1 + 1 mustEqual 3
//     }
//   }
// }

// nested example
object ArithmeticSpec extends Specification {
  "Arithmetic" should {
    "add" in {
      "two numbers" in {
        1 + 1 mustEqual 2
      }
      "three numbers" in {
        1 + 1 + 1 mustEqual 3
      }
    }
  }
}

object ExecSpec extends Specification {
  "mutations are isolated" should {
    var x = 0
    "x equals 1 if we set it." in {
      x = 1
      x mustEqual 1
    }
    "x is the default value if we don't change it" in {
      x mustEqual 0
    }
  }
}

// do before do after, only run on leaf example

"mys system" should {
  doBefore { resetTheSystem() }
  "mess up the system" in { ... }
  "and again" in { ... }
  doAfter { cleanThingsUp() }
}


// doFirst & doLast, only run single-time setup
"foo" should {
  doFirst { openTheCurtains() }
  "test stateless methods" in { ... }
  "test other stateless methods" in { ... }
  doLast { closeTheCurations() }
}

// Matchers


1 mustEqual 1
"a" mustEqual "a"

val numbers = List(1,2,3)
numbers must contain(1)
numbers must not contain(4)

numbers must containAll(List(1,2,3))
numbers must containInOrder(List(1,2,3))

List(1, List(2,3, List(4)), 5) must haveTheSameElementsAs(List(5, List(List(4), 2,3),1))


map must haveKey(k)
map must notHaveKey(k)

map must haveValue(v)
map must notHaveValue(v)

a must beGraterThan(b)
a must beGraterThanOrEqualTo(b)

a must beLessThan(b)
a must beLessThanOrEqualTo(b)

a must beCloseTo(b, delta)



a must beNone
a must beSome[Type]
a must beSomething
a must beSome(value)


a must throwA[WhateverException]

import org.specs.matcher.Matcher

"A matcher" should {
  "be created as a val" in {
    val beEven = new Matcher[Int] {
      def apply(n: => Int) = {
        (n % 2 == 0, "%d is even".format(n), "%d is odd".format(n))
      }
    }
    2 must beEven
  }
}

