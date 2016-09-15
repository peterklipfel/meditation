package app.meditation

// i is the row
// j is the column
object MatrixSpiral {
  def stringify(matrix: Array[Array[Int]]): String = {
    if (matrix.length < 1) { return "" }
    goRight(matrix, 0, 0, matrix(0).length-1, 0, matrix.length-1, 0)
    return ""
  }

  def check_finish(matrix:Array[Array[Int]], max_col:Int, min_col:Int, max_row:Int, min_row:Int): Boolean = {
    val row_end = ((max_row - min_row) < 1) && (matrix(0).length % 2 == 0) || ((max_row - min_row) < 2) && (matrix(0).length % 2 == 1)
    val col_end = ((max_col - min_col) < 1) && (matrix.length % 2 == 0) || ((max_col - min_col) < 2) && (matrix.length % 2 == 1)
    return row_end && col_end
  }

  def goRight(matrix:Array[Array[Int]], i: Int, j: Int, max_col: Int, min_col: Int, max_row: Int, min_row: Int): Unit = {
    if(check_finish(matrix, max_col, min_col, max_row, min_row)){ return }
    println(matrix(i)(j))
    if(j == max_col) {
      goDown(matrix, i+1, j, max_col-1, min_col, max_row, min_row)
    } else {
      goRight(matrix, i, j+1, max_col, min_col, max_row, min_row)
    }
  }

  def goDown(matrix: Array[Array[Int]], i: Int, j: Int, max_col: Int, min_col: Int, max_row: Int, min_row: Int): Unit = {
    if(check_finish(matrix, max_col, min_col, max_row, min_row)){ return }
    println(matrix(i)(j))
    if(i == max_row) {
      goLeft(matrix, i, j-1, max_col, min_col, max_row-1, min_row)
    } else {
      goDown(matrix, i+1, j, max_col, min_col, max_row, min_row)
    }
  }

  def goLeft(matrix: Array[Array[Int]], i: Int, j: Int, max_col: Int, min_col: Int, max_row: Int, min_row: Int): Unit = {
    if(check_finish(matrix, max_col, min_col, max_row, min_row)){ return }
    println(matrix(i)(j))
    if(j == min_col) {
      goUp(matrix, i-1, j, max_col, min_col+1, max_row, min_row)
    } else {
      goLeft(matrix, i, j-1, max_col, min_col, max_row, min_row)
    }
  }

  def goUp(matrix: Array[Array[Int]], i: Int, j: Int, max_col: Int, min_col: Int, max_row: Int, min_row: Int): Unit = {
    if(check_finish(matrix, max_col, min_col, max_row, min_row)){ return }
    println(matrix(i)(j))
    if(i - min_row < 2) {
      goRight(matrix, i, j+1, max_col, min_col, max_row, min_row+1)
    } else {
      goUp(matrix, i-1, j, max_col, min_col, max_row, min_row)
    }
  }
}

