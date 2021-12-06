package main.scala.day01

import scala.io.Source
import Solution._

object Day01 extends App {
    val source = Source.fromResource("day01.txt")
    val list = source.getLines().map(_.toInt).toList

    println(s"Result first part: ${howManyIncreased(list, 0)}")
    println(s"Result second part: ${howManyIncreased(groupByWindows(list, Nil), 0)}")

    source.close()
}
