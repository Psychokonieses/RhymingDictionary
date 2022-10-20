package tests

import org.scalatest._
import rhymes.RhymingDictionary

class TestIsRhymeSounds extends FunSuite {


  test("check for rhyming sound lists") {
    val filename: String = "C:/Users/psych/IdeaProjects/RhymingDictionary/data/cmudict-0.7b"
    assert(RhymingDictionary.isRhymeSounds( List("Z","EH1","S","T"), List("T","EH1","S","T")))





  }

}
