package tests

import org.scalatest._
import rhymes.RhymingDictionary

class TestIsRhyme extends FunSuite  {
  test("Tester bester"){
    val filename: String = "C:/Users/psych/IdeaProjects/RhymingDictionary/data/cmudict-0.7b"
    assert(RhymingDictionary.isRhyme(filename, "ZEST", "TEST"))
    assert(RhymingDictionary.isRhyme(filename, "DIAMOND", "ISLAND"))
    assert(RhymingDictionary.isRhyme(filename, "LEGEND", "DEFINE") == false)


  }

}
