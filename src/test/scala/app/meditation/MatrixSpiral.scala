package app.meditation

import app.meditation.MatrixSpiral
import org.scalatest._

class MatrixSpiralSpec extends FlatSpec with Matchers {
  "MatrixSpiral" should "handle the null matrix" in {
    val matrix = Array.ofDim[Int](0,0)
    MatrixSpiral.stringify(matrix) should be ("")
  }

  "MatrixSpiral" should "a 1x1 matrix" in {
    val matrix = Array(Array(1))
    MatrixSpiral.stringify(matrix) should be ("1")
  }

  "MatrixSpiral" should "should handle large matrices" in {
    val matrix = Array(Array(1,11,111,1111), Array(2,22,222,2222), Array(3,33,333,3333), Array(4,44,444,4444))
    MatrixSpiral.stringify(matrix) should be ("1,11,111,1111,2222,3333,4444,444,44,4,3,2,22,222,333,33")
  }
  
}
