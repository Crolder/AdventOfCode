package main.scala.day06

import scala.io.Source
import Solution._

object Day06 extends App {
    val source = Source.fromResource("day06.txt")

    val lanternFishes = source.getLines().toList.flatMap(_.split(",").map(_.toInt).toList)
    val fishMap = FishMap(lanternFishes.groupBy(identity).map{ case (timer, list) => timer -> list.size.toLong })


    println("Part1 result: " + simulateDays(fishMap, 80).size)
    println("Part2 result: " + simulateDays(fishMap, 256).size)

    source.close()
}
