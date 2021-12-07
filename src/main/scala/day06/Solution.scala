package main.scala.day06

object Solution {
    case class FishMap(map: Map[Int, Long]){
        val size = map.values.sum
        def update = copy(map =
          map
            .updated(8, map.getOrElse(0, 0L))
            .updated(7, map.getOrElse(8, 0L))
            .updated(6, map.getOrElse(7, 0L) + map.getOrElse(0, 0L))
            .updated(5, map.getOrElse(6, 0L))
            .updated(4, map.getOrElse(5, 0L))
            .updated(3, map.getOrElse(4, 0L))
            .updated(2, map.getOrElse(3, 0L))
            .updated(1, map.getOrElse(2, 0L))
            .updated(0, map.getOrElse(1, 0L))
        )
    }

    def simulateDays(fishMap: FishMap, days: Int): FishMap = days match {
        case 0 => fishMap
        case _ => simulateDays(fishMap.update, days - 1)
    }
}
