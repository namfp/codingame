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
  def main(args: Array[String]): Unit = {
    println("Hello world")
  }

}
