package app.meditation

import app.meditation.NumberToWords
import org.scalatest._

class NumberToWordsSpec extends FlatSpec with Matchers {
  "NumberToWords" should "work" in {
    NumberToWords.toWord(0) should be ("zero")
    NumberToWords.toWord(1) should be ("one")
    NumberToWords.toWord(3) should be ("three")

  // "NumberToWords" should "handle tens" in {
    NumberToWords.toWord(13) should be ("thirteen")
    NumberToWords.toWord(17) should be ("seventeen")
    NumberToWords.toWord(23) should be ("twenty three")
  // }

  // "NumberToWords" should "handle hundreds" in {
    NumberToWords.toWord(100) should be ("one hundred")
    NumberToWords.toWord(135) should be ("one hundred thirty five")
    NumberToWords.toWord(200) should be ("two hundred")
    NumberToWords.toWord(707) should be ("seven hundred seven")
  // }
  
  // "NumberToWords" should "handle thousands" in {
    NumberToWords.toWord(300000) should be ("three hundred thousand")
    NumberToWords.toWord(719402) should be ("seven hundred nineteen thousand four hundred two")
  // }

  // "NumberToWords" should "handle negative numbers" in {
    NumberToWords.toWord(-10) should be ("negative ten")
    NumberToWords.toWord(-619) should be ("negative six hundred nineteen")
    NumberToWords.toWord(-1034) should be ("negative one thousand thirty four")
  // }


  // "NumberToWords" should "big numbers" in {
    NumberToWords.toWord(800000902) should be ("eight hundred million nine hundred two")
    NumberToWords.toWord(1719837337) should be ("one billion seven hundred nineteen million eight hundred thirty seven thousand three hundred thirty seven")
  // }
  }


}
