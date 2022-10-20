package tests

import org.scalatest._
import rhymes.RhymingDictionary


class TestGetSounds extends FunSuite {

  test("check for rhyming sound lists") {
    val filename: String = "C:/Users/psych/IdeaProjects/RhymingDictionary/data/cmudict-0.7b"
    assert(RhymingDictionary.getSounds(dictionaryFilename = filename, "ZEST") == (List("Z","EH1","S","T")))
    assert(RhymingDictionary.getSounds(dictionaryFilename = filename, "AGREEMENTS") == (List("Z","EH1","S","T")) == false)
    assert(RhymingDictionary.getSounds(dictionaryFilename = filename, "OOFIE") == (List()))

  }
}
