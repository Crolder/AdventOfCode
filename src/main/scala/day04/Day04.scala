package main.scala.day04

import scala.io.Source
import Solution._

object Day04 extends App {
    val source = Source.fromResource("day04.txt")

    val rawDrawNumbers :: rawBoards = source.getLines().toList

    val drawNumbers = rawDrawNumbers.split(",").map(_.toInt).toList

    val rows = for {
        board <- rawBoards.filterNot(_ == "")
        row = board.split(" ").filterNot(_ == "").map(_.toInt).toList
    } yield Row(row, Nil)

    val boards = rows.grouped(5).map(rows => Board(rows, None)).toList

    val winnerBoards = playGame(boards, drawNumbers, winnerBoards = Nil)
    val firstWinningBoard = winnerBoards.head
    val lastWinningBoard = winnerBoards.last

    println("Part1 result: " + firstWinningBoard.lastDrawnNumber.map(_ * firstWinningBoard.unmarkedNumbers.sum))
    println("Part2 result: " + lastWinningBoard.lastDrawnNumber.map(_ * lastWinningBoard.unmarkedNumbers.sum))

    source.close()
}
