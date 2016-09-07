package app.meditation

import app.meditation.NumberToWords
import org.scalatest._

class NumberToWordsSpec extends FlatSpec with Matchers {

  "NumberToWords" should "convert 1 to a word" in {
    NumberToWords.toWord(1) should be ("one")
  }
}
