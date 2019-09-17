val students = Map(
  "taro" -> Map("数" -> 78, "英" -> 98),
  "jiro" -> Map("国" -> 81, "英" -> 69, "社" -> 86),
  "taro" -> Map("国" -> 98, "英" -> 78),
)

students.foreach {
  case (name, score) => average(name, score).foreach(println)
}

def average(name: String, score: Map[String, Int]):
  Option[(String, Int)] =
    score.get("国").flatMap { ja =>
      score.get("英").map { en =>
        (name, (ja + en) / 2)
      }
    }