package main.scala.day03

import scala.io.Source
import Solution._

object Day03 extends App {
    val source = Source.fromResource("day03.txt")

    val inputStrings = source.getLines().toList
    val parsedInput = inputStrings.map(_.split("").map(_.toInt).toList)


    println("Part1 result: " + getGammaEpsilonRate(parsedInput, Rate.empty).result)
    println("Part2 result: " + Integer.parseInt(getOxygenRating(inputStrings, inputStrings, ""), 2) * Integer.parseInt(getCo2Rating(inputStrings, inputStrings, ""), 2))

    source.close()
}
