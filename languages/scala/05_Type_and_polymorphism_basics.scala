// parametric polymorphism
val list = 2::1::"bar"::"foo"::Nil

list.head // 2

def drop2[A](l: List[A]) = l.tail
drop1(List(1,2,3))

// scala has rank 1 polymorphism

def toList[A](a: A) = List(a).flatten


def foo[A, B](f: A => List(A), b: B) = f(b)

def foo[A](f: A => List[A], i: A) = f(i) //not compile mismatch maybe

// type inference
def id[T](x: T) = x

val x = id(322)
val x = id("hey")
val x = id(Array(1,2,3,4))

// Variance

class Covariant[+A]

val cv: Covariant[AnyRef] = new Covariant[String]

val fail: Covariant[String] = new Covariant[AnyRef] /// anyref is not as subtype of String ..?


class Contravariant[-A]

val cv: Contravariant[String] = new Contravariant[AnyRef]

val fail: Contravariant[AnyRef] = new Contravariant[String]

trait Function1[-T1, +R] extends AnyRef

class Animal { val sound = "rustle" }

class Bird extends Animal { override val sound = "call" }

class Chicken extends Bird { override val sound: String = "cluck" }

val getTweet: (Bird => String) = ((a: Animal) => a.sound)

val hatch: (() => Bird) = (() => new Chicken)


// Bounds
def cacophony[T](things: Seq[T]) = things map (_.sound) // scala can't understand T has method `sound`

def biophony[T <: Animal](things: Seq[T]) = things map (_.sound) // Animal and its subtype has sound method. if T specify as it must be super class of Animal, it will written as T >: Animal

biophony(Seq(new Chicken, new Bird)) // subytpe of Animal can contains above argument

// Quantification
def count[A](l: List[A]) = l.size

def count(l: List(_)) = l.size // ←is shorthand of ↓

def count(l: List[T forSome { type T }]) = l.size

def drop1(l: List[_]) = l.tail // welost type information,,,

def drop1(l: List[T forSome { type T }]) = l.tail

hashcodes(l: Seq[_ <: AnyRef]) = l map (_.hashCode)// bound of wildcard variables
