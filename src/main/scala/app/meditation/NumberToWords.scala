package app.meditation

// all prefixes are the same for all numbers except "ten", "eleven", "twelve", forty
// there are some that overlap
// thir-teen thir-ty, fif-teen fif-ty

// for each chunk of 3 digits, there is a similar pattern
// 142,482,405 (x hundred y-ty z) million (p hundred q-ty r) thousand etc. 

// there is a further pattern that after thousand, all suffixes end in "illion"
object NumberToWords {
  def toWord(x: Int): String = x match {
    case 0 => "zero"
    case _ if x < 0 => "negative "+parse_number(-x)
    case _ => parse_number(x)
  }

  def parse_number(x: Int): String = {
    val triples = count_triples(x)
    chunk_triples(x, triples).replaceAll("\\s+", " ").trim
  }

  def count_triples(x: Int, triple_place:Int = 0): Int = {
    if(x/1000 > 0) {
      count_triples(x/1000, triple_place+1)
    } else {
      return triple_place
    }
  }

  def chunk_triples(x: Int, triple_place: Int): String = {
    val w = triple_place match {
      case _ if x/(Math.pow(1000, triple_place).toInt)%1000 == 0 => ""
      case 0 => ""
      case 1 => "thousand"
      case 2 => "million"
      case 3 => "billion"
      case 4 => "trillion"
      case 5 => "quadrillion"
      case 6 => "quintillion"
      case 7 => "septillion"
    }
    if (triple_place < 1) {
      return wordify_triple(x%1000)
    } else {
      return Array(
        wordify_triple( (x/(Math.pow(1000, triple_place).toInt ))%1000 ),
        w,
        chunk_triples(x, triple_place-1)
      ).mkString(" ")
    }
  }

  def wordify_triple(x: Int): String = Array(hundreds(x), tens(x), ones(x)).mkString(" ")

  def ones(x: Int): String = x % 10 match {
    case _ if (x/10)%10 == 1 => ""
    case 1 => "one"
    case 2 => "two"
    case 3 => "three"
    case 4 => "four"
    case 5 => "five"
    case 6 => "six"
    case 7 => "seven"
    case 8 => "eight"
    case 9 => "nine"
    case _ => ""
  }

  def tens(x: Int): String = (x/10)%10 match {
    case 0 => ""
    case 1 => x match {
      case 10 => "ten"
      case 11 => "eleven"
      case 12 => "twelve"
      case 13 => "thirteen"
      case 15 => "fifteen"
      case _ => ones(x%10) + "teen"
    }
    case 2 => "twenty"
    case 3 => "thirty"
    case 4 => "forty"
    case _ => ones(x/10 % 10)+"ty"
  }

  def hundreds(x: Int): String = x/100 match {
    case 0 => ""
    case _ => ones(x/100) + " hundred"
  }
}
