// function coposition

def f(s: String) = "f(" + s + ")"
def g(s: String) = "g(" + s + ")"

val fComposeG = f _ compose g _
fComposeG("Yay")

val fAndThenG = f _ andThen g _
fAndThenG("yay")

// currying vs partial applicatioon

val one: PartialFunction[Int, String] = { case 1 => "one" }
one.isDefinedAt(1)
one.isDefinedAt(2)


val two: PartialFunction[Int, String] = { case 2 => "two" }
val three: PartialFunction[Int, String] = { case 3 => "three" }
val wildcard: PartialFunction[Int, String] = { case _ => "something else" }
val partial = one orElse two orElse three orElse wildcard
partial(5)
partial(3)
partial(2)
partial(1)

// mystery of case
case class PhoneExt(name: String, ext: Int)

val extensions = List(PhoneExt("steve", 100), PhoneExt("robey", 200))
extensions.filter { case PhoneExt(name, extensions) => extension < 200 } // partial function is subtype of function
