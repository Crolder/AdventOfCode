package main.scala.day05

object Solution {
    case class Point(x: Int, y: Int)
    case class Line(start: Point, end: Point) {
        val isVerticalHorizontal = start.x == end.x || start.y == end.y
        val isDiagonal = Math.abs(start.x - end.x) == Math.abs(start.y - end.y) || start.x == start.y && end.x == end.y
    }

    def lineFromString(string: String) = {
        val List(firstPoint, secondPoint) = string.split(" -> ").map(pointFromString).toList
        Line(firstPoint, secondPoint)

    }
    def pointFromString(string: String) = {
        val List(x, y) = string.split(",").map(_.toInt).toList
        Point(x, y)
    }
    def lineToCoveredPoints(line: Line): List[Point] = {
        val allX = if(line.start.x < line.end.x) (line.start.x to line.end.x).toList else (line.start.x to line.end.x by -1).toList
        val allY = if(line.start.y < line.end.y) (line.start.y to line.end.y).toList else (line.start.y to line.end.y by -1).toList
        if(line.start.x == line.end.x || line.start.y == line.end.y) for {
            x <- allX
            y <- allY
        } yield Point(x, y)
        else  (allX zip allY).map { case (x, y) => Point(x, y) }
    }
}
