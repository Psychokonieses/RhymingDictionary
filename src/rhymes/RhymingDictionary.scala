package rhymes

import rhymes.RhymingDictionary.{getSounds, isRhymeSounds}

import scala.io.{BufferedSource, Source}


object RhymingDictionary {
  var dict: Map[String, List[String]] = Map()
  if (dict.size == 0) {
    val file: BufferedSource = Source.fromFile("data/cmudict-0.7b")
    for (line <- file.getLines()) {
      var count: Int = line.indexOf(" ")
      if (line.startsWith(";")) {
      }
      else {
        var words33: String = line.substring(0, count)
        var words66: List[String] = line.substring(count).split(" ").toList
        dict = dict + (words33 -> words66)
      }
    }
  }

  def findRhymes(dictionaryFilename: String, word: String): List[String] = {
    var finalList: List[String] = List()
    var rhymes = getSounds(dictionaryFilename, word)

  for ((i, j) <- dict) { //run through the map keys and values
    if (isRhymeSounds(rhymes, j)) {
      finalList = finalList :+ i.toString
    }
    else if(rhymes.length<= 0){

    }
    // println(finalList.toString)
  }
  finalList
}

    def isRhymeSounds(word1: List[String], word2: List[String]): Boolean = {
      var list1: List[String] = List()
      var list2: List[String] = List()
      var counter1: Int = 0
      var counter2: Int = 0
      var bool1: Boolean = true
      var bool2: Boolean = true
      for (i <- word1.indices.reverse) {
        for (vowel1 <- word1.reverse) {
          if (bool1) {
            counter1 = counter1 + 1
            if (vowel1.length > 2) {
              bool1 = false
              if (vowel1 != word1(i)) {
                var checker: String = vowel1(0) + vowel1(1).toString
                list1 = list1 :+ checker
                for (checker1 <- (1 until counter1).reverse) {
                  list1 = list1 :+ (word1(word1.length - checker1))
                }
              }
              else {
                list1 = list1 :+ vowel1.toUpperCase()
              }
            }
          }
        }
        for (i <- word2.indices.reverse) {
          for (vowel2 <- word2.reverse) {
            if (bool2) {
              counter2 = counter2 + 1
              if (vowel2.length > 2) {
                bool2 = false
                if (vowel2 != word2(i)) {
                  var checkerDuo: String = vowel2(0) + vowel2(1).toString
                  list2 = list2 :+ checkerDuo
                  for (checker2 <- (1 until counter2).reverse) {
                    list2 = list2 :+ (word2(word2.length - checker2))
                  }
                }
                else {
                  list2 = list2 :+ vowel2.toUpperCase()
                }
              }
            }
          }
        }
      }
      (list1 == list2)
    }


    def getSounds(dictionaryFilename: String, word: String): List[String] = {
      val file: BufferedSource = Source.fromFile(dictionaryFilename)
      var sounds: List[String] = List()
      var spliced: List[String] = List()

      for (lineSounds <- file.getLines()) {
        val splits: Array[String] = lineSounds.split(" ") //split method along the spaces in order to retrieve sounds
        if (splits(0) == word.toUpperCase()) {
          sounds = splits.toList
        }
      }

      spliced = sounds.slice(2, sounds.length) //Interval begins at 2 to avoid spacing issues
      if (sounds == ()) {
        List()
      }
      else {
        spliced
      }
    }

    def isRhyme(dictionaryFilename: String, word1: String, word2: String): Boolean = {
      val rhymeGuy1: List[String] = getSounds(dictionaryFilename, word1)
      val rhymeGuy2: List[String] = getSounds(dictionaryFilename, word2)
      if (isRhymeSounds(rhymeGuy1, rhymeGuy2)) {
        true
      }
      else {
        false
      }
    }


    def main(args: Array[String]): Unit = {
      val dictionaryFilename: String = "data/cmudict-0.7b"
      findRhymes(dictionaryFilename, "ZEST")
      //println(getSounds(dictionaryFilename,"photograph"))

    }

}
  //var soundsFin: List[String] = map1(i)
//  var inputSounds: List[String] = getSounds(dictionaryFilename, word)
 // if (isRhymeSounds(inputSounds, soundsFin)){
 //  finalList ::= i

 // }
//}
//finalList
/*
    val file: BufferedSource = Source.fromFile(dictionaryFilename)
    var rhymedWords: List[String] = List()
    var splitsList: List[String] = List()
    var preList: List[String] = List()
    var map1: Map[String, List[String]] = Map()
    var map2: Map[String, List[String]] = Map()
    var finalList: List[String] = List()
    var count: Int = 0
    for (line <- file.getLines()) {
      var splits: Array[String] = line.split("  ")
      splitsList = splits.toList
      preList ::= splitsList(0)
      var sounds2 = splitsList(splitsList.length - 1)
      var splits2: Array[String] = sounds2.split(" ")
      var splits2List: List[String] = splits2.toList
 */