package main.scala.day02

import scala.io.Source
import Solution._

object Day02 extends App {
    val source = Source.fromResource("day02.txt")
    val list = source.getLines().map{ action =>
        val array = action.split(" ").toList
        Action(array.head, array.last.toInt)
    }.toList

    println("Part1 result: " + countResult(list, Destination(0, 0, 0)).multiply)
    println("Part2 result: " + countResultWithAim(list, Destination(0, 0, 0)).multiply)

    source.close()
}
