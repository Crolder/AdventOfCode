package main.scala.day05

import scala.io.Source
import Solution._

object Day05 extends App {
    val source = Source.fromResource("day05.txt")
    val lines = source.getLines().map(lineFromString).toList

    val onlyVerticalHorizontalLines = lines.filter(_.isVerticalHorizontal)
    val onlyDiagonalLines = lines.filter(_.isDiagonal)

    val verticalHorizontalCoveredPoints = onlyVerticalHorizontalLines.flatMap(lineToCoveredPoints)
    val allCoveredPoints = (onlyVerticalHorizontalLines ++ onlyDiagonalLines).flatMap(lineToCoveredPoints)

    println("Part1 result: " + verticalHorizontalCoveredPoints.groupBy(identity).count { case (_, overlaps) => overlaps.size >= 2 })
    println("Part2 result: " + allCoveredPoints.groupBy(identity).count { case (_, overlaps) => overlaps.size >= 2 })

    source.close()
}
