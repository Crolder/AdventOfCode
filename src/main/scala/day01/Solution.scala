package main.scala.day01

import scala.annotation.tailrec

object Solution {
    @tailrec
    def howManyIncreased(list: List[Int], result: Int): Int = {
        list match {
            case first :: second :: Nil => if(first < second) result + 1 else result
            case first :: second :: tail =>
                if(first < second)
                    howManyIncreased(second :: tail, result + 1)
                else
                    howManyIncreased(second :: tail, result)
        }
    }
    @tailrec
    def groupByWindows(list: List[Int], result: List[Int]): List[Int] = {
        list match {
            case first :: second :: third :: Nil => result :+ (first + second + third)
            case first :: second :: third :: tail => {
                val updatedResult = result :+ (first + second + third)
                groupByWindows(second :: third :: tail, updatedResult)
            }
        }
    }
}
