// Mutable

val numbers = collection.mutable.Map(1 -> 2)
numbers.get(1) //returns Some(2)
numbers.getOrElseUpdate(2, 3)
numbers += (4 -> 2)
/*
numbers
res65: scala.collection.mutable.Map[Int,Int] = Map(2 -> 3, 4 -> 2, 1 -> 2)
*/

