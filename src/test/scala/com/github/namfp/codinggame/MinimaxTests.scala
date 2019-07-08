package com.github.namfp.codinggame

import com.github.namfp.codingame._
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest._

class MinimaxTests extends FlatSpec with Matchers {
  it should "do the job" in {
    val board = Vector(
      Vector(Played(Self), Played(Self), Played(Self)),
      Vector(Played(Opponent), Played(Opponent), Blanked),
      Vector(Blanked, Blanked, Blanked)
    )
    Minimax.computeWinner(board) shouldBe Win
  }
}
