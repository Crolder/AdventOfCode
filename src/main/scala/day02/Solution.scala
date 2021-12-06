package main.scala.day02

object Solution {
    case class Action(direction: String, amount: Int)
    case class Destination(depth: Int, lenght: Int, aim: Int) {
        def multiply: Int = depth * lenght
    }

    def countResult(list: List[Action], result: Destination): Destination = {
        list match {
            case Nil => result
            case Action(direction, amount) :: tail => direction match {
                case "forward" => countResult(tail, result.copy(lenght = result.lenght + amount))
                case "up" => countResult(tail, result.copy(depth = result.depth - amount))
                case "down" => countResult(tail, result.copy(depth = result.depth + amount))
            }
        }
    }

    def countResultWithAim(list: List[Action], result: Destination): Destination = {
        list match {
            case Nil => result
            case Action(direction, amount) :: tail => direction match {
                case "forward" => countResultWithAim(tail, result.copy(lenght = result.lenght + amount, depth = result.depth + result.aim * amount))
                case "up" => countResultWithAim(tail, result.copy(aim = result.aim - amount))
                case "down" => countResultWithAim(tail, result.copy(aim = result.aim + amount))
            }
        }
    }
}
