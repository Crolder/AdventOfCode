package main.scala.day04

object Solution {
    sealed trait RowOrColumn {
        val numbers: List[Int]
        val markedNumbers: List[Int]
        def unmarkedNumbers = numbers.diff(markedNumbers)
        def win = unmarkedNumbers.isEmpty
    }

    case class Row(numbers: List[Int], markedNumbers: List[Int]) extends RowOrColumn
    case class Column(numbers: List[Int], markedNumbers: List[Int]) extends RowOrColumn

    case class Board(rows: List[Row], lastDrawnNumber: Option[Int]) {
        private def getColumnsFromRows(rows: List[List[Int]], columns: List[List[Int]]): List[List[Int]] = rows match {
            case rows if rows.forall(_.isEmpty) => columns
            case rows => getColumnsFromRows(rows.map(_.tail),columns.appended(rows.map(_.head)))
        }
        def updateBoardWithDrawnNumber(number: Int) = copy(
            rows = rows.map(row => row.copy(markedNumbers = row.markedNumbers.appended(number))),
            lastDrawnNumber = Some(number)
        )
        def win = rows.exists(_.win) || columns.exists(_.win)
        def unmarkedNumbers = rows.flatMap(_.unmarkedNumbers)
        val columns: List[Column] = getColumnsFromRows(rows.map(_.numbers), Nil).map(column => Column(column, rows.flatMap(_.markedNumbers)))
    }

    def playGame(playingBoards: List[Board], draw: List[Int], winnerBoards: List[Board]): List[Board] = playingBoards match {
        case Nil => winnerBoards
        case playingBoards =>
            val updatedBoards = playingBoards.map(_.updateBoardWithDrawnNumber(draw.head))
            playGame(updatedBoards.filterNot(_.win), draw.tail, winnerBoards ++ updatedBoards.filter(_.win))
    }
}
