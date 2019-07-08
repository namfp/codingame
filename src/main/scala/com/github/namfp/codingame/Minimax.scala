package com.github.namfp.codingame

sealed trait Player
case object Self extends Player
case object Opponent extends Player

sealed trait CellState
case object Blanked extends CellState
case class Played(player: Player) extends CellState


case class GameState(nextMove: Player, board: Vector[Vector[CellState]])



sealed trait Result
case object Win extends Result
case object Lose extends Result
case object Draw extends Result

object Minimax {
  type Board = Vector[Vector[CellState]]

  private def isWon(board: Board, player: Player): Boolean = {
    val positions = List(
      List((0, 0), (1, 0), (2, 0)),
      List((0, 1), (1, 1), (2, 1)),
      List((0, 2), (1, 2), (2, 2)),
      List((0, 0), (0, 1), (0, 2)),
      List((1, 0), (1, 1), (1, 2)),
      List((2, 0), (2, 1), (2, 2)),
      List((0, 0), (1, 1), (2, 2)),
      List((0, 2), (1, 1), (2, 0)),
    )
    positions.foldLeft(false) {
      case (true, _) => true
      case (false, pos) => pos.forall { case (x, y) =>
        val currentCell = board(y)(x)
        currentCell match {
          case Played(p) => p == player
          case _ => false
        }
      }
    }
  }

  def computeWinner(board: Board): Result = {
    if (isWon(board, Self))
      Win
    else if (isWon(board, Opponent))
      Lose
    else
      Draw
  }



  def main(args: Array[String]): Unit = {
    println("Hello world")
  }

}
