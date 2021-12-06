package main.scala.day03

object Solution {
    case class Rate(gammaBinary: List[Int], epsilonBinary: List[Int]){
        def result: Int = {
            Integer.parseInt(gammaBinary.mkString(""), 2) * Integer.parseInt(epsilonBinary.mkString(""), 2)
        }
    }
    object Rate {
        val empty = Rate(Nil, Nil)
    }

    def getGammaEpsilonRate(list: List[List[Int]], result: Rate): Rate  = list match {
        case list if list.forall(_ == Nil) => result
        case list => {
            val groupedValues = list.map(_.head).groupBy(identity)
            val (gammaValue, _) = groupedValues.maxBy { case (_, list) => list.size }
            val (epsilonValue, _) = groupedValues.minBy { case (_, list) => list.size }
            getGammaEpsilonRate(
                list.map(_.tail),
                result.copy(
                    gammaBinary = result.gammaBinary.appended(gammaValue),
                    epsilonBinary = result.epsilonBinary.appended(epsilonValue),
                )
            )
        }
    }

    def getOxygenRating(list: List[String], acc: List[String], slice: String): String  = list match {
        case head :: Nil => head
        case List(first,second) => if(first.startsWith(slice + "1")) first else second
        case list => {
            val groupedValues = acc.map(_.head).groupBy(identity)
            val (gammaValue, _) = groupedValues.maxBy { case (_, list) => list.size }
            val newSlice = slice + gammaValue
            val filteredList = list.filter(_.startsWith(newSlice))
            getOxygenRating(filteredList, filteredList.map(_.drop(newSlice.length)), newSlice)
        }
    }

    def getCo2Rating(list: List[String], acc: List[String], slice: String): String  = list match {
        case head :: Nil => head
        case List(first,second) => if(first.startsWith(slice + "0")) first else second
        case list => {
            val groupedValues = acc.map(_.head).groupBy(identity)
            val (epsilonValue, _) = groupedValues.minBy { case (_, list) => list.size }
            val newSlice = slice + epsilonValue
            val filteredList = list.filter(_.startsWith(newSlice))
            getCo2Rating(filteredList, filteredList.map(_.drop(newSlice.length)), newSlice)
        }
    }
}
