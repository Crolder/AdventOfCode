package main.scala.day07

import scala.io.Source

object Day07 extends App {
    def fuelToPoint(position: Int, target: Int, constant: Boolean) = {
        if(constant) Math.abs(position - target)
        else (1 to Math.abs(position - target)).sum
    }

    def findMedian(list: List[Int]): Int = {
        val sortedList = list.sorted
        if (list.size % 2 == 1) sortedList(sortedList.size / 2)
        else {
            val (up, down) = sortedList.splitAt(list.size / 2)
            (up.last + down.head) / 2
        }
    }

    val source = Source.fromResource("day07.txt")

    val crabs = source.getLines().flatMap(_.split(",").map(_.toInt).toList).toList

    val median = findMedian(crabs)
    val average = crabs.sum / crabs.size

    println("Part1 result: " + crabs.map(position => fuelToPoint(position, median, constant = true)).sum)
    println("Part2 result: " + crabs.map(position => fuelToPoint(position, average, constant = false)).sum)

    source.close()
}
